package com.jsystems.jdbc;

import com.jsystems.api.TestUser;
import com.jsystems.dao.UserServiceDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JDBCTest {

    @Test
    @DisplayName("JDBC Test")
    public void jdbcTest(){

        UserServiceDao userDao = new UserServiceDao();
        TestUser testUser = userDao.getOne(1l);
        assertTrue(testUser.getName().equals("Piotr"));
    }
}
