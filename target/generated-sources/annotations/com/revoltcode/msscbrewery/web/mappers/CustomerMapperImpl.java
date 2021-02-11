package com.revoltcode.msscbrewery.web.mappers;

import com.revoltcode.msscbrewery.domain.Customer;
import com.revoltcode.msscbrewery.domain.Customer.CustomerBuilder;
import com.revoltcode.msscbrewery.web.model.CustomerDto;
import com.revoltcode.msscbrewery.web.model.CustomerDto.CustomerDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-11T21:14:05+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.7-ea (Debian)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer customerDtoToCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        CustomerBuilder customer = Customer.builder();

        customer.id( customerDto.getId() );
        customer.name( customerDto.getName() );

        return customer.build();
    }

    @Override
    public CustomerDto customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDtoBuilder customerDto = CustomerDto.builder();

        customerDto.id( customer.getId() );
        customerDto.name( customer.getName() );

        return customerDto.build();
    }
}
