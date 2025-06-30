package com.gab.products_requester.domain.response;

import java.util.UUID;

public record RequestResponse(UUID id, ProductDTO product, double total) {
}
