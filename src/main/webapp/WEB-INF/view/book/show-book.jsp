
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

    <!-- 数据表格 -->
    <div id="show_book_table" class="easyui-datagrid"></div>
    <!-- 设置工具条 -->
    <div id = "insert_book_logo"></div>

    <script type="text/javascript">


        $("#show_book_table").datagrid({
            url:"selectBookList.jhtml",
            striped:true,
            ctrlSelect:true,
            pagePosition:"bottom",
            pagination:true,
            pageSize:3,
            pageList:[3,5,8,10],
            columns:[[
                {field:'bookID',title:'id',width:100},
                {field:'bookName',title:'书籍名称',width:100},
                {field:'bookPrice',title:'书籍价格',width:100}
            ]],
            toolbar: [
                {
                    text: '删除',
                    iconCls: 'icon-remove',
                    handler: function(){
                        var checkID = $("#show_book_table").datagrid("getSelected");
                               $.ajax({
                                    url:"<%=request.getContextPath()%>/deleteBook.jhtml?bookID=" + checkID.bookID,
                                    type:"get",
                                    dataType:"json",
                                    success:function(data) {
                                        //重新加载数据表格
                                        $("#show_book_table").datagrid("reload");
                                    }
                                });
                        }
                },
                {
                    text: '编辑',
                    iconCls: 'icon-edit',
                    handler: function(){
                        var selectArr = $("#show_book_table").datagrid("getSelections");
                        if(0 != selectArr && 0 < selectArr.length){
                            if(1 == selectArr.length){
                                $('#insert_book_logo').dialog({
                                    title: '修改用户信息',
                                    modal: true,
                                    width: 400,
                                    height: 200,
                                    closed: false,
                                    cache: false,
                                    href: '<%=request.getContextPath()%>/toUpdatePage.jhtml?bookID='+selectArr[0].bookID
                                });
                            } else {
                                $.messager.alert('警告','不能编辑多条',"warning");
                            }
                        }else{
                            $.messager.alert('警告','请至少选择一条数据',"info");
                        }

                    }
                },
                {
                    text: '导出excel',
                    iconCls: 'icon-print',
                    handler: function(){
                        alert("导出excel");
                        location.href="<%=request.getContextPath()%>/exportBookExcel.jhtml";
                    }
                },
                {
                    text: '导入excel',
                    iconCls: 'icon-save',
                    handler: function(){
                        alert("导入excel");
                        location.href="<%=request.getContextPath()%>/toImportBookExcel.jhtml";
                    }
                }
            ]

        })

    </script>
</body>
</html>
