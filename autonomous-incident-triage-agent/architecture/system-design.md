# System Design: Autonomous Incident Triage & RCA Agent

## Objective

Build a Java-based Agentic AI system that assists SRE and engineering teams during production incidents by automating context gathering, evidence correlation, RCA drafting, and remediation recommendation.

## Design Principles

1. Human approval before production-impacting action
2. Full auditability of agent decisions
3. Clear separation between reasoning and execution
4. Provider-neutral LLM abstraction
5. Enterprise-ready security and observability
6. Deterministic fallback paths when LLMs are unavailable

## Components

### Agent Orchestrator
Coordinates the incident workflow. It does not directly execute production actions without explicit approval.

Responsibilities:
- Classify incident severity
- Plan investigation steps
- Invoke diagnostic tools
- Call RAG layer
- Generate RCA summary
- Route recommended action for approval

### Tool Registry
Controlled interface between the agent and enterprise systems.

Example tools:
- `searchLogs`
- `getRecentDeployments`
- `retrieveRunbook`
- `createIncidentTicket`
- `recommendRollback`

### RAG Service
Retrieves operational knowledge from runbooks, SOPs, postmortems, and historical incidents.

### Approval Service
Determines whether the proposed action requires human approval.

### Audit Service
Stores all investigation evidence, prompts, retrieved context, tool calls, model outputs, and final decisions.

## Sequence Flow

```text
Monitoring Alert
    -> Agent Orchestrator
    -> Log Search Tool
    -> Deployment Lookup Tool
    -> Runbook Retrieval Tool
    -> LLM Reasoning Boundary
    -> RCA Summary
    -> Approval Service
    -> Audit Store
    -> Human Reviewer
```

## Failure Handling

| Failure | Fallback |
|---|---|
| LLM unavailable | Return evidence-only incident summary |
| Vector DB unavailable | Use keyword search over indexed metadata |
| Tool timeout | Continue with partial evidence and mark confidence lower |
| Approval service unavailable | Block remediation and require manual review |

