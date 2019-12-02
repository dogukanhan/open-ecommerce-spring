package com.dogukanhan.ecom.appserver.repository;

import com.dogukanhan.ecom.appserver.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
