package com.cn.t3;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class MyUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=gbk");

        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        Goods goods = new Goods();
        GoodsDao dao = new GoodsDao();

        if(isMultipart){// 判断当前提交的表单是做文件上传的
            FileItemFactory factory = new DiskFileItemFactory();

            ServletFileUpload upload = new ServletFileUpload(factory);

            try{
                // 解析request
                List<FileItem> items = upload.parseRequest(req);

                Iterator<FileItem> it = items.iterator();

                while (it.hasNext()){
                    FileItem item = it.next();

                    String itemName = item.getFieldName();

                    if(item.isFormField()){// 判断当前是否普通的表单元素
                        if(itemName.equals("gname")){
                            goods.setGname(item.getString());
                        } else if(itemName.equals("gprice")){
                            goods.setGprice(Double.parseDouble(item.getString()));
                        } else  if(itemName.equals("gstatus")){
                            goods.setGstatus(Integer.parseInt(item.getString()));
                        }
                    } else {// 当前是文件类型
                        String fileName = "我的图片.jpg";//item.getName();

                        String surfix = fileName.substring(fileName.lastIndexOf("."),fileName.length());


                        goods.setGimg(fileName);
                        String path = "E:\\jsp202204\\src\\main\\webapp\\";//req.getRealPath("/");// 获取工程运行的web服务器的绝对路径

                        File file = new File(path,fileName);// 通过路径+文件名创建文件对象
                        item.write(file);// 将文件对象放入输出流

                    }
                }

                dao.addGoods2(goods);
            } catch (Exception e){
                e.printStackTrace();
            }
        }


        PrintWriter out = resp.getWriter();
        out.print("操作成功！！！");
    }
}
