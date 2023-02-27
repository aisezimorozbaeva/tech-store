package com.ais.techstore.service.impl;

import com.ais.techstore.model.Comment;
import com.ais.techstore.repository.CommentRepository;
import com.ais.techstore.service.CommentService;
import com.ais.techstore.service.ProductService;
import com.ais.techstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final ProductService productService;

    @Override
    public void save(Comment comment, long productId, long userId) {
        comment.setDate(LocalDate.now());
        comment.setUser(userService.findById(userId));
        comment.setProduct(productService.findById(productId));
        commentRepository.save(comment);
    }

}
