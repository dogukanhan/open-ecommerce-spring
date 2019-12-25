package com.dogukanhan.ecom.appserver.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Summary extends AbstractEntity {

    private Long id = 1L;

    private long categoryCouunt;

    private long productCount;

}
