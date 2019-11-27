package com.dogukanhan.ecom.appserver.admin.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateDTO {

    private Long id;

    private Long parentId;

    private String name;
}
