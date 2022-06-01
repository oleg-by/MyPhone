package com.solvd.laba.dao.mybatisMySQLimpl;

import com.solvd.laba.dao.IUserDAO;
import com.solvd.laba.enums.AccountType;
import com.solvd.laba.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBatisTest {

    private static final Logger LOGGER = LogManager.getLogger(MyBatisTest.class);

    public static void main(String[] args) {

        User user = new User("andrey", "andrey@gmail.com", "123456789", AccountType.USER, "1983-04-07");

        IUserDAO userDAO = new UserDAO();

        LOGGER.info(userDAO.getEntityById(1));

        //userDAO.saveEntity(user);
        //userDAO.removeEntity(14);

    }
}
