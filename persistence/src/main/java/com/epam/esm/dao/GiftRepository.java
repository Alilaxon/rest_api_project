package com.epam.esm.dao;

import com.epam.esm.entity.GiftCertificate;

import java.util.List;

public interface GiftRepository {

    GiftCertificate save (GiftCertificate giftCertificate);

    List<GiftCertificate> findAll();

    GiftCertificate update (GiftCertificate giftCertificate);

    void delete(Long id);


}
