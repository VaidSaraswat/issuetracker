package com.example.issuecrudservice.services.impl;

import com.example.issuecrudservice.entities.ColumnEntity;
import com.example.issuecrudservice.repositories.ColumnRepository;
import com.example.issuecrudservice.services.ColumnService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ColumnServiceImpl implements ColumnService {
    private final ColumnRepository columnRepository;

    public ColumnServiceImpl(ColumnRepository columnRepository) {
        this.columnRepository = columnRepository;
    }

    @Override
    public ColumnEntity createColumn(ColumnEntity columnEntity) {
        return columnRepository.save(columnEntity);
    }

    @Override
    public ColumnEntity updateColumn(ColumnEntity columnEntity) {
        return columnRepository.save(columnEntity);
    }

    @Override
    public void deleteColumn(Long columnId) {
        columnRepository.deleteById(columnId);
    }

    @Override
    public List<ColumnEntity> getAllColumns() {
        return StreamSupport.
                stream(columnRepository.findAll().spliterator(), false)
                .toList();
    }

    @Override
    public ColumnEntity getColumnById(Long id) {
        return columnRepository.findById(id).orElse(null);
    }


    @Override
    public List<ColumnEntity> findColumnsByBoardId(Long boardId) {
        return this.columnRepository.findColumnEntitiesByBoardEntity_BoardId(boardId);
    }
}
