package annotation.mapper;

import annotation.pojo.Account;

import java.util.List;

public interface AccountMapper {
    List<Account> findAll();
}
