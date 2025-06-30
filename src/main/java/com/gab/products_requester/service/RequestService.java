package com.gab.products_requester.service;

import com.gab.products_requester.domain.request.Request;
import com.gab.products_requester.domain.response.ProductDTO;
import com.gab.products_requester.domain.response.ResponseFromAPI;
import com.gab.products_requester.domain.response.ResponseListFromAPI;
import jakarta.ws.rs.NotFoundException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RequestService {

    private final String URL =  "http://products-api/v1/products";
    private final RestTemplate restTemplate;

    @Getter
    private List<ProductDTO> productsDTOList;

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

    public ResponseFromAPI buyProduct(Request data) {
        ResponseFromAPI responseFromAPI = restTemplate.getForObject(URL + "/" + data.productId(), ResponseFromAPI.class);

        if (responseFromAPI == null || responseFromAPI.responseObject() == null) {
            throw new NotFoundException("Product not found");
        }

        this.addProduct(responseFromAPI.responseObject());

        return responseFromAPI;
    }

    public void removeProduct(String id) {
        ProductDTO productDTO = productsDTOList.stream().filter(p -> p.id().equals(UUID.fromString(id))).findFirst().orElseThrow(NotFoundException::new);
        productsDTOList.remove(productDTO);
    }

    private void addProduct(ProductDTO product) {
        if (this.productsDTOList == null) {
            this.productsDTOList = new ArrayList<>();
        }

        this.productsDTOList.add(product);
    }
}
