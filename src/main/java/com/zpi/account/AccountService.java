package com.zpi.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService
{
    @Autowired
    private AccountRepository accountRepository;


    public List<Account> findAll()
    {
        return accountRepository.findAll();
    }


    public Optional<Account> findById(int serviceId, String login)
    {
        return accountRepository.findById(new AccountPK(serviceId, login));

    }

    public List<com.zpi.service.Service> findAllServicesByUser(String login)
    {
        return accountRepository.findAllServicesByUser(login);

    }


    public Account save(Account favourite)
    {
        return accountRepository.save(favourite);
    }


    public void deleteById(int serviceId, String login)
    {
        accountRepository.deleteById(new AccountPK(serviceId, login));
    }


}
