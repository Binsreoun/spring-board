package com.sparta.springboard.entity;

import com.sparta.springboard.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "comment") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "board_id", nullable = false, length = 1000)
    private Long boardId;
    @Column(name = "detail", nullable = false, length = 1000)
    private String detail;
    @Column(name = "writer", nullable = false)
    private String writer;
    @Column(name = "password", nullable = false)
    private String password;

    public Comment(CommentRequestDto commentRequestDto){
        this.boardId = commentRequestDto.getBoradId();
        this.detail = commentRequestDto.getDetail();
        this.writer = commentRequestDto.getWriter();
        this.password = commentRequestDto.getPassword();
    }

    public void update(CommentRequestDto commentRequestDto) {
        this.detail = commentRequestDto.getDetail();
        this.writer = commentRequestDto.getWriter();
    }
}