package com.solvd.laba.dao.jdbcMySQLimpl;

import com.solvd.laba.enums.AccountType;
import com.solvd.laba.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCMySQLTest {

    private static final Logger LOGGER = LogManager.getLogger(JDBCMySQLTest.class);

    public static void main(String[] args) {

        testJDBCUserDAO();
        testJDBCAddressDAO();
        testJDBCCustomerDAO();
        testJDBCProductDAO();
        testJDBCOrderDAO();

    }

    public static void testJDBCUserDAO() {
        UserDAO userDAO = new UserDAO();
        User userTestInsert = new User(9, "vitalik", "vitalik007@mail.ru", "dbnfkbr",
                "2022-05-10 18:22:00", AccountType.USER, "1999-11-01");
        userDAO.saveEntity(userTestInsert);
        User userById = userDAO.getEntityById(9);
        LOGGER.info("An object read from the database: " + userById);
        userById.setEmail("vitalik007@gmail.com");
        userById.setPassword("qwertyasdf");
        userDAO.updateEntity(userById);
        LOGGER.info("The updated object: " + userDAO.getUserByEmail("vitalik007@gmail.com"));
        userDAO.removeEntity(9);
    }

    public static void testJDBCCustomerDAO() {
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customerTestInsert = new Customer(8, "Vitaly", "Ivanov",
                296718122, 15, 8);
        customerDAO.saveEntity(customerTestInsert);
        Customer customerById = customerDAO.getEntityById(8);
        LOGGER.info("An object read from the database: " + customerById);
        customerById.setLastName("Sidorov");
        customerById.setPhoneNumber(336718122);
        customerDAO.updateEntity(customerById);
        LOGGER.info("The updated object: " + customerDAO.getEntityById(8));
        customerDAO.removeEntity(8);
    }

    public static void testJDBCAddressDAO() {
        AddressDAO addressDAO = new AddressDAO();
        Address addressTestInsert = new Address(16, "Ukraine", "Kiev", "Khreschatyk",
                14, 1, 101, 10);
        addressDAO.saveEntity(addressTestInsert);
        Address addressById = addressDAO.getEntityById(16);
        LOGGER.info("An object read from the database: " + addressById);
        addressById.setCountry("Belarus");
        addressById.setCity("Vitebsk");
        addressById.setStreet("Severnaya");
        addressDAO.updateEntity(addressById);
        LOGGER.info("The updated object: " + addressDAO.getEntityById(16));
        addressDAO.removeEntity(16);
    }

    public static void testJDBCProductDAO() {
        ProductDAO productDAO = new ProductDAO();
        Product productTestInsert = new Product(4, 1, "HUAWEI P50 PRO", 1500.0F, 4);
        productDAO.saveEntity(productTestInsert);
        Product productById = productDAO.getEntityById(4);
        LOGGER.info("An object read from the database: " + productById);
        productById.setName("HUAWEI P50 PRO MAX");
        productById.setPrice(1200.0F);
        productDAO.updateEntity(productById);
        LOGGER.info("The updated object: " + productDAO.getEntityById(4));
        productDAO.removeEntity(4);
    }

    public static void testJDBCOrderDAO() {
        OrderDAO orderDAO = new OrderDAO();
        Order orderTestInsert = new Order(10, 8, 1, 4, 2400.0F,
                2, 2);
        orderDAO.saveEntity(orderTestInsert);
        Order orderById = orderDAO.getEntityById(10);
        LOGGER.info("An object read from the database: " + orderById);
        orderById.setCount(3);
        orderById.setIdDelivery(1);
        orderById.setIdPayment(1);
        orderDAO.updateEntity(orderById);
        LOGGER.info("The updated object: " + orderDAO.getEntityById(10));
        orderDAO.removeEntity(10);
    }
}
