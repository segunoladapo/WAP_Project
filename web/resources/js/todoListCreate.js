$(function () {

        $("#submitbutton").click(
            function (eventData) {
                //alert('ok');
                var title = $("#title").val();
                var expiredDate = $("#expiredDate").val();
                var summary = $("#summary").val();
                var priority = $("#priority").val();
                $.post(
                    "/todoList",
                    {"title":title,"expiredDate":expiredDate,"summary":summary,"priority":priority},
                    function (data) {
                        //alert(result.auth);
                        var result = JSON.parse(data);
                        /*
                        if(result.auth=='YES'){
                            window.location = 'welcome';
                        }
                        else {
                            var err = $("#errorMsg");
                            err.html(result.message);
                            err.css("text-align","center");
                            err.insertBefore("#loginBox",null);
                        }
                        */
                        $("#todoList").text(result.message);
                    });
            }
        );
    }
);