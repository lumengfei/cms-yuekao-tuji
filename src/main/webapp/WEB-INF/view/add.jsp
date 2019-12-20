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
<script type="text/javascript" src="/resource/bootstrap-4.3.1/js/bootstrap.js"></script>
<script type="text/javascript" src="/resource/js/jqueryvalidate/jquery.validate.js"></script>
<script type="text/javascript" src="/resource/js/jqueryvalidate/localization/messages_zh.js"></script>
<script type="text/javascript" src="/resource/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
<script type="text/javascript">
	function provinceschange(id){
		
		
		$.post("getcity",{id:id},function(arr){
			//alert(JSON.stringify(arr))
			$(".city").empty();
			$(".county").empty();
			//$(".city").append("<option value=''>"+请选择+"</option>")
			for ( var i in arr) {
				$(".city").append("<option value='"+arr[i].id+"'>"+arr[i].name+"</option>")
			}
		},"json")
	}
	function citychange(id){
		$.post("getcity",{id:id},function(arr){
			//alert(JSON.stringify(arr))
			//$(".city").empty();
			$(".county").empty();
			//$(".county").append("<option value=''>"+请选择+"</option>")
			for ( var i in arr) {
				$(".county").append("<option value='"+arr[i].id+"'>"+arr[i].name+"</option>")
			}
		},"json")
	}
</script>
	<form:form action="add" method="post" modelAttribute="student">
        <table class="table">
        	<tr>
        		<th>姓名</th>
        		<th><form:input path="name"/><form:errors path="name"></form:errors> </th>
        	</tr>
        	<tr>
        		<th>姓别</th>
        		<th><form:radiobutton path="gender" value="0" label="女"/>
        			<form:radiobutton path="gender" value="1" label="男"/>
        		<form:errors path="gender"></form:errors>  </th>
        	</tr>
        	 <tr>
        		<th>所属省</th>
        		<th>
        		 <form:select path="provinces.id"  onchange="provinceschange($(this).val())">
        			<c:forEach items="${provinces}" var="p">
        			<option value="${p.id}">${p.name}</option>
        			</c:forEach>
        			</form:select> 
        		 <form:errors path="provinces"></form:errors>
        		  </th> 
        	</tr>  
        	<tr>
        		<th>所属市</th>
        		<th><form:select path="city.id" class="city" onchange="citychange($(this).val())">
        			
        			</form:select>
        			<form:errors path="name"></form:errors>  </th>
        	</tr>
        	<tr>
        		<th>所属县</th>
        		<th><form:select path="county.id" class="county">
        			
        			</form:select>
        			<form:errors path="name"></form:errors>  </th>
        	</tr>
        	<tr>
        		<th>出生年份</th>
        		<th><form:input onclick="WdatePicker()" path="birth"/><form:errors path="birth"></form:errors>  </th>
        	</tr>
        	<%-- <tr>
        		<th>入学日期</th>
        		<th><form:date path="date"/><form:errors path="name"></form:errors>  </th>
        	</tr> --%>
        	<tr>
        		<th>爱好</th>
        		<th><form:input path="hobby"/><form:errors path="hobby"></form:errors>  </th>
        	</tr>
        	<tr>
        		<th>身高</th>
        		<th><form:input path="height"/><form:errors path="height"></form:errors>  </th>
        	</tr>
        	<tr>
        		<th>体重</th>
        		<th><form:input path="weight"/><form:errors path="weight"></form:errors>  </th>
        	</tr>
        	<tr>
        		<th>身份证号</th>
        		<th><form:input path="idNumber"/><form:errors path="idNumber"></form:errors>  </th>
        	</tr>
        	 <tr>
        		<th>课程</th>
        		<th>
        		<c:forEach items="${courses}" var="co">
        		<input type="checkbox" name="cid" value="${co.id}">${co.name}&emsp;
        		<%-- <form:checkbox path="cid" value="${co.id}" label="${co.name}"/> --%>
        		</c:forEach>
        		<form:errors path="courses"></form:errors>  </th>
        	</tr> 
        	<tfoot>
        		<tr>
        			<th colspan="100"><center><button>提交</button></center></th>
        		</tr>
        	</tfoot>
        </table>
        </form:form>
</body>
</html>