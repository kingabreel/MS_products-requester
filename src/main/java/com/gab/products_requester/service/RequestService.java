package com.gab.products_requester.service;

import com.gab.products_requester.domain.response.ProductDTO;
import com.gab.products_requester.domain.response.ResponseFromAPI;
import com.gab.products_requester.domain.response.ResponseListFromAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestService {

    private final String URL =  "http://products-api/v1/products";
    private final RestTemplate restTemplate;

    @Autowired
    public RequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseListFromAPI getProducts() {
        return restTemplate.getForObject(URL, ResponseListFromAPI.class);

    }

    public ResponseFromAPI getById(String id) {
        return restTemplate.getForObject(URL + "/" + id, ResponseFromAPI.class);
    }
}
