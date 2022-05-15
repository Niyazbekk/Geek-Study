$(document).ready(function() {
    let a = "${contextPath}/resources/img/favicon.png";
    let studentId = document.getElementsByClassName("id")[0].outerText;
    console.log(studentId)
    $.ajax({
        url: `http://localhost:8082/courses-core-api/course/api/${studentId}`,
        type: 'GET',
        dataType: 'json',
        success: function (res) {
            for (i = 0; i < res.length; i++) {
                $(".w3-row-padding").append(
                    `<div class="w3-col m4 w3-margin-bottom">
                            <div>
                                <img src="/resources/img/favicon.png" style="width:100%">
                                    <div class="w3-container">
                                        <h3>${res[i].course_name}</h3>
                                        <a href="/TeacherCoursePage/${res[i].id}" class="w3-opacity">${res[i].id}</a>
                                        <p>${res[i].course_description}</p>
                                    </div>
                            </div>
                        </div>`
                )
            }

        }
    });

});