package com.solvd.laba.dao;

import com.solvd.laba.model.Order;

import java.util.List;

public interface IOrderDAO extends IBaseDAO<Order>{
    List<Order> getOrdersByCustomerId(int idCustomer);
}
