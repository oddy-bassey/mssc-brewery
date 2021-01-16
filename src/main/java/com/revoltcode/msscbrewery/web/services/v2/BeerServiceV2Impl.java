package com.revoltcode.msscbrewery.web.services.v2;

import com.revoltcode.msscbrewery.web.model.BeerDto;
import com.revoltcode.msscbrewery.web.model.v1.BeerDtoV2;
import com.revoltcode.msscbrewery.web.model.v1.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j //lombok includes logger
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.GOUT)
                .build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
        //todo impl - would add a real implementation to update beer
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("deleting beer "+beerId);
    }
}
