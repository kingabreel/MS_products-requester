package com.gab.products_requester.controller;

import com.gab.products_requester.domain.request.Request;
import com.gab.products_requester.domain.response.ProductDTO;
import com.gab.products_requester.domain.response.ResponseFromAPI;
import com.gab.products_requester.domain.response.ResponseListFromAPI;
import com.gab.products_requester.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/history")
    public ResponseEntity<List<ProductDTO>> getBuyHistory() {
        return ResponseEntity.ok(this.requestService.getProductsDTOList());
    }

    @GetMapping("/history/remove/{id}")
    public ResponseEntity<List<ProductDTO>> removeBuyHistory(@PathVariable String id) {
        this.requestService.removeProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ResponseFromAPI> buyProduct(@RequestBody Request data) {
        return ResponseEntity.ok(this.requestService.buyProduct(data));
    }

}
