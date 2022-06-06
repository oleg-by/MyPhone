package com.solvd.laba.dao;

import java.util.List;

public interface IBaseDAO <Entity>{
    void saveEntity(Entity model);
    Entity getEntityById(int id);
    void updateEntity(Entity model);
    void removeEntity(int id);
    List<Entity> getAll();
}
