package com.solvd.laba.dao;

public interface IBaseDAO <Entity>{
    void saveEntity(Entity model);
    Entity getEntityById(int id);
    void updateEntity(Entity model);
    void removeEntity(int id);
}
