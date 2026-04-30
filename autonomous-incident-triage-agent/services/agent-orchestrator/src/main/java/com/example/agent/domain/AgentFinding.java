package com.example.agent.domain;

import java.util.List;

public record AgentFinding(
        String summary,
        String probableRootCause,
        double confidenceScore,
        String recommendedAction,
        List<ToolResult> evidence
) {}
