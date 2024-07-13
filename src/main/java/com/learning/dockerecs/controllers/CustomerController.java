package com.learning.dockerecs.controllers;

import com.learning.dockerecs.beans.Customer;
import com.learning.dockerecs.exceptions.CustomerException;
import org.apache.logging.log4j.message.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    @GetMapping("/customers")
    private List<Customer> getCustomers() {
        return getCustomerList();
    }

    @GetMapping("/customer/{customerId}")
    private Customer getCustomer(@PathVariable Long customerId) throws CustomerException {
        List<Customer> customers = getCustomerList();
        return getCustomerList().stream().filter(customer -> customer.getCustomerId().equals(customerId))
                .findFirst()
                .orElseThrow(() -> new CustomerException(
                        String.format("Customer with id: %s not found", customerId)
                ));
    }

    private List<Customer> getCustomerList() {
        Customer customer1 = new Customer();
        customer1.setCustomerId(1L);
        customer1.setFirstName("John");
        customer1.setLastName("Doe");
        customer1.setAge(28L);
        customer1.setAddress("No. 34, LA");

        Customer customer2 = new Customer();
        customer2.setCustomerId(2L);
        customer2.setFirstName("Kevin");
        customer2.setLastName("Smith");
        customer2.setAge(33L);
        customer2.setAddress("No. 34, South Africa");

        Customer customer3 = new Customer();
        customer2.setCustomerId(2L);
        customer2.setFirstName("jason");
        customer2.setLastName("roy");
        customer2.setAge(33L);
        customer2.setAddress("No. 34, behmrinham, UK");

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        return customers;
    }
}
