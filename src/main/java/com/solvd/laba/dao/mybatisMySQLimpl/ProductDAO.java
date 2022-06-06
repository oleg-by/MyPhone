package com.solvd.laba.dao.mybatisMySQLimpl;

import com.solvd.laba.dao.IProductDAO;
import com.solvd.laba.model.Order;
import com.solvd.laba.model.Product;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ProductDAO implements IProductDAO, ISession{

    private static final Logger LOGGER = LogManager.getLogger(ProductDAO.class);

    @Override
    public void saveEntity(Product product) {
        try (SqlSession session = getSqlSession().openSession()) {
            session.insert("saveProduct", product);
            session.commit();
            LOGGER.info("The Product with ID = " + product.getId() + " has been written in DB successfully.");
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public Product getEntityById(int id) {
        try (SqlSession session = getSqlSession().openSession()) {
            Product product = session.selectOne("getProductById", id);
            session.commit();
            return product;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateEntity(Product product) {
        try (SqlSession session = getSqlSession().openSession()) {
            session.update("updateProduct", product);
            session.commit();
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession session = getSqlSession().openSession()) {
            session.delete("removeProduct", id);
            session.commit();
            LOGGER.info("The Product with ID = " + id + " has been removed successfully.");
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public List<Product> getAll() {
        try (SqlSession session = getSqlSession().openSession()) {
            List<Product> products = session.selectList("getAllProducts");
            session.commit();
            return products;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Product> getProductsByCategory(int idCategory) {
        try (SqlSession session = getSqlSession().openSession()) {
            List<Product> products = session.selectList("getProductsByCategory", idCategory);
            session.commit();
            return products;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
