layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 机构类型管理
     */
    var SysTenementType = {
        tableId: "sysTenementTypeTable"
    };

    /**
     * 初始化表格的列
     */
    SysTenementType.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'tenementTypeId', hide: true, title: '租户类型id'},
            {field: 'typeName', sort: true, title: '类型名称'},
            {field: 'isPlatform', sort: true, title: '是否平台租户'},
            {field: 'sort', sort: true, title: '排序'},
            {field: 'status', sort: true, title: '状态'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {field: 'updateTime', sort: true, title: '更新时间'},
            {field: 'createUser', sort: true, title: '创建人'},
            {field: 'updateUser', sort: true, title: '更新人'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    SysTenementType.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(SysTenementType.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    SysTenementType.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加机构类型',
            content: Feng.ctxPath + '/sysTenementType/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(SysTenementType.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    SysTenementType.exportExcel = function () {
        var checkRows = table.checkStatus(SysTenementType.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击编辑
     *
     * @param data 点击按钮时候的行数据
     */
    SysTenementType.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改机构类型',
            content: Feng.ctxPath + '/sysTenementType/edit?tenementTypeId=' + data.tenementTypeId,
            end: function () {
                admin.getTempData('formOk') && table.reload(SysTenementType.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    SysTenementType.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.apiPath + "/sysTenementType/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(SysTenementType.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("tenementTypeId", data.tenementTypeId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + SysTenementType.tableId,
        url: Feng.apiPath + '/sysTenementType/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: SysTenementType.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        SysTenementType.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        SysTenementType.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        SysTenementType.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + SysTenementType.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            SysTenementType.openEditDlg(data);
        } else if (layEvent === 'delete') {
            SysTenementType.onDeleteItem(data);
        }
    });
});
