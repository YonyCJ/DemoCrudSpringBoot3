package com.academic.app.business.impl;

import com.academic.app.business.GradeService;
import com.academic.app.dao.entity.GradeEntity;
import com.academic.app.dao.repository.GradeRepository;
import com.academic.app.expose.dto.GradeDto;
import com.academic.app.mapper.GradeMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;
    private final GradeMapper gradeMapper;

    @Override
    public List<GradeDto.Response> listGrade(){
        List<GradeEntity> listEntity = gradeRepository.findAllByIsActiveTrueAndIsDeletedFalse();
        return gradeMapper.toResponseList(listEntity);
    }

    @Override
    public GradeDto.Response findGradeById(Long idGrade){
        Optional<GradeEntity> entity = gradeRepository.findByIdGradeAndIsActiveTrueAndIsDeletedFalse(idGrade);
        return entity.map(gradeMapper::toResponse).orElse(null);
    }

    @Override
    @Transactional
    public GradeDto.Response saveGrade(GradeDto.Request request){
        GradeEntity entity = gradeMapper.toRequest(request);
        entity.setIsActive(true);
        entity.setIsDeleted(false);
        entity.setCreatedDate(LocalDateTime.now());
        GradeEntity save = gradeRepository.save(entity);
        return gradeMapper.toResponse(save);
    }

    @Override
    public GradeDto.Response updateGrade(Long idGrade, GradeDto.Request request){
        request.setIdGrade(idGrade);
        Optional<GradeEntity> getEntity = gradeRepository.findById(request.getIdGrade());
        if (getEntity.isPresent()){
            GradeEntity entity = gradeMapper.toRequest(request);
            entity.setCreatedDate(getEntity.get().getCreatedDate());
            entity.setIsActive(true);
            entity.setIsDeleted(false);
            entity.setLastModifiedDate(LocalDateTime.now());
            GradeEntity save = gradeRepository.save(entity);
            return gradeMapper.toResponse(save);
        }
        throw new EntityNotFoundException("Entity not found with ID: " + idGrade);
    }

    @Override
    public void deleteGrade(Long idGrade){
        Optional<GradeEntity> getEntity = gradeRepository.findByIdGradeAndIsActiveTrueAndIsDeletedFalse(idGrade);
        if (getEntity.isPresent()) {
            getEntity.get().setIsActive(false);
            getEntity.get().setIsDeleted(true);
            gradeRepository.save(getEntity.get());
        }

    }
}
