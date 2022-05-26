package com.solvd.laba.dao;

import com.solvd.laba.model.Product;

import java.util.List;

public interface IProductDAO extends IBaseDAO<Product> {
    List<Product> getProductsByCategory(int idCategory);
}
