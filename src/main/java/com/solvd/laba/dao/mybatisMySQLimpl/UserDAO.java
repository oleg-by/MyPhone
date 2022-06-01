package com.solvd.laba.dao.mybatisMySQLimpl;

import com.solvd.laba.dao.IUserDAO;
import com.solvd.laba.model.User;
import org.apache.ibatis.session.SqlSession;

public class UserDAO implements IUserDAO, ISession {

    @Override
    public void saveEntity(User user) {
        try(SqlSession session = getSqlSession().openSession()) {
            session.insert("saveEntity", user);
            session.commit();
        }
    }

    @Override
    public User getEntityById(int id) {
        IUserDAO userDAO;
        try (SqlSession session = getSqlSession().openSession()) {
            userDAO = session.getMapper(IUserDAO.class);
            session.commit();
            return userDAO.getEntityById(id);
        }
    }

    @Override
    public void updateEntity(User user) {
        try(SqlSession session = getSqlSession().openSession()) {
            session.update("updateEntity", user);
            session.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try(SqlSession session = getSqlSession().openSession()) {
            session.delete("removeEntity", id);
            session.commit();
        }
    }

    @Override
    public User getUserByEmail(String email) {
        IUserDAO userDAO;
        try (SqlSession session = getSqlSession().openSession()) {
            userDAO = session.getMapper(IUserDAO.class);
            session.commit();
            return userDAO.getUserByEmail(email);
        }
    }
}
