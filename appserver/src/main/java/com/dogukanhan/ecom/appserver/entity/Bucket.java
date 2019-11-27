package com.dogukanhan.ecom.appserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Bucket extends AbstractEntity {

    @OneToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @ManyToMany
    private List<Product> products;

}
