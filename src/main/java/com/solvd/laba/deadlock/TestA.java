package main.java.com.solvd.laba.deadlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestA extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(TestA.class);

    @Override
    public void run() {
        super.run();
        LOGGER.info("Test A is running.");
    }
}
