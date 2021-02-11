package com.revoltcode.msscbrewery.web.controller;

import com.revoltcode.msscbrewery.web.model.BeerDto;
import com.revoltcode.msscbrewery.web.services.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody BeerDto beerDto){
        val beer = beerService.saveNewBeer(beerDto);

        var header = new HttpHeaders();

        log.info("saving data!");
        //todo add hostname to url
        header.add("location", "/api/v1/beer"+beer.getId().toString());

        return new ResponseEntity(header, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto){

        beerService.updateBeer(beerId, beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //spring provides support for returning a response status via annotation
    public void deleteBeer(@PathVariable("beerId") UUID beerId){

        beerService.deleteById(beerId);
    }
}
