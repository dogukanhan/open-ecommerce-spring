package com.dogukanhan.ecom.appserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer extends AbstractEntity {

    private String name;

    private String lastName;

    private String email;

    private String password;

    @OneToMany
    private List<CustomerAddress> customerAddress;

    @OneToOne(fetch = FetchType.LAZY)
    private Bucket bucket;

    @OneToMany
    private List<CustomerOrder> customerOrder;

    @OneToMany
    private List<OrderReturn> orderReturn;

}
