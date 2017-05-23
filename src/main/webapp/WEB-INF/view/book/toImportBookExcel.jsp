<%--
  Created by IntelliJ IDEA.
  User: Lynn-F_X
  Date: 2017/5/17
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- uploadify -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/uploadify/jquery.uploadify.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/uploadify/uploadify.css" />
<html>
<head>
    <title></title>
</head>
<body>
<input type="file" id="uploadify" name="excel"/>
<script type="text/javascript">

  $("#uploadify").uploadify({
    //插件自带  不可忽略的参数flash插件
    'swf': '<%=request.getContextPath()%>/js/uploadify/uploadify.swf',//导入包中的uploadify.swf文件
    //前台请求后台的url 不可忽略的参数
    'uploader': '<%=request.getContextPath()%>/importBookExcel.jhtml',//后台上传的请求
    'queueID': 'fileQueue',//给div的进度条加背景 不可忽略
    //上传文件文件名 跟file标签 name值 保持一致
    'fileObjName' : 'excel',
    //给上传按钮设置文字
    'buttonText': '上传文件',
    //设置文件是否自动上传
    'auto': true,
    //可以同时选择多个文件 默认为true  不可忽略
    'multi': true,
    //上传后队列是否消失
    'removeCompleted': true,
    //队列消失时间
    'removeTimeout' : 1,
    //上传文件的个数，项目中一共可以上传文件的个数
    'uploadLimit':  10,
    'fileTypeExts': '*.*',
    //成功回调函数 file：文件对象。data后台输出数据
    'onUploadSuccess':function(file,data,response){

    }

  });
</script>
</body>
</html>
