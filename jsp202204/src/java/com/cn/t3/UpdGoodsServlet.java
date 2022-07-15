package com.cn.t3;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=gbk");
        int gid = Integer.parseInt(req.getParameter("gid"));
        String gname = req.getParameter("gname");
        double gprice = Double.parseDouble(req.getParameter("gprice"));
        int  gstatus = Integer.parseInt(req.getParameter("gstatus"));

        Goods goods = new Goods();
        goods.setGid(gid);
        goods.setGname(gname);
        goods.setGprice(gprice);
        goods.setGstatus(gstatus);

        GoodsDao dao = new GoodsDao();

        dao.updGoods(goods);

        PrintWriter out = resp.getWriter();

        out.print("操作成功！！！");
    }
}
