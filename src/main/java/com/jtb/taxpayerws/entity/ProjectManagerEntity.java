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

@Entity(name = "project_manage_table")
public class ProjectManagerEntity extends Auditable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name",nullable = false, length = 100)
    private String firstName;
    @Column(name = "middle_name",nullable = false, length = 100)
    private String middleName;
    @Column(name = "last_name",nullable = false, length = 100)
    private String lastName;
    @Column(name = "department",nullable = false, length = 100)
    private String department;
    @Column(name = "assign_project_name",nullable = false, length = 100)
    private String assignProjectName;
    @Column(name = "project_status",nullable = false, length = 100)
    private String projectStatus;
    @Column(name = "project_complete",nullable = false, length = 100)
    private String projectComplete;
    @Column(name = "project_start_date",nullable = false, length = 100)
    private LocalDate projectStartDate;
    @Column(name = "project_finish_date",nullable = false, length = 100)
    private LocalDate projectFinishDate;

    @CreatedBy
    private Long createdBy;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedBy
    private Long modifiedBy;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public ProjectManagerEntity(Long id, String firstName, String middleName, String lastName, String department, String assignProjectName, String projectStatus, String projectComplete, LocalDate projectStartDate, LocalDate projectFinishDate, Long createdBy, LocalDateTime createdAt, Long modifiedBy, LocalDateTime modifiedAt) {
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
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
    }

    public ProjectManagerEntity() {
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
        return "ProjectManagerEntity{" +
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
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                ", modifiedBy=" + modifiedBy +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
