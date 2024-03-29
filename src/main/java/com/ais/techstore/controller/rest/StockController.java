package com.ais.techstore.controller.rest;

import com.ais.techstore.model.Stock;
import com.ais.techstore.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
@Api(description = "контроллер для управления Акция")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping
    @Operation(summary = "все акции", description = "Позволяет получить всех акции из база данных")
    public ResponseEntity<List<Stock>> findAllStock() {
        try {
            return new ResponseEntity<>(stockService.findAllStock(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    @Operation(summary = "Save stock", description = "Save stock")
    public ResponseEntity<?> insert(@RequestBody Stock stock) {
        try {
            stockService.save(stock);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/stock/{stockId}")
    @Operation(summary = "Акция(stockId)", description = "Позволяеть получить акцию по stockId")
    public ResponseEntity<Stock> findById(@PathVariable("stockId") Long stockId) {
        try {
            return new ResponseEntity<>(stockService.findById(stockId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{stockId}")
    @Operation(summary = "Delete stock", description = "Позволяеть удалить акция")
    public ResponseEntity<?> deleteById(@PathVariable("stockId") Long stockId) {
        try {
            stockService.deleteById(stockId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
