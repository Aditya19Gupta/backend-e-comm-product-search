package com.productSearch.models;

import com.productSearch.data.enums.Category;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    private BigDecimal price;

    private String brand;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String imageUrl;


}
