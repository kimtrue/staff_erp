<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<style>
  .errorMsg { 
  font-size:12px;
  color: red; 
  }
</style>

<body>
    <!-- commandName 는 폼에 적용할 모델의 이름을 정의한다.    -->
    <form:form modelAttribute="staff" action="check.do" method="POST">
        <table border="1">
            <tr>
                <td>name</td>
                <!-- path 는 따로 지정하지 않았다면 <input>태그의 id, name에 할당된다. 
                      이때 path명은 모델의 변수명과 동일해야된다!!@@ -->
                <td>얌마</td>
                <!-- errors는 위의 input의 바인딩 에러메시지를 출력하기위해 사용한다. 
                     path에 지정한 이름과 일치하는 곳에 에러메시지 출력.-->
                <td>얌마ㄴㄴㄴㄴㄴㄴ</td>
            </tr>
            <tr>
                <td>email</td>
                <td><form:input path="staffEmail" /></td>
                <td><form:errors path="staffEmail" id="staffEmail" cssClass="errorMsg"></form:errors></td>
            </tr>
            <tr>
            <td colspan="3" align="center"> <input type="submit" value="check">
            </tr>
        </table>
    </form:form>
 
</body>


      
</body>

</html>