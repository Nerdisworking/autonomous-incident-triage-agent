package com.example.agent.tools;

import com.example.agent.domain.ToolResult;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Map;

@Component
public class DeploymentLookupTool {
    public ToolResult getRecentDeployments(String serviceName) {
        return new ToolResult(
                "getRecentDeployments",
                Instant.now(),
                Map.of(
                        "serviceName", serviceName,
                        "latestVersion", "2.7.14",
                        "previousVersion", "2.7.13",
                        "deployedAt", "2026-04-29T18:05:00Z",
                        "changeSummary", "Updated rendering timeout and downstream retry policy"
                )
        );
    }
}
