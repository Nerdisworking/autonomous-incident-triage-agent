package com.example.agent.service;

import com.example.agent.approval.ApprovalService;
import com.example.agent.audit.AuditService;
import com.example.agent.domain.*;
import com.example.agent.rag.RunbookRetrievalService;
import com.example.agent.tools.DeploymentLookupTool;
import com.example.agent.tools.LogSearchTool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AgentOrchestratorService {
    private final LogSearchTool logSearchTool;
    private final DeploymentLookupTool deploymentLookupTool;
    private final RunbookRetrievalService runbookRetrievalService;
    private final LlmReasoningService llmReasoningService;
    private final ApprovalService approvalService;
    private final AuditService auditService;

    public AgentOrchestratorService(
            LogSearchTool logSearchTool,
            DeploymentLookupTool deploymentLookupTool,
            RunbookRetrievalService runbookRetrievalService,
            LlmReasoningService llmReasoningService,
            ApprovalService approvalService,
            AuditService auditService
    ) {
        this.logSearchTool = logSearchTool;
        this.deploymentLookupTool = deploymentLookupTool;
        this.runbookRetrievalService = runbookRetrievalService;
        this.llmReasoningService = llmReasoningService;
        this.approvalService = approvalService;
        this.auditService = auditService;
    }

    public TriageResponse triage(TriageRequest request) {
        String incidentId = "INC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        List<ToolResult> evidence = new ArrayList<>();
        evidence.add(logSearchTool.searchLogs(request.serviceName(), request.timeRange()));
        evidence.add(deploymentLookupTool.getRecentDeployments(request.serviceName()));
        evidence.add(runbookRetrievalService.retrieveRunbook(request.serviceName(), request.alertMessage()));

        auditService.recordToolEvidence(incidentId, evidence);

        AgentFinding finding = llmReasoningService.generateFinding(request, evidence);
        auditService.recordAgentFinding(incidentId, finding);

        boolean approvalRequired = approvalService.requiresApproval(finding);
        String status = approvalRequired ? "PENDING_APPROVAL" : "READY_FOR_EXECUTION";

        return new TriageResponse(
                incidentId,
                request.serviceName(),
                finding.probableRootCause(),
                finding.confidenceScore(),
                finding.recommendedAction(),
                approvalRequired,
                status
        );
    }
}
