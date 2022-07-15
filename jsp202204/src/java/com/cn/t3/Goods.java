package com.cn.t3;
// 实体类，用于封装数据
public class Goods {
    private  int gid;
    private String gname;
    private  String gdate;
    private double gprice;
    private int gstatus;
    private String gimg;

    public String getGimg() {
        return gimg;
    }

    public void setGimg(String gimg) {
        this.gimg = gimg;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGdate() {
        return gdate;
    }

    public void setGdate(String gdate) {
        this.gdate = gdate;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public int getGstatus() {
        return gstatus;
    }

    public void setGstatus(int gstatus) {
        this.gstatus = gstatus;
    }

    public Goods(int gid, String gname, String gdate, double gprice, int gstatus) {
        this.gid = gid;
        this.gname = gname;
        this.gdate = gdate;
        this.gprice = gprice;
        this.gstatus = gstatus;
    }

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", gdate='" + gdate + '\'' +
                ", gprice=" + gprice +
                ", gstatus=" + gstatus +
                '}';
    }
}
