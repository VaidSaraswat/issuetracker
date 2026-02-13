package com.example.issuecrudservice.repositories;

import com.example.issuecrudservice.entities.ColumnEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColumnRepository extends CrudRepository<ColumnEntity, Long> {
    List<ColumnEntity> findColumnEntitiesByBoardEntity_BoardId(Long boardEntityBoardId);
}
