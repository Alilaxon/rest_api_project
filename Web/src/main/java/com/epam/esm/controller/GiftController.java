package com.epam.esm.controller;

import com.epam.esm.dto.GiftDto;
import com.epam.esm.entity.GiftCertificate;

import com.epam.esm.service.GiftService;
import com.epam.esm.service.implementation.GiftCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gift")
public class GiftController {

    private final GiftService giftCertificateService;

    @Autowired
    public GiftController(GiftCertificateService giftCertificateService) {

        this.giftCertificateService = giftCertificateService;
    }

    @GetMapping
    public List<GiftCertificate> getAll() {

        return giftCertificateService.getAll();

    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody GiftDto giftDto) {

        giftCertificateService.create(giftDto);

        Long id = 1L;

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }


}
