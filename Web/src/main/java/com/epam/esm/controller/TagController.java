package com.epam.esm.controller;


import com.epam.esm.entity.Tag;
import com.epam.esm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    TagService tagService;
    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }
    @RequestMapping("/get-all")
    public List<Tag> getAll (){
        return tagService.getAll();
    }
}
