package com.academic.app.expose.dto;

import lombok.Getter;
import lombok.Setter;



public class GradeDto {

    @Getter
    @Setter
    public static class Response{
        private Long idGrade;
        private String name;
        private String description;
        private LevelDto.Response level;
    }

    @Getter
    @Setter
    public static class Request{
        private Long idGrade;
        private String name;
        private String description;
        private LevelDto.Response level;
        private String createdBy;
        private String lastModifiedBy;
    }

}
