package com.epam.esm.service.implementation;

import com.epam.esm.dao.GiftRepository;
import com.epam.esm.dao.builders.GiftBuilder;
import com.epam.esm.dto.GiftDto;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GiftCertificateService implements GiftService {

    private final GiftRepository giftRepository;

    @Autowired
    public GiftCertificateService(GiftRepository giftRepository) {

        this.giftRepository = giftRepository;
    }
    @Override
    public GiftCertificate create(GiftDto giftDto) {

        System.out.println(giftDto.toString());

        return giftRepository.save(GiftBuilder.builder()
                .name(giftDto.getName())
                .description(giftDto.getDescription())
                .price(giftDto.getPrice())
                .duration(giftDto.getDuration())
                .createDate(String.valueOf(LocalDateTime.now()))
                .lastUpdateDate(String.valueOf(LocalDateTime.now()))
                .build());
    }

    public List<GiftCertificate> getAll() {


        return giftRepository.findAll();
    }

    @Override
    public List<GiftCertificate> getAllByTag(String tag) {

        return giftRepository.findAll();
    }

    @Override
    public GiftCertificate get() {
        return null;
    }

    @Override
    public Long deleteById(Long id) {
        return null;
    }

    @Override
    public Long update(Long id, GiftDto giftDto) {
        return null;
    }

    private boolean checkGiftName(GiftDto giftDto){


    return false;
    }
}
