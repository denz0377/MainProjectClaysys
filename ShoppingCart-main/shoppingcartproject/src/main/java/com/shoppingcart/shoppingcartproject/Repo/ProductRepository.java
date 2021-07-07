package com.shoppingcart.shoppingcartproject.Repo;

import com.shoppingcart.shoppingcartproject.Modelx.Product;
import com.shoppingcart.shoppingcartproject.Modelx.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
