package com.solvd.laba.services;

import com.solvd.laba.dao.IBaseDAO;

public abstract class AbstractFactory {
    public abstract IBaseDAO getDAO(String entity);
}
