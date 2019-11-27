package com.dogukanhan.ecom.appserver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Category {

    public static final long ROOT_ID =0;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Size(min = 2, max = 15)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category parent;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Category> children;

    @OneToMany
    private List<Product> products;

    @ManyToMany
    private List<CategoryField> fields;

    public Category(String name) {
        this.name = name;
    }

    public Category(long id) {
        this.id = id;
    }

    public Category(Category parent, String name) {
        this.parent = parent;
        this.name = name;
    }
}
