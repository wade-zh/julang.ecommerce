$(function () {
    $("#v-submit").click(function () {
        $.post(gateway.user + "users/login", {
            uname: $("#uname").val(),
            pwd: $("#pwd").val()
        }, function (data) {
            if(!standardMeg.isSuccess(data)){
                jlpop.error("登录失败");
                return;
            }
            location.href = gateway.product;
        })
    })
})