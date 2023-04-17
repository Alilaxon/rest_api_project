package com.epam.esm.dao;

import com.epam.esm.entity.Tag;

public interface TagRepository {

    Tag save(Tag tag);

    Tag findByName(String name);
}
