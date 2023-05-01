package com.epam.esm.dao;

import com.epam.esm.entity.GiftCertificate;

import java.util.List;

public interface GiftRepository {

    GiftCertificate save (GiftCertificate giftCertificate);

    GiftCertificate findById(Long id);

    boolean existsByName (String name);

    List<GiftCertificate> findAll();

    List<GiftCertificate> findAllByTag(String tag);

    GiftCertificate update (GiftCertificate giftCertificate);

    void delete(Long id);


}
