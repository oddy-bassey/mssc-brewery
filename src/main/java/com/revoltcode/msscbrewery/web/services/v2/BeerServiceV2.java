package com.revoltcode.msscbrewery.web.services.v2;

import com.revoltcode.msscbrewery.web.model.v1.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBerById(UUID beerId);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDtoV2);

    void updateBeer(UUID beerId, BeerDtoV2 beerDtoV2);

    void deleteById(UUID beerId);
}
