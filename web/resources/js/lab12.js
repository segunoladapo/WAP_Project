$(function () {

    $("#btnSubmit").click(
        function (eventData) {
            //alert('ok');
            /*var uName = $("#userName").val();
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
                });*/
            $("#frmLogin").submit();


        } );

    $("#btnSignUp").click(
        function (eventData) {
            eventData.preventDefault();
            window.location = '/registration.jsp';
        } );

    var uName = getCookie("uName");
    var pwd = getCookie("pwd");

    if(uName !="" && pwd != ""){
        $("#userName").val(uName);
        $("#passWord").val(pwd);
        $("#keepLogged").attr("checked",true);

    }




    }
);

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}