package com.dogukanhan.ecom.appserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class CategoryField extends AbstractEntity {

    enum FieldStyle {
        RANGE, SELECT, MULTI_SELECT
    }

    private String name;

    @ElementCollection
    private List<String> fieldValues;

    @Enumerated(value = EnumType.STRING)
    private FieldStyle style;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Category> categories;

}
