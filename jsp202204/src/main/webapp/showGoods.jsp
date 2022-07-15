<%@ page language="java"  pageEncoding="GBK" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
${msg}<br/><a href="t3start.jsp">添加</a><br/><a href="showcart.jsp">查看购物车</a><br/>
    <table border="1" width="560">
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>价格</td>
            <td>日期</td>
            <td>状态</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list}" var="goods" varStatus="idx">
            <c:if test="${idx.index mod 2 eq 0}">
                <tr bgcolor="#00ffff">
            </c:if>
            <c:if test="${idx.index mod 2 eq 1}">
                <tr bgcolor="yellow">
            </c:if>
                <td>${goods.gid}</td>
                <td>${goods.gname}</td>
                <td>${goods.gprice}</td>
                <td>${goods.gdate}</td>
            <td>${goods.gstatus}</td>
            <td><a href="PreUpdGoodsServlet?gid=${goods.gid}">修改</a>&nbsp;<a href="DelGoodsServlet?gid=${goods.gid}">删除</a>&nbsp;
                <a href="CartServlet?gid=${goods.gid}">放入购物车</a>
            </td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>