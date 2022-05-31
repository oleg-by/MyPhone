package com.solvd.laba.dao.mybatisMySQLimpl;

import java.io.IOException;
import java.io.Reader;

import com.solvd.laba.enums.AccountType;
import com.solvd.laba.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTest {
    public static void main(String[] args) {

        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        User user = new User("andrey", "andrey@gmail.com", "123456789", AccountType.USER, "1983-04-07");

        session.insert("User.saveEntity", user);
        session.commit();
        session.close();

    }
}
