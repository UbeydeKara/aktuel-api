package com.ubeydekara.catalog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity(name = "catalogs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Catalog {
    @Id
    @GeneratedValue
    private UUID catalogID;
    private String img_path;
    private LocalDate deadline;
    private LocalDate startAt;
    private LocalDate createAt;

    @ManyToOne
    @JoinColumn(name = "brandID")
    private Brand brand;

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL)
    private List<Product> products;
}
