package com.solvd.laba.parsers;

import com.fasterxml.jackson.core.JsonParseException;
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

            objectMapper.writeValue(new File(System.getProperty("user.dir") + "/src/main/resources/user.json"), userTest);

        } catch (JsonParseException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

    }

}
