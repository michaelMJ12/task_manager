package com.jtb.taxpayerws.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalTime;

public class TaskRequest {


    private Long id;
    @JsonProperty("task_description")
    private String taskDescription;
    @JsonProperty("task_status")
    private String taskStatus;
    @JsonProperty("category")
    private String category;
    @JsonProperty("task_assign_to")
    private String taskAssignTo;
    @JsonProperty("percentage_complete")
    private String percentageComplete;
    @JsonProperty("task_start_date")
    private LocalDate taskStartDate;
    @JsonProperty("task_finish_date")
    private LocalDate taskFinishDate;
    @JsonProperty("task_hours_duration")
    private LocalTime taskHoursDuration;
    @JsonProperty("task_date_duration")
    private LocalDate taskDateDuration;

    public TaskRequest(Long id, String taskDescription, String taskStatus, String category, String taskAssignTo, String percentageComplete, LocalDate taskStartDate, LocalDate taskFinishDate, LocalTime taskHoursDuration, LocalDate taskDateDuration) {
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
    }

    public TaskRequest() {
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
    public String toString() {
        return "TaskRequest{" +
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
                '}';
    }
}
