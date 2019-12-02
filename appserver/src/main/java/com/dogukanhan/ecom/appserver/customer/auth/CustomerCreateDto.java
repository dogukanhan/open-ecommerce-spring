package com.dogukanhan.ecom.appserver.customer.auth;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCreateDto {

    private String username;

    private String email;

    private String password;

}
