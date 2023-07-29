package com.ubeydekara.catalog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue
    private UUID productID;

    @Column(length = 1024)
    private String path;

    @ManyToOne
    @JoinColumn(name = "catalogID")
    @JsonIgnore
    @ToString.Exclude
    private Catalog catalog;
}
