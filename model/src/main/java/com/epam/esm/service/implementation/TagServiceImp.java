package com.epam.esm.service.implementation;

import com.epam.esm.dao.TagRepository;
import com.epam.esm.dao.builders.TagBuilder;
import com.epam.esm.dto.TagDto;
import com.epam.esm.entity.Tag;
import com.epam.esm.exception.TagNameIsReservedException;
import com.epam.esm.service.TagService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImp implements TagService {

    private static final Logger log = LogManager.getLogger(TagServiceImp.class);

    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImp(TagRepository tagRepository) {

        this.tagRepository = tagRepository;
    }

    @Override
    public Tag create(TagDto tagDto) throws TagNameIsReservedException {

        if (checkTagName(tagDto)) {
            throw new TagNameIsReservedException();
        }

        log.info("Tag '{}' will be create", tagDto.getName());

        return tagRepository.save(TagBuilder.builder().name(tagDto.getName()).build());
    }

    @Override
    public Tag getById(Long id) {

        return tagRepository.findById(id);
    }

    @Override
    public List<Tag> getAll() {


        return tagRepository.getAll();
    }


    @Override
    public Long deleteById(Long id) {
        log.info("Tag id= '{}' will be create", id);

        return tagRepository.Delete(id);
    }

    private boolean checkTagName(TagDto tagDto) {

        return tagRepository.existsByName(tagDto.getName());
    }
}
