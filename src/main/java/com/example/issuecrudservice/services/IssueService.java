package com.example.issuecrudservice.services;

import com.example.issuecrudservice.entities.IssueEntity;

import java.util.List;

public interface IssueService {
    public List<IssueEntity> getAllIssus();
    public IssueEntity getIssue(Long id);
    public IssueEntity createIssue(IssueEntity issueEntity);
    public IssueEntity updateIssue(IssueEntity issueEntity);
    public void deleteIssue(Long id);
    public List<IssueEntity> findIssuesByColumnId(Long id);
}
