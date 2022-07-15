package com.cn.t3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SelectGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsDao dao = new GoodsDao();
        List<Goods> list = dao.getAllGoods();

        // 将数据放入request范围内
        req.setAttribute("list",list);

        req.setAttribute("msg","查询成功，额呵呵！！！");

        // 转发到显示所有商品的页面
        req.getRequestDispatcher("showGoods.jsp").forward(req,resp);
    }
}
