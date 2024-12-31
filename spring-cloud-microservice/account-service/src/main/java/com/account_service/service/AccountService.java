package com.account_service.service;

import com.account_service.entity.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    public Account get(String id){
        return new Account();
    }

    public Account save(Account account){
        return new Account();
    }

    public Account update(Account account){
        return new Account();
    }

    public void delete(String id){

    }

}
