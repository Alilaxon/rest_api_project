package com.epam.esm.dao.builders;

import com.epam.esm.entity.Tag;

public class TagBuilder {

    private Long id;

    private String name;

    public static TagBuilder builder() {

        return new TagBuilder();
    }

    public TagBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public TagBuilder name(String name) {
        this.name = name;
        return this;
    }

    public Tag build() {

        return new Tag(id,name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
