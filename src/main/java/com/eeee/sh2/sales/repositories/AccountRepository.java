package com.eeee.sh2.sales.repositories;

import com.eeee.sh2.sales.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Charles on 15/06/2017.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
    Optional<Account> findByEmailAndPassword(String email, String password);
}
