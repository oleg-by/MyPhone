package com.solvd.laba.dao.mybatisMySQLimpl;

import com.solvd.laba.dao.IUserDAO;
import com.solvd.laba.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDAO implements IUserDAO, ISession {

    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);

    @Override
    public void saveEntity(User user) {
        try (SqlSession session = getSqlSession().openSession()) {
            session.insert("saveUser", user);
            session.commit();
            LOGGER.info("The User with ID = " + user.getId() + " has been written in DB successfully.");
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public User getEntityById(int id) {
        try (SqlSession session = getSqlSession().openSession()) {
            User user = session.selectOne("getUserById", id);
            session.commit();
            return user;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateEntity(User user) {
        try (SqlSession session = getSqlSession().openSession()) {
            session.update("updateUser", user);
            session.commit();
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession session = getSqlSession().openSession()) {
            session.delete("removeUser", id);
            session.commit();
            LOGGER.info("The User with ID = " + id + " has been removed successfully.");
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public User getUserByEmail(String email) {
        try (SqlSession session = getSqlSession().openSession()) {
            User user = session.selectOne("getUserByEmail", email);
            session.commit();
            return user;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
