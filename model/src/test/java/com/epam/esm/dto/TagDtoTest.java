package com.epam.esm.dto;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TagDtoTest {

    TagDto tagDto;

    Long ID = 1L;

    String NAME = "red";
    @BeforeEach
    void setUp(){
        tagDto = new TagDto();
    }
    @Test
    void tagDtoSettersAndGettersTest(){
        tagDto.setId(ID);
        tagDto.setName(NAME);
        assertEquals(tagDto.getId(),ID);
        assertEquals(tagDto.getName(),NAME);

    }

}