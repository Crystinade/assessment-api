package cryst.api.controller;



import cryst.api.dto.CreateAgentRequest;
import cryst.api.dto.CreateAgentResponse;
import cryst.api.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @PostMapping
    public CreateAgentResponse createAgent(@RequestBody CreateAgentRequest request) {
        return agentService.createAgent(request);
    }
}
