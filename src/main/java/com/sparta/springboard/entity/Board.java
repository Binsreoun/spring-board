package com.sparta.springboard.entity;

import com.sparta.springboard.dto.BoardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "board") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Board extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "detail", nullable = false, length = 1000)
    private String detail;
    @Column(name = "writer", nullable = false)
    private String writer;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "view")
    @ColumnDefault("0")
    private Long view;


    public Board(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.detail = boardRequestDto.getDetail();
        this.writer = boardRequestDto.getWriter();
        this.password = boardRequestDto.getPassword();
    }

    public void update(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.detail = boardRequestDto.getDetail();
    }

    public void plusView(Board board) {
        this.view = board.getView() + 1;
    }

    @PrePersist
    public void prePersist() {
        this.view = this.view == null ? 0 : this.view;
    }
}