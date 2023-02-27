package com.ais.techstore.service.impl;

import com.ais.techstore.model.News;
import com.ais.techstore.repository.NewsRepository;
import com.ais.techstore.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Override
    public List<News> findAllNews() {
        List<News> newsList = newsRepository.findAll();
        return newsList;
    }


    @Override
    public News findById(Long id) {
        return newsRepository.findById(id).orElse(null);
    }

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }

    @Override
    public void deleteById(Long id) {
        newsRepository.deleteById(id);
    }



}
