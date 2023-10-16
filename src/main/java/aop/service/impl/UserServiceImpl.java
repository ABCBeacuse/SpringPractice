package aop.service.impl;

import aop.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void show1() {
        System.out.println("show1.....");
    }

    public void show1(String a) {
        System.out.println("aaa.....");
    }

    @Override
    public void show2() {
        System.out.println("show2.....");
        // int i = 1 / 0;
    }
}
