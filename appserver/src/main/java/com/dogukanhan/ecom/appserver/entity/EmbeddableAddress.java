package com.dogukanhan.ecom.appserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class EmbeddableAddress {

    private String state;

    private String city;

    private String country;

    private String postcode;

    private String detailedAddress;
}
