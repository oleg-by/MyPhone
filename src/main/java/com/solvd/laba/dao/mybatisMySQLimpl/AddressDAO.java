package com.solvd.laba.dao.mybatisMySQLimpl;

import com.solvd.laba.dao.IAddressDAO;
import com.solvd.laba.model.Address;
import com.solvd.laba.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AddressDAO implements IAddressDAO, ISession {

    private static final Logger LOGGER = LogManager.getLogger(AddressDAO.class);

    @Override
    public List<Address> getAddressesByCity(String city) {
        try (SqlSession session = getSqlSession().openSession()) {
            List<Address> addresses = session.selectList("getAddressesByCity", city);
            session.commit();
            return addresses;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void saveEntity(Address address) {
        try (SqlSession session = getSqlSession().openSession()) {
            session.insert("saveAddress", address);
            session.commit();
            LOGGER.info("The Address with ID = " + address.getId() + " has been written in DB successfully.");
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public Address getEntityById(int id) {
        try (SqlSession session = getSqlSession().openSession()) {
            Address address = session.selectOne("getAddressById", id);
            session.commit();
            return address;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateEntity(Address address) {
        try (SqlSession session = getSqlSession().openSession()) {
            session.update("updateAddress", address);
            session.commit();
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession session = getSqlSession().openSession()) {
            session.delete("removeAddress", id);
            session.commit();
            LOGGER.info("The Address with ID = " + id + " has been removed successfully.");
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public List<Address> getAll() {
        try (SqlSession session = getSqlSession().openSession()) {
            List<Address> addresses = session.selectList("getAllAddresses");
            session.commit();
            return addresses;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
