package service;

import api.ProductService;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private List<Product> products;
    private static ProductServiceImpl instance = null;

    private ProductServiceImpl() {
        products = new ArrayList<Product>();
    }

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }

        return instance;
    }

    public void setProductsList(List<Product> productsList) {
        this.products = productsList;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Integer getCountProducts() {
        return products.size();
    }

    public Product getProductByProductName(String productName) {
        for(Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }

        return null;
    }

    public boolean isProductExist(String productName) {
        for(Product product : products) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isProductExist(Long productId) {
        for(Product product : products) {
            if (product.getId().equals(productId)) {
                return true;
            }
        }
        return false;
    }

    public boolean isProductOnWarehouse(String productName) {
        for(Product product : products) {
            if (isProductExist(productName) && product.getProductCount() > 0) {
                return true;
            }
        }
        return false;
    }

}
