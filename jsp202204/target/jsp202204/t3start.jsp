<%@ page language="java"  pageEncoding="GBK"%>
<html>
<body>
    <form method="post" action="AddGoodsServlet">
        商品名称：<input type="text" name="gname"/><br/>
        价格：<input type="text" name="gprice"/><br/>
        状态：<input type="text" name="gstatus"/><br/>
        <br/><a href="SelectGoodsServlet">查看所有商品信息</a>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
