package com.revoltcode.msscbrewery.web.controller;

import com.revoltcode.msscbrewery.web.model.CustomerDto;
import com.revoltcode.msscbrewery.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable  UUID customerId){

        return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody CustomerDto customerDto){

        CustomerDto customer = customerService.saveNewCustomer(customerDto);

        HttpHeaders header = new HttpHeaders();

        header.add("location", "api/v1/customer/"+customer.getId());

        return new ResponseEntity(header, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity handlePut(@PathVariable("customerId") UUID customerId, @Valid @RequestBody CustomerDto customerDto){

        customerService.updateCustomer(customerId, customerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId){

        customerService.deleteCustomerById(customerId);
    }
}
