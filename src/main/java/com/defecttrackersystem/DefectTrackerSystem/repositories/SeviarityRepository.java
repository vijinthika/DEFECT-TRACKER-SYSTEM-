package com.defecttrackersystem.DefectTrackerSystem.repositories;

import com.defecttrackersystem.DefectTrackerSystem.entities.Seviarity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SeviarityRepository extends JpaRepository<Seviarity,Long>, QuerydslPredicateExecutor<Seviarity> {
    boolean existsByColorIgnoreCase(String color);

    public boolean existsByNameIgnoreCase(String name);

    public boolean existsByNameIgnoreCaseAndIdNot(String name,Long id);

    public boolean existsByColorIgnoreCaseAndIdNot(String color,Long id);
}
