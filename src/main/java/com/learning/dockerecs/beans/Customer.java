package com.learning.dockerecs.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private Long customerId;
    private String firstName;
    private String lastName;
    private Long age;
    private String address;
}
