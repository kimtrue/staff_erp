<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateStaff</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
</head>
<body> 
<form name="sjform" id="sjform" method="post" action="staffupdate.do" onsubmit="return infoCheck();">

	<div class="updateStaff">
		<table>
			<tbody>
				<tr>
					<td colspan="6" class="label">사원정보수정</td>
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
					<td><input type="text" name="staffName" value="${staff.staffName}" />
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
				
			</tbody>
		</table>
			<input type="hidden" name="staffEmail"/>
			<input type="hidden" name="staffPh"/>
			<input type="hidden" name="staffNo" value="${staff.staffNo}"/>

	</form>
		<div id="submitt">
			<button id="sbutton">수정</button>
			<button id="cancel" type="button" onclick="location.href='/staff/front/main.do'">취소</button>
		</div>


	</div>

<script src="<c:url value='/resources/js/board.js' />"></script>	
<script type="text/javascript">
//취소버튼

let staffemail = '${staff.staffEmail}'
let email = staffemail.split('@');
let emailF = email[0];
let emailB = email[1];

$("#emailF").val(emailF);
$("#emailB").val(emailB);

let phone = '${staff.staffPh}'
let ph = phone.split('-');
$("#ph1").val(ph[0]);
$("#ph2").val(ph[1]);
$("#ph3").val(ph[2]);

let staffRank = '${staff.staffRank}';
$("select[name='staffRank']").val(staffRank).attr("selected", "selected");




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
	 
	alert("수정완료되었습니다");
}

</script>	
</body>
</html>