<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="email" method="post" align="center">
<h1>Send email without attachment</h1>
      <b>Enter Email</b>
			<input type="text" placeholder="Email..."
					name="email" required><br>
					<b>Enter Subject</b>
			<input type="text" placeholder="Subject..."
					name="subject" required><br>
					<b>Enter body</b>
			<input type="text" placeholder="Body..."
					name="body" required><br>
					<button onclick="myFunction()" type="submit" class="button">Submit</button>
</form>
<form action="email1" method="post" enctype="multipart/form-data" align="center">
<h1>Send email with attachment</h1>
      <b>Enter Email</b>
			<input type="text" placeholder="Email..."
					name="email" required><br>
					<b>Enter Subject</b>
			<input type="text" placeholder="Subject..."
					name="subject" required><br>
					<b>Enter body</b>
			<input type="text" placeholder="Body..."
					name="body" required><br>
					<b>Attachment</b>
			<input type="file" 
				  id="img" name="img" accept="*" ><br>
					<button onclick="myFunction()" type="submit" class="button">Submit</button>
</form>
</body>
</html>
		