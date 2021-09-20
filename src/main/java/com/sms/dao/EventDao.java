package com.sms.dao;

import com.sms.domain.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class EventDao implements AutoCloseable {
    private static Logger log = LoggerFactory.getLogger(EventDao.class);

    private Connection connection;
    private final static String sql = "INSERT INTO event (id, duration, type, host, alert)  VALUES (?, ?, ?, ?, ?)";

    public EventDao(Connection connection) {
        this.connection = connection;
    }

    public Boolean save(Event event) {
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, event.getId());
            statement.setLong(2, event.getDuration());
            statement.setString(3, event.getType());
            statement.setString(4, event.getHost());
            statement.setBoolean(5, event.isAlert());
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            log.error("Failure saving event, skipping",  e);
            return false;
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            log.error("Failure closing database connection",  e);
        }
    }
}
