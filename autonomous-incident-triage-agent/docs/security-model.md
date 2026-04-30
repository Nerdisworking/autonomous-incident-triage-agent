# Security Model

## Core Controls

- OAuth2/JWT authentication for API access
- RBAC for incident investigation and approval actions
- mTLS for service-to-service communication
- Secrets stored outside application configuration
- Tool allowlist to prevent unrestricted action execution
- Human approval for rollback, restart, failover, or customer-impacting actions

## Agent Safety Boundaries

The agent can recommend production actions but cannot execute risky actions without approval.

Risky actions include:
- Rollback
- Restart
- Scaling changes
- Feature flag changes
- Customer notification
- Data correction

## Audit Requirements

Each incident should persist:
- User/request metadata
- Retrieved evidence
- Tool calls
- Model input/output summary
- Recommendation
- Human approval decision
- Final action outcome
