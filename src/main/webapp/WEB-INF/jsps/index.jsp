<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sms Login</title>
<style type="text/css">
.container {
	position: relative;
	width: 500px;
	height: auto;
	margin-top:150px;
	margin-bottom:150px;
	margin-left:150px;
	margin-right:150px;
	padding: 20px;
	border-radius: 5px;
	background-color: #94abd1;
}
</style>
</head>
<body>
<center>
	<div class="container">
		<h3 style="color: red ; font-style: normal;"> Send Message</h3>
		<font style="color: Green">${Status},${error}</font>
		<form action="send" method="post">
			<table align="center">
				<tr>
					<td style="padding-bottom: 20px; padding-top: 10px;">To:</td>
					<td><input type="text" style="border-radius: 5px; height: 20px;"
						name="mobile" placeholder="Mobile" /></td>
				</tr>

				<tr>
					<td>Message:</td>
					<td><textarea rows="8" cols="50" name="message" placeholder="Text Message"
							style="border-radius: 5px;"></textarea>
				</tr>

				<tr>
					<td style="padding-bottom: 20px; padding-top: 30px;"></td>
					<td><input type="submit" value="Send"
						style="border-radius: 5px;"></td>
				</tr>
			</table>
		</form>
	</div>
</center>

</body>
		<H2>gROUP</H2>
	<div class="container">
		<h3 style="color: red ; font-style: normal;"> Send Message</h3>
		<font style="color: Green">${Status},${error}</font>
		<form action="sendGroup" method="post">
			<table align="center">
				<tr>
					<td style="padding-bottom: 20px; padding-top: 10px;">To:</td>
					<td><input type="text" style="border-radius: 5px; height: 20px;"
						name="mobile" placeholder="Mobile" /></td>
				</tr>

				<tr>
					<td>Message:</td>
					<td><textarea rows="8" cols="50" name="message" placeholder="Text Message"
							style="border-radius: 5px;"></textarea>
				</tr>

				<tr>
					<td style="padding-bottom: 20px; padding-top: 30px;"></td>
					<td><input type="submit" value="Send"
						style="border-radius: 5px;"></td>
				</tr>
			</table>
		</form>
	</div>

</html>