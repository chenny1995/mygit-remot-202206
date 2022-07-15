package com.cn.t3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PreUpdGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=gbk");
        int gid = Integer.parseInt(req.getParameter("gid"));

        GoodsDao dao = new GoodsDao();
        Goods goods = dao.getGoodsById(gid);

        req.setAttribute("goods",goods);

        req.getRequestDispatcher("t3upd.jsp").forward(req,resp);
    }
}
