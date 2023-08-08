package com.academic.app.mapper;


import com.academic.app.dao.entity.LevelEntity;
import com.academic.app.expose.dto.LevelDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface LevelMapper {
    List<LevelDto.Response> toResponseList(List<LevelEntity> entity);
    LevelEntity toRequest(LevelDto.Request request);
    LevelDto.Response toResponse(LevelEntity entity);

}
