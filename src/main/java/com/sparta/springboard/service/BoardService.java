package com.sparta.springboard.service;

import com.sparta.springboard.dto.BoardRequestDto;
import com.sparta.springboard.dto.BoardResponseDto;
import com.sparta.springboard.entity.Board;
import com.sparta.springboard.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository repository) {
        this.boardRepository = repository;
    }

    public List<BoardResponseDto> getBoard() {
        return boardRepository.findAllByOrderByModifiedAtDesc().stream().map(BoardResponseDto::new).toList();
    }

    public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {
        Board board = new Board(boardRequestDto);
        boardRepository.save(board);
        return new BoardResponseDto(board);
    }

}
