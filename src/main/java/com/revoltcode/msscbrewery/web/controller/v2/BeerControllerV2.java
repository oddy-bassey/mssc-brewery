package com.revoltcode.msscbrewery.web.controller.v2;

import com.revoltcode.msscbrewery.web.model.v1.BeerDtoV2;
import com.revoltcode.msscbrewery.web.services.v2.BeerServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 beerServiceV2;

    @Autowired
    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<BeerDtoV2>(beerServiceV2.getBerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDtoV2 beerDto){
        BeerDtoV2 beer = beerServiceV2.saveNewBeer(beerDto);

        HttpHeaders header = new HttpHeaders();

        //todo add hostname to url
        header.add("location", "/api/v1/beer"+beer.getId().toString());

        return new ResponseEntity(header, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDto){

        beerServiceV2.updateBeer(beerId, beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //spring provides support for returning a response status via annotation
    public void deleteBeer(@PathVariable("beerId") UUID beerId){

        beerServiceV2.deleteById(beerId);
    }
}
