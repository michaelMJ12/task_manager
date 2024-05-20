package com.jtb.taxpayerws.controller;

import com.jtb.taxpayerws.dto.TaskDto;
import com.jtb.taxpayerws.enums.ErrorInfo;
import com.jtb.taxpayerws.payload.Meta;
import com.jtb.taxpayerws.payload.PageDetail;
import com.jtb.taxpayerws.payload.request.ApiRequest;
import com.jtb.taxpayerws.payload.request.TaskRequest;
import com.jtb.taxpayerws.payload.response.ApiResponse;
import com.jtb.taxpayerws.payload.response.TaskResponse;
import com.jtb.taxpayerws.service.TaskService;
import com.jtb.taxpayerws.utils.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("task")
public class TaskController {


    private final TaskService taskService;

    private final ModelMapper modelMapper;


    public TaskController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }


    @PostMapping(value = "create_task", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ApiResponse<TaskResponse>> createTask(@RequestBody ApiRequest<TaskRequest> request){
        TaskDto taskDto = modelMapper.map(request.getData(), TaskDto.class);
        try{
            taskService.createTask(taskDto);
            Meta meta = new Meta();
            meta.setMessage(ErrorInfo.FORM_SUBMITTED_SUCCESSFULLY.getErrorMessage());
            meta.setInfo(ErrorInfo.SUCCESS.getErrorMessage());
            meta.setStatus(HttpStatus.OK.name());

            ApiResponse<TaskResponse> Response = new ApiResponse();
            Response.setMeta(meta);
            Response.setData(null);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(Response);

        }catch (Exception e){

            e.printStackTrace();
            Meta meta = new Meta();
            meta.setMessage(ErrorInfo.INTERNAL_SERVER_ERROR.getErrorMessage());
            meta.setInfo(ErrorInfo.INFO.getErrorMessage());
            meta.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());

            ApiResponse<TaskResponse> errorResponse = new ApiResponse();
            errorResponse.setMeta(meta);
            errorResponse.setData(null);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body(errorResponse);

        }

    }


    @GetMapping(value = "task_list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ApiResponse<List<TaskResponse>>> getAllTeam(){
        List<TaskDto> taskDtoList = taskService.getAllTask();
        List<TaskResponse> taskResponseList = taskDtoList.stream().map(list ->modelMapper.map(list, TaskResponse.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(ResponseUtil.buildOkResponse(taskResponseList));
    }


    @GetMapping(value = "get_per_task/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ApiResponse<TaskResponse>> getPerTaskById(@PathVariable Long id){
        TaskDto taskDto = taskService.getTaskById(id);
        TaskResponse taskResponse = modelMapper.map(taskDto,TaskResponse.class);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(ResponseUtil.buildOkResponse(taskResponse));
    }


    @PutMapping(value = "update_task/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ApiResponse<TaskResponse>> updateTaskById(@RequestBody @Valid ApiRequest<TaskRequest> taskRequestApiRequest, @PathVariable Long id){
        TaskDto taskDto = modelMapper.map(taskRequestApiRequest.getData(), TaskDto.class);
        taskDto.setId(id);
        TaskResponse taskResponse = modelMapper.map(taskService.UpdateTaskById(taskDto),TaskResponse.class);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).body(ResponseUtil.buildOkResponse(taskResponse));
    }


    @DeleteMapping(value = "delete_task/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<PageDetail>> getTaskPaginated(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit) {

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(ResponseUtil.buildOkResponse(taskService.pagenateAllTask(page, limit)));
    }





}
