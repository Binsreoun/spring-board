package com.sparta.springboard.dto;

import com.sparta.springboard.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {

    private final Long id;
    private final String title;
    private final String detail;
    private final String writer;
    private final Long view;

    public BoardResponseDto(Board Board) {
        this.id=Board.getId();
        this.title=Board.getTitle();
        this.detail=Board.getDetail();
        this.writer=Board.getWriter();
        this.view=Board.getView();
    }
}
