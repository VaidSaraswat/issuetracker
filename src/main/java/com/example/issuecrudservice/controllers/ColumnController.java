package com.example.issuecrudservice.controllers;

import com.example.issuecrudservice.dto.ColumnDto;
import com.example.issuecrudservice.entities.ColumnEntity;
import com.example.issuecrudservice.mapper.impl.ColumnMapperImpl;
import com.example.issuecrudservice.services.impl.ColumnServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
    private final SimpMessagingTemplate messagingTemplate;

    public ColumnController(ColumnMapperImpl columnMapper, ColumnServiceImpl columnService, SimpMessagingTemplate messagingTemplate) {
        this.columnMapper = columnMapper;
        this.columnService = columnService;
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping(path = "/columns/board/{boardId}")
    public List<ColumnDto> getAllColumnsForBoard(@PathVariable Long boardId) {
        List<ColumnEntity> columnEntities = columnService.findColumnsByBoardId(boardId);
        return columnEntities.stream().map(columnMapper::mapTo).collect(Collectors.toList());
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
        ColumnDto createdColumnDto = columnMapper.mapTo(columnService.createColumn(columnEntity));
        messagingTemplate.convertAndSend("/topic/updates", createdColumnDto);
        return columnDto;
    }

    @PutMapping(path = "/column")
    public ColumnDto updateColumn(@RequestBody ColumnDto columnDto) {
        ColumnEntity columnEntity = columnMapper.mapFrom(columnDto);
        ColumnDto updatedColumnDto = columnMapper.mapTo(columnService.createColumn(columnEntity));
        messagingTemplate.convertAndSend("/topic/updates", updatedColumnDto);
        return updatedColumnDto;
    }

    @DeleteMapping(path = "/columns/{columnId}")
    public ResponseEntity<ColumnEntity> deleteColumn(@PathVariable Long columnId) {
        columnService.deleteColumn(columnId);
        return ResponseEntity.ok().build();
    }

}

