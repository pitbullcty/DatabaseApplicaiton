<%@ page import="bean.Info" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/11/9
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="team_info" class="java.util.ArrayList" scope="session"></jsp:useBean>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%if (team_info == null || team_info.isEmpty()) { %>
对不起没有结果,请单击<a href="index.html">返回</a>
<%} else { %>
<p></p>
<table style="align:center; border:1px">
    <caption>Title</caption>
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>生日</td>
        <td>爱好</td>
    </tr>
        <%
           for(int i=0;i<team_info.size();i++){
              Info temp = (Info)team_info.get(i);
        %>
    <tr>
        <td><%=temp.getNum()%>
        </td>
        <td><%=temp.getName()%>
        </td>
        <td><%= temp.getBirthday() %>
        </td>
        <td><%= temp.getHobby() %>
        </td>
        <%}%>
    </tr>
        <%}%>

</body>
</html>
