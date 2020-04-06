<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/summernote/summernote-lite.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mailform</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="<c:url value='/resources/js/summernote/summernote-lite.js' />"></script>
<script src="<c:url value='/resources/js/summernote/lang/summernote-ko-KR.js' />"></script>
	
</head>
</head>
<body> 
			<h2>메일 폼</h2>
	<div id="all">
		<form name="sendmail" method="post" action="sendmail.do" onsubmit="return infoCheck();">
		<table>
		 <tr> 
		 	<td>받는 사람</td>
		 	<td><input type="text" /></td>
		 </tr>
		 <tr> 
		 	<td>제목</td>
		 	<td><input type="text" /></td>
		 </tr>
		 <tr> 
		 	<td>파일 첨부</td>
		 	<td><button type="file" />pc</button> </td>
		 </tr>
		 <tr>	
			 <td colspan="2">
			 	<textarea id="summernote" name="editordata"></textarea>
			 </td>
		 </tr>

		 	
			
		</table>

		</form>
		<div id="submitt">
			<button id="sbutton">보내기</button>
			<button type="button" id="cancel" onclick="location.href='/kr.co.staff/front/main.do'">취소</button>
		</div>


	</div>

<script src="<c:url value='/resources/js/board.js' />"></script>	
<script type="text/javascript">
$(document).ready(function() {  
    $('#summernote').summernote({
      height: 400,
      minHeight: null,
      maxHeight: null,
      focus: true,
      callbacks: {
        onImageUpload: function(files, editor, welEditable) {
          for (var i = files.length - 1; i >= 0; i--) {
            sendFile(files[i], this);
          }
        }
      }
    });  

  });




function sendFile(file, el) {
	  var contextPath = "${pageContext.request.contextPath}";
    var form_data = new FormData();
    form_data.append('file', file);
    $.ajax({
      data: form_data,
      type: "POST",
      url: 'imagesave.do',
      cache: false,
      contentType: false,
      enctype: 'multipart/form-data',
      processData: false,
      success: function(url) {
      	alert(url);	 
      	$(el).summernote('editor.insertImage', url);
      }
    });
  }
</script>

</body>
</html>