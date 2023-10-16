package annotation.service.impl;

import annotation.dao.UserDao;
import annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl2 implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void show() {
        System.out.println(userDao);
    }
}
