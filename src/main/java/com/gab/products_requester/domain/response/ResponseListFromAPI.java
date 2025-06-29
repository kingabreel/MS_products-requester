package com.gab.products_requester.domain.response;

import java.util.List;

public record ResponseListFromAPI(List<ProductDTO> responseObject, String message) {
}
