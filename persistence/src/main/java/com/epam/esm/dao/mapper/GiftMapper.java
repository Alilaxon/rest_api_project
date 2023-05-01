package com.epam.esm.dao.mapper;

import com.epam.esm.dao.builders.GiftBuilder;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GiftMapper {

    public static GiftCertificate extractGift (ResultSet resultSet, List<Tag> tags) throws SQLException {




        return GiftBuilder.builder()
                .id(resultSet.getLong(Columns.ID))
                .name(resultSet.getString(Columns.NAME))
                .description(resultSet.getString(Columns.DESCRIPTION))
                .price(resultSet.getLong(Columns.PRICE))
                .duration(resultSet.getLong(Columns.DURATION))
                .createDate(resultSet.getString(Columns.CREATE_DATE))
                .lastUpdateDate(resultSet.getString(Columns.lAST_UPDATE_DATE))
                .tags(tags)
                .build();

    }
}
