package com.epam.esm.dao.implementation;

import com.epam.esm.dao.DBmanadger.DBManager;
import com.epam.esm.dao.TagRepository;
import com.epam.esm.dao.mapper.TagMapper;
import com.epam.esm.entity.Tag;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class TagDao implements TagRepository {

    public Tag save(Tag tag) {

        try (Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO tags (tag_name) VALUES(?) ");
            statement.setString(1, tag.getName());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tag;
    }

    @Override
    public Tag findByName(String name) {

        try (Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT FROM tags WHERE tag_name=?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            Tag tag = null;

            while (resultSet.next()) tag = TagMapper.extractTag(resultSet);

            statement.close();

            return tag;

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }



    @Override
    public void Delete(Long id) {

        try (Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("DELETE FROM tags WHERE id =?");
            statement.setLong(1, id);
            statement.execute();
            statement.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}


