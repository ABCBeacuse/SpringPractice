package com.springtest.service.impl;

import com.springtest.dao.UserDao;
import com.springtest.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private List<String> stringList;

    private List<UserDao> userDaoList;

    private Set<String> strSet;

    private Set<UserDao> userDaoSet;

    private Map<String, UserDao> map;

    private Properties properties;

    public UserServiceImpl() {
        System.out.println("UserServiceImpl 无参构造");
    }

    public UserServiceImpl(String name) {

    }

    // BeanFactory 去调用该方法 从容器中获得 userDao 设置到此处
    public void setUserDao(UserDao userDao) {
        System.out.println("userDao 进行属性注入到 userService");
        this.userDao = userDao;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setUserDaoList(List<UserDao> userDaoList) {
        this.userDaoList = userDaoList;
    }

    public void setStrSet(Set<String> strSet) {
        this.strSet = strSet;
    }

    public void setUserDaoSet(Set<UserDao> userDaoSet) {
        this.userDaoSet = userDaoSet;
    }

    public void setMap(Map<String, UserDao> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void show() {
        /*
            System.out.println(stringList);
            System.out.println(userDaoList);
            System.out.println("*************************");
            System.out.println(strSet);
            System.out.println(userDaoSet);
            System.out.println("****************************");
            System.out.println(map);
            System.out.println("****************************");
            System.out.println(properties);
         */
        System.out.println(userDao);
    }
}
