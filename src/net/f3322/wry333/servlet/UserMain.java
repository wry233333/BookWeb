package net.f3322.wry333.servlet;

import net.f3322.wry333.domain.Book;
import net.f3322.wry333.service.BookControl;
import net.f3322.wry333.service.BookControlImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userMain")
public class UserMain extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookControl bc = new BookControlImp();
        java.util.List<Book> books = bc.findAllBook();
        req.setAttribute("books",books);
        req.getRequestDispatcher("/user_main.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
