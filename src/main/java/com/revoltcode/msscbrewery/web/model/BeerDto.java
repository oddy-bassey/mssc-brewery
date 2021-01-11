package com.revoltcode.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BearDto {
    private UUID id;
    private String beerName;
    private String beerStyle;
    private long upc;
}
