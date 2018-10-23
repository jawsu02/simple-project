package com.myo2.automation.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Profile("API")
@Component
public class DBUtils {

    private final Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    @Autowired
    public DBUtils(Connection connection) {
        this.connection = connection;
    }


    public ResultSet executeStatement(String queryStatement) {

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryStatement);
            while (resultSet.next()) {
                return resultSet;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
