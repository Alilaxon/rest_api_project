package com.epam.esm.service;


import com.epam.esm.dao.builders.GiftBuilder;
import com.epam.esm.dao.GiftRepository;
import com.epam.esm.dto.GiftDto;
import com.epam.esm.entity.GiftCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class GiftService {

    private GiftRepository giftRepository;

    @Autowired
    public GiftService(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    public GiftCertificate create(GiftDto giftDto) {

        return giftRepository.save(GiftBuilder.builder()
                .name(giftDto.getName())
                .description(giftDto.getDescription())
                .price(giftDto.getPrice())
                .duration(giftDto.getDuration())
                .createDate(String.valueOf(LocalDateTime.now()))
                .lastUpdateDate(String.valueOf(LocalDateTime.now()))
                .build());
    }

    public List<GiftCertificate> getAll(){
        return null;
    }
}
