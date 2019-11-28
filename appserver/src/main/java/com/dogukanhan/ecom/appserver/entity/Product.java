package com.dogukanhan.ecom.appserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Product extends AbstractDateEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @OneToMany
    private List<ProductImage> productImages;

    private String thumbnail;

    private String name;

    private String detail;

    private BigDecimal oldPrice;

    private BigDecimal price;

    private int piece;

}
