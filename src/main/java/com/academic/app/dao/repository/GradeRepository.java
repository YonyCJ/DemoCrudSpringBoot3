package com.academic.app.dao.repository;

import com.academic.app.dao.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface GradeRepository extends JpaRepository<GradeEntity, Long> {
    List<GradeEntity> findAllByIsActiveTrueAndIsDeletedFalse();
    Optional<GradeEntity> findByIdGradeAndIsActiveTrueAndIsDeletedFalse(Long idGrade);
}
