(function () {
    var scope = window.home;
    var modules = scope.components;

    var category = {
        initCategoryColumn : function () {
            modules.category.setColName();
            modules.category.initEleList();
            var categoryList = modules.category.getCategorys();
        }
    }

    category.initCategoryColumn();
})()