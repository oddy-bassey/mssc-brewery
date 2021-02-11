package com.revoltcode.msscbrewery.web.mappers;

import com.revoltcode.msscbrewery.domain.Beer;
import com.revoltcode.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
