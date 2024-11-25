package com.java5.ps36645_lab7.Dao;

import com.java5.ps36645_lab7.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account, String> {

}
