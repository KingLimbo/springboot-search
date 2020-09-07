//JavaScript代码区域
var tableGloabl;
var tableIns;
var schameNullOptions = [{text: '请选择库', value: ''}];
var tableNullOptions = [{text: '请选择表', value: ''}];
var defaultCloumnWidth = 300;
var calculationOptions = [
    {text: '包含', value: '01'}
    , {text: '不包含', value: '02'}
    , {text: '等于', value: '03'}
    , {text: '不等于', value: '04'}
    , {text: '小于', value: '05'}
    , {text: '小于或等于', value: '06'}
    , {text: '大于', value: '07'}
    , {text: '大于或等于', value: '08'}
    , {text: '是NULL', value: '09'}
    , {text: '不是NULL', value: '10'}
    , {text: '在列表中', value: '11'}
    , {text: '不在列表中', value: '12'}
    , {text: '介于', value: '13'}
    , {text: '非介于', value: '14'}
    ];
var cloumnNullOptions = [{cloumn: '', cloumnName: '请选择条件', dataType: ''}];

var vm = new Vue({
    el: '#container',
    data: {
        schame: '',
        schameOptions: [
            {text: '请选择库', value: ''},
            {text: 'cric_db', value: 'cric_db'},
            {text: 'business_db', value: 'business_db'},
            {text: 'sc_db', value: 'sc_db'}
        ],
        table: '',
        tableOptions: Object.create(tableNullOptions),
        cloumns: Object.create(cloumnNullOptions),
        cloumnData: '',
        conditions: [],
        calculationOptions: calculationOptions
    },
    methods: {
        listTables: function (event) {
            if (this.schame == "") {
                vm.clearTables();
                return false;
            }
            $.ajax({
                url: $ctx + "/search/sh0201/queryTables",
                async: true,
                data: {schame: this.schame},
                success: function (result) {
                    if (result.code == '0') {
                        var dataJson = result.data;
                        if (dataJson != undefined && dataJson.length > 0) {
                            var option = Object.create(tableNullOptions);
                            for (var i = 0; i < dataJson.length; i++) {
                                var item = {text: dataJson[i].tableName, value: dataJson[i].table};
                                option.push(item);
                            }
                            vm.tableOptions = option;
                        } else {
                            vm.clearTables();
                        }
                        // 清空查询条件
                        vm.conditions = [];
                    } else {
                        alert(result.msg);
                    }
                    console.log(result.data);
                },
                error: function (error) {
                    console.log(error);
                }
            });
        },
        listCloumns: function (event) {
            if (this.table == "") {
                return false;
            }
            $.ajax({
                url: $ctx + "/search/sh0201/queryCloumns",
                async: true,
                data: {
                    schame: this.schame,
                    table: this.table
                },
                success: function (result) {
                    if (result.code == '0') {
                        var dataJson = result.data;
                        var tempCloumns = Object.create(cloumnNullOptions);
                        if (dataJson != undefined && dataJson.length > 0) {
                            var option = [];
                            for (var i = 0; i < dataJson.length; i++) {
                                var item = {
                                    field: dataJson[i].cloumn
                                    , title: dataJson[i].cloumnName
                                    , width: defaultCloumnWidth
                                };
                                option.push(item);
                                tempCloumns.push(dataJson[i]);
                            }
                            var tempTableOptions = Object.create(tableOptions);
                            // 设置表头
                            tempTableOptions.cols = [option];
                            tempTableOptions.where = null;
                            // 设置条件
                            tempTableOptions.where = {
                                schame: vm.schame,
                                table: vm.table
                            };
                            // 方法渲染：重新渲染
                            tableIns = tableGloabl.render(tempTableOptions);
                        } else {
                            var tempTableOptions = Object.create(tableOptions);
                            tempTableOptions.cols = [[]];
                            // 方法渲染：重新渲染
                            tableIns = tableGloabl.render(tempTableOptions);
                        }
                        vm.cloumns = tempCloumns;
                        // 清空查询条件
                        vm.conditions = [];
                    } else {
                        alert(result.msg);
                    }
                },
                error:function (error) {
                    console.log(error);
                }
            });

        },
        /**
         * 清空表格数据
         */
        clearTables: function () {
            vm.tableOptions = Object.create(tableNullOptions);
            vm.table = "";
        },
        /**
         * 显示查询条件
         * @param event
         */
        addConditionDiv : function () {
            this.conditions.push({});
        },
        /**
         * 显示查询条件
         * @param event
         */
        showCondition : function (event) {
            // `event` 是原生 DOM 事件
            if (event) {
                // alert(event.target.tagName)
                var mySelect = event.target;
                var tempIndex=mySelect.selectedIndex ; // selectedIndex代表的是你所选中项的index
                var datatype = mySelect.options[tempIndex].dataset.type;
                console.log(datatype);
                if (!datatype) {
                    return
                }
                // 验证查询类型
                vm.validateCalculation(datatype, mySelect.parentNode.nextElementSibling.nextElementSibling);
                // 条件选择下拉框框
                var calculationSelect = mySelect.parentNode.nextElementSibling.firstChild;
                // 条件数据框
                var calculationInput = mySelect.parentNode.nextElementSibling.nextElementSibling.firstChild;
                // 设置name属性
                calculationInput.name = mySelect.value;
                // 禁用项重置
                for (var i = 0; i < calculationSelect.options.length; i++) {
                    calculationSelect.options[i].disabled = false;
                }
                // 字符
                if (datatype == "char"
                    || datatype == "varchar"
                    || datatype == "tinytext"
                    || datatype == "text"
                    || datatype == "longtext"
                    || datatype == "mediumtext") {
                    // 禁用无关 选项
                    calculationSelect.options[4].disabled = true;
                    calculationSelect.options[5].disabled = true;
                    calculationSelect.options[6].disabled = true;
                    calculationSelect.options[7].disabled = true;
                    calculationSelect.options[12].disabled = true;
                    calculationSelect.options[13].disabled = true;
                    // 设置默认值
                    calculationSelect.value = "01";
                    // 设置条件类型
                    calculationInput.dataset.calculation = "01";
                    calculationInput.dataset.placeholder = "请输入字符";
                    // 设置输入格式
                    calculationInput.type = "text";
                    // 设置输入框提示
                    calculationInput.placeholder = "请输入字符";
                // 数字
                } else if (datatype == "tinyint"
                    || datatype == "smallint"
                    || datatype == "mediumint"
                    || datatype == "int"
                    || datatype == "integer"
                    || datatype == "bigint"
                    || datatype == "double"
                    || datatype == "float"
                    || datatype == "decimal"
                    || datatype == "numeric"){
                    // 禁用无关选项
                    calculationSelect.options[0].disabled = true;
                    calculationSelect.options[1].disabled = true;
                    calculationSelect.options[10].disabled = true;
                    calculationSelect.options[11].disabled = true;
                    // 设置默认值
                    calculationSelect.value = "07";
                    // 设置默认条件类型
                    calculationInput.dataset.calculation = "07";
                    calculationInput.dataset.placeholder = "请输入数字";
                    // 设置输入框格式
                    calculationInput.type = "number";
                    // 设置输入框提示
                    calculationInput.placeholder = "请输入数字";
                // 时间
                } else if (datatype == "date"
                || datatype == "time"
                || datatype == "year"
                || datatype == "timestamp"
                || datatype == "datetime"){
                    // 禁用无关选项
                    calculationSelect.options[0].disabled = true;
                    calculationSelect.options[1].disabled = true;
                    calculationSelect.options[2].disabled = true;
                    calculationSelect.options[3].disabled = true;
                    calculationSelect.options[10].disabled = true;
                    calculationSelect.options[11].disabled = true;
                    // 设置默认值
                    calculationSelect.value = "07";
                    // 设置默认条件类型
                    calculationInput.dataset.calculation = "07";
                    calculationInput.dataset.placeholder = "请输入时间";
                    // 设置输入框提示
                    calculationInput.placeholder = "请输入时间";
                    // 判断日期格式，设置不同的条件值
                    if (datatype == "date") {
                        calculationInput.type = "date";
                    } else if (datatype == "time") {
                        calculationInput.type = "time";
                    } else if (datatype == "year") {
                        calculationInput.type = "number";
                        calculationInput.dataset.placeholder = "请输入年份";
                        // 设置输入框提示
                        calculationInput.placeholder = "请输入年份";
                    } else if (datatype == "timestamp" || datatype == "datetime") {
                        calculationInput.type = "datetime-local";
                    } else {
                        // 设置输入格式
                        calculationInput.type = "text";
                        // 设置输入框提示
                        calculationInput.placeholder = "请输入字符";
                        calculationInput.dataset.placeholder = "请输入字符";
                    }
                }
            }
        },
        /**
         * 更新查询条件
         * @param event
         */
        updateCondition :  function (event) {
            // `event` 是原生 DOM 事件
            if (event) {
                // alert(event.target.tagName)
                var mySelect = event.target;
                // 条件输入框
                var calculationInput = mySelect.parentNode.nextElementSibling.firstChild;
                // 重新设置查询类型
                calculationInput.dataset.calculation = mySelect.value;
                // 验证查询类型
                vm.validateCalculation(mySelect.value, mySelect.parentNode.nextElementSibling);
            }
        },
        /**
         * 验证查询类型
         * @param calculation 类型
         * @param elementDiv 输入DIV原生对象
         */
        validateCalculation: function(calculation, elementDiv){
            // 如果兄弟节点是输入框，则先删除
            if (elementDiv.nextElementSibling.className == "col-sm-2") {
                elementDiv.nextElementSibling.remove();
            }
            // 重新设置class
            $(elementDiv).attr("class","col-sm-4");
            // 条件输入框，重置初始值
            var calculationInput = elementDiv.firstChild;
            calculationInput.disabled = false;
            calculationInput.placeholder = calculationInput.dataset.placeholder;
            // NULL判断
            if (calculation == "09" || calculation == "10") {
                calculationInput.disabled = true;
                // 列表判断
            } else if (calculation == "11" || calculation == "12") {
                calculationInput.placeholder = "请输入字符,多个字符直接用逗号（,）分隔。例如：AA,BB";
                // 介于判断
            } else if (calculation == "13" || calculation == "14") {
                $(elementDiv).attr("class","col-sm-2");
                var div = $(elementDiv).clone(true).data("after", "1").removeAttr("name");
                div.find("input").attr('onkeyup', 'vm.keydownAfter(this)');
                $(elementDiv).after(div);
            }
        },
        /**
         * after按键绑定
         * @param element
         */
        keydownAfter: function(element){
            var calculationInput = element.parentNode.previousElementSibling.firstChild;
            calculationInput.dataset.after = element.value;
        },
        /**
         * 删除父元素
         * @param index
         */
        deletePerson: function(event){
            // 删一个数组元素
            // this.conditions.splice(index,1);
            if (event) {
                event.target.parentNode.parentNode.remove();
            }
        },
        /**
         * 查询
         * @param index
         */
        search: function(){
            var dataJson = [];
            $("div[name=search_value] > input").each(function(index, element){
                // 如果没有
                if (element.value == undefined || element.value == "") {
                    if (element.dataset.calculation == "09" || element.dataset.calculation == "10") {
                        var item = {};
                        item.calculation = element.dataset.calculation;
                        item.name = element.name;
                        item.value = "1";
                        dataJson.push(item);
                    } else if ((element.dataset.calculation == "13" || element.dataset.calculation == "14")
                        && element.dataset.after != undefined && element.dataset.after != "") {
                        var item = {};
                        item.calculation = element.dataset.calculation;
                        item.after = element.dataset.after;
                        item.name = element.name;
                        item.value = element.value;
                        dataJson.push(item);
                    }
                } else {
                    var item = {};
                    item.calculation = element.dataset.calculation;
                    item.after = element.dataset.after;
                    item.name = element.name;
                    item.value = element.value;
                    dataJson.push(item);
                }
            });
            var paramJson = {
                schame: vm.schame,
                table: vm.table,
                queryConditionsList: dataJson
            };
            // 设置条件
            var tempTableOptions= {
                where : $.jsonParam(paramJson)
                , page: {
                    curr: 1 //重新从第 1 页开始
                }
            };
            //表格重载
            tableIns.reload(tempTableOptions);
        }
    }
})


var tableOptions = {
    elem: '#demo'
    , height: 400
    , url: $ctx + "/search/sh0201/queryData" //数据接口
    , page: true //开启分页
    , cols: [[ //表头
    ]]
    , page: {
        curr: 1 //重新从第 1 页开始
    }
};

layui.use('table', function () {
    var table = layui.table;

    //第一个实例
    tableIns = table.render(Object.create(tableOptions));
    tableGloabl = table;
});
