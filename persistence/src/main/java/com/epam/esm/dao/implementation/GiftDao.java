package com.epam.esm.dao.implementation;

import com.epam.esm.dao.DBmanadger.DBManager;
import com.epam.esm.dao.GiftRepository;
import com.epam.esm.dao.mapper.GiftMapper;
import com.epam.esm.entity.GiftCertificate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GiftDao implements GiftRepository {
    @Override
    public GiftCertificate save(GiftCertificate giftCertificate) {
        try (Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO gifts " +
                            "(gift_name, description, price," +
                            " duration, createdate, lastupdatedate, tag_id)" +
                            " VALUES(?,?,?,?,?,?,?) ");

            statement.setString(1, giftCertificate.getName());
            statement.setString(2, giftCertificate.getDescription());
            statement.setLong(3, giftCertificate.getPrice());
            statement.setLong(4, giftCertificate.getDuration());
            statement.setString(5, giftCertificate.getCreateDate());
            statement.setString(6, giftCertificate.getLastUpdateDate());
            statement.execute();
            statement.close();


        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return giftCertificate;
    }

    @Override
    public List<GiftCertificate> findAll() {

        List<GiftCertificate> giftCertificateList = new ArrayList<>();

        try (Connection connection = DBManager.getInstance().getConnection()){

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM gifts");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                giftCertificateList.add(GiftMapper.extractGift(resultSet));
            }

            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public GiftCertificate update(GiftCertificate giftCertificate) {
        try (Connection connection = DBManager.getInstance().getConnection()) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void delete(Long id) {

    }


}
