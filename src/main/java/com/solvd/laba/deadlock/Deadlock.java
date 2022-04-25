package com.solvd.laba.deadlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Deadlock {

    private static final Logger LOGGER = LogManager.getLogger(Deadlock.class);

    public static void main(String[] args) {
        TestA lockA = new TestA();
        TestB lockB = new TestB();

        Thread threadA = new Thread(() -> {
            LOGGER.info(Thread.currentThread().getName() + " start");
            synchronized (lockA) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    LOGGER.error(e.getMessage());
                }

                synchronized (lockB) {

                }
            }
            LOGGER.info(Thread.currentThread().getName() + " end");
        }, "Thread A");

        Thread thread2 = new Thread(() -> {
            LOGGER.info(Thread.currentThread().getName() + " start");
            synchronized (lockB) {
                synchronized (lockA) {

                }
            }
            LOGGER.info(Thread.currentThread().getName() + " end");
        }, "Thread B");

        threadA.start();
        thread2.start();
    }
}

