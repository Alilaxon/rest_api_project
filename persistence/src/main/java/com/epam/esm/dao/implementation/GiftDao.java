package com.epam.esm.dao.implementation;

import com.epam.esm.dao.DBmanadger.DBManager;
import com.epam.esm.dao.GiftRepository;
import com.epam.esm.dao.mapper.GiftMapper;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GiftDao implements GiftRepository {
    @Override
    public GiftCertificate save(GiftCertificate gift) {
        try (Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO gifts " +
                            "(gift_name, description, price," +
                            " duration, create_date, last_update_date)" +
                            " VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            connection.setAutoCommit(false);
            statement.setString(1, gift.getName());
            statement.setString(2, gift.getDescription());
            statement.setLong(3, gift.getPrice());
            statement.setLong(4, gift.getDuration());
            statement.setString(5, gift.getCreateDate());
            statement.setString(6, gift.getLastUpdateDate());
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0){
                throw new SQLException("Creating gift failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    gift.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating gift failed, no ID obtained.");
                }
            }

            PreparedStatement manyToMany = connection.prepareStatement
                    ("INSERT INTO gifts_tags(gift_id, tag_id) VALUES(?,?) ");

            for (Tag tag: gift.getTags()) {
                manyToMany.setLong(1,gift.getId());
                manyToMany.setLong(2,tag.getId());
                manyToMany.execute();
            }
            connection.commit();
            connection.setAutoCommit(true);
            statement.close();
            manyToMany.close();
            return gift;

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean existsByName(String name) {
        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM gifts WHERE gift_name =?");
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            statement.close();

            return resultSet.next();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


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
        return giftCertificateList;
    }

    @Override
    public List<GiftCertificate> findAllByTag(String tag) {
        List<GiftCertificate> giftCertificateList = new ArrayList<>();

        try (Connection connection = DBManager.getInstance().getConnection()){

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM  gifts INNER JOIN tags t on t.tag_name = ? ORDER BY gift_name DESC ");
            statement.setString(1,tag);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                giftCertificateList.add(GiftMapper.extractGift(resultSet));
            }

            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return giftCertificateList;
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
