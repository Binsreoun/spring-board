package com.sparta.springboard.service;

import com.sparta.springboard.dto.BoardRequestDto;
import com.sparta.springboard.dto.BoardResponseDto;
import com.sparta.springboard.entity.Board;
import com.sparta.springboard.repository.BoardRepository;
import jakarta.transaction.Transactional;
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

    public List<BoardResponseDto> getBoardByDetail(String keyword) {
        return boardRepository.findAllByDetailContainsOrderByModifiedAtDesc(keyword).stream().map(BoardResponseDto::new).toList();
    }

    public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {
        Board board = new Board(boardRequestDto);
        boardRepository.save(board);
        return new BoardResponseDto(board);
    }

    public BoardResponseDto getBoardById(Long id) {
        return boardRepository.findById(id).stream().map(BoardResponseDto::new).findFirst().orElseThrow(
                () -> new IllegalArgumentException("선택한 게시물이 존재하지 않습니다.")
        );
    }

    @Transactional
    public BoardResponseDto updateBoard(Long id, BoardRequestDto boardRequestDto) {
        Board board = findBoardAndCheckedPassword(id,boardRequestDto);
        board.update(boardRequestDto);
        return new BoardResponseDto(board);
    }
    @Transactional
    public void updateView(Long id) {
        Board board =findBoardById(id);
        board.plusView(board);
    }

    public Long deleteBoard(Long id) {
        Board board =findBoardById(id);
        boardRepository.delete(board);
        return id;
    }

    private Board findBoardById(Long id) {
        return boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("선택한 게시물이 존재하지 않습니다.")
        );
    }

    private Board findBoardAndCheckedPassword(Long id,BoardRequestDto boardRequestDto) {
        return boardRepository.findById(id).filter(board -> board.getPassword().equals(boardRequestDto.getPassword())).orElseThrow(
                () -> new IllegalArgumentException("선택한 게시물이 존재하지 않거나, 비밀번호가 일치하지 않습니다.")
        );
    }
}
