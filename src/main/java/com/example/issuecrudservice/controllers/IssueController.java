package com.example.issuecrudservice.controllers;

import com.example.issuecrudservice.dto.IssueDto;
import com.example.issuecrudservice.entities.IssueEntity;
import com.example.issuecrudservice.mapper.impl.IssueMapperImpl;
import com.example.issuecrudservice.services.impl.IssueServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class IssueController {

    private final IssueServiceImpl issueService;
    private final IssueMapperImpl issueMapper;

    public IssueController(IssueServiceImpl issueService, IssueMapperImpl issueMapper) {
        this.issueService = issueService;
        this.issueMapper = issueMapper;
    }

    @GetMapping(path = "/issues")
    public List<IssueDto> getAllIssues() {
        List<IssueEntity> issueEntities = issueService.getAllIssus();
        return issueEntities.stream().map(issueMapper::mapTo).collect(Collectors.toList());
    }

    @GetMapping(path = "/issues/{issueId}")
    public IssueDto getIssue(@PathVariable Long issueId) {
        return issueMapper.mapTo(issueService.getIssue(issueId));
    }

    @GetMapping(path = "/issues/{columndId}")
    public List<IssueDto> getAllIssuesForAColumn(@PathVariable Long columnId) {
        List<IssueEntity> issueEntities = issueService.findIssuesByColumnId(columnId);
        return issueEntities.stream().map(issueMapper::mapTo).collect(Collectors.toList());
    }
    @PostMapping(path = "/issues")
    public IssueDto createIssue(@RequestBody IssueDto issueDto) {
        IssueEntity issueEntity = issueMapper.mapFrom(issueDto);
        return issueMapper.mapTo(issueService.createIssue(issueEntity));
    }

    @PutMapping(path = "/issues")
    public IssueDto updateIssue(@RequestBody IssueDto issueDto) {
        IssueEntity issueEntity = issueMapper.mapFrom(issueDto);
        return issueMapper.mapTo(issueService.updateIssue(issueEntity));
    }

    @DeleteMapping(path = "/issues")
    public ResponseEntity<IssueDto> deleteIssue(@RequestBody IssueDto issueDto) {
        issueService.deleteIssue(issueDto.getIssueId());
        return ResponseEntity.ok().build();
    }

}
