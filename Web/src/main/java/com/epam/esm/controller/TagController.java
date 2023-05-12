package com.epam.esm.controller;


import com.epam.esm.dto.GiftDto;
import com.epam.esm.dto.TagDto;
import com.epam.esm.entity.Tag;
import com.epam.esm.exception.TagNameIsReservedException;
import com.epam.esm.service.TagService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    private static final Logger log = LogManager.getLogger(TagController.class);
    private final TagService tagService;


    @Autowired
    public TagController(TagService tagService) {

        this.tagService = tagService;
    }

    @RequestMapping("/get-all")
    public List<Tag> getAll() {

        return tagService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tag getById(@PathVariable Long id) {

        return tagService.getById(id);

    }

    @PostMapping("/create")
    public ResponseEntity<Long> create(@RequestBody TagDto tagDto) throws TagNameIsReservedException {

        System.out.println("create");

        log.info("Tag '{}' will be create",tagDto.getName());


        Long id = tagService.create(tagDto).getId();

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {

        log.info("Delete Tag by id = '{}'",id);

        tagService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
