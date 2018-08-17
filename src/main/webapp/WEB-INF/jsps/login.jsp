<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
.container {
	position: relative;
	width: 500px;
	height: auto;
	margin-top: 150px;
	margin-bottom: 150px;
	margin-left: 150px;
	margin-right: 150px;
	padding: 20px;
	border-radius: 5px;
	background-color: #94abd1;
	margin-bottom: 150px;
	margin-left: 150px;
	margin-right: 150px;
}
</style>
</head>
<body>
	<center>
		<div class="container">
			<h3 style="color: red; font-style: normal;">Send Message</h3>
			<font style="color: Green">${Success}</font>
			<form action="log" method="post">
				<table align="center">
					<tr>
						<td>MObile:</td>
						<td><input rows="8" cols="50" name="mobile"
							style="border-radius: 5px;"></input>
					</tr>


					<tr>
						<td>Password :</td>
						<td><input rows="8" cols="50" name="email"
							style="border-radius: 5px;"></input>
					</tr>

					<tr>
						<td style="padding-bottom: 20px; padding-top: 30px;"></td>
						<td><input type="submit" value="login"
							style="border-radius: 5px;" /><a href="regi">Not have an
								Account</a></td>
					</tr>
				</table>
			</form>
		</div>
	</center>
</html>