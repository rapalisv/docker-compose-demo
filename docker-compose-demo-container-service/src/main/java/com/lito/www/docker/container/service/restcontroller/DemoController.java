package com.lito.www.docker.container.service.restcontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Builder;
import lombok.Data;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DemoController {

  @GetMapping("/products")
  public List<Product> getProducts() {
    List<Product> products = Arrays.asList(Product.builder()
        .id(Long.valueOf(1))
        .name("Coca-Cola")
        .imgSrc("https://www.cocacola.de/content/dam/GO/CokeZone/Common/global/logo/"
            + "logodesktop/coca-cola-logo-260x260.png")
        .build(),
        Product.builder()
            .id(Long.valueOf(2))
            .name("Milk")
            .imgSrc("http://www.legendairy.com.au/~/media/legendairy/images/lhp/"
                + "milk-carton-thumbnail.jpg?h=600&la=en&w=600")
            .build(),
        Product.builder()
            .id(Long.valueOf(3))
            .name("Aple")
            .imgSrc("http://cdn.ipernity.com/122/89/30/12778930.7b534dab.640.jpg?r2")
            .build());
    return products;
  }

  @Data
  @Builder
  private static class Product {
    private Long id;
    private String name;
    private String imgSrc;
  }
}
