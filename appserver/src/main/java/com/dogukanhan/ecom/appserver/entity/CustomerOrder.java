package com.dogukanhan.ecom.appserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class CustomerOrder extends AbstractDateEntity {
    //Useless remove this
    private Date date;

    @ManyToMany
    private List<Product> product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @Embedded
    private EmbeddableAddress address;

}
