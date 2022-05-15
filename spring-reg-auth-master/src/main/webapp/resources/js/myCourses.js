$(document).ready(function(){
    let a = "${contextPath}/resources/img/favicon.png";
    let studentId = document.getElementsByClassName("id");
        $.ajax({
            url: `http://localhost:8082/study-office-api/study/enroll/api/${studentId[0].outerText}`,
            type: 'GET',
            dataType: 'json',
            success: function(res) {
                for (i = 0; i < res.length; i++) {
                    $(".w3-row-padding").append(
                        `<div class="w3-col m4 w3-margin-bottom">
                            <div>
                                <img src="/resources/img/favicon.png" style="width:100%">
                                    <div class="w3-container">
                                        <h3>${res[i].course_name}</h3>
                                        <a href="/coursePage/${res[i].id}" class="w3-opacity">${res[i].id}</a>
                                        <p>${res[i].course_description}</p>
                                    </div>
                            </div>
                        </div>`
                    )
                }
                    
            }
        });

    function w3_open() {
        document.getElementById("mySidebar").style.display = "block";
        document.getElementById("myOverlay").style.display = "block";
    }

    function w3_close() {
        document.getElementById("mySidebar").style.display = "none";
        document.getElementById("myOverlay").style.display = "none";
    }
        
                



  });

