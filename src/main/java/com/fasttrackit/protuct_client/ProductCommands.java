package com.fasttrackit.protuct_client;

import com.fasttrackit.protuct_client.model.Category;
import com.fasttrackit.protuct_client.model.Product;
import com.fasttrackit.protuct_client.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Scanner;

@ShellComponent
@RequiredArgsConstructor
public class ProductCommands {
    private final ProductService productService;

    @ShellMethod("Print all products")
    void printAllProducts() {
        productService.getAll()
                .forEach(System.out::println);
    }

    @ShellMethod("Get product by id")
    void getProduct() {
        System.out.print("id: ");
        Scanner scanner = new Scanner(System.in);
        int lookupId = scanner.nextInt();
        productService.getById(lookupId);
    }


    @ShellMethod("Print all products from category")
    void printAllProductsFromCategory() {
        System.out.print("category: ");
        Scanner scanner = new Scanner(System.in);
        String lookupCategory = scanner.nextLine();
        productService.getByCategory(lookupCategory)
                .forEach(System.out::println);
    }

    @ShellMethod("Print max price product")
    void printMaxPriceProduct() {
        productService.MaxPriceProduct()
                .forEach(System.out::println);
    }

    @ShellMethod("Add new product")
    void addProduct() {
        System.out.println(productService.addProduct(new Product("Coca Cola Zero", 3, "no sugar", Category.DRINKS)));
    }

    @ShellMethod("delete product by id")
    void deleteProduct() {
        System.out.print("id: ");
        Scanner scanner = new Scanner(System.in);
        int lookupId = scanner.nextInt();
        productService.deleteById(lookupId);
    }


}
