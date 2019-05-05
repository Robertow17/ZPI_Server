package com.zpi.account;

import com.zpi.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository  extends JpaRepository<Account, AccountPK>
{
    @Query(value = "SELECT a.service FROM Account a WHERE a.pk.login = ?1")
    List<Service> findAllServicesByUser(String userLogin);
}
