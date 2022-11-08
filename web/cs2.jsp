
<%@ page import="Service.Cs1" %><%--
  Created by IntelliJ IDEA.
  User: hbl
  Date: 2022/9/25
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<script>


    let  a=10,b=10;
    let k=400,k1=400;
    function print(a1) {  //执行定时函数


<%--        <%--%>
<%--        ModuleService moduleService=new ModuleService();--%>
<%--        System.out.println(moduleService.abc());--%>
<%--        %>--%>

        var a4=<%=Cs1.abc1()%>   //传输值
        function print4() {
            document.getElementById("demo").innerHTML="pr1:"+a4;
        }


        setTimeout(print4, k); //设置程序400毫秒后执行
        setTimeout(print, k); //设置程序400毫秒后执行


    }



    function print1() {  //执行定时函数

        function print5() {
            document.getElementById("demo1").innerHTML="pr2:"+b;
            b++;
        }

        setTimeout(print5, k1); //设置程序400毫秒后执行
        setTimeout(print1, k1); //设置程序400毫秒后执行

    }
</script>
<body>

<p id="demo">222</p>
<p id="demo1">222</p>
<div>
    <p th:text="${session.abc}">222</p>
    <button  onclick="print()">按钮1</button>
    <button  onclick="print1()">按钮2</button>
</div>




</body>
</html>
