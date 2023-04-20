package com.epam.esm.service;

import com.epam.esm.entity.Tag;

import java.util.List;

public interface TagService {

    public Tag create (Tag tag);

    public List<Tag> getAll();

    public Boolean delete (String name);


}
