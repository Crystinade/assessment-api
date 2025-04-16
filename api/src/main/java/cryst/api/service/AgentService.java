
    package cryst.api.service;

    import cryst.api.dto.CreateAgentRequest;
    import cryst.api.dto.CreateAgentResponse;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    @Service
    public class AgentService {

        @Autowired
        private VapiService vapiService;

        @Autowired
        private RetellService retellService;

        public CreateAgentResponse createAgent(CreateAgentRequest request) {
            try {
                if ("vapi".equalsIgnoreCase(request.getProvider())) {
                    return vapiService.createAgent(request);
                } else if ("retell".equalsIgnoreCase(request.getProvider())) {
                    return retellService.createAgent(request);
                } else {
                    throw new IllegalArgumentException("Invalid provider specified");
                }
            } catch (Exception e) {
                CreateAgentResponse response = new CreateAgentResponse();
                response.setSuccess(false);
                response.setMessage("Failed to create agent: " + e.getMessage());
                return response;
            }
        }
    }