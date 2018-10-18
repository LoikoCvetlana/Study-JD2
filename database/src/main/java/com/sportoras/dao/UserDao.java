package com.sportoras.dao;

import com.sportoras.connection.ConnectionPool;
import com.sportoras.entity.Role;
import com.sportoras.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDao {

    private static final UserDao INSTANCE = new UserDao();

    public static UserDao getInstance() {
        return INSTANCE;
    }

    private static final String FIND_BY_ID = "SELECT id, role, password, name, lastname, registration_date, email, organization, other_information  FROM oraz_storage.users WHERE id = ?";


    public Optional<User> findById(Long userId) {
        Optional<User> user = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = Optional.of(getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getLong("id"))
                .role(Role.valueOf(resultSet.getString("role")))
                .password(resultSet.getString("password"))
                .name(resultSet.getString("name"))
                .lastname(resultSet.getString("lastname"))
                .registrationDate(resultSet.getDate("registration_date").toLocalDate())
                .email(resultSet.getString("email"))
                .organization(resultSet.getString("organization"))
                .otherInformation(resultSet.getString("other_information"))
                .build();
    }
}
