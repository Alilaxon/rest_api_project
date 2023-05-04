package com.epam.esm.service;

import com.epam.esm.dto.GiftDto;
import com.epam.esm.entity.GiftCertificate;

import java.util.List;

public interface GiftService {


    public GiftCertificate create(GiftDto giftDto);

    List<GiftCertificate> getAll();

    List<GiftCertificate> getAllByTag(String tag);

    GiftCertificate get(Long id);

    Long deleteById(Long id);

    GiftCertificate update(Long id, GiftDto giftDto);
}
