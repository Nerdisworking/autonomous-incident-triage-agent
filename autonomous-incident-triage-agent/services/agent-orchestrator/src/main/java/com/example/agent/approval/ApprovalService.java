package com.example.agent.approval;

import com.example.agent.domain.AgentFinding;
import org.springframework.stereotype.Service;

@Service
public class ApprovalService {
    public boolean requiresApproval(AgentFinding finding) {
        return finding.recommendedAction().toLowerCase().contains("rollback")
                || finding.confidenceScore() < 0.90;
    }
}
