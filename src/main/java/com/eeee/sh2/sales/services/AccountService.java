package com.eeee.sh2.sales.services;


import com.eeee.sh2.sales.model.Account;

import java.util.Optional;

/**
 * Created by Charles on 15/06/2017.
 */
public interface AccountService {
    public Account add(Account user) throws Exception;
    public Optional<Account> getByEmail(String email);
    public Optional<Account> get(Long id);
    public Optional<Account> authenticate(String email, String password);
}
