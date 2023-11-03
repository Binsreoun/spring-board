package com.sparta.springboard.service;

import com.sparta.springboard.dto.CommentRequestDto;
import com.sparta.springboard.dto.CommentResponseDto;
import com.sparta.springboard.entity.Comment;
import com.sparta.springboard.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<CommentResponseDto> getComment(Long id) {
        return commentRepository.findByBoardId(id).stream().map(CommentResponseDto::new).toList();
    }

    public CommentResponseDto createComment(CommentRequestDto commentRequestDto) {
        Comment comment = new Comment(commentRequestDto);
        commentRepository.save(comment);
        return new CommentResponseDto(comment);
    }

    @Transactional
    public CommentResponseDto updateComment(Long id, CommentRequestDto commentRequestDto) {
        Comment comment = findCommentAndCheckedPassword(id,commentRequestDto);
        comment.update(commentRequestDto);
        return new CommentResponseDto(comment);
    }

    public Long deleteComment(Long id) {
        Comment comment = findCommentById(id);
        commentRepository.delete(comment);
        return id;
    }

    private Comment findCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("선택한 게시물이 존재하지 않습니다.")
        );
    }
    private Comment findCommentAndCheckedPassword(Long id, CommentRequestDto commentRequestDto) {
        return commentRepository.findById(id).filter(board -> board.getPassword().equals(commentRequestDto.getPassword())).orElseThrow(
                () -> new IllegalArgumentException("선택한 게시물이 존재하지 않거나, 비밀번호가 일치하지 않습니다.")
        );
    }
}
