package com.epam.esm.dao;

import com.epam.esm.entity.Tag;

import java.util.List;

public interface TagRepository {

    List<Tag> getAll();

    Tag save(Tag tag);

    Tag findByName(String name);

    void Delete (Long id);
}
