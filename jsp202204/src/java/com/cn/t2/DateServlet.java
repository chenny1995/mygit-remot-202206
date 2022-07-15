package com.cn.t2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=GBK");
        resp.setHeader("refresh","1");
        PrintWriter out = resp.getWriter();

        ServletConfig config = this.getServletConfig();

        ServletContext context = this.getServletContext();

        String uname = config.getInitParameter("uname");

        String upass = config.getInitParameter("upass");

        String appname = context.getInitParameter("appname");

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");

        String now = sdf.format(date);

        out.print("当前时间是：" + now);

        out.print("<br/>");
        out.print(uname);
        out.print("<br/>");
        out.print(upass);
        out.print("<br/>");
        out.print(appname);
    }
}
