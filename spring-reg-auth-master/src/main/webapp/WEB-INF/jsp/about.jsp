<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>About us</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
    <style>
        body,h1,h2,h3,h4,h5 {font-family: "Comic Sans MS", "Comic Sans"}
        body {font-size:16px;}
        .w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
        .w3-half img:hover{opacity:1}
    </style>

    <!-- scripts -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-orange w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
    <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px">Close Menu</a>
    <div class="w3-container">
        <sec:authentication var="principal" property="principal" />
        <h3 class="w3-padding-64"><b>${pageContext.request.userPrincipal.name}<br><p class="id">${principal.id}</p></b></h3>
    </div>
    <div class="w3-bar-block">
        <a href="/myAccount" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">My account</a>
        <a href="/studentPage" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Explore Courses</a>
        <a href="/myCourses" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">My Courses</a>
        <a href="/about" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">About us</a>
        <sec:authorize access="isAuthenticated()">
            <a href="/logout" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Log out</a>
        </sec:authorize>
    </div>
</nav>

<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-orange w3-xlarge w3-padding">
    <a href="javascript:void(0)" class="w3-button w3-orange w3-margin-right" onclick="w3_open()">☰</a>
    <span>Geek Study</span>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:340px;margin-right:40px">

    <!-- Header -->
    <div class="w3-container" id="aboutUs" style="margin-top:75px">
        <h1 class="w3-xxxlarge w3-text-orange"><b>About us</b></h1>
        <hr style="width:50px;border:5px solid orange" class="w3-round">
        <p>Geek Study - the best place to study</p>
    </div>

    <!-- About -->
    <div class="w3-container" id="about" style="margin-top:15px">
        <p>Our project is an educational platform that will help students and
            teachers to facilitate the learning process. After studying alternative platforms, our team came to the conclusion
            that all online platforms are traditionally used in the educational field, although they are rather inconvenient.
            For example, Google Classroom is used in educational organizations, there are all the traditional features
            (publishing lecture material, homework, comments), but many users complain about inconvenient class link, users also
            need to have a Google account. Moodle also has all the traditional features, but the best visual tracking of the
            progress of the learning material. But it also has many disadvantages, the platform is difficult to learn and not
            intuitive, difficult to develop and change. There is also a platform in which the author of the material can put a
            price. For example, Udemy, in which there are all the functions as in the platforms presented earlier. The biggest
            plus is that 90% of the material is video. The project will take the best of the alternatives, such as design,
            homework uploads and lectures and video tutorials.!</p>
    </div>

    <!-- Contact -->
    <div class="w3-container" id="contact" style="margin-top:75px">
        <h1 class="w3-xxxlarge w3-text-orange"><b>Contact</b></h1>
        <hr style="width:50px;border:5px solid orange" class="w3-round">
        <form action="#" target="_blank">
            <div class="w3-section">
                <label>Name</label>
                <input class="w3-input w3-border" type="text" name="Name" required>
            </div>
            <div class="w3-section">
                <label>Message</label>
                <input class="w3-input w3-border" type="text" name="Message" required>
            </div>
            <button type="submit" class="w3-button w3-block w3-padding-large w3-orange w3-margin-bottom">Send Message</button>
        </form>
    </div>

    <!-- End page content -->
</div>

<!-- W3.CSS Container -->
<div class="w3-light-grey w3-container w3-padding-32" style="margin-top:75px;padding-right:35%"><p class="w3-right">Geek Study</p></div>

<script>
    function w3_open() {
        document.getElementById("mySidebar").style.display = "block";
        document.getElementById("myOverlay").style.display = "block";
    }

    function w3_close() {
        document.getElementById("mySidebar").style.display = "none";
        document.getElementById("myOverlay").style.display = "none";
    }
</script>

</body>
</html>
