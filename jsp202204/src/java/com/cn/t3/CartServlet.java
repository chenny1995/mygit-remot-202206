package com.cn.t3;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int gid = Integer.parseInt(req.getParameter("gid"));

        ///使用集合来保存要购买的商品信息--》Map<k,v>  k---gid,v---cartitem(方便袋)--》Goods，num
        // Session--》会话

        // Map<Integer,CartItem> map = new HashMap<Integer,CartItem>();

        GoodsDao dao = new GoodsDao();


        // 获取会话对象
        HttpSession session = req.getSession();

        Map<Integer,CartItem> map = (Map<Integer, CartItem>) session.getAttribute("cart");

        if(map == null){
            map = new HashMap<Integer, CartItem>();
            session.setAttribute("cart",map);
        }

        // 购物车已经存在，判断当前商品是否购买过
        if(map.containsKey(gid)){// 商品已经存在，数量+1
            CartItem ci = map.get(gid);
            ci.setQuantity(ci.getQuantity() + 1);
        } else {
            CartItem ci = new CartItem();
            ci.setQuantity(1);
            Goods goods = dao.getGoodsById(gid);
            ci.setGoods(goods);

            map.put(gid,ci);
        }

        req.getRequestDispatcher("SelectGoodsServlet").forward(req,resp);
    }
}
