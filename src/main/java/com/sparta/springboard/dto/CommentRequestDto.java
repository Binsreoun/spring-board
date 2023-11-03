package com.sparta.springboard.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private Long boradId;
    private String detail;
    private String writer;
    private String password;
}
