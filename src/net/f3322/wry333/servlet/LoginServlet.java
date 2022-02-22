package net.f3322.wry333.servlet;

import net.f3322.wry333.Dao.UserDao;
import net.f3322.wry333.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        //从请求获取用户名和密码
        Map<String, String[]> pm = req.getParameterMap();
        //创建user对象
        User user = new User();
        try {
            /**
             * 用BeanUtils自动封装对象
             * 前面的对象是封装对象，后面是包含数据的map对象
             qian  */
            BeanUtils.populate(user, pm);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //用userDao登录user
        UserDao userDao = new UserDao();
        User login = userDao.login(user);
        //判断是否登录成功
        if (login == null) {
            //登陆失败
            req.setAttribute("login_error", "用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);

        } else {
            //登陆成功
            //存储数据
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/successServlet").forward(req, resp);

        }


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
