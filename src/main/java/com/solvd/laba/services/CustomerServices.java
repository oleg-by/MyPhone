package com.solvd.laba.services;

import com.solvd.laba.dao.IBaseDAO;
import com.solvd.laba.exceptions.UnsupportedFactoryException;
import com.solvd.laba.model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class CustomerServices {
    private static final Logger LOGGER = LogManager.getLogger(CustomerServices.class);

    public static void main(String[] args) {

        showCustomersWithMaxOrderAmount();

    }

    public static void showCustomersWithMaxOrderAmount() {
        AbstractFactory factory = null;
        try {
            factory = FactoryGenerator.getFactory("mybatis");
        } catch (UnsupportedFactoryException e) {
            LOGGER.error(e.getMessage());
        }
        IBaseDAO customerDAO = factory.getDAO("customer");
        IBaseDAO orderDAO = factory.getDAO("order");
        Set<Float> amounts = new TreeSet<>();
        List<Order> orders = orderDAO.getAll();
        for (Order order : orders) {
            amounts.add(order.getOrderAmount());
        }
        Float max = Collections.max(amounts);
        LOGGER.info("The max order amount is " + max + "$.");
        LOGGER.info("Customer(s) with order amount " + max + "$:");
        for (Order order : orders) {
            if (order.getOrderAmount() == max) {
                LOGGER.info(customerDAO.getEntityById(order.getIdCustomer()));
            }
        }
    }
}
