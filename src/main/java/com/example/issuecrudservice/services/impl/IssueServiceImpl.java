package com.example.issuecrudservice.services.impl;

import com.example.issuecrudservice.entities.IssueEntity;
import com.example.issuecrudservice.repositories.IssueRepository;
import com.example.issuecrudservice.services.IssueService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class IssueServiceImpl implements IssueService {
    private IssueRepository issueRepository;
    public IssueServiceImpl(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @Override
    public List<IssueEntity> getAllIssus() {
        return StreamSupport
                .stream(issueRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public IssueEntity getIssue(Long id){
        return issueRepository.findById(id).orElse(null);
    }

    @Override
    public IssueEntity createIssue(IssueEntity issueEntity) {
        return issueRepository.save(issueEntity);
    }

    @Override
    public IssueEntity updateIssue(IssueEntity issueEntity) {
        return issueRepository.save(issueEntity);
    }

    @Override
    public void deleteIssue(Long id) {
        issueRepository.deleteById(id);
    }

    @Override
    public List<IssueEntity> findIssuesByColumnId(Long columnId) {
        return issueRepository.findIssuesByColumnId(columnId);
    }
}
