<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registStaff</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
</head>
<body> 

	<div class="registStaff">
	<form name="sjform" id="sjform" method="post" action="join.do" onsubmit="return infoCheck();">
		<table>
			<tbody>
				<tr>
					<td colspan="6" class="label">사원등록</td>
				</tr>
				<tr>
					<td class="label">직급</td>
					<td>
						<select name="staffRank">
							<option value="사원">사원</option>
							<option value="대리">대리</option>
							<option value="과장">과장</option>
							<option value="차장">차장</option>
							<option value="부장">부장</option>
						</select>
					</td>
				</tr>
				<tr>	
					<td class="label">이름</td>
					<td><input type="text" name="staffName" />
					</td>
				</tr>
				<tr>
					<td class="label">이메일주소</td>
					<td>
					<input type="text" id="emailF">@<input type="text" id="emailB">
					</td>
					
				</tr>
				<tr>
					<td class="label">전화번호</td>
					<td>
					<input type="text" numberOnly id="ph1">-<input type="text" numberOnly id="ph2">-<input type="text" numberOnly id="ph3">
					</td>
					
				</tr>
				<tr>
					<td class="label">비밀번호 입력</td>
					<td>
					<input type="password"  name="password">
					</td>
					
				</tr>
				
			</tbody>
		</table>
			<input type="hidden" name="staffEmail"/>
			<input type="hidden" name="staffPh"/>

		<div id="submitt">
			<button id="sbutton">등록</button>
			<button type="button" id="cancel" onclick="location.href='/truestaff/front/main.do'">취소</button>
		</div>
	</form>


	</div>

<script src="<c:url value='/resources/js/board.js' />"></script>	
<script type="text/javascript">
$("input:text[numberOnly]").on("keyup", function() {
    $(this).val($(this).val().replace(/[^0-9]/g,""));
});


function infoCheck(){
	if($('input[name="staffName"]').val() == "") {
		alert("이름을 입력해주세요")
		return false;
	}
	if($("#emailF").val() == "" || $("#emailB").val() == ""){
		alert("이메일을 정확히 입력해주세요");
		return false;
	} else {
		let staffEmail = $("#emailF").val()+'@'+$("#emailB").val();
		$('input[name="staffEmail"]').val(staffEmail);
	}
	if($("#ph1").val() == "" || $("#ph2").val() == "" || $("#ph3").val() == "" ){
		alert("번호를 정확히 입력해주세요");
		return false;
	} else {
		let staffPh = $("#ph1").val()+'-'+$("#ph2").val()+'-'+$("#ph3").val();
		$('input[name="staffPh"]').val(staffPh); 
	}
	 
	alert("등록완료되었습니다");
}

</script>	
</body>
</html>