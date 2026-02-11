package com.example.issuecrudservice.controllers;

import com.example.issuecrudservice.mapper.impl.BoardMapperImpl;
import com.example.issuecrudservice.services.impl.BoardServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    private final BoardMapperImpl boardMapper;
    private final BoardServiceImpl boardService;

    public BoardController(BoardMapperImpl boardMapper, BoardServiceImpl boardService) {
        this.boardMapper = boardMapper;
        this.boardService = boardService;
    }

}

