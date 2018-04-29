/***
 * 注册
 * @author HongWei
 * @dependency jQuery
 */
$(function () {
    $("#v-submit").click(function () {
        var uname = $("#username").val(),
            pwd = $("#password").val(),
            email = $("#email").val();
        if(uname != null && pwd != null && email !=null){
            $.post(gateway.user + "users/signup", {
                uname: uname,
                pwd: pwd,
                email: email
            }, function (data) {
                if(!standardMeg.isSuccess(data)){
                    jlpop.error(data.message);
                    return;
                }
                location.href = "/";
            });

        }
    })
})
