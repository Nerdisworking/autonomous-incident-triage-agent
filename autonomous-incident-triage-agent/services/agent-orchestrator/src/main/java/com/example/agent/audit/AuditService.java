package com.example.agent.audit;

import com.example.agent.domain.AgentFinding;
import com.example.agent.domain.ToolResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditService {
    private static final Logger log = LoggerFactory.getLogger(AuditService.class);

    public void recordToolEvidence(String incidentId, List<ToolResult> evidence) {
        log.info("AUDIT incidentId={} event=TOOL_EVIDENCE toolCount={}", incidentId, evidence.size());
    }

    public void recordAgentFinding(String incidentId, AgentFinding finding) {
        log.info("AUDIT incidentId={} event=AGENT_FINDING confidence={} recommendation={}",
                incidentId, finding.confidenceScore(), finding.recommendedAction());
    }
}
