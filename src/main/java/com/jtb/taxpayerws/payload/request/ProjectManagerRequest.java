package com.jtb.taxpayerws.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class ProjectManagerRequest {

    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("middle_name")
    private String middleName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("department")
    private String department;
    @JsonProperty("assign_project_name")
    private String assignProjectName;
    @JsonProperty("project_status")
    private String projectStatus;
    @JsonProperty("project_complete")
    private String projectComplete;
    @JsonProperty("project_start_date")
    private LocalDate projectStartDate;
    @JsonProperty("project_finish_date")
    private LocalDate projectFinishDate;

    public ProjectManagerRequest(Long id, String firstName, String middleName, String lastName, String department, String assignProjectName, String projectStatus, String projectComplete, LocalDate projectStartDate, LocalDate projectFinishDate) {
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
    public ProjectManagerRequest() {
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
        return "ProjectManagerRequest{" +
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
