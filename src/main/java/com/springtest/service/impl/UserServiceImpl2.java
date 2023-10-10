package com.springtest.service.impl;

import com.springtest.mapper.AccountMapper;
import com.springtest.pojo.Account;
import com.springtest.service.UserService;

import java.util.List;

public class UserServiceImpl2 implements UserService {

    private AccountMapper accountMapper;

    public AccountMapper getAccountMapper() {
        return accountMapper;
    }

    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public void show() {
        List<Account> all = accountMapper.findAll();
        all.forEach(System.out::println);
    }
}
