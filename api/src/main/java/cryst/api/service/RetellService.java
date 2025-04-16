
    package cryst.api.service;

    import cryst.api.dto.CreateAgentRequest;
    import cryst.api.dto.CreateAgentResponse;
    import cryst.api.dto.RetellAgentRequest;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.http.*;
    import org.springframework.stereotype.Service;
    import org.springframework.web.client.RestTemplate;

    @Service
    public class RetellService {

        @Value("${retell.api.key}")
        private String apiKey;

        @Value("${retell.base.url}")
        private String baseUrl;

        public CreateAgentResponse createAgent(CreateAgentRequest request) {
            RestTemplate restTemplate = new RestTemplate();

            // Set headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + apiKey);

            // Convert to Retell-specific request
            RetellAgentRequest retellRequest = request.toRetellRequest();

            // Make API call
            HttpEntity<RetellAgentRequest> entity = new HttpEntity<>(retellRequest, headers);
            ResponseEntity<String> response = restTemplate.exchange(
                    baseUrl + "/create-agent",
                    HttpMethod.POST,
                    entity,
                    String.class);

            // Process response (simplified - should parse JSON properly)
            CreateAgentResponse result = new CreateAgentResponse();
            result.setSuccess(response.getStatusCode().is2xxSuccessful());
            result.setAgentId(extractAgentIdFromResponse(response.getBody()));
            result.setProvider("retell");
            result.setMessage("Agent created successfully");

            return result;
        }

        private String extractAgentIdFromResponse(String responseBody) {
            // Implement proper JSON parsing here
            return "retell-agent-id"; // placeholder
        }
    }