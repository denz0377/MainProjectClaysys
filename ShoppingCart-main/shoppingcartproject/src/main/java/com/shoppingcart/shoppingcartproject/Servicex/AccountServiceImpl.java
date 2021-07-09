package com.shoppingcart.shoppingcartproject.Servicex;

import com.shoppingcart.shoppingcartproject.Modelx.AccountDetail;
import com.shoppingcart.shoppingcartproject.Modelx.Product;
import com.shoppingcart.shoppingcartproject.Repo.AccountRepositry;
import com.shoppingcart.shoppingcartproject.Repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepositry accountRepository;

    @Override
    public List<AccountDetail> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public void saveAccount(AccountDetail account) {
        this.accountRepository.save(account);

    }

    @Override
    public AccountDetail getAccountById(long id) {
        Optional<AccountDetail> optional = accountRepository.findById(id);
        AccountDetail account = null;
        if(optional.isPresent()) {
            account=optional.get();
        }else {
            throw new RuntimeException(" account not found for id :: " + id);
        }
        return account;
    }

    @Override
    public void deleteAccountById(long id) {
        this.accountRepository.deleteById(id);

    }
}
