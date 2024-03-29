package com.ais.techstore.controller.rest;


import com.ais.techstore.model.Comment;
import com.ais.techstore.service.CommentService;
import com.ais.techstore.service.ProductService;
import com.ais.techstore.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@CrossOrigin
@Api(description = "Контроллер для коментарии")
public class CommentController {
    private final CommentService commentService;
    private final UserService userService;
    private final ProductService productService;

    public CommentController(CommentService commentService, UserService userService, ProductService productService) {
        this.commentService = commentService;
        this.userService = userService;
        this.productService = productService;
    }

    @PostMapping("/{product-id}/{user-id}")
    @Operation(summary = "Добавление комментарии", description = "Позволяет добавить коментарии в базу данных")

    public ResponseEntity<?> saveComment(
            @RequestBody Comment comment,
            @PathVariable("product-id") long productId,
            @PathVariable("user-id") long userId) {
        try {
            commentService.save(comment, productId, userId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
