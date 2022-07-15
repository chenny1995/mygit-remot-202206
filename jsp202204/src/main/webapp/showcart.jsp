<%@ page language="java"  pageEncoding="GBK" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <table width="600" border="1">
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>价格</td>
            <td>数量</td>
            <td>小计</td>
        </tr>
        <c:forEach items="${cart}" var="obj">
            <tr>
                <td>${obj.value.goods.gid}</td>
                <td>${obj.value.goods.gname}</td>
                <td>${obj.value.goods.gprice}</td>
                <td>${obj.value.quantity}</td>
                <td>${obj.value.goods.gprice * obj.value.quantity}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
