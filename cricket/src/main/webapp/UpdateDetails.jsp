<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
    <form method="post" action="Updatedetails">
        <h1>Update Player Details</h1>

        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        <br>

        <label for="password">Password:</label>
        <input type="text" id="password" name="password" required><br><br>
        <br>

        <label for="playername">Update playername:</label>
        <input type="text" id="playername" name="playername" required><br><br>
        <br>

        <label for="playernumber">Update playernumber:</label>
        <input type="number" id="playernumber" name="playername" required><br><br>
        <br>
        
        <label for="playertype">Update playertype:</label>
        <input type="text" id="playertype" name="playertype" required><br><br>
		<br>
        <input type="submit" name="submit" value="Update This Record">
    </form>
</center>
</body>
</html>