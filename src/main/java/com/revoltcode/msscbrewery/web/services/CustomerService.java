package com.revoltcode.msscbrewery.web.services;

import com.revoltcode.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID id);
}
