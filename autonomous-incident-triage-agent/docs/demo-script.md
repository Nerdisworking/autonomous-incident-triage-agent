# Demo Script

## Scenario

A high-severity alert fires for `statement-generator-service` after a deployment.

## Steps

1. Start the application.
2. Submit the sample triage request.
3. Review the RCA response.
4. Explain the evidence collected by each tool.
5. Show that rollback is recommended but blocked pending approval.
6. Highlight audit logs.

## Interview Talking Points

- Agentic AI should be constrained by governance.
- Tool execution must be deterministic and auditable.
- RAG improves context but does not replace production telemetry.
- Human approval is mandatory for risky operational actions.
