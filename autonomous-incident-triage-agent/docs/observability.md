# Observability

## Metrics

- Incident triage count
- Average triage latency
- Tool call success/failure rate
- LLM call latency
- Approval pending count
- Recommendation acceptance rate
- RCA confidence distribution

## Logs

Use structured logs with fields:

```text
incidentId
serviceName
toolName
latencyMs
confidenceScore
approvalStatus
```

## Traces

Trace each incident flow across:
- API request
- Tool calls
- RAG retrieval
- LLM reasoning
- Approval workflow
- Audit persistence
