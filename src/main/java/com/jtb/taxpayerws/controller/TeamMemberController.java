package com.jtb.taxpayerws.controller;

import com.jtb.taxpayerws.dto.TeamMemberDto;
import com.jtb.taxpayerws.enums.ErrorInfo;
import com.jtb.taxpayerws.payload.Meta;
import com.jtb.taxpayerws.payload.PageDetail;
import com.jtb.taxpayerws.payload.request.ApiRequest;
import com.jtb.taxpayerws.payload.request.TeamMemberRequest;
import com.jtb.taxpayerws.payload.response.ApiResponse;
import com.jtb.taxpayerws.payload.response.TeamMemberResponse;
import com.jtb.taxpayerws.service.TeamMemberService;
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
@RequestMapping("team_member")
public class TeamMemberController {

    private final TeamMemberService teamMemberService;
    private final ModelMapper modelMapper;

    public TeamMemberController(TeamMemberService teamMemberService, ModelMapper modelMapper) {
        this.teamMemberService = teamMemberService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(value = "create_team", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ApiResponse<TeamMemberResponse>> createTeam(@RequestBody ApiRequest<TeamMemberRequest> request){
        TeamMemberDto teamMemberDto = modelMapper.map(request.getData(),TeamMemberDto.class);
        try{
            teamMemberService.createTeam(teamMemberDto);
            Meta meta = new Meta();
            meta.setMessage(ErrorInfo.FORM_SUBMITTED_SUCCESSFULLY.getErrorMessage());
            meta.setInfo(ErrorInfo.SUCCESS.getErrorMessage());
            meta.setStatus(HttpStatus.OK.name());

            ApiResponse<TeamMemberResponse> Response = new ApiResponse();
            Response.setMeta(meta);
            Response.setData(null);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(Response);

        }catch (Exception e){

            e.printStackTrace();
            Meta meta = new Meta();
            meta.setMessage(ErrorInfo.INTERNAL_SERVER_ERROR.getErrorMessage());
            meta.setInfo(ErrorInfo.INFO.getErrorMessage());
            meta.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());

            ApiResponse<TeamMemberResponse> errorResponse = new ApiResponse();
            errorResponse.setMeta(meta);
            errorResponse.setData(null);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body(errorResponse);

        }

    }

    @GetMapping(value = "team_list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ApiResponse<List<TeamMemberResponse>>> getAllTeam(){
        List<TeamMemberDto> teamMemberDtoList = teamMemberService.getAllTeam();
        List<TeamMemberResponse> teamMemberResponseList = teamMemberDtoList.stream().map(list ->modelMapper.map(list, TeamMemberResponse.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(ResponseUtil.buildOkResponse(teamMemberResponseList));
    }

    @GetMapping(value = "get_per_team_member/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ApiResponse<TeamMemberResponse>> getPerTeamMemberById(@PathVariable Long id){
        TeamMemberDto teamMemberDto = teamMemberService.getTeamById(id);
        TeamMemberResponse teamMemberResponse = modelMapper.map(teamMemberDto,TeamMemberResponse.class);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(ResponseUtil.buildOkResponse(teamMemberResponse));
    }


    @PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ApiResponse<TeamMemberResponse>> updateTeamMemberById(@RequestBody @Valid ApiRequest<TeamMemberRequest> teamMemberRequestApiRequest, @PathVariable Long id){
        TeamMemberDto teamMemberDto = modelMapper.map(teamMemberRequestApiRequest.getData(), TeamMemberDto.class);
        teamMemberDto.setId(id);
        TeamMemberResponse teamMemberResponse = modelMapper.map(teamMemberService.UpdateTeamMemberById(teamMemberDto),TeamMemberResponse.class);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).body(ResponseUtil.buildOkResponse(teamMemberResponse));
    }

    @DeleteMapping(value = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteTeamMember(@PathVariable("id") Long id) {
        teamMemberService.deleteTeamMember(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<PageDetail>> getTeamMemberPaginated(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit) {

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(ResponseUtil.buildOkResponse(teamMemberService.pagenateAllTeamMember(page, limit)));
    }






}
