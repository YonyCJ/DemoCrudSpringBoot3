package com.academic.app.expose.dto;

import lombok.Getter;
import lombok.Setter;



public class LevelDto {

    @Getter
    @Setter
    public static class Response{
        private Long idLevel;
        private String name;
        private String description;
    }

    @Getter
    @Setter
    public static class Request{
        private Long idLevel;
        private String name;
        private String description;
        private String createdBy;
        private String lastModifiedBy;
    }

}
