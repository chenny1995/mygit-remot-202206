package com.cn.t2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncServlet1  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取表单数据
        String oldstr = req.getParameter("oldstr");
        // 将加密之前的字符串转换成字符数组
        char[] oldchars = oldstr.toCharArray();
        // 创建新字符数组，用于保存加密后的字符数组
        char[] newchars = new char[oldchars.length];

        for(int i=0;i<oldchars.length;i++){
            char ch = oldchars[i];
            // abz   ---》   bca
            if(ch=='z'){
                newchars[i] = 'a';
            } else if(ch == 'Z'){
                newchars[i] = 'A';
            } else {
                newchars[i]=(char)(ch + 1);
            }

        }

        String newstr = new String(newchars);

        // 将加密后的字符串放入request
        req.setAttribute("newstr",newstr);

        // 页面跳转: 转发
        //req.getRequestDispatcher("EncServlet2").forward(req,resp);

        // 页面跳转：重定向
        resp.sendRedirect("EncServlet2");
    }
}
