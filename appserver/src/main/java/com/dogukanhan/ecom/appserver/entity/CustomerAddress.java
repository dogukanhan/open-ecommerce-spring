package com.dogukanhan.ecom.appserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class CustomerAddress extends AbstractEntity {

    private String name;

    @Embedded
    private EmbeddableAddress address;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

}
