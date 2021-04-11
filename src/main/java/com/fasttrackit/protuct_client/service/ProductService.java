package com.fasttrackit.protuct_client.service;

import com.fasttrackit.protuct_client.model.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Service
public class ProductService {
    public List<Product> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "http://localhost:8080/products",
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public Product getById(int productId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/products/" + productId, Product.class);
    }

    public List<Product> getByCategory(String lookupCategory) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "http://localhost:8080/products/category/" + lookupCategory,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public List<Product> MaxPriceProduct() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "http://localhost:8080/products/maxprice/",
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public Product addProduct(Product newProduct) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:8080/products", newProduct, Product.class);
    }

    public void deleteById(int lookupId) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8080/products/delete/" + lookupId);
    }
}
