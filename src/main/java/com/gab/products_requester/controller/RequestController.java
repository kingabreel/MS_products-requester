package com.gab.products_requester.controller;

import com.gab.products_requester.domain.response.ProductDTO;
import com.gab.products_requester.domain.response.ResponseFromAPI;
import com.gab.products_requester.domain.response.ResponseListFromAPI;
import com.gab.products_requester.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("requests")
public class RequestController {

    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public ResponseEntity<ResponseListFromAPI> getProduct() {
        return ResponseEntity.ok(this.requestService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFromAPI> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(this.requestService.getById(id));
    }
}
