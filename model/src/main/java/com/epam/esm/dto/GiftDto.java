package com.epam.esm.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.beans.ConstructorProperties;

public class GiftDto {

    private String name;

    private String description;

    private Long price;

    private Long duration;


    public GiftDto() {
    }
    @ConstructorProperties({"name", "description","price","duration"})
    public GiftDto(String name, String description, Long price, Long duration) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "GiftDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                '}';
    }
}
