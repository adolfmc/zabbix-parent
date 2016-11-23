 var _menus = { "menus": [
				{ "menuid": "1", "icon": "icon-sys", "menuname": "系统设置",
				    "menus": [
							{ "menuid": "15", "menuname": "员工管理", "icon": "icon-role", "url": "/uc/staff/list" },
							{ "menuid": "16", "menuname": "部门管理", "icon": "icon-log", "url": "/uc/department/list"  },
							{ "menuid": "16", "menuname": "权限管理", "icon": "icon-role", "url": "/uc/function/list"  },
							{ "menuid": "14", "menuname": "角色管理", "icon": "icon-log", "url": "/uc/role/list"  }
						]
				}, { "menuid": "8", "icon": "icon-sys", "menuname": "客户管理",
				    "menus": [{ "menuid": "21", "menuname": "客户列表", "icon": "icon-users", "url": "demo.html" }	
						]
				}, { "menuid": "56", "icon": "icon-sys", "menuname": "业务管理",
				    "menus": [{ "menuid": "31", "menuname": "投资管理", "icon": "icon-nav", "url": "demo1.html" },
							{ "menuid": "32", "menuname": "回款管理", "icon": "icon-nav", "url": "demo2.html" },
                            { "menuid": "32", "menuname": "变更记录", "icon": "icon-nav", "url": "demo2.html" },
                            { "menuid": "32", "menuname": "账单列表", "icon": "icon-nav", "url": "demo2.html" },
                            { "menuid": "32", "menuname": "异常债权管理", "icon": "icon-nav", "url": "demo2.html" },
                            { "menuid": "32", "menuname": "邮件列表", "icon": "icon-nav", "url": "demo2.html" }
						]
				}, { "menuid": "28", "icon": "icon-nav", "menuname": "交易管理",
				    "menus": [{ "menuid": "41", "menuname": "原始债权", "icon": "icon-nav", "url": "demo.html" },
							{ "menuid": "42", "menuname": "可交易债权", "icon": "icon-nav", "url": "demo1.html" },
							{ "menuid": "43", "menuname": "订单管理", "icon": "icon-nav", "url": "demo2.html" },
                            { "menuid": "43", "menuname": "交易单管理", "icon": "icon-nav", "url": "demo2.html" },
                            { "menuid": "43", "menuname": "卖单管理", "icon": "icon-nav", "url": "demo2.html" }
						]
				},{ "menuid": "28", "icon": "icon-nav", "menuname": "系统设置",
                    "menus": [{ "menuid": "41", "menuname": "工作日历", "icon": "icon-nav", "url": "demo.html" },
                            { "menuid": "42", "menuname": "自动撮合设置", "icon": "icon-nav", "url": "demo1.html" }
                        ]
                },{ "menuid": "28", "icon": "icon-nav", "menuname": "结算管理",
                    "menus": [{ "menuid": "41", "menuname": "划扣管理", "icon": "icon-nav", "url": "demo.html" },
                            { "menuid": "42", "menuname": "划扣回盘", "icon": "icon-nav", "url": "demo1.html" },
                            { "menuid": "42", "menuname": "付款管理", "icon": "icon-nav", "url": "demo1.html" },
                            { "menuid": "42", "menuname": "报盘单列表", "icon": "icon-nav", "url": "demo1.html" }
                        ]
                }
		]
};

 function InitLeftMenu1() {
     $(".easyui-accordion1").empty();
     var menulist = "";

	$.post('/getMenu', null, function(data) {
		$.each(data.children, function(i, n) {
			menulist += '<div title="' + n.name + '"  iconCls="icon-sys" style="overflow:auto;">';
			menulist += '<ul style="list-style:none;margin:10px 0;padding:0 15px">';
			$.each(n.children, function(j, o) {
				menulist += '<li style="margin-bottom:10px;padding-left:16px;background: url(static/jquery-easyui-1.5/themes/icons/ok.png) left no-repeat;"><div><a style="text-decoration:none" ref="' + o.id + '" href="#" rel="' + o.url + '" ><span class="icon icon-nav" >&nbsp;</span><span class="nav">' + o.name + '</span></a></div></li> ';
			});
			menulist += '</ul></div>';
		});
		
		$(".easyui-accordion1").append(menulist);

	     $('.easyui-accordion1 li a').click(function() {
	         var tabTitle = $(this).children('.nav').text();
	         var url = $(this).attr("rel");
	         var menuid = $(this).attr("ref");
	         var icon = getIcon(menuid, icon);
	         addTab(tabTitle, url, icon);
	         $('.easyui-accordion1 li div').removeClass("selected");
	         $(this).parent().addClass("selected");
	     }).hover(function() {
	         $(this).parent().addClass("hover");
	     }, function() {
	         $(this).parent().removeClass("hover");
	     });

	     //导航菜单绑定初始化
	     $(".easyui-accordion1").accordion();
		
	}, 'json');
     
// $.each(_hestia_menu.childrens, function(i, n) {
//         menulist += '<div title="' + n.name + '"  iconCls="icon-sys" style="overflow:auto;">';
//         menulist += '<ul>';
//         $.each(n.childrens, function(j, o) {
//             menulist += '<li><div><a ref="' + o.icon + '" href="#" rel="' + o.url + '" ><span class="icon ' + o.icon + '" >&nbsp;</span><span class="nav">' + o.name + '</span></a></div></li> ';
//         })
//         menulist += '</ul></div>';
//     })


     
 }

 $(function() {
//     $.ajax({
//         url: "/"+_appName+"/getMenu",
//         async: false,
//         success: function(data) {
//             _hestia_menu = data.obj;
//             InitLeftMenu1();
//
//         },
//         error: function() {
//             $.messager.alert('提示', '加载菜单树失败', 'info');
//         }
//     });

     InitLeftMenu1();
     $('#editpass').click(function() {
         $('#w').window('open');
     });

     $('#btnEp').click(function() {
         serverLogin();
     })

     $('#btnCancel').click(function() {
         closePwd();
     })

     $('#loginOut').click(function() {
         $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
             if (r) {
                 location.href = '/ajax/loginout.ashx';
             }
         });
     })
 });