//格式化时间 2016-07-09 17:01:34
function add0(m) {
	return m < 10 ? '0' + m : m
}

function formattime(t, b) {//如果要输出时间，time=true
	var time = new Date(t);
	var y = time.getFullYear();
	var m = time.getMonth() + 1;
	var d = time.getDate();
	var h = time.getHours();
	var mm = time.getMinutes();
	var s = time.getSeconds();
	if (b) {
		return y + '-' + add0(m) + '-' + add0(d) + ' ' + add0(h) + ':'
				+ add0(mm) + ':' + add0(s);
	} else {
		return y + '-' + add0(m) + '-' + add0(d);
	}
};

//type为 error | info | question | warning
function msg(title,msg,type){
	$.messager.alert(title,msg,type);
}