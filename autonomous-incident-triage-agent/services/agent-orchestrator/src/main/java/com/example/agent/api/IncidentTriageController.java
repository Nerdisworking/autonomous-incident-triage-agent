package com.example.agent.api;

import com.example.agent.domain.TriageRequest;
import com.example.agent.domain.TriageResponse;
import com.example.agent.service.AgentOrchestratorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/incidents")
public class IncidentTriageController {
    private final AgentOrchestratorService orchestratorService;

    public IncidentTriageController(AgentOrchestratorService orchestratorService) {
        this.orchestratorService = orchestratorService;
    }

    @PostMapping("/triage")
    public ResponseEntity<TriageResponse> triage(@Valid @RequestBody TriageRequest request) {
        return ResponseEntity.ok(orchestratorService.triage(request));
    }
}
