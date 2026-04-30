package com.example.agent.rag;

import com.example.agent.domain.ToolResult;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;

@Service
public class RunbookRetrievalService {
    public ToolResult retrieveRunbook(String serviceName, String alertMessage) {
        return new ToolResult(
                "retrieveRunbook",
                Instant.now(),
                Map.of(
                        "serviceName", serviceName,
                        "matchedRunbook", "statement-generator-timeout-runbook.md",
                        "recommendedChecks", "Validate downstream renderer latency, retry budget, deployment diff, and rollback readiness",
                        "retrievalMode", "semantic-search-placeholder"
                )
        );
    }
}
