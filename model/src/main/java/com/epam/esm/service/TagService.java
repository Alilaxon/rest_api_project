package com.epam.esm.service;

import com.epam.esm.dto.TagDto;
import com.epam.esm.entity.Tag;

import java.util.List;

public interface TagService {

    public Tag create (Tag tag);

    public Tag create (TagDto tagDto);

    public Tag getById(Long id);

    public List<Tag> getAll();

    Long deleteById(Long id);


}
