package com.epam.esm.dto;

import com.epam.esm.entity.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TagDtoTest {

    Tag tag;

    Long ID = 1L;

    String NAME = "red";
    @BeforeEach
    void setUp(){
        tag = new Tag();
    }
    @Test
    void tagDtoSettersAndGettersTest(){
        tag.setId(ID);
        tag.setName(NAME);
        assertEquals(tag.getId(),ID);
        assertEquals(tag.getName(),NAME);

    }

}