if(window.home == undefined) window.home = {};
if(window.home.components == undefined) window.home.components = {};
window.home.components.category = (function () {
    var bar_name = "商品分类",
        bar_icon = "fa-align-justify";

    var categorys = {
        id: 1,
        code: "101",
        name: "Clothing",
        icon: "fa-shopping-bag",
        parent_id: 0,
        childs: [{
            id: 2,
            code: "10101",
            name: "a",
            parent_id: 1,
            childs: [
                {
                    id: 3,
                    code: "1010101",
                    name: "b",
                    parent_id: 2,
                    childs: [
                        {
                            id: 4,
                            code: "101010101",
                            name: "c",
                            parent_id: 3,
                            childs: null
                        }
                    ]
                }
            ]
        }]
    };

    var $categorys = $("#categorys");
    var $elements = $categorys.find("nav .nav");

    return {
        /**
         * 获取分类列表
         * @returns {{id: number, code: string, name: string, icon: string, parent_id: number, childs: *[]}}
         */
        getCategorys : function () {
            return categorys;
            $categorys.find(".head").text("<i class=\"icon fa " + bar_icon + " fa-fw\"></i>" + bar_name);
        },
        /**
         * 设置栏目标题
         */
        setColName : function () {
            $categorys.find(".head").html("<i class=\"icon fa " + bar_icon + " fa-fw\"></i>" + bar_name);
        },
        /**
         * 移除所有元素
         */
        removeAllEle: function () {
            $elements.find("li").remove();
        },
        /**
         * 初始化元素列表
         */
        initEleList: function () {
            this.removeAllEle();
            var data = this.getCategorys();
            var html = "<li class=\"dropdown menu-item\" data-id='" + data.id + "'>";
            html += "<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><i class=\"icon fa " + data.icon + "\"></i>" + data.name + "</a>";
            if(data.childs != null && data.childs.length > 0){
                html += "<ul class=\"dropdown-menu mega-menu\">";
                html += "<li class=\"yamm-content\">";
                html += "<div class=\"row\">";
                html += "<div class=\"col-xs-12 col-sm-12 col-lg-4\">";
                html += "<ul>";
                data.childs.forEach(function (value) {
                    html += "<li data-id='" + value.id + "'><a href=\"#\">" + value.name + "</a></li>";
                })
                html += "</ul>";
                html += "</div>";
                html += "</div><!-- /.row -->";
                html += "</li><!-- /.yamm-content -->";
                html += "</ul>";
            }
            html += "</li>";
            $elements.html(html);
        }
    };
})();

