package com.epam.esm.service;

import com.epam.esm.dto.GiftDto;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.exception.GiftNameIsReservedException;
import com.epam.esm.exception.InvalidGiftDtoException;
import com.epam.esm.exception.InvalidTagException;

import java.util.List;

public interface GiftService {


    GiftCertificate create(GiftDto giftDto) throws GiftNameIsReservedException, InvalidGiftDtoException, InvalidTagException;

    List<GiftCertificate> getAll();

    List<GiftCertificate> getAllByTag(String tag);

    List<GiftCertificate> getAllByDescription(String description);

    GiftCertificate get(Long id);

    Long deleteById(Long id);

    GiftCertificate update(Long id, GiftDto giftDto);
}
