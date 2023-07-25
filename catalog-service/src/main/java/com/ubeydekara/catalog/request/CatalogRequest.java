package com.ubeydekara.catalog.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CatalogRequest {
    private UUID catalogID;
    private LocalDate deadline;
    private LocalDate startAt;
    private LocalDate createAt;
    private UUID marketID;
    private List<String> images;
    private List<String> products;
}
