package com.shoppingcart.shoppingcartproject.Servicex;

import com.shoppingcart.shoppingcartproject.Modelx.Product;
import com.shoppingcart.shoppingcartproject.Modelx.User;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    void saveProduct(Product product);
    Product getProductById(int id);
    void deleteProductById(int id);
}
