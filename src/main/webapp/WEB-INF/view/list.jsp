<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/resource/bootstrap-4.3.1/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1/jquery.js" ></script>
<script type="text/javascript" src="/resource/bootstrap-4.3.1/css/bootstrap.css"></script>
<script type="text/javascript" src="/resource/bootstrap-4.3.1/js/bootstrap.js"></script>
<script type="text/javascript" src="/resource/js/jqueryvalidate/jquery.validate.js"></script>
<script type="text/javascript" src="/resource/js/jqueryvalidate/localization/messages_zh.js"></script>
</head>
<body>
        <table class="table">
        	<thead>
        		<tr>
        			<td>id</td>
        			<td>姓名</td>
        			<td>性别</td>
        			<td>所属省</td>
        			<td>所属市</td>
        			<td>所属县</td>
        			<td>年龄</td>
        			<td>入学日期</td>
        			<td>爱好</td>
        			<td>身高</td>
        			<td>体重</td>
        			<td>身份证编号</td>
        			<td>课程</td>
        			<td>操作</td>
        		</tr>
        	</thead>
        	<tbody>
        	<c:forEach items="${pageinfostudent.list}" var="student">
        	<tr>
        	<td>${student.id}</td>
        	<td>${student.name}</td>
        	<td>${student.gender==1?'男':女 }</td>
        	<td>${student.provinces.name }</td>
        	<td>${student.city.name }</td>
        	<td>${student.county.name }</td>
        	<td>${student.birth }</td>
        	<td>${student.date }</td>
        	<td>${student.hobby }</td>
        	<td>${student.height}cm</td>
        	<td>${student.weight}kg</td>
        	<td>${student.idNumber}</td>
        	<td>
        	<c:forEach items="${student.courses}" var="co" >
        	${co.name}&nbsp;
        	 
        	</c:forEach>
        	</td>
        	<td>
        		<input type="button" onclick="toupdate(${student.id})" value="修改" >
        	</td>
        	</tr>
        	
        	</c:forEach>
        	</tbody>
        	<tfoot>
        	<tr>
        		<th colspan="13">
        		<button onclick="add()">新增</button>
        		<center>
        		<button class="button center">上一页</button>
        		<button class="button center">下一页</button>
        		</center>
        		</th>
        	</tr>
        	</tfoot>
        </table>
</body>

<script type="text/javascript">
	function add(){
		location='toadd';
	}
	function toupdate(id){
		location="toupdate?id="+id;
	}
</script>
</html>