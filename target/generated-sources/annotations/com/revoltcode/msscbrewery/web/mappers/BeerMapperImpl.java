package com.revoltcode.msscbrewery.web.mappers;

import com.revoltcode.msscbrewery.domain.Beer;
import com.revoltcode.msscbrewery.web.model.BeerDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-11T14:55:20+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.7-ea (Debian)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDto beerDto = new BeerDto();

        return beerDto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        if ( beerDto == null ) {
            return null;
        }

        Beer beer = new Beer();

        return beer;
    }
}
