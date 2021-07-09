package com.shoppingcart.shoppingcartproject.Repo;

import com.shoppingcart.shoppingcartproject.Modelx.AccountDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepositry extends JpaRepository<AccountDetail, Long> {
}
