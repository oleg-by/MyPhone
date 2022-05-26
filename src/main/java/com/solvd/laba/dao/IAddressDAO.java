package com.solvd.laba.dao;

import com.solvd.laba.model.Address;

import java.util.List;

public interface IAddressDAO extends IBaseDAO<Address>{
    List<Address> getAddressesByCity(String city);
}
