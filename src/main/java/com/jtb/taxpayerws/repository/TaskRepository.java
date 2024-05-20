package com.jtb.taxpayerws.repository;

import com.jtb.taxpayerws.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, String> {


    @Query(value = "SELECT * FROM task_table WHERE task_description = :taskDescription", nativeQuery = true)
    Optional<TaskEntity> findByTaskDescription(String taskDescription);

    @Query(value = "SELECT * FROM task_table WHERE id = :id", nativeQuery = true)
    Optional<TaskEntity> findTaskById(@Param("id") Long id);

    void deleteById(Long id);


}
