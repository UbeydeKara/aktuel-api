package com.ubeydekara.catalog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDate deadline;
    private LocalDate startAt;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name = "marketID")
    private Market market;

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL)
    private List<CatalogImage> images;

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL)
    private List<Product> products;
}
