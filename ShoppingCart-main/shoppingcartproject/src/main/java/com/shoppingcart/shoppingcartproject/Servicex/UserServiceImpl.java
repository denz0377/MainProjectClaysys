package com.shoppingcart.shoppingcartproject.Servicex;

import com.shoppingcart.shoppingcartproject.Modelx.User;
import com.shoppingcart.shoppingcartproject.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
@Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);

    }

    @Override
    public User getUserById(long id) {
        Optional<User> optional= userRepository.findById(id);
        User user=null;
        if(optional.isPresent()) {
            user=optional.get();

        }else{
            throw new RuntimeException("user not fount for id :"+id);
        }
    return user;
    }


    @Override
    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);

    }
}
