package annotation.dao.impl;

import annotation.dao.UserDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("userDao2")
@Primary
public class UserDaoImpl2 implements UserDao {
    @Override
    public void show() {

    }
}
