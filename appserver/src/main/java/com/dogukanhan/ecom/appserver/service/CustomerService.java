package com.dogukanhan.ecom.appserver.service;

import com.dogukanhan.ecom.appserver.customer.auth.CustomerCreateDto;
import com.dogukanhan.ecom.appserver.entity.Customer;
import com.dogukanhan.ecom.appserver.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public void create(CustomerCreateDto dto) {

        Customer customer = new Customer();
        customer.setUsername(dto.getUsername());
        customer.setEmail(dto.getEmail());
        customer.setPassword(dto.getPassword());

        repository.save(customer);

    }

    public List<Customer> findAll() {
        return repository.findAll();
    }
}
