<%@ page language="java"  pageEncoding="GBK" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
${msg}<br/><a href="t3start.jsp">���</a><br/><a href="showcart.jsp">�鿴���ﳵ</a><br/>
    <table border="1" width="560">
        <tr>
            <td>���</td>
            <td>����</td>
            <td>�۸�</td>
            <td>����</td>
            <td>״̬</td>
            <td>����</td>
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
            <td><a href="PreUpdGoodsServlet?gid=${goods.gid}">�޸�</a>&nbsp;<a href="DelGoodsServlet?gid=${goods.gid}">ɾ��</a>&nbsp;
                <a href="CartServlet?gid=${goods.gid}">���빺�ﳵ</a>
            </td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>