package com.example.issuecrudservice.services;

import com.example.issuecrudservice.entities.BoardEntity;

import java.util.List;

public interface BoardService {
    public BoardEntity createBoard(BoardEntity boardEntity);
    public BoardEntity getBoard(Long boardId);
    public BoardEntity updateBoard(BoardEntity boardEntity);
    public List<BoardEntity> getBoards();
    public void deleteBoard(Long boardId);
}
