package cryst.api.dto;


import lombok.Data;

    @Data
    public class RetellAgentRequest {
        private String agent_name;
        private String gpt_3_5_turbo_16k_instruction;
        private String voice_id;
        private Double temperature;
        private String[] sample_conversation;
        private String first_sentence;
    }

