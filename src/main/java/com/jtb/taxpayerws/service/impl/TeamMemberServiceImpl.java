package com.jtb.taxpayerws.service.impl;

import com.jtb.taxpayerws.dto.TeamMemberDto;
import com.jtb.taxpayerws.entity.ProjectManagerEntity;
import com.jtb.taxpayerws.entity.TeamMemberEntity;
import com.jtb.taxpayerws.enums.ErrorInfo;
import com.jtb.taxpayerws.exception.ApiException;
import com.jtb.taxpayerws.payload.PageDetail;
import com.jtb.taxpayerws.payload.Paging;
import com.jtb.taxpayerws.payload.response.TeamMemberResponse;
import com.jtb.taxpayerws.repository.TeamMemberRepository;
import com.jtb.taxpayerws.service.TeamMemberService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

    private final TeamMemberRepository teamMemberRepository;

    private final ModelMapper modelMapper;

    public TeamMemberServiceImpl(TeamMemberRepository teamMemberRepository, ModelMapper modelMapper){

        this.teamMemberRepository = teamMemberRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createTeam(TeamMemberDto teamMemberDto) {

        Optional<TeamMemberEntity> optionalTeamMember = teamMemberRepository.findByEmail(teamMemberDto.getEmail());
        if(optionalTeamMember.isPresent()) {
            throw new ApiException(HttpStatus.CONFLICT, "team member already exists");
        }
        TeamMemberEntity teamMemberEntity = modelMapper.map(teamMemberDto, TeamMemberEntity.class);
        modelMapper.map(teamMemberRepository.save(teamMemberEntity), TeamMemberDto.class);

    }

    @Override
    public List<TeamMemberDto> getAllTeam() {
        List<TeamMemberEntity> teamMemberEntityList = teamMemberRepository.findAll();
        List<TeamMemberDto> teamMemberDtoList = teamMemberEntityList.stream().map(list ->modelMapper.map(list,TeamMemberDto.class)).collect(Collectors.toList());
        return teamMemberDtoList;
    }

    @Override
    public TeamMemberDto getTeamById(Long id) {
        return abortIfTeamMemberRecordDoseNotExist(id);
    }

    @Override
    public TeamMemberDto UpdateTeamMemberById(TeamMemberDto teamMemberDto) {
        TeamMemberDto oldTeamMemberDto = abortIfTeamMemberRecordDoseNotExist(teamMemberDto.getId());
        modelMapper.map(teamMemberDto, oldTeamMemberDto);
        TeamMemberEntity teamMemberEntity = modelMapper.map(oldTeamMemberDto,TeamMemberEntity.class);
        TeamMemberDto teamMemberDto1 = modelMapper.map(teamMemberEntity, TeamMemberDto.class);

        return teamMemberDto1;
    }

    @Override
    public void deleteTeamMember(Long id) {
       TeamMemberDto teamMemberDto = abortIfTeamMemberRecordDoseNotExist(id);
       TeamMemberEntity teamMember = modelMapper.map(teamMemberDto, TeamMemberEntity.class);
       teamMemberRepository.delete(teamMember);

    }


    @Override
    @Transactional
    public PageDetail<TeamMemberResponse> pagenateAllTeamMember(int page, int limit) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by("").descending());
        Page<TeamMemberEntity> pages = teamMemberRepository.findAll(pageable);
        Paging paging = new Paging();
        paging.setPage(pages.getNumber() + 1);
        paging.setPageSize(pages.getSize());
        paging.setTotalPages(pages.getTotalPages());
        paging.setTotalRecord(pages.getTotalElements());

        PageDetail<TeamMemberResponse> pageDetail = new PageDetail<>();
        pageDetail.setPaging(paging);
        pageDetail.setRequests(pages.getContent().stream().map(x -> modelMapper.map(x, TeamMemberResponse.class)).collect(Collectors.toList()));

        return pageDetail;
    }



    public TeamMemberDto abortIfTeamMemberRecordDoseNotExist(Long id){
        Optional<TeamMemberEntity> teamMemberEntity = teamMemberRepository.findTeamMemberById(id);
        TeamMemberEntity teamMember = teamMemberEntity.orElseThrow(() -> new  ApiException(HttpStatus.NOT_FOUND, ErrorInfo.RECORD_DOES_NOT_EXIST.getErrorMessage()));
        return modelMapper.map(teamMember, TeamMemberDto.class);
    }




}
