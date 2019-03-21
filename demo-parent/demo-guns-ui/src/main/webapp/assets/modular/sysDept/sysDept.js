layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 部门管理
     */
    var SysDept = {
        tableId: "sysDeptTable"
    };

    /**
     * 初始化表格的列
     */
    SysDept.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'deptId', hide: true, title: '部门id'},
            {field: 'simpleName', sort: true, title: '简称'},
            {field: 'fullName', sort: true, title: '全称'},
            {field: 'deptType', sort: true, title: '部门类型'},
            {field: 'pid', sort: true, title: '父部门id'},
            {field: 'pids', sort: true, title: '父id路径'},
            {field: 'isVirtual', sort: true, title: '是否虚拟部门'},
            {field: 'fullPath', sort: true, title: '全路径名称'},
            {field: 'wxDeptId', sort: true, title: '微信部门id'},
            {field: 'description', sort: true, title: '描述'},
            {field: 'sort', sort: true, title: '排序'},
            {field: 'status', sort: true, title: '状态'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {field: 'updateTime', sort: true, title: '更新时间'},
            {field: 'createUser', sort: true, title: '创建人'},
            {field: 'updateUser', sort: true, title: '更新人'},
            {field: 'tenementId', sort: true, title: '机构id'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    SysDept.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(SysDept.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    SysDept.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加部门',
            content: Feng.ctxPath + '/sysDept/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(SysDept.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    SysDept.exportExcel = function () {
        var checkRows = table.checkStatus(SysDept.tableId);
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
    SysDept.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改部门',
            content: Feng.ctxPath + '/sysDept/edit?deptId=' + data.deptId,
            end: function () {
                admin.getTempData('formOk') && table.reload(SysDept.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    SysDept.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.apiPath + "/sysDept/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(SysDept.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("deptId", data.deptId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + SysDept.tableId,
        url: Feng.apiPath + '/sysDept/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: SysDept.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        SysDept.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        SysDept.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        SysDept.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + SysDept.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            SysDept.openEditDlg(data);
        } else if (layEvent === 'delete') {
            SysDept.onDeleteItem(data);
        }
    });
});
