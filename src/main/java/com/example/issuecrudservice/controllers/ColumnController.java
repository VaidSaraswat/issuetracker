package com.example.issuecrudservice.controllers;

import com.example.issuecrudservice.dto.ColumnDto;
import com.example.issuecrudservice.entities.ColumnEntity;
import com.example.issuecrudservice.mapper.impl.ColumnMapperImpl;
import com.example.issuecrudservice.services.impl.ColumnServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ColumnController {

    private final ColumnMapperImpl columnMapper;
    private final ColumnServiceImpl columnService;

    public ColumnController(ColumnMapperImpl columnMapper, ColumnServiceImpl columnService) {
        this.columnMapper = columnMapper;
        this.columnService = columnService;
    }

    @GetMapping(path = "/columns/{columnId}")
    public ColumnDto getColumn(@PathVariable Long columnId) {
        return columnMapper.mapTo(columnService.getColumnById(columnId));
    }

    @GetMapping(path = "/columns")
    public List<ColumnDto> getAllColumns() {
        List<ColumnEntity> columnEntities = columnService.getAllColumns();
        return columnEntities.stream().map(columnMapper::mapTo).collect(Collectors.toList());
    }

    @PostMapping(path = "/columns")
    public ColumnDto createColumn(@RequestBody ColumnDto columnDto) {
        ColumnEntity columnEntity = columnMapper.mapFrom(columnDto);
        return columnMapper.mapTo(columnService.createColumn(columnEntity));
    }

    @PutMapping(path = "/columns")
    public ColumnDto updateColumn(@RequestBody ColumnDto columnDto) {
        ColumnEntity columnEntity = columnMapper.mapFrom(columnDto);
        return columnMapper.mapTo(columnService.updateColumn(columnEntity));
    }

    @DeleteMapping(path = "/columns")
    public ResponseEntity<ColumnEntity> deleteColumn(Long columnId) {
        columnService.deleteColumn(columnId);
        return ResponseEntity.ok().build();
    }

}

