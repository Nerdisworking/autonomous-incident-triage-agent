package com.example.agent.domain;

import jakarta.validation.constraints.NotBlank;

public record TriageRequest(
        @NotBlank String serviceName,
        @NotBlank String severity,
        @NotBlank String alertMessage,
        @NotBlank String timeRange
) {}
