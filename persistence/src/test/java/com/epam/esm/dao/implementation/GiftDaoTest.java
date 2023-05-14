package com.epam.esm.dao.implementation;

import com.epam.esm.config.EmbeddedJdbcConfig;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {EmbeddedJdbcConfig.class})
@ActiveProfiles("integration-test")
class GiftDaoTest {

    private static GiftCertificate gift;
    private static Tag tag;
    @Autowired
    private DataSource dataSource;
    private GiftDao giftDao;

    @BeforeEach
    void setUp() {
        giftDao = new GiftDao(dataSource);

        tag = new Tag(1l, "red");

        gift = new GiftCertificate(1l,
                "giftN1",
                "very good gift",
                1000L,
                7L,
                "10.01.2023",
                "12.01.2023", List.of(tag));

    }


    @Test
    void findAll() {
        //total number of gifts = 4
        assertEquals(giftDao.findAll().size(), 4);
    }


    @Test
    void findById() {
        GiftCertificate gift = giftDao.findById(1L);
        assertNotNull(gift);
        assertEquals(gift.getId(), 1l);
    }

    @Test
    void findByName() {
        assertEquals(giftDao.findByName("giftN2").getName(), "giftN2");
    }

    @Test
    void existsByName() {
        assertTrue(giftDao.existsByName("giftN3"));
    }


    @Test
    void findAllByTag() {
        // tag{id = 1 , name = "red"}
        assertEquals(giftDao.findAllByTag(tag.getId()).get(0).getTags().get(0).getId(), tag.getId());
    }

    @Test
    void findAllByPartOfDescription() {
        assertEquals(giftDao.findAllByPartOfDescription("good").get(0).getDescription(), gift.getDescription());
    }

    @Test
    void save() {
        gift.setName("TestGift");
        assertEquals(giftDao.save(gift).getId(), 6L);
    }

    @Test
    void update() {
        gift.setName("NewGift");
        giftDao.update(gift);
        assertEquals(giftDao.findByName("NewGift").getId(), 1L);

    }

    @Test
    void delete() {
        giftDao.delete(4L);
        assertNull(giftDao.findById(4L).getId());
        gift.setName("SuperGift");
        giftDao.save(gift);
    }

}