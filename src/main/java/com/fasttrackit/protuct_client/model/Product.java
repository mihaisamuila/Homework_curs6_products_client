package com.fasttrackit.protuct_client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    //private long id;
    private String name;
    private long price;
    private String description;
    private Category category;

}
