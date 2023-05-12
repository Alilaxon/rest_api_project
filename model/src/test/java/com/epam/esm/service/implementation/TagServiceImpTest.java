package com.epam.esm.service.implementation;

import com.epam.esm.dao.TagRepository;
import com.epam.esm.dao.builders.TagBuilder;
import com.epam.esm.dto.TagDto;
import com.epam.esm.entity.Tag;
import com.epam.esm.exception.TagNameIsReservedException;
import com.epam.esm.service.TagService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TagServiceImpTest {

    private final TagRepository tagRepository = mock(TagRepository.class);

    private final TagService tagService = new TagServiceImp(tagRepository);

    private Long ID = 1L;

    private String NAME = "Tag";

    private Tag TAG;

    private TagDto TAG_DTO;

    @BeforeEach
   void setUp(){

        TAG_DTO = new TagDto(NAME);

        TAG = TagBuilder.builder().id(ID).name(NAME).build();

    }

    @Test
    void create() throws TagNameIsReservedException {
        when(tagRepository.save(TAG)).thenReturn(TAG);
        assertEquals(tagService.create(TAG_DTO),TAG);
        verify(tagRepository,times(1)).save(TAG);

    }

    @Test
    void testCreate() {
    }

    @Test
    void getById() {
        when(tagRepository.findById(ID)).thenReturn(TAG);
        assertEquals(tagService.getById(ID),TAG);
    }

    @Test
    void getAll() {
        when(tagRepository.getAll()).thenReturn(List.of(TAG));
        assertEquals(tagService.getAll(),List.of(TAG));
    }

    @Test
    void deleteById() {
        when(tagRepository.Delete(ID)).thenReturn(ID);
        tagService.deleteById(ID);
        verify(tagRepository,times(1)).Delete(ID);
    }
}