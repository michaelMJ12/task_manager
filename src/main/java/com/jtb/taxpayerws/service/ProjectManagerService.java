package com.jtb.taxpayerws.service;

import com.jtb.taxpayerws.dto.ProjectManagerDto;
import com.jtb.taxpayerws.payload.PageDetail;
import com.jtb.taxpayerws.payload.response.ProjectManagerResponse;


import java.util.List;

public interface ProjectManagerService {

    void createProjectManager(ProjectManagerDto projectManagerDto);

    List<ProjectManagerDto> getAllProjectManager();

    ProjectManagerDto getProjectManagerById(Long id);

    ProjectManagerDto  UpdateProjectManagerById(ProjectManagerDto projectManagerDto);

    void deleteProjectManager(Long id);

    PageDetail<ProjectManagerResponse> pagenateAllProjectManager(int page, int limit);



}
