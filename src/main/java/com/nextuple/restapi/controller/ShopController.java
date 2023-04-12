package com.nextuple.restapi.controller;

import com.nextuple.restapi.dao.request.PurchaseRequestDao;
import com.nextuple.restapi.dao.request.SaleRequestDao;
import com.nextuple.restapi.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {
    @Autowired
    private ShopService shopService;
    @PostMapping(
            value = "/purchase",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?>purchase(@RequestBody List<PurchaseRequestDao> purchaseRequestDaoList)
    {
        ResponseEntity<?> responseEntity =  new ResponseEntity<>(shopService.purchase(purchaseRequestDaoList), HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping(
            value = "/sale",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sale(@RequestBody List<SaleRequestDao> saleRequestDaoList)
    {
        ResponseEntity<?> responseEntity =  new ResponseEntity<>(shopService.sale(saleRequestDaoList), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(value = "/allProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> showAllProducts()
    {
        ResponseEntity<?> responseEntity =  new ResponseEntity<>(shopService.showAllProducts(), HttpStatus.OK);
        return responseEntity;
    }


    @GetMapping(value = "/numberOfTransactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> showNumberOfTransactions()
    {
        ResponseEntity<?> responseEntity =  new ResponseEntity<>(shopService.showNumberOfTransactions(), HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping(value = "/updatePrice/{productName}/{newPrice}")
    public ResponseEntity<?> update(@PathVariable String productName,@PathVariable double newPrice)
    {
        ResponseEntity<?> responseEntity =  new ResponseEntity<>(shopService.update(productName,newPrice), HttpStatus.OK);
         return responseEntity;
    }



}
