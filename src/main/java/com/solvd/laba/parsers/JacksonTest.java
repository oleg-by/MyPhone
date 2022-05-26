package com.solvd.laba.parsers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.laba.model.Purchase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JacksonTest {
    private static final Logger LOGGER = LogManager.getLogger(JacksonTest.class);

    public static void main(String[] args) throws ParseException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Purchase> purchases = new ArrayList<>();
            purchases.add(new Purchase(1, "IPhone 11 PRO"
                    , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-01-10 12:22:00"), 1800.0F));
            purchases.add(new Purchase(2, "IPhone 12 PRO"
                    , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-02-19 19:45:00"), 2000.0F));
            purchases.add(new Purchase(3, "IPhone 13 PRO"
                    , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-05-10 10:55:00"), 2400.0F));
            UserTest userTest = new UserTest(1, "Oleg", "oleg@mail.ru"
                    , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-05-10 10:55:00")
                    , new SimpleDateFormat("yyyy-MM-dd").parse("1990-07-20"), purchases);
            File file = new File(System.getProperty("user.dir") + "/src/main/resources/user.json");
            if (!file.exists()) {
                file.createNewFile();
            }
            objectMapper.writeValue(file, userTest);
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, UserTest.class);
            List<UserTest> userTestList = objectMapper.readValue(new File(System.getProperty("user.dir") + "/src/main/resources/users.json"), type);
            //UserTest u = objectMapper.readValue(new File(System.getProperty("user.dir") + "/src/main/resources/user.json"), UserTest.class);
            for (UserTest u : userTestList) {
                LOGGER.info(u);
            }
        } catch (JsonParseException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
