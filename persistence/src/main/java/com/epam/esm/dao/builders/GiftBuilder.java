package com.epam.esm.dao.builders;

import com.epam.esm.entity.GiftCertificate;

public class GiftBuilder {

    private Long id;
    private String name;
    private String description;
    private Long price;
    private Long duration;
    private String createDate;
    private String lastUpdateDate;



    public static GiftBuilder builder() {

        return new GiftBuilder();
    }

    public GiftBuilder id(Long id) {

        this.id = id;

        return this;
    }

    public GiftBuilder name (String name) {

        this.name = name;

        return this;
    }

    public GiftBuilder description(String description) {

        this.description = description;

        return this;
    }

    public GiftBuilder price (Long price) {

        this.price = price;

        return this;
    }

    public GiftBuilder duration(Long duration) {

        this.duration = duration;

        return this;
    }

    public GiftBuilder createDate(String createDate) {

        this.createDate = createDate;

        return this;
    }

    public GiftBuilder lastUpdateDate(String lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;

        return this;
    }

    public GiftCertificate build(){

        return new GiftCertificate(id,name,description,price,
                duration,createDate,lastUpdateDate);
    }
}

