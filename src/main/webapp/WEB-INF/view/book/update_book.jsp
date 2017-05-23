<%--
  Created by IntelliJ IDEA.
  User: Lynn-F_X
  Date: 2017/5/15
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form id="book_edit_form">
  <input type="hidden" id="edit_book_id" value="${book.bookID }">
  书籍名称：<input id="edit_book_name" value="${book.bookName }" class="easyui-textbox" data-options="prompt:'书籍名称'"><br>
  书籍价格：<input id="edit_book_price"  value="${book.bookPrice }" class="easyui-textbox" data-options="prompt:'书籍价格'"><br>
  <div style="text-align:center;padding:5px">
    <a href="javascript:update_submitForm(0)" class="easyui-linkbutton" >Submit</a>
    <a href="javascript:update_clearForm(0)" class="easyui-linkbutton" >Clear</a>
  </div>
</form>
</body>
</html>
