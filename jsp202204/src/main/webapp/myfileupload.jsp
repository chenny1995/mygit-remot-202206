<%@ page language="java"  pageEncoding="GBK" isELIgnored="false" %>
<html>
<body>
    <form method="post" action="MyUploadServlet" enctype="multipart/form-data">
        Ҫ��ӵ���Ʒ��Ϣ���£�<br/>
        ���ƣ�<input type="text" name="gname" /><br/>
        �۸�<input type="text" name="gprice" /><br/>
        ״̬��<input type="text" name="gstatus" /><br/>
        ͼƬ��<input type="file" name="gimg" /><br/>
        <br/>
        <a href="MyDownServlet?filename=b.txt">����1</a>
        <a href="MyDownServlet?filename=a.jpg">����2</a>
        <input type="submit" value="�ύ"/>
    </form>
</body>
</html>
