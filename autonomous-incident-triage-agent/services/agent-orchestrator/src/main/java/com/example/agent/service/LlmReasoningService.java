package com.example.agent.service;

import com.example.agent.domain.AgentFinding;
import com.example.agent.domain.ToolResult;
import com.example.agent.domain.TriageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LlmReasoningService {
    /**
     * Replace this deterministic implementation with Spring AI or LangChain4j.
     * Keep this service as a boundary so model providers can be swapped safely.
     */
    public AgentFinding generateFinding(TriageRequest request, List<ToolResult> evidence) {
        String probableRootCause = "Recent deployment correlated with increased error rate and timeout symptoms.";
        String recommendation = "Rollback the latest deployment, validate downstream latency, and monitor error rate for 15 minutes.";

        return new AgentFinding(
                "Incident requires immediate investigation with rollback candidate identified.",
                probableRootCause,
                0.82,
                recommendation,
                evidence
        );
    }
}
