package me.don1ns.adsonlineresaleshop.service.impl;

import me.don1ns.adsonlineresaleshop.DTO.CommentDTO;
import me.don1ns.adsonlineresaleshop.DTO.CreateCommentDTO;
import me.don1ns.adsonlineresaleshop.DTO.ResponseWrapperCommentDTO;
import me.don1ns.adsonlineresaleshop.DTO.Role;
import me.don1ns.adsonlineresaleshop.entity.Ads;
import me.don1ns.adsonlineresaleshop.entity.Comment;
import me.don1ns.adsonlineresaleshop.entity.User;
import me.don1ns.adsonlineresaleshop.exception.AdNotFoundException;
import me.don1ns.adsonlineresaleshop.exception.CommentNotFoundException;
import me.don1ns.adsonlineresaleshop.mapper.CommentMapper;
import me.don1ns.adsonlineresaleshop.repository.AdsRepository;
import me.don1ns.adsonlineresaleshop.repository.CommentRepository;
import me.don1ns.adsonlineresaleshop.service.AdsService;
import me.don1ns.adsonlineresaleshop.service.CommentService;
import me.don1ns.adsonlineresaleshop.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static me.don1ns.adsonlineresaleshop.constant.Constant.*;

public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final AdsRepository adsRepository;
    private final CommentMapper commentMapper;
    private final UserService userService;

    public CommentServiceImpl(CommentRepository commentRepository, AdsRepository adsRepository, AdsService adsService, CommentMapper commentMapper, UserService userService) {
        this.commentRepository = commentRepository;
        this.adsRepository = adsRepository;
        this.commentMapper = commentMapper;
        this.userService = userService;
    }

    public ResponseWrapperCommentDTO getComments(Integer id, UserDetails currentUser) {
        List<CommentDTO> comments = commentRepository.findByAdsId(id).stream()
                .map(comment -> commentMapper.toCommentDto(comment))
                .toList();
        return new ResponseWrapperCommentDTO(comments.size(), comments);
    }

    @Override
    public CommentDTO addComment(Integer id, Comment commentDto, User currentUser) {
        Ads ads = adsRepository.findById(id).orElseThrow();
        User user = userService.checkUserByUsername(currentUser.getUsername());

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setAds(ads);
        comment.setCreatedAt(System.currentTimeMillis());
        comment.setText(commentDto.getText());

        comment = commentRepository.save(comment);

        return commentMapper.toCommentDto(comment);
    }

    @Override
    public CommentDTO updateComment(Integer adId, Integer commentId, CommentDTO commentDTO, UserDetails currentUser) {
        checkPermission(commentId, currentUser);
        Ads ads = adsRepository.findById(adId).
                orElseThrow(() -> {
                    return new AdNotFoundException(AD_NOT_FOUND_MSG.formatted(adId));
                });
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        comment.setCreatedAt(System.currentTimeMillis());
        comment.setText(commentDTO.getText());
        commentRepository.save(comment);
        return commentMapper.toCommentDto(comment);
    }


    @Override
    public boolean deleteComment(Integer commentId, UserDetails currentUser) {
        checkPermission(commentId, currentUser);
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException(COMMENT_NOT_FOUND_MSG.formatted(commentId)));
        commentRepository.delete(comment);
        return true;
    }

    /**
     * Проверяет, совпадает ли автор комментария с пользователем, вошедшим в систему.
     * Если это не так и пользователь не является администратором, то генерируется исключение.
     */

    private void checkPermission(Integer commentId, UserDetails currentUser) {
        String userName = commentRepository
                .findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException(COMMENT_NOT_FOUND_MSG.formatted(commentId)))
                .getUser()
                .getUsername();
        if (!userName.equals(currentUser.getUsername())
                && !currentUser.getAuthorities().contains(new SimpleGrantedAuthority(Role.ADMIN.name()))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, ACCESS_DENIED_MSG.formatted(currentUser.getUsername()));
        }
    }
}
