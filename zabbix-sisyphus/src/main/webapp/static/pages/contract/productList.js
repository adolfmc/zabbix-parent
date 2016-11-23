function createProduct() {
		$('')
		$('#pversiondialog').dialog('open');
};


//function createProduct() {
//    var p = _hestia.dialog({
//        title: '添加产品',
//        href: './productVersion.html',
//        fit: false,
//        doSize: true,
//        left: 200,
//        top: 65,
//        width: 800,
//        iconCls: 'icon-ok',
//        buttons: [{
//            text: '添加',
//            handler: function() {
//                var f = p.find('form');
//                f.form('submit', {
//                    url: '/fortune/institutional/save',
//                    success: function(d) {
//                        var json = $.parseJSON(d);
//                        if (json.success) {
//                            datagrid.datagrid('reload');
//                            p.dialog('close');
//                        }
//
//                        _hestia.messagerShow({
//                            msg: json.msg,
//                            title: '提示'
//                        });
//                    }
//                });
//            }
//        }, {
//            text: '取消',
//            handler: function() {
//                var f = p.find('form');
//                f.form('clear');
//                p.dialog('close');
//            }
//        }],
//        onLoad: function() {
//            var f = p.find('form');
//            var roleIds = f.find('input[name=roleIds]');
//            var roleIdsCombobox = roleIds.combobox({
//                url: './productVersion.html',
//                valueField: 'cid',
//                textField: 'cname',
//                multiple: true,
//                editable: false,
//                panelHeight: 'auto'
//            });
//        }
//    });
//};



function formatterCreateVersion(val, row, index) {
    return '<a href="#" onclick="createVersion();">新增版本</a>';
};

$(function() {
    //product detail 

    $('#dg').datagrid({
        view: detailview,
        detailFormatter: function(index, row) {
            return '<div style="padding:2px"><table class="ddv"></table></div>';
        },
        onExpandRow: function(index, row) {
            var ddv = $(this).datagrid('getRowDetail', index).find('table.ddv');
            ddv.datagrid({
                url: '/'+_appName+'/institutional/findProductVersionByProdId?id='+row.id,
                fitColumns: true,
                singleSelect: false,
                rownumbers: true,
                loadMsg: '',
                columns: [
                    [{
                        field: 'orderid',
                        title: '版本'
                    }, {
                        field: 'quantity',
                        title: '预计年化收益率',
                        align: 'right'
                    }, {
                        field: 'unitprice',
                        title: '产品封闭期',
                        align: 'right'
                    }, {
                        field: 'unitprice',
                        title: '是否有效',
                        align: 'right'
                    }, {
                        field: 'operater',
                        title: '操作',
                        align: 'center',
                        formatter: function(val, rec) {
                            return '<span class="nav1"><img onclick="createVersion();" title="查看" src="../static/jquery-easyui-1.3.5/themes/icons/extjs_icons/pencil_go.png"/></span>' + '<span class="nav2"><img onclick="createVersion();" title="修改" src="../static/jquery-easyui-1.3.5/themes/icons/extjs_icons/pencil.png"/></span>' + '<span class="nav2"><img  title="停用" src="../static/jquery-easyui-1.3.5/themes/icons/extjs_icons/pencil_delete.png"/></span><span class="nav1"></span>';
                        }
                    }]
                ],

                onResize: function() {
                    $('#dg').datagrid('fixDetailRowHeight', index);
                },
                onLoadSuccess: function() {
                    setTimeout(function() {
                        $('#dg').datagrid('fixDetailRowHeight', index);
                    }, 0);
                }
            });
            $('#dg').datagrid('fixDetailRowHeight', index);
        }
    });
});