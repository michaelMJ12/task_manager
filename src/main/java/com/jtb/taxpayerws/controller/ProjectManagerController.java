package com.jtb.taxpayerws.controller;

import com.jtb.taxpayerws.dto.ProjectManagerDto;
import com.jtb.taxpayerws.enums.ErrorInfo;
import com.jtb.taxpayerws.payload.Meta;
import com.jtb.taxpayerws.payload.PageDetail;
import com.jtb.taxpayerws.payload.request.ApiRequest;
import com.jtb.taxpayerws.payload.request.ProjectManagerRequest;
import com.jtb.taxpayerws.payload.response.ApiResponse;
import com.jtb.taxpayerws.payload.response.ProjectManagerResponse;
import com.jtb.taxpayerws.service.ProjectManagerService;
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
@RequestMapping("project")
public class ProjectManagerController {

          private final ProjectManagerService projectManagerService;

          private final ModelMapper modelMapper;


    public ProjectManagerController(ProjectManagerService projectManagerService, ModelMapper modelMapper) {
        this.projectManagerService = projectManagerService;
        this.modelMapper = modelMapper;
    }




    @PostMapping(value = "create_project_manager", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ApiResponse<ProjectManagerResponse>> createProjectManager(@RequestBody ApiRequest<ProjectManagerRequest> request){
        ProjectManagerDto projectManagerDto = modelMapper.map(request.getData(), ProjectManagerDto.class);
        System.out.println(projectManagerDto);
        try{
            projectManagerService.createProjectManager(projectManagerDto);
            Meta meta = new Meta();
            meta.setMessage(ErrorInfo.FORM_SUBMITTED_SUCCESSFULLY.getErrorMessage());
            meta.setInfo(ErrorInfo.SUCCESS.getErrorMessage());
            meta.setStatus(HttpStatus.OK.name());

            ApiResponse<ProjectManagerResponse> Response = new ApiResponse();
            Response.setMeta(meta);
            Response.setData(null);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(Response);

        }catch (Exception e){

            e.printStackTrace();
            Meta meta = new Meta();
            meta.setMessage(ErrorInfo.INTERNAL_SERVER_ERROR.getErrorMessage());
            meta.setInfo(ErrorInfo.INFO.getErrorMessage());
            meta.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());

            ApiResponse<ProjectManagerResponse> errorResponse = new ApiResponse();
            errorResponse.setMeta(meta);
            errorResponse.setData(null);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body(errorResponse);

        }

    }


    @GetMapping(value = "project_manager_list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ApiResponse<List<ProjectManagerResponse>>> getAllProjectManager(){
        List<ProjectManagerDto> projectManagerDtoList = projectManagerService.getAllProjectManager();
        List<ProjectManagerResponse> projectManagerResponseList = projectManagerDtoList.stream().map(list ->modelMapper.map(list, ProjectManagerResponse.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(ResponseUtil.buildOkResponse(projectManagerResponseList));
    }


    @GetMapping(value = "get_per_project_manager/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ApiResponse<ProjectManagerResponse>> getPerProjectManagerById(@PathVariable("id") Long id){
        ProjectManagerDto projectManagerDto = projectManagerService.getProjectManagerById(id);
        ProjectManagerResponse projectManagerResponse = modelMapper.map(projectManagerDto,ProjectManagerResponse.class);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(ResponseUtil.buildOkResponse(projectManagerResponse));
    }


    @PutMapping(value = "update_project_manager/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ApiResponse<ProjectManagerResponse>> updateProjectManagerById(@RequestBody @Valid ApiRequest<ProjectManagerRequest> projectManagerRequestApiRequest, @PathVariable Long id){
        ProjectManagerDto projectManagerDto = modelMapper.map(projectManagerRequestApiRequest.getData(), ProjectManagerDto.class);
        projectManagerDto.setId(id);
        ProjectManagerResponse projectManagerResponse = modelMapper.map(projectManagerService.UpdateProjectManagerById(projectManagerDto),ProjectManagerResponse.class);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).body(ResponseUtil.buildOkResponse(projectManagerResponse));
    }


    @DeleteMapping(value = "delete_project_manager/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProjectManager(@PathVariable("id") Long id) {
        projectManagerService.deleteProjectManager(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<PageDetail>> getProjectManagerPaginated(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(ResponseUtil.buildOkResponse(projectManagerService.pagenateAllProjectManager(page, limit)));
    }




}
