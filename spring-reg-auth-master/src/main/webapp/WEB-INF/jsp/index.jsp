<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Geek Study</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Comic+Neue:wght@300&display=swap" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/main.css">
</head>
<body>

<!-- Header -->
<div class="header">

  <!-- Logo -->
  <div class="logo">
    <img src="../../resources/img/geekstudy_no_back.png" alt="">
  </div>


  <!-- Navigation -->
  <div class="navigation">
    <p>Learn new with us</p>
  </div>


  <!-- Logging -->
  <div class="logging">
    <sec:authorize access="!isAuthenticated()">
      <button><a href="/login">Login</a></button>
      <a href="/registration">Sign up</a>
    </sec:authorize>
  </div>
</div>

<div class="mainInfo">

  <div class="textInfo">
    <p>
      Teach anywhere you like
      Learn on your schedule from any device
    </p>
    <p>
      We believe everyone has the capacity to be creative.
      GeekStudy is a place where people develop their own potential.
    </p>
  </div>

  <div class="imgInfo">
    <img src="${contextPath}/resources/img/banner.png" alt="">
  </div>

</div>


</body>
</html>