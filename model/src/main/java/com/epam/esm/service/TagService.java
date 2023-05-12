package com.epam.esm.service;


import com.epam.esm.dto.TagDto;
import com.epam.esm.entity.Tag;
import com.epam.esm.exception.TagNameIsReservedException;

import java.util.List;

public interface TagService {



    Tag create (TagDto tagDto) throws TagNameIsReservedException;

    Tag getById(Long id);

    List<Tag> getAll();

    Long deleteById(Long id);




}
