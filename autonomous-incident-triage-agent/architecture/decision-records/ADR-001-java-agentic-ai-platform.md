# ADR-001: Use Java for Enterprise Agentic AI Platform

## Status

Accepted

## Context

Agentic AI systems require integration with enterprise APIs, databases, messaging platforms, observability systems, and security controls. Java is well suited for this infrastructure-heavy layer.

## Decision

Use Java 21 and Spring Boot as the main platform for orchestration, tool execution, governance, and audit logging.

## Consequences

### Positive

- Strong enterprise integration model
- Mature observability and security ecosystem
- Strong typing and maintainability
- Easier adoption in Java-heavy organizations

### Trade-offs

- Python remains stronger for rapid AI experimentation
- Some agent frameworks are more mature in Python
- Java-native AI frameworks are evolving quickly but still catching up

