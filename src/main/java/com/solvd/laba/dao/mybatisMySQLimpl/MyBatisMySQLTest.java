package com.solvd.laba.dao.mybatisMySQLimpl;

import com.solvd.laba.dao.*;
import com.solvd.laba.enums.AccountType;
import com.solvd.laba.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBatisMySQLTest {

    private static final Logger LOGGER = LogManager.getLogger(MyBatisMySQLTest.class);

    public static void main(String[] args) {

        testMyBatisUserDAO();
        testMyBatisAddressDAO();
        testMyBatisProductDAO();
        testMyBatisOrderDAO();
        testMyBatisCustomerDAO();

    }

    public static void testMyBatisUserDAO() {
        IUserDAO userDAO = new UserDAO();
        User userTestInsert = new User(9, "alex", "alex@mail.ru", "qwertyz", AccountType.USER, "1998-05-30");
        userDAO.saveEntity(userTestInsert);
        User userById = userDAO.getEntityById(9);
        LOGGER.info("An object read from the database: " + userById);
        userById.setPassword("102030458541");
        userById.setEmail("alex@gmail.com");
        userDAO.updateEntity(userById);
        LOGGER.info("The updated object: " + userDAO.getUserByEmail(userById.getEmail()));
        userDAO.removeEntity(9);
    }

    public static void testMyBatisProductDAO(){
        IProductDAO productDAO = new ProductDAO();
        Product productTestInsert = new Product(4, 1, "HUAWEI P50 PRO", 1500.0F, 4);
        productDAO.saveEntity(productTestInsert);
        Product productById = productDAO.getEntityById(4);
        LOGGER.info("An object read from the database: " + productById);
        productById.setName("HUAWEI P50 PRO MAX");
        productById.setPrice(1600.0F);
        productDAO.updateEntity(productById);
        LOGGER.info("The updated object: " + productDAO.getEntityById(4));
        productDAO.removeEntity(4);
    }

    public static void testMyBatisOrderDAO(){
        IOrderDAO orderDAO = new OrderDAO();
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

    public static void testMyBatisCustomerDAO(){
        ICustomerDAO customerDAO = new CustomerDAO();
        Customer customerTestInsert = new Customer(8, "Vitaly", "Ivanov",
                296718122, 15, 8);
        customerDAO.saveEntity(customerTestInsert);
        Customer customerById = customerDAO.getEntityById(8);
        LOGGER.info("An object read from the database: " + customerById);
        customerById.setPhoneNumber(336818123);
        customerById.setLastName("Sidorov");
        customerDAO.updateEntity(customerById);
        LOGGER.info("The updated object: " + customerDAO.getEntityById(8));
        customerDAO.removeEntity(8);
    }

    public static void testMyBatisAddressDAO(){
        IAddressDAO addressDAO = new AddressDAO();
        Address addressTestInsert = new Address(16, "Ukraine", "Kiev", "Khreschatyk",
                14, 1, 101, 10);
        addressDAO.saveEntity(addressTestInsert);
        Address addressById = addressDAO.getEntityById(16);
        LOGGER.info("An object read from the database: " + addressById);
        addressById.setCountry("Poland");
        addressById.setCity("Krakov");
        addressById.setStreet("Grzegorzecka");
        addressById.setBuildingNumber(16);
        addressDAO.updateEntity(addressById);
        LOGGER.info("The updated object: " + addressDAO.getEntityById(16));
        addressDAO.removeEntity(16);
    }
}
