package com.jtb.taxpayerws.service.impl;

import com.jtb.taxpayerws.dto.TaskDto;
import com.jtb.taxpayerws.dto.TeamMemberDto;
import com.jtb.taxpayerws.entity.TaskEntity;
import com.jtb.taxpayerws.entity.TeamMemberEntity;
import com.jtb.taxpayerws.enums.ErrorInfo;
import com.jtb.taxpayerws.exception.ApiException;
import com.jtb.taxpayerws.payload.PageDetail;
import com.jtb.taxpayerws.payload.Paging;
import com.jtb.taxpayerws.payload.response.TaskResponse;
import com.jtb.taxpayerws.payload.response.TeamMemberResponse;
import com.jtb.taxpayerws.repository.TaskRepository;
import com.jtb.taxpayerws.service.TaskService;
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
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final ModelMapper modelMapper;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createTask(TaskDto taskDto) {

        Optional<TaskEntity> optionalTask = taskRepository.findByTaskDescription(taskDto.getTaskDescription());
        if(optionalTask.isPresent()) {
            throw new ApiException(HttpStatus.CONFLICT, "team member already exists");
        }
        TaskEntity taskEntity = modelMapper.map(taskDto, TaskEntity.class);
        modelMapper.map(taskRepository.save(taskEntity), TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTask() {

        List<TaskEntity> taskEntityList = taskRepository.findAll();
        List<TaskDto> taskDtoList = taskEntityList.stream().map(list ->modelMapper.map(list,TaskDto.class)).collect(Collectors.toList());
        return taskDtoList;

    }

    @Override
    public TaskDto getTaskById(Long id) {
        return  abortIfTaskRecordDoseNotExist(id);
    }

    @Override
    public TaskDto UpdateTaskById(TaskDto taskDto) {
        TaskDto oldTaskDto = abortIfTaskRecordDoseNotExist(taskDto.getId());
        modelMapper.map(taskDto, oldTaskDto);
        TaskEntity taskEntity = modelMapper.map(oldTaskDto,TaskEntity.class);
        TaskDto taskDto1 = modelMapper.map(taskEntity, TaskDto.class);
        return taskDto1;

    }

    @Override
    public void deleteTask(Long id) {
         TaskDto taskDto = abortIfTaskRecordDoseNotExist(id);
         TaskEntity taskEntity = modelMapper.map(taskDto, TaskEntity.class);
         taskRepository.delete(taskEntity);
    }

    @Override
    public PageDetail<TaskResponse> pagenateAllTask(int page, int limit) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by("").descending());
        Page<TaskEntity> pages = taskRepository.findAll(pageable);
        Paging paging = new Paging();
        paging.setPage(pages.getNumber() + 1);
        paging.setPageSize(pages.getSize());
        paging.setTotalPages(pages.getTotalPages());
        paging.setTotalRecord(pages.getTotalElements());

        PageDetail<TaskResponse> pageDetail = new PageDetail<>();
        pageDetail.setPaging(paging);
        pageDetail.setRequests(pages.getContent().stream().map(x -> modelMapper.map(x, TaskResponse.class)).collect(Collectors.toList()));

        return pageDetail;

    }


    public TaskDto abortIfTaskRecordDoseNotExist(Long id){
        Optional<TaskEntity> taskEntity = taskRepository.findTaskById(id);
        TaskEntity taskEntity1 = taskEntity.orElseThrow(() -> new  ApiException(HttpStatus.NOT_FOUND, ErrorInfo.RECORD_DOES_NOT_EXIST.getErrorMessage()));
        return modelMapper.map(taskEntity1, TaskDto.class);
    }




}
