package com.epam.esm.utils;

import com.epam.esm.dto.GiftDto;
import com.epam.esm.exception.InvalidGiftDtoException;

public class GiftValidator {

    private final static Long PRICE_MAX_VALUE = 10000000L;
    private final static Long DURATION_MAX_VALUE = 365L;

    public static void checkGiftDto (GiftDto dto) throws InvalidGiftDtoException {
        checkName(dto.getName());
        checkPrice(dto.getPrice());
        checkDuration(dto.getDuration());

    }

    private static void checkName(String name) throws InvalidGiftDtoException {
        if(name == null){
            throw new InvalidGiftDtoException();
        }

        if(!(name.length() >= 1 && name.length() <= 32)){
            throw new InvalidGiftDtoException();
        }

    }

    private static void checkPrice(Long price) throws InvalidGiftDtoException {
        if(price == null){
            throw new InvalidGiftDtoException();
        }

        if(!(price >= 1 && price <= PRICE_MAX_VALUE)){
            throw new InvalidGiftDtoException();
        }
    }
    private static void checkDuration(Long duration) throws InvalidGiftDtoException {
        if(duration == null){
            throw new InvalidGiftDtoException();
        }

        if(!(duration >= 1 && duration <=DURATION_MAX_VALUE)){
            throw new InvalidGiftDtoException();
        }

    }

}
