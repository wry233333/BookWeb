package net.f3322.wry333.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCode")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        //1.创建一对象，在内存中图片（验证码图片）
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //2.美化图片

        //2.1获取画笔
        Graphics g = bi.getGraphics();
        //给画笔设置颜色
        g.setColor(Color.PINK);
        //设置填充区域
        g.fillRect(0,0,width,height);
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);
        //设置图片字符
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //随机画四个字符
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            Random ran = new Random();
            int index = ran.nextInt(str.length());
            char c = str.charAt(index);
            sb.append(c);
            g.drawString(c+"",width/5*(i+1),height/2);

        }
        String s = sb.toString();
        req.getSession().setAttribute("checkCode",s);
        g.setColor(Color.GREEN);
        //随机画十条线段
        for (int i = 0; i < 10; i++) {
            Random ran = new Random();
            int x = ran.nextInt(width);
            int y = ran.nextInt(height);

            int x1 = ran.nextInt(width);
            int y1 =ran.nextInt(height);
            g.drawLine(x,y,x1,y1);
        }
        //3.讲图片输出到页面展示
        ImageIO.write(bi,"jpg",resp.getOutputStream());
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
