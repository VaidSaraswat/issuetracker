package com.example.issuecrudservice.controllers;

import com.example.issuecrudservice.dto.BoardDto;
import com.example.issuecrudservice.entities.BoardEntity;
import com.example.issuecrudservice.mapper.impl.BoardMapperImpl;
import com.example.issuecrudservice.services.impl.BoardServiceImpl;
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
public class BoardController {

    private final BoardMapperImpl boardMapper;
    private final BoardServiceImpl boardService;

    public BoardController(BoardMapperImpl boardMapper, BoardServiceImpl boardService) {
        this.boardMapper = boardMapper;
        this.boardService = boardService;
    }

    @GetMapping(path = "/boards")
    public List<BoardDto> getBoards() {
        List<BoardEntity> boardEntities = boardService.getBoards();
        return boardEntities.stream().map(boardMapper::mapTo).collect(Collectors.toList());
    }

    @GetMapping(path = "/boards/{boardId}")
    public BoardDto getBoard(@PathVariable Long boardId) {
        return boardMapper.mapTo(boardService.getBoard(boardId));
    }

    @PostMapping(path = "/boards")
    public BoardDto createBoard(@RequestBody BoardDto boardDto) {
        BoardEntity boardEntity = boardMapper.mapFrom(boardDto);
        return boardMapper.mapTo(boardService.createBoard(boardEntity));
    }

    @PutMapping(path = "/board")
    public BoardDto updateBoard(@RequestBody BoardDto boardDto) {
        BoardEntity boardEntity = boardMapper.mapFrom(boardDto);
        return boardMapper.mapTo(boardService.updateBoard(boardEntity));
    }

    @DeleteMapping(path = "/board")
    public ResponseEntity<BoardDto> deleteBoard(@RequestBody BoardDto boardDto) {
        boardService.deleteBoard(boardDto.getBoardId());
        return ResponseEntity.ok().build();
    }

}

