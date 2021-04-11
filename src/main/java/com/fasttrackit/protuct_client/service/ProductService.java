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

    final String ROOT_URL = "http://localhost:8080/products";

    public List<Product> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                ROOT_URL,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public Product getById(int productId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(ROOT_URL + "/" + productId, Product.class);
    }

    public List<Product> getByCategory(String category) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                ROOT_URL + "?category=" + category,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public List<Product> maxPriceProduct() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                ROOT_URL + "?maxprice=true",
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public Product addProduct(Product newProduct) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(ROOT_URL, newProduct, Product.class);
    }

    public void deleteById(int productId) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(ROOT_URL + "/delete/" + productId);
    }
}
