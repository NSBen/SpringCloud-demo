layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 机构管理
     */
    var SysTenement = {
        tableId: "sysTenementTable"
    };

    /**
     * 初始化表格的列
     */
    SysTenement.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'tenementId', hide: true, title: '机构id'},
            {field: 'simpleName', sort: true, title: '简称'},
            {field: 'fullName', sort: true, title: '全称'},
            {field: 'linkman', sort: true, title: '联系人'},
            {field: 'mobile', sort: true, title: '联系电话'},
            {field: 'tenementTypeId', sort: true, title: '租户类型id'},
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
    SysTenement.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(SysTenement.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    SysTenement.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加机构',
            content: Feng.ctxPath + '/sysTenement/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(SysTenement.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    SysTenement.exportExcel = function () {
        var checkRows = table.checkStatus(SysTenement.tableId);
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
    SysTenement.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改机构',
            content: Feng.ctxPath + '/sysTenement/edit?tenementId=' + data.tenementId,
            end: function () {
                admin.getTempData('formOk') && table.reload(SysTenement.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    SysTenement.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.apiPath + "/sysTenement/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(SysTenement.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("tenementId", data.tenementId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + SysTenement.tableId,
        url: Feng.apiPath + '/sysTenement/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: SysTenement.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        SysTenement.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        SysTenement.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        SysTenement.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + SysTenement.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            SysTenement.openEditDlg(data);
        } else if (layEvent === 'delete') {
            SysTenement.onDeleteItem(data);
        }
    });
});
