package com.academic.app.business;

import com.academic.app.expose.dto.LevelDto;

import java.util.List;

public interface LevelService {

    List<LevelDto.Response> listLevel();
    LevelDto.Response findLevelById(Long idLevel);
    LevelDto.Response saveLevel(LevelDto.Request request);
    LevelDto.Response updateLevel(Long idLevel, LevelDto.Request request);
    void deleteLevel (Long idLevel);

}
