package com.solvd.laba.dao.jdbcMySQLimpl;

import com.solvd.laba.enums.AccountType;
import com.solvd.laba.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class JDBCMySQLTest {

    private static final Logger LOGGER = LogManager.getLogger(JDBCMySQLTest.class);

    public static void main(String[] args) {

        testUserDAO();
        testAddressDAO();
        testCustomerDAO();
        testProductDAO();
        testOrderDAO();

    }

    public static void testUserDAO() {
        User userTestInsert = new User(8, "vitalik", "vitalik007@mail.ru", "dbnfkbr",
                "2022-05-10 18:22:00", AccountType.USER, "1999-11-01");
        User userTestUpdate = new User(8, "vitalik", "vitalik007@gmail.com", "qwertyasdf",
                "2022-05-10 18:22:00", AccountType.USER, "1999-11-01");
        UserDAO userDAO = new UserDAO();

        /* Uncomment the line below if you want to insert a new entry into the database.*/

        //userDAO.saveEntity(userTestInsert);

        List<User> users = new ArrayList<>();
        int i = 1;
        while (i < 9) {
            users.add(userDAO.getEntityById(i));
            i++;
        }
        for (User user : users) {
            LOGGER.info(user);
        }
        User userTestGet = userDAO.getEntityById(8);
        LOGGER.info("An object read from the database: " + userTestGet);
        userDAO.updateEntity(userTestUpdate);
        LOGGER.info("The updated object: " + userDAO.getEntityById(8));
        LOGGER.info("The user with email 'valera@mail.ru' is " + userDAO.getUserByEmail("valera@mail.ru"));

        /* Uncomment the line below if you want to remove an inserted entry from the database.*/

        //userDAO.removeEntity(8);
    }

    public static void testCustomerDAO() {
        Customer customerTestInsert = new Customer(8, "Vitaly", "Ivanov",
                296718122, 16, 8);
        Customer customerTestUpdate = new Customer(8, "Vitaly", "Ivanov",
                336718122, 16, 8);
        CustomerDAO customerDAO = new CustomerDAO();

        /* Uncomment the line below if you want to insert a new entry into the database.*/

        //customerDAO.saveEntity(customerTestInsert);

        List<Customer> customers = new ArrayList<>();
        int i = 1;
        while (i < 9) {
            customers.add(customerDAO.getEntityById(i));
            i++;
        }
        for (Customer customer : customers) {
            LOGGER.info(customer);
        }
        Customer customerTestGet = customerDAO.getEntityById(8);
        LOGGER.info("An object read from the database: " + customerTestGet);
        customerDAO.updateEntity(customerTestUpdate);
        LOGGER.info("The updated object: " + customerDAO.getEntityById(8));
        LOGGER.info("The customer with User ID (5) is " + customerDAO.getCustomerByUserId(5));

        /* Uncomment the line below if you want to remove an inserted entry from the database.*/

        //customerDAO.removeEntity(8);
    }

    public static void testAddressDAO() {
        Address addressTestInsert = new Address(16, "Ukraine", "Kiev", "Khreschatyk",
                14, 1, 101, 10);
        Address addressTestUpdate = new Address(16, "Belarus", "Vitebsk", "Severnaya",
                10, 2, 11, 1);
        AddressDAO addressDAO = new AddressDAO();

        /* Uncomment the line below if you want to insert a new entry into the database.*/

        //addressDAO.saveEntity(addressTestInsert);

        List<Address> addresses = new ArrayList<>();
        int i = 1;
        while (i < 17) {
            addresses.add(addressDAO.getEntityById(i));
            i++;
        }
        for (Address address : addresses) {
            LOGGER.info(address);
        }
        Address addressTestGet = addressDAO.getEntityById(16);
        LOGGER.info("An object read from the database: " + addressTestGet);
        addressDAO.updateEntity(addressTestUpdate);
        LOGGER.info("The updated object: " + addressDAO.getEntityById(16));
        LOGGER.info("The addresses with city 'Minsk' are " + addressDAO.getAddressesByCity("Minsk"));

        /* Uncomment the line below if you want to remove an inserted entry from the database.*/

        //addressDAO.removeEntity(16);
    }

    public static void testProductDAO() {
        Product productTestInsert = new Product(4, 1, "HUAWEI P50 PRO", 1500.0F, 4);
        Product productTestUpdate = new Product(4, 1, "HUAWEI P50 PRO", 1200.0F, 4);
        ProductDAO productDAO = new ProductDAO();

        /* Uncomment the line below if you want to insert a new entry into the database.*/

        //productDAO.saveEntity(productTestInsert);

        List<Product> products = new ArrayList<>();
        int i = 1;
        while (i < 5) {
            products.add(productDAO.getEntityById(i));
            i++;
        }
        for (Product product : products) {
            LOGGER.info(product);
        }
        Product productTestGet = productDAO.getEntityById(4);
        LOGGER.info("An object read from the database: " + productTestGet);
        productDAO.updateEntity(productTestUpdate);
        LOGGER.info("The updated object: " + productDAO.getEntityById(4));
        LOGGER.info("The products from Category 1: " + productDAO.getProductsByCategory(1));

        /* Uncomment the line below if you want to remove an inserted entry from the database.*/

        //productDAO.removeEntity(4);
    }

    public static void testOrderDAO() {
        Order orderTestInsert = new Order(10, 8, 1, 4, 2400.0F,
                2, 2);
        Order orderTestUpdate = new Order(10, 8, 1, 3, 2400.0F,
                3, 2);
        OrderDAO orderDAO = new OrderDAO();

        /* Uncomment the line below if you want to insert a new entry into the database.*/

        //orderDAO.saveEntity(orderTestInsert);

        List<Order> orders = new ArrayList<>();
        int i = 1;
        while (i < 11) {
            orders.add(orderDAO.getEntityById(i));
            i++;
        }
        for (Order order : orders) {
            LOGGER.info(order);
        }
        Order orderTestGet = orderDAO.getEntityById(10);
        LOGGER.info("An object read from the database: " + orderTestGet);
        orderDAO.updateEntity(orderTestUpdate);
        LOGGER.info("The updated object: " + orderDAO.getEntityById(10));
        LOGGER.info("The orders of Customer (5): " + orderDAO.getOrdersByCustomerId(5));

        /* Uncomment the line below if you want to remove an inserted entry from the database.*/

        //orderDAO.removeEntity(10);
    }
}
