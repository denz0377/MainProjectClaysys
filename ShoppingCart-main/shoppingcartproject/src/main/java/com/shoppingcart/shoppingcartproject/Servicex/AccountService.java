package com.shoppingcart.shoppingcartproject.Servicex;

import com.shoppingcart.shoppingcartproject.Modelx.AccountDetail;
import com.shoppingcart.shoppingcartproject.Modelx.Product;

import java.util.List;

public interface AccountService {

    List<AccountDetail> getAllAccount();
    void saveAccount(AccountDetail account);
    AccountDetail getAccountById(long id);
    void deleteAccountById(long id);
}
