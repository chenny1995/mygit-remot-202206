package com.cn.t3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBHelper {

    private static final String className = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/db423";
    private static final String uname = "root";
    private static final String upass = "111";

    // 获取数据库连接对象
    public static Connection getConn(){
        Connection conn = null;
        try{
            Class.forName(className);
            conn = DriverManager.getConnection(url,uname,upass);
        } catch(Exception e){
            e.printStackTrace();
        }

        return conn;
    }

    public static void closeConn(Connection conn){
        try{
            if(conn !=null || !conn.isClosed()){
                conn.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void closePstmt(PreparedStatement pstmt){
        try{
            if(pstmt !=null){
                pstmt.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void closeRs(ResultSet rs){
        try{
            if(rs !=null){
                rs.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
