
    package cryst.api.service;


    import cryst.api.dto.CreateAgentRequest;
    import cryst.api.dto.CreateAgentResponse;
    import cryst.api.dto.VapiAgentRequest;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.http.*;
    import org.springframework.stereotype.Service;
    import org.springframework.web.client.RestTemplate;

    @Service
    public class VapiService {

        @Value("${vapi.api.key}")
        private String apiKey;

        @Value("${vapi.base.url}")
        private String baseUrl;

        public CreateAgentResponse createAgent(CreateAgentRequest request) {
            RestTemplate restTemplate = new RestTemplate();


            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + apiKey);


            VapiAgentRequest vapiRequest = request.toVapiRequest();


            HttpEntity<VapiAgentRequest> entity = new HttpEntity<>(vapiRequest, headers);
            ResponseEntity<String> response = restTemplate.exchange(
                    baseUrl + "/assistants",
                    HttpMethod.POST,
                    entity,
                    String.class);


            CreateAgentResponse result = new CreateAgentResponse();
            result.setSuccess(response.getStatusCode().is2xxSuccessful());
            result.setAgentId(extractAgentIdFromResponse(response.getBody()));
            result.setProvider("vapi");
            result.setMessage("Agent created successfully");

            return result;
        }

        private String extractAgentIdFromResponse(String responseBody) {
            // Implement proper JSON parsing here
            return "vapi-agent-id"; // placeholder
        }
    }