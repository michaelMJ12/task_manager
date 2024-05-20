package com.jtb.taxpayerws.service.impl;

import com.jtb.taxpayerws.dto.ProjectManagerDto;
import com.jtb.taxpayerws.entity.ProjectManagerEntity;
import com.jtb.taxpayerws.enums.ErrorInfo;
import com.jtb.taxpayerws.exception.ApiException;
import com.jtb.taxpayerws.payload.PageDetail;
import com.jtb.taxpayerws.payload.Paging;
import com.jtb.taxpayerws.payload.response.ProjectManagerResponse;
import com.jtb.taxpayerws.repository.ProjectManagerRepository;
import com.jtb.taxpayerws.service.ProjectManagerService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectManagerServiceImpl implements ProjectManagerService {


    private final ProjectManagerRepository projectManagerRepository;

    private final ModelMapper modelMapper;

    public ProjectManagerServiceImpl(ProjectManagerRepository projectManagerRepository, ModelMapper modelMapper) {
        this.projectManagerRepository = projectManagerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void createProjectManager(ProjectManagerDto projectManagerDto) {
        System.out.println(projectManagerDto);
        Optional<ProjectManagerEntity> optionalProjectManagerEntity = projectManagerRepository.findByAssignProjectName(projectManagerDto.getAssignProjectName());
        if(optionalProjectManagerEntity.isPresent()) {
            throw new ApiException(HttpStatus.CONFLICT, "project manager already exists");
        }
        ProjectManagerEntity projectManagerEntity = modelMapper.map(projectManagerDto, ProjectManagerEntity.class);
        System.out.println(projectManagerEntity);
        modelMapper.map(projectManagerRepository.save(projectManagerEntity), ProjectManagerEntity.class);


    }

    @Override
    public List<ProjectManagerDto> getAllProjectManager() {
        List<ProjectManagerEntity> projectManagerEntityList = projectManagerRepository.findAll();
        List<ProjectManagerDto> projectManagerDtoList = projectManagerEntityList.stream().map(list ->modelMapper.map(list,ProjectManagerDto.class)).collect(Collectors.toList());
        return projectManagerDtoList;
    }

    @Override
    public ProjectManagerDto getProjectManagerById(Long id) {
        return abortIfProjectManagerRecordDoseNotExist(id);
    }

    @Override
    public ProjectManagerDto UpdateProjectManagerById(ProjectManagerDto projectManagerDto) {

        ProjectManagerDto oldProjectManagerDto = abortIfProjectManagerRecordDoseNotExist(projectManagerDto.getId());
        modelMapper.map(projectManagerDto, oldProjectManagerDto);
        ProjectManagerEntity projectManagerEntity = modelMapper.map(oldProjectManagerDto,ProjectManagerEntity.class);
        ProjectManagerDto projectManagerDto1 = modelMapper.map(projectManagerEntity, ProjectManagerDto.class);
        return projectManagerDto1;
    }

    @Override
    public void deleteProjectManager(Long id) {
        ProjectManagerDto projectManagerDto = abortIfProjectManagerRecordDoseNotExist(id);
        ProjectManagerEntity projectManager = modelMapper.map(projectManagerDto, ProjectManagerEntity.class);
        projectManagerRepository.delete(projectManager);
    }

    @Override
    public PageDetail<ProjectManagerResponse> pagenateAllProjectManager(int page, int limit) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by("").descending());
        Page<ProjectManagerEntity> pages = projectManagerRepository.findAll(pageable);
        Paging paging = new Paging();
        paging.setPage(pages.getNumber() + 1);
        paging.setPageSize(pages.getSize());
        paging.setTotalPages(pages.getTotalPages());
        paging.setTotalRecord(pages.getTotalElements());

        PageDetail<ProjectManagerResponse> pageDetail = new PageDetail<>();
        pageDetail.setPaging(paging);
        pageDetail.setRequests(pages.getContent().stream().map(x -> modelMapper.map(x, ProjectManagerResponse.class)).collect(Collectors.toList()));

        return pageDetail;

    }


    public ProjectManagerDto abortIfProjectManagerRecordDoseNotExist(Long id){
        Optional<ProjectManagerEntity> projectManagerEntity = projectManagerRepository.findProjectManagerById(id);
        ProjectManagerEntity projectManagerEntity1 = projectManagerEntity.orElseThrow(() -> new  ApiException(HttpStatus.NOT_FOUND, ErrorInfo.RECORD_DOES_NOT_EXIST.getErrorMessage()));
        return modelMapper.map(projectManagerEntity1, ProjectManagerDto.class);
    }





}
