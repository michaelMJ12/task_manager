package com.jtb.taxpayerws.entity;

import com.jtb.taxpayerws.entity.audit.Auditable;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity(name = "task_table")
public class TaskEntity extends Auditable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "task_description",nullable = false, length = 100)
    private String taskDescription;
    @Column(name = "task_status",nullable = false, length = 100)
    private String taskStatus;
    @Column(name = "category",nullable = false, length = 100)
    private String category;
    @Column(name = "task_assign_to",nullable = false, length = 100)
    private String taskAssignTo;
    @Column(name = "percentage_complete",nullable = false, length = 100)
    private String percentageComplete;
    @Column(name = "task_start_date",nullable = false, length = 100)
    private LocalDate taskStartDate;
    @Column(name = "task_finish_date",nullable = false, length = 100)
    private LocalDate taskFinishDate;
    @Column(name = "task_hours_duration",nullable = false, length = 100)
    private LocalTime taskHoursDuration;
    @Column(name = "task_date_duration",nullable = false, length = 100)
    private LocalDate taskDateDuration;

    @CreatedBy
    private Long createdBy;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedBy
    private Long modifiedBy;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public TaskEntity(Long id, String taskDescription, String taskStatus, String category, String taskAssignTo, String percentageComplete, LocalDate taskStartDate, LocalDate taskFinishDate, LocalTime taskHoursDuration, LocalDate taskDateDuration, Long createdBy, LocalDateTime createdAt, Long modifiedBy, LocalDateTime modifiedAt) {
        this.id = id;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
        this.category = category;
        this.taskAssignTo = taskAssignTo;
        this.percentageComplete = percentageComplete;
        this.taskStartDate = taskStartDate;
        this.taskFinishDate = taskFinishDate;
        this.taskHoursDuration = taskHoursDuration;
        this.taskDateDuration = taskDateDuration;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
    }

    public TaskEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTaskAssignTo() {
        return taskAssignTo;
    }

    public void setTaskAssignTo(String taskAssignTo) {
        this.taskAssignTo = taskAssignTo;
    }

    public String getPercentageComplete() {
        return percentageComplete;
    }

    public void setPercentageComplete(String percentageComplete) {
        this.percentageComplete = percentageComplete;
    }

    public LocalDate getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(LocalDate taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public LocalDate getTaskFinishDate() {
        return taskFinishDate;
    }

    public void setTaskFinishDate(LocalDate taskFinishDate) {
        this.taskFinishDate = taskFinishDate;
    }

    public LocalTime getTaskHoursDuration() {
        return taskHoursDuration;
    }

    public void setTaskHoursDuration(LocalTime taskHoursDuration) {
        this.taskHoursDuration = taskHoursDuration;
    }

    public LocalDate getTaskDateDuration() {
        return taskDateDuration;
    }

    public void setTaskDateDuration(LocalDate taskDateDuration) {
        this.taskDateDuration = taskDateDuration;
    }

    @Override
    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public Long getModifiedBy() {
        return modifiedBy;
    }

    @Override
    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    @Override
    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }


    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", category='" + category + '\'' +
                ", taskAssignTo='" + taskAssignTo + '\'' +
                ", percentageComplete='" + percentageComplete + '\'' +
                ", taskStartDate=" + taskStartDate +
                ", taskFinishDate=" + taskFinishDate +
                ", taskHoursDuration=" + taskHoursDuration +
                ", taskDateDuration=" + taskDateDuration +
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                ", modifiedBy=" + modifiedBy +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
