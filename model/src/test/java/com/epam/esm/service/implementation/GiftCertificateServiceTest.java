package com.epam.esm.service.implementation;

import com.epam.esm.dao.GiftRepository;
import com.epam.esm.dao.TagRepository;
import com.epam.esm.dao.builders.GiftBuilder;
import com.epam.esm.dto.GiftDto;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GiftCertificateServiceTest {

    private final GiftRepository giftRepository = mock(GiftRepository.class);

    private final TagRepository tagRepository = mock(TagRepository.class);

    private final GiftCertificateService giftCertificateService
            = new GiftCertificateService(giftRepository,tagRepository);

    private  GiftCertificate GIFT;

    private GiftDto GIFT_DTO;

    private final Long ID = 1L;

    private final String NAME = "Gift";

    private final String DESCRIPTION = "description";

    private final Long PRICE = 1000L;

    private final Long DURATION = 7L;

    private final Tag TAG_ONE = new Tag(1L, "red");

    private final Tag TAG_TWO = new Tag(2L,"blue");

    @BeforeEach
    void setUp(){

        GIFT = GiftBuilder.builder()
                .id(ID)
                .name(NAME)
                .description(DESCRIPTION)
                .price(PRICE)
                .duration(DURATION)
                .createDate(String.valueOf(LocalDateTime.now()))
                .lastUpdateDate(String.valueOf(LocalDateTime.now()))
                .tags(List.of(TAG_ONE,TAG_TWO))
                .build();

        GIFT_DTO = new GiftDto(NAME,DESCRIPTION,PRICE,DURATION,List.of(TAG_ONE));

    }



    @Test
    void create() {
        when(tagRepository.save(TAG_ONE)).thenReturn(TAG_ONE);
        when(giftRepository.save(GIFT)).thenReturn(GIFT);
        assertEquals(giftCertificateService.create(GIFT_DTO),GIFT);
        verify(giftRepository,times(1)).save(GIFT);
    }

    @Test
    void getAll() {
        when(giftRepository.findAll()).thenReturn(List.of(GIFT));
        assertEquals(giftCertificateService.getAll(),List.of(GIFT));
    }

    @Test
    void getAllByTag() {
        when(giftRepository.findAllByTag(TAG_ONE.getName())).thenReturn(List.of(GIFT));
    }

    @Test
    void get() {
        when(giftRepository.findById(ID)).thenReturn(GIFT);
        assertEquals(giftCertificateService.get(ID),GIFT);
    }

    @Test
    void deleteById() {
        giftCertificateService.deleteById(ID);
        verify(giftRepository,times(1)).delete(ID);
    }

    @Test
    void update() {
        when(giftRepository.update(GIFT)).thenReturn(GIFT);
        assertEquals(giftCertificateService.update(ID,GIFT_DTO),GIFT);
        verify(giftRepository,times(1)).update(GIFT);
    }
}