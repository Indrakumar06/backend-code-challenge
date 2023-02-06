package com.midwesttape.project.challengeapplication.service;

import com.midwesttape.project.challengeapplication.mapper.UserRowMapper;
import com.midwesttape.project.challengeapplication.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JdbcTemplate template;

    public User user(final Long userId) {
        try {

            return template.queryForObject(
                "select " +
                    "user.id, " +
                    "user.firstName, " +
                    "user.lastName, " +
                    "user.username, " +
                    "user.password , " +
                    " address.address1, " +
                    "address.address2, " +
                    "address.city, " +
                    "address.state, " +
                    "address.postal  " +
                    "from User user " +
                    "join Address address on user.id = address.id " +
                    "where user.id =  ?",
                new UserRowMapper(),
                userId
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }


    public int update(User user) {
        try {

            return template.update(
                "UPDATE User " +
                    "SET firstname= ?, " +
                    "lastname= ?, " +
                    "username= ?, " +
                    "password= ? " +
                    "WHERE id= ? ",
                new UserRowMapper(),
                user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(), user.getId()
            );
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }

}
