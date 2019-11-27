package com.dogukanhan.ecom.appserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class ProductImage extends AbstractDateEntity {

    private String link;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

}
