package com.walker.wncommercejavaspring.dto;

import com.walker.wncommercejavaspring.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDto {

    private Long id;
    @Size(min = 3, max = 80, message = "Campo name precisa ter de 3 a 80 caracteres!")
    @NotBlank(message = "Campo name requerido!")
    private String name;
    @Size(min = 10, message = "Campo description precisa ter no mínimo 10 caracteres!")
    @NotBlank(message = "Campo description requerido!")
    private String description;
    @Positive(message = "Campo price deve ser positivo!")
    private Double price;
    private String imgUrl;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDto(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Double getPrice() {
        return price;
    }
}
