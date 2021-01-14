package com.revoltcode.msscbrewery.web.services;

import com.revoltcode.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    BeerDto getBerById(UUID beerId);
}
