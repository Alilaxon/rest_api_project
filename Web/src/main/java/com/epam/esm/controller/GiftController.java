package com.epam.esm.controller;
import com.epam.esm.dto.GiftDto;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.exception.GiftNameIsReservedException;
import com.epam.esm.service.GiftService;
import com.epam.esm.service.implementation.GiftCertificateService;
import com.epam.esm.utils.Sorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gift")
public class GiftController {

    private static final Logger log = LogManager.getLogger(GiftController.class);

    private final GiftService giftCertificateService;

    @Autowired
    public GiftController(GiftCertificateService giftCertificateService) {

        this.giftCertificateService = giftCertificateService;
    }

    @GetMapping("/get-all")
    public List<GiftCertificate> getAll() {

        log.info("gel_all");

        return giftCertificateService.getAll();

    }

    @GetMapping("/getAllByTag")
    public List<GiftCertificate> getAllByTag
            (@RequestParam("tag") String tag ,
             @RequestParam("order") String order){
        log.info("get all by tag = {}",tag);

        if (order.equals("desc")){
            log.info("sort all by desc");
           return Sorter.sorting(giftCertificateService.getAllByTag(tag));
        }

        log.info("sort all by asc");
        return giftCertificateService.getAllByTag(tag);
    }
    @GetMapping("/getAllByDescription")
    public List<GiftCertificate> getAllByDescription (
            @RequestParam("description")String description,
            @RequestParam("order") String order){

        log.info("get all by description = {}",description);

        if (order.equals("desc")){
            log.info("sort all by desc");
            return Sorter.sorting(giftCertificateService.getAllByDescription(description));
        }
        log.info("sort all by asc");
        return giftCertificateService.getAllByDescription(description);
    }


    @PostMapping("/create")
    public ResponseEntity<Long> create(@RequestBody GiftDto giftDto) throws GiftNameIsReservedException {

        log.info("Gift '{}' will be create",giftDto.getName());
        Long id = giftCertificateService.create(giftDto).getId();

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
    @GetMapping("/read/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GiftCertificate getById (@PathVariable("id") Long id){

        log.info("Get Gift by id = '{}'",id);

        return giftCertificateService.get(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Long> create (@PathVariable("id") Long id,
                                        @RequestBody GiftDto giftDto){

        log.info("Update Gift by id = '{}'",id);
        Long resultId = giftCertificateService.update(id,giftDto).getId();

        return ResponseEntity.status(HttpStatus.CREATED).body(resultId);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id){

        log.info("Delete Gift by id = '{}'",id);
        giftCertificateService.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
