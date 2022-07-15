<%@ page language="java"  pageEncoding="GBK"%>
<html>
<body>
    <form method="post" action="ThirdServlet">
        用户名：<input type="text" name="uname"/><br/>
        密码：<input type="password" name="upass"/><br/>
        爱好：<input type="checkbox" name="like" value="eat"/>吃
        <input type="checkbox" name="like" value="sleep"/>睡
        <input type="checkbox" name="like" value="play"/>玩
        <br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
