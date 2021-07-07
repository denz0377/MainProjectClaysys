package com.shoppingcart.shoppingcartproject.Servicex;

import com.shoppingcart.shoppingcartproject.Modelx.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    void saveUser(User user);
    User getUserById(long id);
    void deleteUserById(long id);
}
