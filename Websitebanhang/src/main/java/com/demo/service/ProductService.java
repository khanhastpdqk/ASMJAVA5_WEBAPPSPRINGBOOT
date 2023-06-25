package com.demo.service;

import com.demo.model.Category;
import com.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

//TODO: Connect to database
@Service
public class ProductService {
    public List<Product> getAll(){
        return Arrays.asList(
        );
    }

    public Product findById(int id) {
        return getAll()
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
