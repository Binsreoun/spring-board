package com.sparta.springboard.dto;

import com.sparta.springboard.entity.Comment;

public class CommentResponseDto {
    private Long id;
    private Long boradId;
    private String detail;
    private String writer;
    private String password;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.boradId = comment.getBoardId();
        this.detail = comment.getDetail();
        this.writer = comment.getWriter();
    }
}
