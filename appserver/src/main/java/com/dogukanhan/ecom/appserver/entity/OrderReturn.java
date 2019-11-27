package com.dogukanhan.ecom.appserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class OrderReturn extends AbstractDateEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerOrder customerOrder;

}
