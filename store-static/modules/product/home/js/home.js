/*! 首页处理器模块 wade 2018年5月2日18:14:08*/
(function () {
    var scope = window.home;
    var modules = scope.components;

    // 加载category模块并初始化 begin
    var category = {
        initCategoryColumn : function () {
            modules.category.setColName();
            modules.category.initEleList();
            var categoryList = modules.category.getCategorys();
        }
    }
    category.initCategoryColumn();
    // 加载category模块并初始化 end
})()