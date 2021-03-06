package com.revoltcode.msscbrewery.web.services;

import com.revoltcode.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j //lombok includes logger
@Service
public class BeerServiceImpl implements BeerService{
    @Override
    public BeerDto getBerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        //todo impl - would add a real implementation to update beer
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("deleting beer "+beerId);
    }
}
