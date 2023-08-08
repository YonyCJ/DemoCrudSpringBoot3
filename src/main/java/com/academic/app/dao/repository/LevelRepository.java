package com.academic.app.dao.repository;

import com.academic.app.dao.entity.LevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface LevelRepository extends JpaRepository<LevelEntity, Long> {
    List<LevelEntity> findAllByIsActiveTrueAndIsDeletedFalse();
    Optional<LevelEntity> findByIdLevelAndIsActiveTrueAndIsDeletedFalse(Long idLevel);
}
