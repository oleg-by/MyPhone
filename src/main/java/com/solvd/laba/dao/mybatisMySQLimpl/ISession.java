package com.solvd.laba.dao.mybatisMySQLimpl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public interface ISession {
    Logger LOGGER = LogManager.getLogger(ISession.class);

    default SqlSessionFactory getSqlSession() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return new SqlSessionFactoryBuilder().build(reader);
    }
}
