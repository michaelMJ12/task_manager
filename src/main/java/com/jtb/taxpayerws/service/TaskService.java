package com.jtb.taxpayerws.service;

import com.jtb.taxpayerws.dto.TaskDto;
import com.jtb.taxpayerws.payload.PageDetail;
import com.jtb.taxpayerws.payload.response.TaskResponse;


import java.util.List;

public interface TaskService {

    void createTask(TaskDto taskDto);

    List<TaskDto> getAllTask();

    TaskDto getTaskById(Long id);

    TaskDto  UpdateTaskById(TaskDto taskDto);

    void deleteTask(Long id);

    PageDetail<TaskResponse> pagenateAllTask(int page, int limit);

}
