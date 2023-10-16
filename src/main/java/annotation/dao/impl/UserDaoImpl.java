package annotation.dao.impl;

import annotation.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository("userDao")
@Profile("test")
public class UserDaoImpl implements UserDao {

    @Value("${jdbc.driver}")
    private String userName;


    @Override
    public void show() {
        System.out.println(userName);
    }
}
