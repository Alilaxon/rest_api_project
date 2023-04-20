package com.epam.esm.service.implementation;

import com.epam.esm.dao.TagRepository;
import com.epam.esm.entity.Tag;
import com.epam.esm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImp implements TagService {


    private TagRepository tagRepository;


    @Autowired
    public TagServiceImp(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag create(Tag tag) {
        return null;
    }

    @Override
    public List<Tag> getAll() {
        return null;
    }

    @Override
    public Boolean delete(String name) {
        return null;
    }
}
