package com.academic.app.business.impl;

import com.academic.app.business.LevelService;
import com.academic.app.dao.entity.LevelEntity;
import com.academic.app.dao.repository.LevelRepository;
import com.academic.app.expose.dto.LevelDto;
import com.academic.app.mapper.LevelMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;
    private final LevelMapper levelMapper;

    @Override
    public List<LevelDto.Response> listLevel(){
        List<LevelEntity> listEntity = levelRepository.findAllByIsActiveTrueAndIsDeletedFalse();
        return levelMapper.toResponseList(listEntity);
    }

    @Override
    public LevelDto.Response findLevelById(Long idLevel){
        Optional<LevelEntity> entity = levelRepository.findByIdLevelAndIsActiveTrueAndIsDeletedFalse(idLevel);
        return entity.map(levelMapper::toResponse).orElse(null);
    }

    @Override
    @Transactional
    public LevelDto.Response saveLevel(LevelDto.Request request){
        LevelEntity entity = levelMapper.toRequest(request);
        entity.setIsActive(true);
        entity.setIsDeleted(false);
        entity.setCreatedDate(LocalDateTime.now());
        LevelEntity save = levelRepository.save(entity);
        return levelMapper.toResponse(save);
    }

    @Override
    public LevelDto.Response updateLevel(Long idLevel, LevelDto.Request request){
        request.setIdLevel(idLevel);
        Optional<LevelEntity> getEntity = levelRepository.findById(request.getIdLevel());
        if (getEntity.isPresent()){
            LevelEntity entity = levelMapper.toRequest(request);
            entity.setCreatedDate(getEntity.get().getCreatedDate());
            entity.setIsActive(true);
            entity.setIsDeleted(false);
            entity.setLastModifiedDate(LocalDateTime.now());
            LevelEntity save = levelRepository.save(entity);
            return levelMapper.toResponse(save);
        }
        throw new EntityNotFoundException("Entity not found with ID: " + idLevel);
    }

    @Override
    public void deleteLevel(Long idLevel){
        Optional<LevelEntity> getEntity = levelRepository.findByIdLevelAndIsActiveTrueAndIsDeletedFalse(idLevel);
        if (getEntity.isPresent()) {
            getEntity.get().setIsActive(false);
            getEntity.get().setIsDeleted(true);
            levelRepository.save(getEntity.get());
        }

    }
}
