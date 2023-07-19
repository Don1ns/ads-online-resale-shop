package me.don1ns.adsonlineresaleshop.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.don1ns.adsonlineresaleshop.DTO.CommentDTO;
import me.don1ns.adsonlineresaleshop.DTO.CreateCommentDTO;
import me.don1ns.adsonlineresaleshop.DTO.ResponseWrapperCommentDTO;
import me.don1ns.adsonlineresaleshop.DTO.Role;
import me.don1ns.adsonlineresaleshop.entity.Ads;
import me.don1ns.adsonlineresaleshop.entity.Comment;
import me.don1ns.adsonlineresaleshop.entity.User;
import me.don1ns.adsonlineresaleshop.exception.AdNotFoundException;
import me.don1ns.adsonlineresaleshop.exception.CommentNotFoundException;
import me.don1ns.adsonlineresaleshop.exception.NoAccessException;
import me.don1ns.adsonlineresaleshop.mapper.CommentMapper;
import me.don1ns.adsonlineresaleshop.repository.AdsRepository;
import me.don1ns.adsonlineresaleshop.repository.CommentRepository;
import me.don1ns.adsonlineresaleshop.service.CommentService;
import me.don1ns.adsonlineresaleshop.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static me.don1ns.adsonlineresaleshop.constant.Constant.COMMENT_NOT_BELONG_AD_MSG;
import static me.don1ns.adsonlineresaleshop.constant.Constant.COMMENT_NOT_FOUND_MSG;
@Slf4j
@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final AdsRepository adsRepository;
    private final CommentMapper commentMapper;
    private final UserService userService;

    public CommentServiceImpl(CommentRepository commentRepository, AdsRepository adsRepository, CommentMapper commentMapper, UserService userService) {
        this.commentRepository = commentRepository;
        this.adsRepository = adsRepository;
        this.commentMapper = commentMapper;
        this.userService = userService;
    }

    @Override
    public ResponseWrapperCommentDTO getComments(Integer id) {
        List<CommentDTO> comments = commentRepository.getCommentsByAds_Id(id).stream()
                .map(commentMapper::toCommentDto)
                .toList();
        return new ResponseWrapperCommentDTO(comments.size(), comments);
    }

    @Override
    public CommentDTO addComment(Integer id, CreateCommentDTO createCommentDTO, Authentication authentication) {
        if (createCommentDTO.getText().isBlank()) {
            throw new IllegalArgumentException("Нет текста комментария");
        }
        Ads ads = adsRepository.findById(id).orElseThrow(AdNotFoundException::new);
        User user = userService.getUser(authentication.getName());

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setAds(ads);
        comment.setCreatedAt(System.currentTimeMillis());
        comment.setText(createCommentDTO.getText());

        comment = commentRepository.save(comment);

        return commentMapper.toCommentDto(comment);
    }

    @Override
    public CommentDTO updateComment(Integer adId, Integer commentId, CommentDTO commentDTO, Authentication authentication) {
        if (checkCommentAccess(commentId, authentication)) {
            Comment comment = commentRepository.getById(commentId);
            comment.setCreatedAt(System.currentTimeMillis());
            comment.setText(commentDTO.getText());
            commentRepository.save(comment);
            return commentMapper.toCommentDto(comment);
        }
        throw new NoAccessException("Нет доступа к комментарию");
    }

    private boolean checkCommentAccess(int commentId, Authentication authentication) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(CommentNotFoundException::new);
        if (userService.getUser(authentication.getName()).getAuthorities().contains(Role.ADMIN)) {
            return true;
        }
        return comment.getUser().getEmail().equals(authentication.getName());
    }

    @Override
    public boolean deleteComment(Integer adId, Integer commentId, Authentication authentication) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException(COMMENT_NOT_FOUND_MSG.formatted(commentId)));
        if (comment.getAds().getId() != adId) {
            throw new CommentNotFoundException(COMMENT_NOT_BELONG_AD_MSG);
        }
        if (checkCommentAccess(commentId, authentication)) {
            commentRepository.delete(comment);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAllByAdsId(int id) {
        commentRepository.deleteAllByAds_Id(id);
    }
}
