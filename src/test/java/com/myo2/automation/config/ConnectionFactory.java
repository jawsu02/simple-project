package com.myo2.automation.config;

import com.myo2.automation.session.SessionVariablesApi;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Profile({"API"})
@Component
public class ConnectionFactory implements FactoryBean<Connection> {

    private final Connection connection;

    public ConnectionFactory(SessionVariablesApi sessionVariablesApi) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlserver://10.60.0.172:1433;databaseName=PPassUAT;user=sumit.mohanty;password=cuttack123#");
    }

    @Override
    public Connection getObject() throws Exception {
        return connection;
    }

    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
