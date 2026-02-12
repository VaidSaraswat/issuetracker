package com.example.issuecrudservice.services;

import com.example.issuecrudservice.entities.ColumnEntity;

import java.util.List;

public interface ColumnService {
    public ColumnEntity createColumn(ColumnEntity columnEntity);
    public ColumnEntity updateColumn(ColumnEntity columnEntity);
    public void deleteColumn(Long columnId);
    public List<ColumnEntity> getAllColumns();
    public ColumnEntity getColumnById(Long id);
}
