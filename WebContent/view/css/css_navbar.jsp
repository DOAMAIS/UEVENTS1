<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
/* required for navbar-fixed-top */
body { 
    padding-top: 30px;
    padding-bottom: 40px; /*for navbar-fixed-bottom*/
    overflow: hidden
}

/* Correct left margin */
.navbar-header{ 
    padding-left: 5px;
}

.navbar .navbar-toggle {
	position: relative;
	z-index: 2;
    	min-height: 34px;
	padding: 9px 5px;
	border-color:transparent
}

.navbar .navbar-toggle:hover,
.navbar .navbar-toggle:focus,
.navbar .navbar-toggle:not(.collapsed) {
	background-color: transparent;
	border-color: transparent
}

.top-bar,
.bottom-bar {
	-webkit-transition: all .2s ease-in-out;
	-moz-transition: all .2s ease-in-out;
	-o-transition: all .2s ease-in-out;
	transition: all .2s ease-in-out
}

.navbar .navbar-toggle:not(.collapsed) .top-bar {
	position: absolute;
	top: 46%;
	-webkit-transform: rotate(45deg);
	-moz-transform: rotate(45deg);
	-o-transform: rotate(45deg);
	transform: rotate(45deg)
}

.navbar .navbar-toggle:not(.collapsed) .middle-bar {
	background-color: transparent
}

.navbar .navbar-toggle:not(.collapsed) .bottom-bar {
	position: absolute;
	bottom: 46%;
	-webkit-transform: rotate(-45deg);
	-moz-transform: rotate(-45deg);
	-o-transform: rotate(-45deg);
	transform: rotate(-45deg)
}
.navbar {
	background-color: #5cb85c;

}
ul.nav.navbar-nav.navbar-right{
	color: #f9f9f9;
}
</style>
</head>
<body>
</body>
</html>