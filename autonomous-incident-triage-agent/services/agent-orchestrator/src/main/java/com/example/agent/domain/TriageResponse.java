package com.example.agent.domain;

public record TriageResponse(
        String incidentId,
        String serviceName,
        String probableRootCause,
        double confidenceScore,
        String recommendedAction,
        boolean approvalRequired,
        String status
) {}
