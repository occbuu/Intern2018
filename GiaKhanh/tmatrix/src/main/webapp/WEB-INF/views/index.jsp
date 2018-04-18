<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<title>Spring Boot</title>
</head>
<body>
  <h1>Spring Boot - MVC web application example</h1>
  <hr>

  <div class="form">
    <form action="hello" method="post" onsubmit="return validate()">
      <table>
        <tr>
          <td>Enter m</td>
          <td><input id="m" name="m"></td>
        </tr>
         <tr>
          <td>Enter n</td>
          <td><input id="n" name="n"></td>
        </tr>
        <tr>
          <td>Enter saved path (default: E:\\matrix.txt)</td>
          <td><input id="path" name="path"></td>
        </tr>
        <tr>
          <td>Enter shown path (default: E:\\matrix.txt)</td>
          <td><input id="path_2" name="path_2"></td>
        </tr>
      </table>
      <input type="submit" value="Submit">
    </form>
  </div>

</body>
</html>