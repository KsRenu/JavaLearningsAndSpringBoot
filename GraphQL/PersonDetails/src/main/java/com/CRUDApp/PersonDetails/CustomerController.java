package com.CRUDApp.PersonDetails;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class CustomerController {
    private CustomerRepository customerRepo ;

    public CustomerController(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @QueryMapping
    public Iterable<Customer> customers(){
        return this.customerRepo.findAll();
    }
    @QueryMapping
    public Customer customerById(@Argument long id){
        return this.customerRepo.findById(id).orElseThrow();
    }
    @QueryMapping
    public Customer customerByEmail(@Argument String email){
        return this.customerRepo.findCustomerByEmail(email);
    }

    @MutationMapping
    public Customer addCustomer(@Argument(name= "input" ) CustomerInput customerInput){
        return this.customerRepo.save(customerInput.getCustomerEntity());
    }
    /*@MutationMapping
    public Customer updateCustomer(@Argument long id,String firstName ,String lastName , String email ,String website ){
        Customer c = new Customer(id,firstName,lastName,email,website);
        //Optional<Customer> check = customerRepo.findById(id).ifPresentOrElse();
        if(customerRepo.findById(id).isPresent()){
            customerRepo.deleteById(id);
            return this.customerRepo.save(c);
        }
        else{
            return this.customerRepo.save(c);
        }
    }*/


}
