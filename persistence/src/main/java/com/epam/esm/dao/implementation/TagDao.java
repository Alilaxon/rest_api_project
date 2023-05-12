package com.epam.esm.dao.implementation;

import com.epam.esm.dao.DBmanadger.DBManager;
import com.epam.esm.dao.TagRepository;
import com.epam.esm.dao.mapper.Columns;
import com.epam.esm.dao.mapper.GiftMapper;
import com.epam.esm.dao.mapper.TagMapper;
import com.epam.esm.entity.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class TagDao implements TagRepository {

    private static final Logger log = LogManager.getLogger(TagDao.class);
    @Override
    public List<Tag> getAll() {

        List<Tag> tagList = new ArrayList<>();
        try (Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tags");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                tagList.add(TagMapper.extractTag(resultSet));
            }

            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tagList;
    }

    public Tag save(Tag tag) {

        try (Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO tags (tag_name) VALUES(?)", Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, tag.getName());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {

                throw new SQLException("Creating Tag failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    tag.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating Tag failed, no ID obtained.");
                }
            }

            statement.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

        return tag;
    }

    @Override
    public Tag findByName(String name) {

        log.info("Find Tag by name {}",name);

        try (Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tags WHERE tag_name=?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            Tag tag = null;

            while (resultSet.next()) {

                tag = TagMapper.extractTag(resultSet);
            }
            statement.close();

            return tag;

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }

    @Override
    public Tag findById(Long id) {
        try (Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT FROM tags WHERE id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            Tag tag = null;

            while (resultSet.next()) {

                tag = TagMapper.extractTag(resultSet);
            }
            statement.close();

            return tag;

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }


    @Override
    public Long Delete(Long id) {

        try (Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("DELETE FROM tags WHERE id =?");
            statement.setLong(1, id);
            statement.execute();
            statement.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
     return id;
    }

    @Override
    public boolean existsByName(String name) {
        try (Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tags WHERE tag_name =?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            statement.close();

            return resultSet.next();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


