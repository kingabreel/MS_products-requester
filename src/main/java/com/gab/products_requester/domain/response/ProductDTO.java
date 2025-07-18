package com.gab.products_requester.domain.response;

import java.util.UUID;

public record ProductDTO(UUID id, String name, String description, int amount, double price) {
}
