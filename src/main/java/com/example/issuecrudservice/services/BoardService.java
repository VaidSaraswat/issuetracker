package com.example.issuecrudservice.services;

import com.example.issuecrudservice.entities.BoardEntity;

public interface BoardService {
    public BoardEntity createBoard(BoardEntity boardEntity);
    public BoardEntity getBoard(Long boardId);
    public BoardEntity updateBoard(BoardEntity boardEntity);
    public void deleteBoard(BoardEntity boardEntity);
}
