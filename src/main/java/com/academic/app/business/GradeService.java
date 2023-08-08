package com.academic.app.business;


import com.academic.app.expose.dto.GradeDto;

import java.util.List;

public interface GradeService {

    List<GradeDto.Response> listGrade();
    GradeDto.Response findGradeById(Long idGrade);
    GradeDto.Response saveGrade(GradeDto.Request request);
    GradeDto.Response updateGrade(Long idGrade, GradeDto.Request request);
    void deleteGrade (Long idGrade);

}
