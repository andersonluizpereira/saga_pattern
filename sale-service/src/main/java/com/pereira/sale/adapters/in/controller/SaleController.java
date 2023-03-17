package com.pereira.sale.adapters.in.controller;

import com.pereira.sale.adapters.in.controller.mapper.SaleRequestMapper;
import com.pereira.sale.adapters.in.controller.request.SaleRequest;
import com.pereira.sale.application.ports.in.CreateSaleInputPort;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    @Autowired
    private CreateSaleInputPort createSaleInputPort;

    @Autowired
    private SaleRequestMapper saleRequestMapper;

    @PostMapping
    @ResponseStatus(CREATED)
    public void CreateSale(@Valid @RequestBody SaleRequest saleRequest) {
        log.info("CreateSale");
        createSaleInputPort.create(saleRequestMapper.toSale(saleRequest));
        log.info("Sale created");
    }
}
