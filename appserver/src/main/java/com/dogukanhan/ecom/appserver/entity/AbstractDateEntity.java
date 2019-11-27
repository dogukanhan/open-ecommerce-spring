package com.dogukanhan.ecom.appserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.sql.Date;

@MappedSuperclass
@Getter
@Setter
class AbstractDateEntity extends AbstractEntity {

    private Date createdAt;

    private Date updatedAt;

}
