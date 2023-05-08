package com.epam.esm.dto;

import com.epam.esm.entity.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GiftDtoTest {

    private GiftDto GIFT_DTO;


    private final Long ID = 1L;

    private final String NAME = "Gift";

    private final String DESCRIPTION = "description";

    private final Long PRICE = 1000L;

    private final Long DURATION = 7L;

    private final Tag TAG = new Tag(1L, "red");

    @BeforeEach
    void setUp(){
        GIFT_DTO = new GiftDto();


    }
    @Test
    void GiftDtoSettersAndGettersTest (){
        GIFT_DTO.setName(NAME);
        GIFT_DTO.setDescription(DESCRIPTION);
        GIFT_DTO.setPrice(PRICE);
        GIFT_DTO.setDuration(DURATION);
        GIFT_DTO.setTags(List.of(TAG));
        assertEquals(GIFT_DTO.getName(),NAME);
        assertEquals(GIFT_DTO.getDescription(),DESCRIPTION);
        assertEquals(GIFT_DTO.getPrice(),PRICE);
        assertEquals(GIFT_DTO.getDuration(),DURATION);
        assertEquals(GIFT_DTO.getTags(),List.of(TAG));

    }

}