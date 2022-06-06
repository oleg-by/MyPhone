package com.solvd.laba.services;

import com.solvd.laba.exceptions.UnsupportedFactoryException;

public class FactoryGenerator {

    public static AbstractFactory getFactory(String factory) throws UnsupportedFactoryException {
        switch (factory) {
            case "jdbc":
                return new JDBCFactory();
            case "mybatis":
                return new MyBatisFactory();
            default:
                throw new UnsupportedFactoryException("Unsupported factory type");
        }
    }

}
