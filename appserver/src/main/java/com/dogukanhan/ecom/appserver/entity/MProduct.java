package com.dogukanhan.ecom.appserver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class MProduct extends Product {
    private Map<CategoryField, Object> extra;

    public MProduct(Product product, Map<CategoryField, Object> extra) {

        this.setPrice(product.getPrice());
        this.setDetail(product.getDetail());
        this.setId(product.getId());
        this.setThumbnail(product.getThumbnail());
        this.setName(product.getName());
        this.setPiece(product.getPiece());
        this.extra = extra;
    }
}
