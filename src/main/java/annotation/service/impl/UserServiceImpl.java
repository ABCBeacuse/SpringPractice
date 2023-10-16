package annotation.service.impl;

import annotation.dao.UserDao;
import annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;

// @Component
@Service
@Scope("singleton")
@Lazy(false)
public class UserServiceImpl implements UserService {

    // 根据类型从 Spring 容器中进行查找，然后进行注入
    // @Autowired
    // @Qualifier("userDao2")
    @Resource(name = "userDao2")
    private UserDao userDao;

    public UserServiceImpl() {

    }

    @PostConstruct
    public void init() {

    }

    @PreDestroy
    public void destroy() {

    }

    @Override
    public void show() {
        System.out.println(userDao);
    }

    @Autowired
    @Qualifier("userDao2")
    public void xxx(UserDao userDao) {
        System.out.println("xxx " + userDao);
    }

    @Autowired
    public void yyy(List<UserDao> userDaoList) {
        System.out.println("yyy " + userDaoList);
    }

}
