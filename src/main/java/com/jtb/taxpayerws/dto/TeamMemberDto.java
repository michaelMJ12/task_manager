package com.jtb.taxpayerws.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class TeamMemberDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String department;
    private String taskName;
    private LocalDate taskDate;
    private LocalTime taskTime;
    private String taskComment;
    private String email;

    public TeamMemberDto(Long id, String firstName, String lastName, String middleName, String department, String taskName, LocalDate taskDate, LocalTime taskTime, String taskComment, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.department = department;
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.taskTime = taskTime;
        this.taskComment = taskComment;
        this.email = email;
    }

    public TeamMemberDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }

    public LocalTime getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(LocalTime taskTime) {
        this.taskTime = taskTime;
    }

    public String getTaskComment() {
        return taskComment;
    }

    public void setTaskComment(String taskComment) {
        this.taskComment = taskComment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "TeamMemberDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", department='" + department + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskDate=" + taskDate +
                ", taskTime=" + taskTime +
                ", taskComment='" + taskComment + '\'' +
                ", email='" + email + '\'' +
                '}';
    }



}
