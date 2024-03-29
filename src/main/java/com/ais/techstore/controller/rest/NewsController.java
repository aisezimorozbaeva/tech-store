package com.ais.techstore.controller.rest;

import com.ais.techstore.model.News;
import com.ais.techstore.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@CrossOrigin
@Api(description = "контроллер для управления новостями")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping()
    @Operation(summary = "новости", description = "Позволяет получить все новости из базы данных")
    public ResponseEntity<List<News>> getAllProduct() {
        try {
            return new ResponseEntity<>(newsService.findAllNews(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/add")
    @Operation(summary = "Save news",description = "Saving news")
    public ResponseEntity<?> saveNews(@RequestBody News news) {
        try {
            newsService.save(news);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<News> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(newsService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete news",description = "Позволяеть удалить news")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        try {
            newsService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
