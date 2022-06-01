package com.solvd.laba.dao.mybatisMySQLimpl;

import com.solvd.laba.dao.IOrderDAO;
import com.solvd.laba.model.Order;

import java.util.List;

public class OrderDAO implements IOrderDAO {
    @Override
    public void saveEntity(Order model) {

    }

    @Override
    public Order getEntityById(int id) {
        return null;
    }

    @Override
    public void updateEntity(Order model) {

    }

    @Override
    public void removeEntity(int id) {

    }

    @Override
    public List<Order> getOrdersByCustomerId(int idCustomer) {
        return null;
    }
}
