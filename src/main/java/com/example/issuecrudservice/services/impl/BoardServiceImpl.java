package com.example.issuecrudservice.services.impl;

import com.example.issuecrudservice.entities.BoardEntity;
import com.example.issuecrudservice.repositories.BoardRepository;
import com.example.issuecrudservice.services.BoardService;
import org.springframework.stereotype.Component;

@Component
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public BoardEntity createBoard(BoardEntity boardEntity) {
        return boardRepository.save(boardEntity);
    }

    @Override
    public BoardEntity getBoard(Long boardId) {
        return boardRepository.findById(boardId).orElse(null);
    }

    @Override
    public BoardEntity updateBoard(BoardEntity boardEntity) {
        return boardRepository.save(boardEntity);
    }

    @Override
    public void deleteBoard(BoardEntity boardEntity) {
        boardRepository.deleteById(boardEntity.getBoardId());
    }
}
