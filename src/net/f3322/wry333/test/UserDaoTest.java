package net.f3322.wry333.test;


import net.f3322.wry333.Dao.UserDao;
import net.f3322.wry333.domain.User;
import org.junit.Test;

public class UserDaoTest {



    @Test
    public void testLogin(){
        User login_user= new User();
        login_user.setUsername("lisi");
        login_user.setPassword("123654");
        UserDao userDao = new UserDao();
        User user = userDao.login(login_user);
        System.out.println(user);
    }

    @Test
    public void test1Login(){
        User login_user= new User();
        login_user.setUsername("lisi");
        login_user.setPassword("123654");
        UserDao userDao = new UserDao();
        User user = userDao.login(login_user);
        System.out.println(user);
    }


}
