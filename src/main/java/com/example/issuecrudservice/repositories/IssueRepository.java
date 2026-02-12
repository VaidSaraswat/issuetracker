package com.example.issuecrudservice.repositories;

import com.example.issuecrudservice.entities.IssueEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends CrudRepository<IssueEntity, Long> {
    public List<IssueEntity> findIssuesByColumnId(Long id);
}
