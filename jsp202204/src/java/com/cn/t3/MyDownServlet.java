package com.cn.t3;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

public class MyDownServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("filename");

        //resp.setContentType("text/html;charset=GBK");

        resp.addHeader("content-Type","application/octet-stream");
        resp.addHeader("content-Disposition","attachement;filename="+ URLEncoder.encode(fileName,"utf-8"));

        InputStream in = getServletContext().getResourceAsStream(fileName);// 将文件路径+文件名，读取成输入流对象

        ServletOutputStream out = resp.getOutputStream();

        byte[] bs = new byte[1024];

        int len = -1;

        while((len=in.read(bs))!=-1){// 将文件从输入流中读向缓冲区，并记录读取的长度，如果是-1说明读到了文件的末尾，结束循环
            out.write(bs,0,len);
        }

        out.close();
        in.close();
    }
}
