package com.sparta.springboard.controller;

import com.sparta.springboard.dto.BoardRequestDto;
import com.sparta.springboard.dto.BoardResponseDto;
import com.sparta.springboard.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/contents")
    public List<BoardResponseDto> getBoard(){
        return boardService.getBoard();
    }

    @GetMapping("/create")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto boardRequestDto){
        return boardService.createBoard(boardRequestDto);
    }

    @GetMapping("/contents/{id}")
    public BoardResponseDto getBoardById(@PathVariable Long id){
        return boardService.getBoardById(id);
    }

    @PostMapping("/update/{id}")
    public BoardResponseDto updateBoard(@PathVariable Long id,@RequestBody BoardRequestDto boardRequestDto){
        return boardService.updateBoard(id,boardRequestDto);
    }

    @PostMapping("/delete/{id}")
    public Long updateBoard(@PathVariable Long id){
        return boardService.deleteBoard(id);
    }

}
