package com.CRUDApp.PersonDetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository< Customer, Long > {
    Customer findCustomerByEmail(String email);
}
