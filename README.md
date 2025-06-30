# Products Requester

The `products_requester` module is a consumer microservice that communicates with the `products_api` service through the **API Gateway**. It demonstrates how a microservice can use service discovery and routing to interact with other components in a distributed architecture.

## Purpose

- Consume product data exposed by `products_api` through the API Gateway.
- Demonstrate internal service-to-service HTTP communication in a microservices architecture.
- Act as an example of how to build client-side logic that leverages dynamic routing via Eureka.

---

## Technologies

- **Java 17+**
- **Spring Boot 3**
- **Spring WebClient**
- **Spring Cloud Netflix Eureka Client**
- **Spring Cloud LoadBalancer**

---

## Architecture

Client -> API Gateway -> products_requester -> products_api

This service sends requests to the `products_api` using a **WebClient** configured with service discovery.

---

## Example Endpoint

### `GET /v1/products-requester/products`

Fetches a list of products by calling `products_api`.

**Response Example:**

```json
{
  "responseObject": [
    {
      "id": "uuid",
      "name": "Product A",
      "price": 10.5,
      "description": "Example product",
      "stock": 100
    }
  ],
  "message": "products returned"
}
