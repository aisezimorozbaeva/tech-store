package com.ais.techstore.service;

import com.ais.techstore.model.Stock;

import java.util.List;

public interface StockService {
    List<Stock> findAllStock();
    Stock findById(Long id);
    void save(Stock stock);
    void deleteById(Long id);
}
