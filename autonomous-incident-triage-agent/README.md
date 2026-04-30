# Autonomous Incident Triage & RCA Agent

A production-style **Java Agentic AI platform** that investigates production alerts, correlates logs, metrics, deployments, and runbooks, performs root-cause analysis, and recommends remediation actions with human-in-the-loop governance.

This repository is designed as a senior/staff-level portfolio project demonstrating enterprise Java, Agentic AI, RAG, observability, auditability, and distributed system design.

---

## Why This Project Exists

Modern production systems generate high-volume alerts, logs, metrics, and deployment signals. Human responders spend significant time gathering context before they can diagnose root cause. This project shows how an Agentic AI system can safely automate the investigation workflow while preserving human approval for risky actions.

---

## Core Capabilities

- Alert ingestion and incident creation
- Agent-based investigation workflow
- Tool calling for logs, deployments, runbooks, and historical incidents
- RAG over operational knowledge documents
- RCA summary generation
- Remediation recommendation with confidence score
- Human approval gate before production action
- Full audit trail for prompts, tool calls, retrieved context, and decisions
- Docker Compose local environment
- Kubernetes deployment templates

---

## Architecture

```text
Alert Source / Monitoring System
        |
        v
Agent Orchestrator API
        |
        +--> Incident Service
        +--> Tool Registry
        |       +--> Log Search Tool
        |       +--> Deployment Lookup Tool
        |       +--> Runbook Retrieval Tool
        |       +--> Ticket Creation Tool
        |
        +--> RAG Service
        |       +--> Vector Store / Metadata Store
        |
        +--> LLM Gateway
        |
        +--> Approval Service
        |
        +--> Audit Service
```

See [`architecture/system-design.md`](architecture/system-design.md) for details.

---

## Technology Stack

| Area | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 3 |
| AI Layer | Spring AI / LangChain4j-ready abstraction |
| Messaging | Kafka-ready design |
| Database | PostgreSQL |
| Vector Search | PGVector/OpenSearch-ready abstraction |
| Cache | Redis-ready design |
| Observability | OpenTelemetry-ready hooks |
| Build | Gradle |
| Deployment | Docker Compose + Kubernetes manifests |

---

## Demo Scenario

1. A synthetic alert is submitted for `statement-generator-service`.
2. The agent retrieves relevant logs and recent deployment metadata.
3. The agent searches runbooks and prior incident records.
4. The agent creates a structured RCA summary.
5. The agent recommends remediation.
6. The recommendation is routed for human approval.
7. Audit events are persisted for governance.

---

## Example API Call

```bash
curl -X POST http://localhost:8080/api/incidents/triage \
  -H "Content-Type: application/json" \
  -d '{
    "serviceName": "statement-generator-service",
    "severity": "HIGH",
    "alertMessage": "Error rate increased above threshold after latest deployment",
    "timeRange": "last_30_minutes"
  }'
```

---

## Sample Response

```json
{
  "incidentId": "INC-2026-0001",
  "serviceName": "statement-generator-service",
  "probableRootCause": "A recent deployment introduced a timeout regression in the statement rendering path.",
  "confidenceScore": 0.82,
  "recommendedAction": "Rollback deployment version 2.7.14 and monitor error rate for 15 minutes.",
  "approvalRequired": true,
  "status": "PENDING_APPROVAL"
}
```

---

## Local Run

```bash
./gradlew bootRun
```

Or with Docker Compose:

```bash
docker compose -f infra/docker-compose.yml up --build
```

---

## Repository Structure

```text
services/agent-orchestrator/   Main Spring Boot application
architecture/                  System design and diagrams
docs/                          Security, observability, prompt strategy
sample-data/                   Logs, runbooks, and sample incidents
infra/                         Docker Compose and Kubernetes templates
```

---

## Portfolio Positioning

This project demonstrates:

- Enterprise-grade Agentic AI beyond chatbot use cases
- Java-native production architecture
- Strong distributed-system design judgment
- Human-in-the-loop governance
- Fintech-style reliability, auditability, and operational control

