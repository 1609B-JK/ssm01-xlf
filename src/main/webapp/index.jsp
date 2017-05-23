<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/insertBook.jhtml" method="post">
        书籍名称:<input name="bookName" class="easyui-textbox" data-options="prompt:'请输入书籍名称',iconCls:'icon-man'">
        书籍价格:<input name="bookPrice" class="easyui-textbox" data-options="prompt:'请输入书籍价格'">
        <input type="submit" value = "提交内容">
    </form>
</body>
</html>
