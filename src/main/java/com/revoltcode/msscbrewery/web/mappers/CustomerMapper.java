package com.revoltcode.msscbrewery.web.mappers;

import com.revoltcode.msscbrewery.domain.Customer;
import com.revoltcode.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDto customerDto);

    CustomerDto customerToCustomerDto(Customer customer);
}
