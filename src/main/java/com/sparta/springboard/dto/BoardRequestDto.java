package com.sparta.springboard.dto;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String title;
    private String detail;
    private String writer;
    private String password;
}
