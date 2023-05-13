package com.epam.esm.utils;

import com.epam.esm.dto.TagDto;
import com.epam.esm.entity.Tag;
import com.epam.esm.exception.InvalidGiftDtoException;
import com.epam.esm.exception.InvalidTagDtoException;
import com.epam.esm.exception.InvalidTagException;

public class TagValidator {

    public static void checkTagDto (TagDto dto) throws InvalidTagDtoException {
        if(dto.getName() == null){
            throw new InvalidTagDtoException();
        }

        if(!(dto.getName().length() >= 1 && dto.getName().length() <= 32)){
            throw new InvalidTagDtoException();
        }
    }

    public static void checkTag (Tag tag) throws InvalidTagException {
        if(tag.getName() == null){
            throw new InvalidTagException();
        }

        if(!(tag.getName().length() >= 1 && tag.getName().length() <= 32)){
            throw new InvalidTagException();
        }
    }
}
