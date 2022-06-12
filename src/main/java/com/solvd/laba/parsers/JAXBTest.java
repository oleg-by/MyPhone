package com.solvd.laba.parsers;

import com.solvd.laba.enums.AccountType;
import com.solvd.laba.model.Order;
import com.solvd.laba.model.User;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JAXBTest {
    private static final Logger LOGGER = LogManager.getLogger(JAXBTest.class);

    public static void main(String[] args) {
        marshal();
        CustomerTest customerTest = unmarshall();
        LOGGER.info(customerTest);
    }

    public static void marshal() {
        User user = new User(11, "volodya", "volodya@mail.ru", "112233665544",
                "2022-05-19 12:22:00", AccountType.USER, "1989-11-01");
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, 11, 1, 4, 2400.0F,
                2, 2));
        orders.add(new Order(2, 11, 2, 3, 2000.0F,
                2, 2));
        orders.add(new Order(3, 11, 3, 2, 1200.0F,
                2, 2));
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("1989-11-01");
        } catch (ParseException e) {
            LOGGER.error(e.getMessage());
        }
        CustomerTest customerTest = new CustomerTest(11, "Vladimir", "Ivanov",
                296718122, date, user, orders);

        JAXBContext context;
        try {
            context = JAXBContext.newInstance(CustomerTest.class, User.class, Order.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(customerTest, new File(System.getProperty("user.dir") + "/src/main/resources/msXML_output.xml"));
            LOGGER.info("Marshalling is done.");
        } catch (JAXBException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static CustomerTest unmarshall() {
        JAXBContext context;
        CustomerTest customerTest = new CustomerTest();
        try {
            context = JAXBContext.newInstance(CustomerTest.class, User.class, Order.class);
            customerTest = (CustomerTest) context.createUnmarshaller()
                    .unmarshal(new FileReader(System.getProperty("user.dir") + "/src/main/resources/msXML_output.xml"));
        } catch (JAXBException e) {
            LOGGER.error(e.getMessage());
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        return customerTest;
    }
}
