package com.example.issuecrudservice.repositories;

import com.example.issuecrudservice.entities.BoardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
}
