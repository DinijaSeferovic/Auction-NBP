package com.etf.nbp.repositories;

import com.etf.nbp.database.DatabaseService;
import com.etf.nbp.domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class UserRepository{

    @Autowired
    DatabaseService dbService;

    public User getById(int id) {
        String sql = "SELECT * FROM nbp.nbp_user WHERE id=?";

        try {
            Connection connection = dbService.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String username = resultSet.getString("username");
                String phoneNumber = resultSet.getString("phone_number");
                Date birthdate = resultSet.getDate("birth_date");

                return new User(id,firstName,lastName,email,username,password,birthdate,phoneNumber,null,null);
            }

            return  null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}