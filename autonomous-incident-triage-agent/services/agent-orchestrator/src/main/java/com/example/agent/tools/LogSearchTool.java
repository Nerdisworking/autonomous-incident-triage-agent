package com.example.agent.tools;

import com.example.agent.domain.ToolResult;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Map;

@Component
public class LogSearchTool {
    public ToolResult searchLogs(String serviceName, String timeRange) {
        return new ToolResult(
                "searchLogs",
                Instant.now(),
                Map.of(
                        "serviceName", serviceName,
                        "timeRange", timeRange,
                        "errorRate", "12.8%",
                        "dominantError", "ReadTimeoutException",
                        "sampleLog", "Timeout while calling statement-renderer downstream dependency"
                )
        );
    }
}
