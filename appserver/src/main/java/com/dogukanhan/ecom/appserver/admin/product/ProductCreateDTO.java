package com.dogukanhan.ecom.appserver.admin.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDTO {

    private Long categoryId;

    private String name;

    private String detail;

    private BigDecimal price;

    private int piece;

}
