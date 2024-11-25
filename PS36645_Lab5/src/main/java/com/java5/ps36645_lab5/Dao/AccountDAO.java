package com.java5.ps36645_lab5.Dao;

import com.java5.ps36645_lab5.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account, String> {
}
