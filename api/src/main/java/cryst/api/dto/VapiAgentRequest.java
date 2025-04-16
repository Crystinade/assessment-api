package cryst.api.dto;


import lombok.Data;

    @Data
    public class VapiAgentRequest {
        private String name;
        private String model;
        private String voice;
        private String systemPrompt;
        private Double temperature;
        private String[] tools;
    }

