$(document).ready(function(){
    let a = "${contextPath}/resources/img/favicon.png";
    let Courseid = parseInt(document.URL.substring(33));
    let studentId = document.getElementsByClassName("id")[0].outerText;
    console.log(Courseid);

    $.ajax({
        url: `http://localhost:8082/lecture-core-api/lecture/${Courseid}`,
        type: 'GET',
        dataType: 'json',
        success: function(res) {
            for (i = 0; i < res.length; i++) {
                $("#lecture").append(
                    `
                        <hr style="width:50px;border:5px solid orange" class="w3-round">
                        <p>${res[i].lecture_message}</p>
                        `
                )
            }

        }
    });


    $.ajax({
        url: `http://localhost:8082/lecture-core-api/attach/all/${Courseid}`,
        type: 'GET',
        dataType: 'json',
        success: function(res) {
            console.log(res);
            for (i = 0; i < res.length; i++) {
                $("#lecture").append(
                    `
                        <hr style="width:50px;border:5px solid orange" class="w3-round">
                        <a style="color:blue" href="http://localhost:8082/lecture-core-api/attach/download/${res[i].id}">${res[i].fileName}</a>
                        `
                )
            }

        }
    });

    let ee = document.getElementById("Desc");

    $.ajax({
        url: `http://localhost:8082/courses-core-api/course/${Courseid}`,
        type: 'GET',
        dataType: 'json',
        success: function(res) {
            console.log(res)
                $("#Desc").append(
                    `
                            <div class="w3-container">
                                    <h3>${res.course_name}</h3>
                                    <p>${res.course_description}</p>
                            </div>
                    `
                )

        }
    });

    $(function() {
        var INDEX = 0;
        $("#chat-submit").click(function(e) {
            e.preventDefault();
            var msg = $("#chat-input").val();
            if(msg.trim() == ''){
                return false;
            }
            $.ajax({
                url: `http://localhost:8093/11321?courseID=${Courseid}`,
                type: 'GET',
                dataType: 'json',
                success: function(res) {
                    console.log(res);
                    for (i = 0; i < res.length; i++) {
                        if(res[i].senderID != studentId){
                            generate_message(res[i].message, 'user');
                        }
                        else{
                            generate_message(res[i].message, 'self');
                        }
                    }

                }
            });
            generate_message(msg, 'self');

        })

        function generate_message(msg, type) {
            INDEX++;
            var str="";
            str += "<div id='cm-msg-"+INDEX+"' class=\"chat-msg "+type+"\">";
            str += "          <span class=\"msg-avatar\">";
            str += "          <\/span>";
            str += "          <div class=\"cm-msg-text\">";
            str += msg;
            str += "          <\/div>";
            str += "        <\/div>";
            $(".chat-logs").append(str);
            $("#cm-msg-"+INDEX).hide().fadeIn(300);
            if(type == 'self'){
                $("#chat-input").val('');
            }
            $(".chat-logs").stop().animate({ scrollTop: $(".chat-logs")[0].scrollHeight}, 1000);
        }

        function generate_button_message(msg, buttons){
            INDEX++;
            var btn_obj = buttons.map(function(button) {
                return  "              <li class=\"button\"><a href=\"javascript:;\" class=\"btn btn-primary chat-btn\" chat-value=\""+button.value+"\">"+button.name+"<\/a><\/li>";
            }).join('');
            var str="";
            str += "<div id='cm-msg-"+INDEX+"' class=\"chat-msg user\">";
            str += "          <span class=\"msg-avatar\">";
            str += "          <\/span>";
            str += "          <div class=\"cm-msg-text\">";
            str += msg;
            str += "          <\/div>";
            str += "          <div class=\"cm-msg-button\">";
            str += "            <ul>";
            str += btn_obj;
            str += "            <\/ul>";
            str += "          <\/div>";
            str += "        <\/div>";
            $(".chat-logs").append(str);
            $("#cm-msg-"+INDEX).hide().fadeIn(300);
            $(".chat-logs").stop().animate({ scrollTop: $(".chat-logs")[0].scrollHeight}, 1000);
            $("#chat-input").attr("disabled", true);
        }

        $(document).delegate(".chat-btn", "click", function() {
            var value = $(this).attr("chat-value");
            var name = $(this).html();
            $("#chat-input").attr("disabled", false);
            generate_message(name, 'self');
        })

        $("#chat-circle").click(function() {
            $("#chat-circle").toggle('scale');
            $(".chat-box").toggle('scale');
        })

        $(".chat-box-toggle").click(function() {
            $("#chat-circle").toggle('scale');
            $(".chat-box").toggle('scale');
        })

    })




});
