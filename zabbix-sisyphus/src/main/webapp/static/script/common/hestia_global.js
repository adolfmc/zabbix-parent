//paremeters
var _hestia_menu ;
var _hestia_user_authenti ;
var _appName='fortune';



/**
 * 显示选择框
 * content 内容文本
 * title 标题
 * callback 回调方式
 */
function showConfirm(content, title, callback){
	$.messager.confirm(title, content, callback);
}

