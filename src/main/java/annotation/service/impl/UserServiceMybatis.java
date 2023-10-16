package annotation.service.impl;

import annotation.mapper.AccountMapper;
import annotation.pojo.Account;
import annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceMybatis implements UserService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void show() {
        List<Account> accounts = accountMapper.findAll();
        accounts.forEach(System.out::println);
    }
}
