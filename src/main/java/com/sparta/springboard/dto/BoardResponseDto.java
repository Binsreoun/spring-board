package com.sparta.springboard.dto;

import com.sparta.springboard.entity.Board;
import jakarta.persistence.Column;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

@Getter
public class BoardResponseDto {

    private Long id;
    private String titile;
    private String detail;
    private String writer;
    private Long view;

    public BoardResponseDto(Board Board) {
        this.id=Board.getId();
        this.titile=Board.getTitile();
        this.detail=Board.getDetail();
        this.writer=Board.getWriter();
        this.view=Board.getView();
    }
}
