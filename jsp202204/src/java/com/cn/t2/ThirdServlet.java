package com.cn.t2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ThirdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=GBK");//  GBK,utf-8,iso-8859-1
        // 获取页面表单数据
        String uname = req.getParameter("uname");
        String upass = req.getParameter("upass");

        String[] like = req.getParameterValues("like");

        PrintWriter out = resp.getWriter();

        out.print("姓名：" + uname);
        out.print("<br/>");
        out.print("密码：" + upass);
        out.print("<br/>");

        out.print("爱好：");
        for(int i=0;i<like.length;i++) {
            out.print(like[i]);
            out.print("<br/>");
        }
    }
}
