package com.cn.t2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EncServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("EncServlet2 的 doPost 被调用了");
        // 获取加密前的数据
        String oldstr = req.getParameter("oldstr");

        // 获取加密后的数据
        String newstr = req.getAttribute("newstr").toString();

        // 输出到页面
        resp.setContentType("text/html;charset=GBK");
        PrintWriter out = resp.getWriter();

        out.print("加密前是：" + oldstr);
        out.print("<br/>");
        out.print("加密后是：" + newstr);
    }
}
