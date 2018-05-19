$(function(){
    $("#submitbtn").click(validate);


});
function validate(){
    if($("#passWord").val() !== $("#repassWord").val()){
        $("#errormessage").text("Password mismatch");
        return false;
    }
}