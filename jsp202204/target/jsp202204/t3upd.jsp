<%@ page language="java"  pageEncoding="GBK" isELIgnored="false" %>
<html>
<body>
    <form method="post" action="UpdGoodsServlet">
        Ҫ�޸ĵ���Ʒ��Ϣ���£�<br/>
        ��ţ�<input type="text" name="gid" value="${goods.gid}" readonly/><br/>
        ���ƣ�<input type="text" name="gname"  value="${goods.gname}"/><br/>
        �۸�<input type="text" name="gprice" value="${goods.gprice}"/><br/>
        ״̬��<input type="text" name="gstatus" value="${goods.gstatus}"/><br/>
        <img src="${goods.gimg}"/>
        <br/>
        <input type="submit" value="�ύ"/>
    </form>
</body>
</html>
