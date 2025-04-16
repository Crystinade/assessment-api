package cryst.api.dto;

import lombok.Data;

    @Data
    public class CreateAgentRequest {
        private String provider;
        private String name;
        private String description;
        private String model;
        private String voiceId;
        private String prompt;
        private Double temperature = 0.7;
        private String[] tools;
        private String[] sampleConversations;
        private String firstMessage;


        public VapiAgentRequest toVapiRequest() {
            VapiAgentRequest request = new VapiAgentRequest();
            request.setName(this.name);
            request.setModel(this.model);
            request.setVoice(this.voiceId);
            request.setSystemPrompt(this.prompt);
            request.setTemperature(this.temperature);
            request.setTools(this.tools);
            return request;
        }


        public RetellAgentRequest toRetellRequest() {
            RetellAgentRequest request = new RetellAgentRequest();
            request.setAgent_name(this.name);
            request.setGpt_3_5_turbo_16k_instruction(this.prompt);
            request.setVoice_id(this.voiceId);
            request.setTemperature(this.temperature);
            request.setSample_conversation(this.sampleConversations);
            request.setFirst_sentence(this.firstMessage);
            return request;
        }
    }

