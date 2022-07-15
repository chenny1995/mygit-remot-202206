package com.cn.t3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=gbk");
        String gname = req.getParameter("gname");
        double gprice = Double.parseDouble(req.getParameter("gprice"));
        int  gstatus = Integer.parseInt(req.getParameter("gstatus"));

        Goods goods = new Goods();
        goods.setGname(gname);
        goods.setGprice(gprice);
        goods.setGstatus(gstatus);

        GoodsDao dao = new GoodsDao();

        dao.addGoods(goods);

        PrintWriter out = resp.getWriter();

        out.print("操作成功！！！");
    }
}
