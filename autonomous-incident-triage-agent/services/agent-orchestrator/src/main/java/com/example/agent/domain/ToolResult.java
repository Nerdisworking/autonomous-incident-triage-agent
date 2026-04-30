package com.example.agent.domain;

import java.time.Instant;
import java.util.Map;

public record ToolResult(
        String toolName,
        Instant executedAt,
        Map<String, Object> payload
) {}
