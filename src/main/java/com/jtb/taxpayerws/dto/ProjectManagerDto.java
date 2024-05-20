package com.jtb.taxpayerws.dto;

import java.time.LocalDate;

public class ProjectManagerDto {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String department;
    private String assignProjectName;
    private String projectStatus;
    private String projectComplete;
    private LocalDate projectStartDate;
    private LocalDate projectFinishDate;

    public ProjectManagerDto(Long id, String firstName, String middleName, String lastName, String department, String assignProjectName, String projectStatus, String projectComplete, LocalDate projectStartDate, LocalDate projectFinishDate) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.department = department;
        this.assignProjectName = assignProjectName;
        this.projectStatus = projectStatus;
        this.projectComplete = projectComplete;
        this.projectStartDate = projectStartDate;
        this.projectFinishDate = projectFinishDate;
    }

    public ProjectManagerDto() {
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAssignProjectName() {
        return assignProjectName;
    }

    public void setAssignProjectName(String assignProjectName) {
        this.assignProjectName = assignProjectName;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getProjectComplete() {
        return projectComplete;
    }

    public void setProjectComplete(String projectComplete) {
        this.projectComplete = projectComplete;
    }

    public LocalDate getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(LocalDate projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public LocalDate getProjectFinishDate() {
        return projectFinishDate;
    }

    public void setProjectFinishDate(LocalDate projectFinishDate) {
        this.projectFinishDate = projectFinishDate;
    }

    @Override
    public String toString() {
        return "ProjectManagerDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", assignProjectName='" + assignProjectName + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                ", projectComplete='" + projectComplete + '\'' +
                ", projectStartDate=" + projectStartDate +
                ", projectFinishDate=" + projectFinishDate +
                '}';
    }
}
