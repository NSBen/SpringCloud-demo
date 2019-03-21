/**
 * 详情对话框
 */
var SysTenementInfoDlg = {
    data: {
        simpleName: "",
        fullName: "",
        linkman: "",
        mobile: "",
        tenementTypeId: "",
        sort: "",
        status: "",
        createTime: "",
        updateTime: "",
        createUser: "",
        updateUser: ""
    }
};

layui.use(['form', 'admin', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;

    //让当前iframe弹层高度适应
    admin.iframeAuto();

    //获取详情信息，填充表单
    var ajax = new $ax(Feng.apiPath + "/sysTenement/detail?tenementId=" + Feng.getUrlParam("tenementId"));
    var result = ajax.start();
    form.val('sysTenementForm', result.data);

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.apiPath + "/sysTenement/editItem", function (data) {
            Feng.success("更新成功！");

            //传给上个页面，刷新table用
            admin.putTempData('formOk', true);

            //关掉对话框
            admin.closeThisDialog();
        }, function (data) {
            Feng.error("更新失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();
    });
});