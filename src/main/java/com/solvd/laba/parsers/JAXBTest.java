package com.solvd.laba.parsers;

import com.solvd.laba.enums.AccountType;
import com.solvd.laba.model.User;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class JAXBTest {
    private static final Logger LOGGER = LogManager.getLogger(JAXBTest.class);

    public static void main(String[] args) {
        marshal();
    }

    public static void marshal() {
        User user = new User(111, "volodya", "volodya@mail.ru", "112233665544",
                "2022-05-18 12:22:00", AccountType.USER, "1989-11-01");

        JAXBContext context;
        try {
            context = JAXBContext.newInstance(User.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(user, new File(System.getProperty("user.dir") + "/src/main/resources/msXML_output.xml"));
        } catch (JAXBException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
