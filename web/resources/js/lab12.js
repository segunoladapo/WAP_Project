$(function () {

    $("#btnSubmit").click(
        function (eventData) {
            //alert('ok');
            var uName = $("#userName").val();
            var pwd = $("#passWord").val();
            var keep = $("#keepLogged").val();
            $.post(
                "login",
                {"userName":uName,"passWord":pwd,"keepLogged":keep},
                function (data) {
                    //alert(result.auth);
                    var result = JSON.parse(data);
                    if(result.auth=='YES'){
                        window.location = 'welcome';
                    }
                    else {
                        var err = $("#errorMsg");
                        err.html(result.message);
                        // err.css("text-align","center");
                        err.css({
                            "text-align": "center",
                            "color": "red"
                        });
                        err.insertBefore("#loginBox",null);
                    }
                });
        }
    );
    }
);