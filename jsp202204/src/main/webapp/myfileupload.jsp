<%@ page language="java"  pageEncoding="GBK" isELIgnored="false" %>
<html>
<body>
    <form method="post" action="MyUploadServlet" enctype="multipart/form-data">
        要添加的商品信息如下：<br/>
        名称：<input type="text" name="gname" /><br/>
        价格：<input type="text" name="gprice" /><br/>
        状态：<input type="text" name="gstatus" /><br/>
        图片：<input type="file" name="gimg" /><br/>
        <br/>
        <a href="MyDownServlet?filename=b.txt">下载1</a>
        <a href="MyDownServlet?filename=a.jpg">下载2</a>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
