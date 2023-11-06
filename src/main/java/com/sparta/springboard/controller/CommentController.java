package com.sparta.springboard.controller;

import com.sparta.springboard.dto.CommentRequestDto;
import com.sparta.springboard.dto.CommentResponseDto;
import com.sparta.springboard.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/contents/{id}")
    public List<CommentResponseDto> getBoardByBoardId(@PathVariable Long id){
        return commentService.getComment(id);
    }

    @GetMapping("/create")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto commentRequestDto){
        return commentService.createComment(commentRequestDto);
    }

    @PostMapping("/update/{id}")
    public CommentResponseDto updateBoard(@PathVariable Long id,@RequestBody CommentRequestDto commentRequestDto){
        return commentService.updateComment(id,commentRequestDto);
    }

    @PostMapping("/delete/{id}")
    public Long updateBoard(@PathVariable Long id,@RequestBody Map<String, String> passwordMap){
        return commentService.deleteComment(id,passwordMap.get("password"));
    }

}
