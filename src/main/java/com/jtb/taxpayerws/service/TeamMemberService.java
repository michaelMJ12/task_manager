package com.jtb.taxpayerws.service;

import com.jtb.taxpayerws.dto.TeamMemberDto;
import com.jtb.taxpayerws.payload.PageDetail;
import com.jtb.taxpayerws.payload.response.TeamMemberResponse;

import java.util.List;

public interface TeamMemberService {

    void createTeam(TeamMemberDto teamMemberDto);

    List<TeamMemberDto> getAllTeam();

    TeamMemberDto getTeamById(Long id);

    TeamMemberDto  UpdateTeamMemberById(TeamMemberDto teamMemberDto);

    void deleteTeamMember(Long id);

    PageDetail<TeamMemberResponse> pagenateAllTeamMember(int page, int limit);



}
