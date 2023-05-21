<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>类别管理</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script>
        var pageindex=1;
        var pagecount=0;
        $(document).ready(function () {
            $("#btn").click(function () {
                search();
            });
          search();
          //全选按钮绑定点击事件
            $("#ckball").click(function () {
                $("input[name='ckbcustid']").prop("checked",$("#ckball").prop("checked"));
            });
            $("#btnmanydel").click(function () {
                let custids=[];
                let len = $("input[name='ckbcustid']:checked").length;

                if(len>0){
                    $("input[name='ckbcustid']:checked").each(function (i) {
                        custids[i]=$(this).val();
                        console.log(custids[i]);
                    });
                    $.ajax({
                       url:"/jsp/docust",
                       type:"post",
                       data:{
                           op:"manydel",
                            custids:custids
                       },
                       dataType:"json",
                        success:function (jsondata) {
                            if(jsondata.result>0){
                                readdata(1);
                            }else{
                                alert(jsondata.msg);
                            }
                        }
                    });
                }else {
                    alert("至少选择一个客户！");
                }
            });
        });
        function search() {
            $.ajax({
                url:"${pageContext.request.contextPath}/admin/category/search",
                type:"post",
                data:{pageindex:pageindex,name:$("#name").val()},
                dataType:"json",
                success:function (jsonresult) {
                    let data=jsonresult.data;
                    pagecount=data.pages;
                    initData(data);
                    $("input[name='ckbcustid']").click(function () {
                        let len=$("input[name='ckbcustid']").length;
                        let checkedlen=$("input[name='ckbcustid']:checked").length;
                        if(len==checkedlen){
                            $("#ckball").prop("checked",true);
                        }else{
                            $("#ckball").prop("checked",false);
                        }
                    });
                    initPage();
                }
            });
        }
        function initData(data) {
            var datas=data.list;
            $("#categorydatas").html("");
            for(var i=0;i<datas.length;i++){
                var category=datas[i];
                $("#categorydatas").append(`<tr>
                       <td><input name="ckbcustid" type="checkbox" value="\${category.id}"></td>
                     <td>\${category.id}</td>
                     <td>\${category.name}</td>
                     <td>\${category.goodsnum}</td>

                    <td>
                  <a href="${pageContext.request.contextPath}/admin/category/toedit/\${category.id}">修改 | </a>
                    <a  href="javascript:delCategory(\${category.id})">删除</a>
                    </td>
                    </tr>`);
            }
        }
        function initPage() {
            $("#categorypage").html(`
             <tr>
        <td colspan="5">
          \${function () {
                //匿名函数自执行函数
                if(pageindex>1){
                    return  `<a href="javascript:readdata(1)">首页</a>
                <a href="javascript:readdata(\${pageindex-1})">上一页</a>` ;
                }else{
                    return "首页 上一页";
                }
        }()}
            \${function () {
                //匿名函数自执行函数
                if (pageindex < pagecount) {
                    return  `<a href="javascript:readdata(\${pageindex}+1)">下一页</a>
                            <a href = "javascript:readdata(\${pagecount})">末页</a>` ;
                }else {
                    return "下一页 末页";
                }
            }()}
        </td>
    </tr>`);}
        function delCategory(categoryid) {
            if(confirm("是否删除？")){
                $.ajax({
                    url:"${pageContext.request.contextPath}/admin/category/del/"+categoryid,
                    type:"post",
                    dataType:"json",
                    success:function (jsondata) {
                      if(jsondata.statusCode==0){
                          readdata(1);
                      }else{
                          alert(jsondata.msg);
                      }
                    }
                });
            }
        }
       function readdata(pagenum) {
           pageindex=pagenum;
            $("#ckball").prop("checked",false);
           search();
        }
    </script>
</head>
<body>
    关键字<input type="text" id="name" />
    <input type="button"  id="btn" value="搜 索">
<table border="2px">
    <thead>
    <tr>
        <td><input type="checkbox" id="ckball"></td>
        <td>Id</td>
        <td>类别名称</td>
        <td>商品数量</td>
        <td>操作</td>
    </tr>
    </thead>
   <tbody id="categorydatas">

   </tbody>
    <tfoot id="categorypage">

    </tfoot>
</table>
<input type="button" id="btnmanydel" value="批量删除"/>
</body>
</html>