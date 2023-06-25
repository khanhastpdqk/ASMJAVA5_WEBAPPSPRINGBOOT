package com.demo.repo;

import com.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// TODO
public interface AccountRepo extends JpaRepository<Account,String> {
    @Query("SELECT p FROM Account p WHERE p.username= ?1 AND p.password=?2")
    Account findByUsernameAndPassword(String username, String password);
}
