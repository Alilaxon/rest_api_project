package com.epam.esm.service.implementation;

import com.epam.esm.dao.GiftRepository;
import com.epam.esm.dao.TagRepository;
import com.epam.esm.dao.builders.GiftBuilder;
import com.epam.esm.dto.GiftDto;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import com.epam.esm.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class GiftCertificateService implements GiftService {

    private final GiftRepository giftRepository;

    private final TagRepository tagRepository;

    @Autowired
    public GiftCertificateService(GiftRepository giftRepository,TagRepository tagRepository) {

        this.giftRepository = giftRepository;
        this.tagRepository = tagRepository;
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

        return giftRepository.findAllByTag(tag);
    }

    @Override
    public GiftCertificate get(Long id) {

        return giftRepository.findById(id);
    }

    @Override
    public Long deleteById(Long id) {

         giftRepository.delete(id);

        return id;
    }

    @Override
    public Long update(Long id, GiftDto giftDto) {
        //TODO
        return null;
    }

    private boolean checkGiftName(GiftDto giftDto){

        //TODO
    return false;
    }

    private void checkNewTags(List<Tag> allTags, List<Tag> newTags){
        for (Tag newTag: newTags) {
            for (Tag tag: allTags) {
               if (!Objects.equals(newTag.getName(), tag.getName())){
                tagRepository.save(newTag);
               }


            }

        }
    }
}
