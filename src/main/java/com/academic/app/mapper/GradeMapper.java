package com.academic.app.mapper;


import com.academic.app.dao.entity.GradeEntity;
import com.academic.app.expose.dto.GradeDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface GradeMapper {
    List<GradeDto.Response> toResponseList(List<GradeEntity> entity);
    GradeEntity toRequest(GradeDto.Request request);
    GradeDto.Response toResponse(GradeEntity entity);

}
