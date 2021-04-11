package com.fasttrackit.protuct_client.model;

public enum Category {

    FOOD("food"),
    DRINKS("drinks"),
    ELECTRONICS("electronics");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
