package com.epam.esm.service.implementation;

import com.epam.esm.dao.GiftRepository;
import com.epam.esm.dao.TagRepository;
import com.epam.esm.dao.builders.GiftBuilder;
import com.epam.esm.dto.GiftDto;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import com.epam.esm.exception.GiftNameIsReservedException;
import com.epam.esm.exception.InvalidGiftDtoException;
import com.epam.esm.exception.InvalidTagException;
import com.epam.esm.service.GiftService;
import com.epam.esm.utils.GiftValidator;
import com.epam.esm.utils.TagValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GiftCertificateService implements GiftService {

    private static final Logger log = LogManager.getLogger(GiftCertificateService.class);

    private final GiftRepository giftRepository;

    private final TagRepository tagRepository;

    @Autowired
    public GiftCertificateService(GiftRepository giftRepository, TagRepository tagRepository) {

        this.giftRepository = giftRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public GiftCertificate create(GiftDto giftDto) throws GiftNameIsReservedException, InvalidGiftDtoException, InvalidTagException {

        GiftValidator.checkGiftDto(giftDto);

       if (checkGiftName(giftDto)) {
           throw new GiftNameIsReservedException();
       }

        List<Tag> tags = checkNewTags(tagRepository.getAll(), giftDto.getTags());

        log.info("Gift '{}' will be create",giftDto.getName());

        return giftRepository.save(GiftBuilder.builder()
                .name(giftDto.getName())
                .description(giftDto.getDescription())
                .price(giftDto.getPrice())
                .duration(giftDto.getDuration())
                .createDate(String.valueOf(LocalDateTime.now()))
                .lastUpdateDate(String.valueOf(LocalDateTime.now()))
                .tags(tags)
                .build());
    }

    public List<GiftCertificate> getAll() {

        return giftRepository.findAll();
    }

    @Override
    public List<GiftCertificate> getAllByTag(String tag) {

        log.info("Find by tag {}",tag);

       Long tagId = tagRepository.findByName(tag).getId();

        return giftRepository.findAllByTag(tagId);
    }

    @Override
    public List<GiftCertificate> getAllByDescription(String description) {
        return giftRepository.findAllByPartOfDescription(description);
    }

    @Override
    public GiftCertificate get(Long id) {

        return giftRepository.findById(id);
    }

    @Override
    public Long deleteById(Long id) {

        log.info("Gift id = '{}' will be delete",id);
        giftRepository.delete(id);

        return id;
    }

    @Override
    public GiftCertificate update(Long id, GiftDto giftDto) {

        log.info("Gift '{}' will be update",giftDto.getName());

        return giftRepository.update(GiftBuilder.builder()
                .id(id)
                .name(giftDto.getName())
                .description(giftDto.getDescription())
                .price(giftDto.getPrice())
                .duration(giftDto.getDuration())
                .createDate(String.valueOf(LocalDateTime.now()))
                .lastUpdateDate(String.valueOf(LocalDateTime.now()))
                .tags(giftDto.getTags())
                .build());
    }

    private boolean checkGiftName(GiftDto giftDto) {

        return giftRepository.existsByName(giftDto.getName());
    }

    private List<Tag> checkNewTags(List<Tag> allTags, List<Tag> newTags) throws  InvalidTagException {
        List<Tag> tagList = new ArrayList<>();
        for (Tag newTag : newTags) {
            boolean isExist = false;
            for (Tag tag : allTags) {
                if (Objects.equals(newTag.getName(), tag.getName())) {
                    tagList.add(tag);
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                TagValidator.checkTag(newTag);
                newTag.setId(tagRepository.save(newTag).getId());
                tagList.add(newTag);
            }
        }
        return tagList;
    }


}
