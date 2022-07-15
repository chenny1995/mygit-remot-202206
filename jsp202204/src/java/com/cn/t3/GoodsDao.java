package com.cn.t3;

import com.sun.xml.internal.ws.spi.db.DatabindingException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GoodsDao {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public void addGoods(Goods goods){
        try{
            conn = DBHelper.getConn();
            String sql = "insert into goods(gname,gdate,gprice,gstatus) values(?,now(),?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,goods.getGname());
            pstmt.setDouble(2,goods.getGprice());
            pstmt.setInt(3,goods.getGstatus());

            pstmt.execute();

        } catch (Exception e){
            e.printStackTrace() ;
        } finally {
            DBHelper.closePstmt(pstmt);
            DBHelper.closeConn(conn);
        }
    }


    public void addGoods2(Goods goods){
        try{
            conn = DBHelper.getConn();
            String sql = "insert into goods(gname,gdate,gprice,gstatus,gimg) values(?,now(),?,?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,goods.getGname());
            pstmt.setDouble(2,goods.getGprice());
            pstmt.setInt(3,goods.getGstatus());
            pstmt.setString(4,goods.getGimg());

            pstmt.execute();

        } catch (Exception e){
            e.printStackTrace() ;
        } finally {
            DBHelper.closePstmt(pstmt);
            DBHelper.closeConn(conn);
        }
    }

    public void updGoods(Goods goods){
        try{
            conn = DBHelper.getConn();
            String sql = "update goods set gname=?,gprice=? where gid=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,goods.getGname());
            pstmt.setDouble(2,goods.getGprice());
            pstmt.setInt(3,goods.getGid());

            pstmt.execute();

        } catch (Exception e){
            e.printStackTrace() ;
        } finally {
            DBHelper.closePstmt(pstmt);
            DBHelper.closeConn(conn);
        }
    }

    public void delGoods(int gid){
        try{
            conn = DBHelper.getConn();
            String sql = "delete from goods where gid=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,gid);

            pstmt.execute();

        } catch (Exception e){
            e.printStackTrace() ;
        } finally {
            DBHelper.closePstmt(pstmt);
            DBHelper.closeConn(conn);
        }
    }

    public List<Goods> getAllGoods(){
        List<Goods> list = new ArrayList<Goods>();
        try{
            conn = DBHelper.getConn();
            String sql = "select * from goods";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()){
                Goods goods = new Goods(rs.getInt("gid"),rs.getString("gname"),rs.getString("gdate"),rs.getDouble("gprice"),rs.getInt("gstatus"));
                list.add(goods);
            }

        } catch (Exception e){
            e.printStackTrace() ;
        } finally {
            DBHelper.closeRs(rs);
            DBHelper.closePstmt(pstmt);
            DBHelper.closeConn(conn);
        }
        return list;
    }


    public  Goods getGoodsById(int gid){
        Goods goods = null;
        try{
            conn = DBHelper.getConn();
            String sql = "select * from goods where gid=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,gid);

            rs = pstmt.executeQuery();

            while (rs.next()){
                goods = new Goods(rs.getInt("gid"),rs.getString("gname"),rs.getString("gdate"),rs.getDouble("gprice"),rs.getInt("gstatus"));

                goods.setGimg(rs.getString("gimg"));
            }

        } catch (Exception e){
            e.printStackTrace() ;
        } finally {
            DBHelper.closeRs(rs);
            DBHelper.closePstmt(pstmt);
            DBHelper.closeConn(conn);
        }
        return goods;
    }


//    public static void main(String[] args) {
//
//        String fileName = "我的图片.jpg";
//
//        String surfix = fileName.substring(fileName.lastIndexOf("."),fileName.length());
//
//        System.out.println(surfix);
//
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//
//        String prefix = sdf.format(date);
//
//        int i = (int)(Math.random()*1000);
//
//        String stri = i + "";
//
//        String newName = prefix+stri+surfix;
//
//        System.out.println(newName);
//
//    }
}
