package com.epam.esm.dao.implementation;

import com.epam.esm.config.EmbeddedJdbcConfig;
import com.epam.esm.dao.builders.TagBuilder;
import com.epam.esm.entity.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {EmbeddedJdbcConfig.class})
@ActiveProfiles("integration-test")
class TagDaoTest {

    private static Tag tag;

    private TagDao tagDao;

    @Autowired
    private DataSource dataSource;

    @BeforeEach
    void setUp(){

        tagDao = new TagDao(dataSource);

        tag = new Tag(1L,"red");

    }

    @Test
    void getAll() {
        assertEquals(tagDao.getAll().size(),4);
    }

    @Test
    void save() {
        tag.setName("blue");
        assertEquals(tagDao.save(tag).getName(),tag.getName());
    }

    @Test
    void findByName() {
        assertEquals(tagDao.findByName("red").getName(),tag.getName());
    }

    @Test
    void findById() {
        assertEquals(tagDao.findById(1L).getId(),tag.getId());
    }

    @Test
    void delete() {
        Tag TestTag = TagBuilder.builder().name("Orange").build();
        Long id = tagDao.save(TestTag).getId();
        assertNotNull(tagDao.findById(id));
        tagDao.Delete(id);
        assertNull(tagDao.findById(id));
    }

    @Test
    void existsByName() {
        assertTrue(tagDao.existsByName("red"));
    }
}