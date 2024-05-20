package com.jtb.taxpayerws.repository;

import com.jtb.taxpayerws.entity.ProjectManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectManagerRepository extends JpaRepository<ProjectManagerEntity, String> {

    @Query(value = "SELECT * FROM project_manage_table WHERE assign_project_name = :assignProjectName", nativeQuery = true)
    Optional<ProjectManagerEntity> findByAssignProjectName(String assignProjectName);

    @Query(value = "SELECT * FROM project_manage_table WHERE id = :id", nativeQuery = true)
    Optional<ProjectManagerEntity> findProjectManagerById(@Param("id") Long id);




}
