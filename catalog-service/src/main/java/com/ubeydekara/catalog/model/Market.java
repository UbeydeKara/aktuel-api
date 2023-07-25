package com.ubeydekara.catalog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "markets")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Market {
    @Id
    @GeneratedValue
    private UUID marketID;

    @NotBlank
    private String title;

    @NotBlank
    @Column(length = 500)
    private String img_path;

    @NotBlank
    private String tint;

    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<Catalog> catalogs;
}
