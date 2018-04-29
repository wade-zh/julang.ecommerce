/***
 * ajax异常处理器
 * @author HongWei
 * @dependentys jQuery、layer
 */
$(function(){
    $.ajaxSetup({
        type: "POST",
        success: function(data){
            alert("操作成功");
        },
        error: function(jqXHR, textStatus, errorThrown){
            switch (jqXHR.status){
                case(500):
                    alert("服务器系统内部错误");
                    break;
                case(401):
                    alert("未登录");
                    break;
                case(403):
                    alert("无权限执行此操作");
                    break;
                case(408):
                    alert("请求超时");
                    break;
            }
        }
    });
});