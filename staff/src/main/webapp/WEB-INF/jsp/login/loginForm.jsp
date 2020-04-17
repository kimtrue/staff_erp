<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<form method="post" action="doLogin.do" onsubmit="validate();">
 <div class="cont">
        <div class="demo">
          <div class="login">
            <div class="login__check"></div>
            <div class="login__form">
              <div class="login__row">
                <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
                  <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
                </svg>
                <input type="text" class="login__input name" placeholder="Username" name="staffEmail"/>
              </div>
              <div class="login__row">
                <svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
                  <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
                </svg>
                <input type="password" class="login__input pass" placeholder="Password" name="password"/>
              </div>
              <button class="login__submit">Sign in</button>
              <p class="login__signup">Don't have an account? &nbsp;<a>Sign up</a></p>
            </div>
          </div>
        </div>
      </div>
</form>
<script type="text/javascript">

function validate() {
	
}




</script>      
      
</body>

</html>