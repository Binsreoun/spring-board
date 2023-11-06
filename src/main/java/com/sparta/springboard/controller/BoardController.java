package com.sparta.springboard.controller;

import com.sparta.springboard.dto.BoardRequestDto;
import com.sparta.springboard.dto.BoardResponseDto;
import com.sparta.springboard.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/contents/keyword")
    public List<BoardResponseDto> getBoarByDetail(String keyword){
        return boardService.getBoardByDetail(keyword);
    }

    @PostMapping("/create")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto boardRequestDto){
        return boardService.createBoard(boardRequestDto);
    }

    @GetMapping("/contents/detail")
    public BoardResponseDto getBoardById(Long id){
        boardService.updateView(id);
        return boardService.getBoardById(id);
    }

    @PostMapping("/update/{id}")
    public BoardResponseDto updateBoard(@PathVariable Long id,@RequestBody BoardRequestDto boardRequestDto){
        return boardService.updateBoard(id,boardRequestDto);
    }

    @PostMapping("/delete/{id}")
    public Long deleteBoard(@PathVariable Long id,@RequestBody Map<String, String> passwordMap){
        return boardService.deleteBoard(id,passwordMap.get("password"));
    }

}
