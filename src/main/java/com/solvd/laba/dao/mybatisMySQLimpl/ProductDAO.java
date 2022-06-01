package com.solvd.laba.dao.mybatisMySQLimpl;

import com.solvd.laba.dao.IProductDAO;
import com.solvd.laba.model.Product;

import java.util.List;

public class ProductDAO implements IProductDAO {
    @Override
    public void saveEntity(Product product) {


    }

    @Override
    public Product getEntityById(int id) {
        return null;
    }

    @Override
    public void updateEntity(Product product) {

    }

    @Override
    public void removeEntity(int id) {

    }

    @Override
    public List<Product> getProductsByCategory(int idCategory) {
        return null;
    }
}
