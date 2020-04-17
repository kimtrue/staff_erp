<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/login.css">


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style type="text/css">
.errorMsg {
	color: red;
}
</style>
</head>
<body>

		<div class="cont">
			<div class="demo">
				<div class="login">
					<div class="login__check"></div>
					<div class="login__form">
						<div class="login__row">
							<svg class="login__icon name svg-icon" viewBox="0 0 20 20">
                  <path
									d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
                </svg>
							<input type="text" class="login__input name"
								placeholder="Username" name="staffEmail" />
						</div>
						<div class="errorMsg" id="emailCheck"></div>
						<div class="login__row">
							<svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
                  <path
									d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
                </svg>
							<input type="password" class="login__input pass"
								placeholder="Password" name="password" />
						</div>
						<div class="errorMsg" id="check"></div>
						<button type="button" class="login__submit" id="signIn">Sign in</button>
						<p class="login__signup">
							Don't have an account? &nbsp;<a>Sign up</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	<script type="text/javascript">


//정규표현식을 정의합니다.
function email_check( email ) {
    let regex=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    return (email != '' && email != 'undefined' && regex.test(email));
}

//name 속성이 'staffEmail'인 input 이 focus를 잃었을때 처리한다.
$("input[name='staffEmail']").blur(function(){
    let email = $(this).val();
    // 값을 입력안한경우는 아예 체크를 하지 않는다.
    if( email == '' || email == 'undefined') return;

    // 이메일 유효성 검사
    if(! email_check(email) ) {
//         alert('잘못된 형식의 이메일 주소입니다.');
		$("#emailCheck").html('잘못된 형식의 이메일 주소입니다.');
        $(this).focus();
        return false;
    } else {
    	$("#errorMsg").html('');
    }
});

let	staffEmail;
let password;


	

$("#signIn").click(() => {
	staffEmail = $("input[name='staffEmail']").val();
	password = $("input[name='password']").val();
	if(staffEmail == '' || password == ''){
		alert("이메일/비밀번호가 입력되지 않았습니다.");
	} else {
		$.ajax({
			url: "check.do",
			type: "POST",
			data: {
				staffEmail, 
				password
			},
			success: list => doLogin(list)
		});
	}
});


function doLogin(list) {
	console.log(list);
	if(list == ''){
		$("#check").html("이메일/비밀번호를 다시 확인해주세요.")
	} else {
		$.post({
			url: "doLogin.do",
			data: {
				staffEmail, 
				password
			}
			
		})
	}
}





</script>

</body>

</html>