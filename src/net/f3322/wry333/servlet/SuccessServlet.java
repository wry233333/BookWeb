package net.f3322.wry333.servlet;



import net.f3322.wry333.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if(user != null){
            if(user.getUsername().equals("admin")){
                req.getRequestDispatcher("/admin").forward(req,resp);
            }
            else {
                req.getRequestDispatcher("/userMain").forward(req,resp);
            }
        }

    }
}
