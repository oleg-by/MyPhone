package com.solvd.laba.dao.mybatisMySQLimpl;

import com.solvd.laba.dao.IAddressDAO;
import com.solvd.laba.model.Address;

import java.util.List;

public class AddressDAO implements IAddressDAO {
    @Override
    public List<Address> getAddressesByCity(String city) {
        return null;
    }

    @Override
    public void saveEntity(Address model) {

    }

    @Override
    public Address getEntityById(int id) {
        return null;
    }

    @Override
    public void updateEntity(Address model) {

    }

    @Override
    public void removeEntity(int id) {

    }
}
