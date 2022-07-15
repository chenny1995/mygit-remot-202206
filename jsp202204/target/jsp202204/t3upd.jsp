<%@ page language="java"  pageEncoding="GBK" isELIgnored="false" %>
<html>
<body>
    <form method="post" action="UpdGoodsServlet">
        要修改的商品信息如下：<br/>
        编号：<input type="text" name="gid" value="${goods.gid}" readonly/><br/>
        名称：<input type="text" name="gname"  value="${goods.gname}"/><br/>
        价格：<input type="text" name="gprice" value="${goods.gprice}"/><br/>
        状态：<input type="text" name="gstatus" value="${goods.gstatus}"/><br/>
        <img src="${goods.gimg}"/>
        <br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
