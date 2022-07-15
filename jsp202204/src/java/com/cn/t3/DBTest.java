package com.cn.t3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBTest {
    // jdbc
    public static void main(String[] args) {
        DBTest db = new DBTest();
        db.delGoods();
    }
    // 增删改查，
    public void showGoods(){
        // 连接对象
        Connection conn = null;
        // 操作对象
        PreparedStatement pstmt = null;
        // 结果集对象
        ResultSet rs = null;

        try {
            // 1.加载驱动类到JVM
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db423","root","111");

            pstmt = conn.prepareStatement("select * from goods");

            rs = pstmt.executeQuery();

            while (rs.next()){
                System.out.println(rs.getInt("gid")+"#"+rs.getString("gname")+"#"+rs.getString("gdate")+"#"+rs.getDouble("gprice")+"#"+rs.getInt("gstatus"));
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void addGoods(){

        Connection conn = null;
        PreparedStatement pstmt = null;
        try{

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db423","root","111");

            pstmt = conn.prepareStatement("insert into goods(gname,gdate,gprice,gstatus) values(?,?,?,?)");

            pstmt.setString(1,"bingzi");
            pstmt.setString(2,"2011-03-28 09:58:23");
            pstmt.setDouble(3,1.5);
            pstmt.setInt(4,1);

            pstmt.execute();


        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }



    public void updGoods(){

        Connection conn = null;
        PreparedStatement pstmt = null;
        try{

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db423","root","111");

            pstmt = conn.prepareStatement("update goods set gname=?,gprice=? where gid=?");

            pstmt.setString(1,"dabaozi");
            pstmt.setDouble(2,1.2);
            pstmt.setInt(3,56);

            pstmt.execute();


        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void delGoods(){

        Connection conn = null;
        PreparedStatement pstmt = null;
        try{

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db423","root","111");

            pstmt = conn.prepareStatement("delete from goods where gid=?");

            pstmt.setInt(1,15);

            pstmt.execute();


        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
