package com.solvd.laba.deadlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestB implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(TestB.class);

    @Override
    public void run() {
        LOGGER.info("Test B is running.");
    }
}
