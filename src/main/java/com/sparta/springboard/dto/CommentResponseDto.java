package com.sparta.springboard.dto;

import com.sparta.springboard.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {
    private final Long id;
    private final Long boradId;
    private final String detail;
    private final String writer;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.boradId = comment.getBoardId();
        this.detail = comment.getDetail();
        this.writer = comment.getWriter();
    }
}
