package com.shoppingcart.shoppingcartproject.Repo;

import com.shoppingcart.shoppingcartproject.Modelx.Cart;
import com.shoppingcart.shoppingcartproject.Modelx.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepositry extends JpaRepository<Cart, Long> {

}
