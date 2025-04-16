package cryst.api.dto;

import lombok.Data;

    @Data
    public class CreateAgentResponse {
        private boolean success;
        private String agentId;
        private String provider;
        private String message;
    }

