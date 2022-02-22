package net.f3322.wry333.servlet;

import net.f3322.wry333.Dao.UserDao;
import net.f3322.wry333.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cc = req.getParameter("cc");
        String checkCode = (String) req.getSession().getAttribute("checkCode");
        if(checkCode.equalsIgnoreCase(cc)){
            User user = new User();
            Map<String, String[]> map = req.getParameterMap();
            try {
                BeanUtils.populate(user,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            UserDao userDao = new UserDao();
            if (userDao.register(user) == 0) {
                req.setAttribute("reg_error","注册失败,用户名重复");
                req.getRequestDispatcher("register.jsp").forward(req,resp);
            }
            else {
                req.setAttribute("reg_success","注册成功，请登录");
                req.getRequestDispatcher("register.jsp").forward(req,resp);
            }
        }
        else {
            req.setAttribute("cc_error","验证码错误");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
