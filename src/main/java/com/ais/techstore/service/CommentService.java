package com.ais.techstore.service;

import com.ais.techstore.model.Comment;

public interface CommentService {
    void save(Comment comment, long productId, long userId);
}
