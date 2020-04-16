<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<script type="text/javascript">
if('${loginStaff}' ==''){
	location.href="${pageContext.request.contextPath}/login/loginForm.do";
}
</script>

	<div id="all">
		<table>
			<tbody>
				<tr>
					<td colspan="6" class="label">사원정보검색</td>
				</tr>
				<tr>
					<td class="label">직급</td>
					<td class="center">
						<select name="staffRank">
							<option></option>
							<option value="사원">사원</option>
							<option value="대리">대리</option>
							<option value="과장">과장</option>
							<option value="차장">차장</option>
							<option value="부장">부장</option>
						</select>
					</td>
					<td class="label">이름</td>
					<td class="center"><input type="text" id="name" name="staffName"/></td>
					<td class="label">직원번호</td>
					<td class="center"><input type="text" id="staffnumber" name="staffNo" /></td>
				</tr>
				<tr>
					<td class="label">이메일주소</td>
					<td colspan="3"><input type="text" id="staffEmail" name="staffEmail"/></td>
					<td class="label">전화번호</td>
					<td colspan="2"><input type="text" id="staffPh" name="staffPh"/> </td>
				</tr>
				
			</tbody>
		</table>
		<div id="bbt">
			<div>
				<button type="button" id="search">검색</button>
			</div>
			
			<div>
				<button id="allsearch">전부검색</button>
				<button>초기화</button>
				<button id="regist">등록</button>
			</div>

		</div>
		<div id="searchCnt">

			검색건수 ------><a>0건</a>

		</div>
		
			<div id="result"></div>
		
		
		<div id="keyword">
			<form id="searchStaff" method="post">
				<input name="sno" type="hidden" value="${pagination.staffNo}" />
				<input name="srank" type="hidden" value="${pagination.staffRank}" />
				<input name="semail" type="hidden" value="${pagination.staffEmail}" />
				<input name="sname" type="hidden" value="${pagination.staffName}" />
				<input name="sph" type="hidden" value="${pagination.staffPh}" />
			</form>
		</div>
		<!-- 검색결과 저장 -->

		
		
		<!-- 페이징 -->
		<div id="paginationBox"></div>
		



	</div>

	<script src="<c:url value='/resources/js/board.js' />"></script>
	<script type="text/javascript">
	$("#regist").click(() => {
		location.href='${pageContext.request.contextPath}/front/staffregistform.do'
	})
	</script>

</body>
</html>