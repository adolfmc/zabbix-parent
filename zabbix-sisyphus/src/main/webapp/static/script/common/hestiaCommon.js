function fomatFloat(val,lg){
	if(val&&typeof val == 'number'){
		val = Number(val).toFixed(lg);
		return val;
	}
	return '';
}
/**
 * 日期格式化
 * 		li
 * @param fmt
 * @returns
 */
Date.prototype.format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

/**
 * 标准电话框加载
 * @param tlAreaCode
 * @param tlTelNum
 * @param tlExtCode
 * @param detailId
 */
function setTel(tlAreaCode,tlTelNum,tlExtCode,detailId){
	var tlAreaCodeText="",tlTelNumText="",tlExtCodeText="";
	var detail =  $("#"+detailId);
	if(detailId.length==0){alert('找不到detailId'+detailId);return;}
	var tlAreaCodeObj =  $("#"+tlAreaCode);
	if(tlAreaCodeObj.length>0){
		tlAreaCodeObj.change(function(){
			tlAreaCodeText = tlAreaCodeObj.val();
			if(tlTelNumObj.length>0)tlTelNumText = tlTelNumObj.val();
			if(tlExtCodeObj.length>0)tlExtCodeText = tlExtCodeObj.val();
			detail.val(tlAreaCodeText+'--tel--'+tlTelNumText+'--tel--'+tlExtCodeText);
	    });
	}
	var tlTelNumObj =  $("#"+tlTelNum);
	if(tlTelNumObj.length>0){
		tlTelNumObj.change(function(){
			tlTelNumText = tlTelNumObj.val();
			if(tlAreaCodeObj.length>0)tlAreaCodeText = tlAreaCodeObj.val();
			if(tlExtCodeObj.length>0)tlExtCodeText = tlExtCodeObj.val();
			detail.val(tlAreaCodeText+'--tel--'+tlTelNumText+'--tel--'+tlExtCodeText);
	    });
	}
	var tlExtCodeObj =  $("#"+tlExtCode);
	if(tlExtCodeObj.length>0){
		tlExtCodeObj.change(function(){
			tlExtCodeText = tlExtCodeObj.val();
			if(tlAreaCodeObj.length>0)tlAreaCodeText = tlAreaCodeObj.val();
			if(tlTelNumObj.length>0)tlTelNumText = tlTelNumObj.val();
			detail.val(tlAreaCodeText+'--tel--'+tlTelNumText+'--tel--'+tlExtCodeText);
	    });
	}
}

function convertTel(telString,tlAreaCode,tlTelNum,tlExtCode){
	if(telString!=null){		
		var tel = telString.split('--tel--'); 
		if(tel.length>1){		
			var tlAreaCodeObj =  $("#"+tlAreaCode);
			if(tlAreaCodeObj.length>0){
				tlAreaCodeObj.val(tel[0]);
			}
			var tlTelNumObj =  $("#"+tlTelNum);
			if(tlTelNumObj.length>0){
				tlTelNumObj.val(tel[1]);
			}
			var tlExtCodeObj =  $("#"+tlExtCode);
			if(tlExtCodeObj.length>0){
				tlExtCodeObj.val(tel[2]);
			}
		}
	}
}


function convertAddr(addrString,proviceId,cityId,countyId,streetId){
	if(addrString!=null){		
		var addr = addrString.split('--addr--'); 
		if(addr.length>1){		
			var street =  $("#"+streetId);
			if(street.length>0){
				street.val(addr[3]);
			}
			var provice =  $("#"+proviceId);
			if(provice.length>0){
				provice.combobox('setValue',addr[0]);
			}
			var city =  $("#"+cityId);
			if(city.length>0){
				city.combobox('setValue',addr[1]);
			}
			var county =  $("#"+countyId);
			if(county.length>0){
				county.combobox('setValue',addr[2]);
			}
		}
	}
}


/**
 * 标准地址框加载
 * @param proviceId
 * @param cityId
 * @param countyId
 * @param streetId
 * @param detailId
 */
function setArea(proviceId,cityId,countyId,streetId,detailId){
	/**获取省市县输入框对象**/
	var provice =  $("#"+proviceId);
	if(provice.length==0){alert('找不到proviceId'+proviceId);return;}
	var city =  $("#"+cityId);
	if(city.length==0){alert('找不到cityId'+cityId);return;}
	var county =  $("#"+countyId);
	if(county.length==0){alert('找不到countyId'+countyId);return;}
	var detail =  $("#"+detailId);
	if(detailId.length==0){alert('找不到detailId'+detailId);return;}
	var street =  $("#"+streetId);
	if(street.length>0){
		street.change(function(){
			detail.val(provice.combobox('getValue')+'--addr--'+city.combobox('getValue')+'--addr--'+county.combobox('getValue')+'--addr--'+$('#'+streetId).val());
	    });
	}
	/**初始化下拉框，防止动态加载**/
	provice.combobox('textbox').focus(function(){provice.combobox('showPanel');});
	city.combobox('textbox').focus(function(){city.combobox('showPanel');});
	county.combobox('textbox').focus(function(){county.combobox('showPanel');});

	/**url**/
	var proviceUrl = "/sys/dictionary/getProvince";
	var cityUrl = "/sys/dictionary/getCity?parentId=";
	var countyUrl = "/sys/dictionary/getCounty?parentId=";
	/**加载省**/
	provice.combobox({
		url:proviceUrl,
		valueField : 'code',
		textField : 'name',
		validType : 'selectValidator["'+proviceId+'"]',
		filter : function(q, row) {
			if(row.pinyin){
				if(row.pinyin.indexOf(q) == 0){
					return true;
				}
			}
			if (row.name.indexOf(q) != -1) {
				return true;
			}
		} ,	
		onChange:function(newValue,oldValue){
			if(newValue==null||newValue==''){
				city.combobox('clear');
				city.combobox('loadData',[{}]);
				county.combobox('clear');
				county.combobox('loadData',[{}]);
			}

			city.combobox({
				url:cityUrl+newValue,
				valueField : 'code',
				textField : 'name',
				validType : 'selectValidator["'+cityId+'"]',
				filter : function(q, row) {
					if(row.pinyin){
						if(row.pinyin.indexOf(q) == 0){
							return true;
						}
					}
					if (row.name.indexOf(q) != -1) {
						return true;
					}
				} ,	
				onChange:function(newValue,oldValue){
					if(newValue==null||newValue==''){
						county.combobox('clear');
						county.combobox('loadData',[{}]);
					}
					county.combobox({
						url:countyUrl+newValue,
						valueField : 'code',
						textField : 'name',
						validType : 'selectValidator["'+countyId+'"]',
						filter : function(q, row) {
							if(row.pinyin){
								if(row.pinyin.indexOf(q) == 0){
									return true;
								}
							}
							if (row.name.indexOf(q) != -1) {
								return true;
							}
						} ,	
						onChange:function(newValue,oldValue){
							if(newValue==null||newValue==''){
							}
							detail.val(provice.combobox('getValue')+'--addr--'+city.combobox('getValue')+'--addr--'+county.combobox('getValue')+'--addr--'+$('#'+streetId).val());
						}
					}).combobox('clear');	
					detail.val(provice.combobox('getValue')+'--addr--'+city.combobox('getValue')+'--addr--'+county.combobox('getValue')+'--addr--'+$('#'+streetId).val());
				}
			}).combobox('clear');
			county.combobox('clear');
			county.combobox('loadData',[{}]);
			detail.val(provice.combobox('getValue')+'--addr--'+city.combobox('getValue')+'--addr--'+county.combobox('getValue')+'--addr--'+$('#'+streetId).val());
		}
	});
}



function getSexAndAge(cardId){
	var ob = new Object();
	var nian,yue,ri,action,csrq,age,sex,xingbie,s,y,d,g;
	var s=cardId;
	var d=new Date();

	// 身份证为18位
	if (cardId.length==18 ){
		nian=s.substr(6,4);
		yue=s.substr(10,2);
		ri=s.substr(12,2);
		csrq=nian+"-"+yue+"-"+ri;
		ob.csrq=csrq;
		xingbie=s.substr(16,1);
		if(xingbie%2==0){
			ob.sexCode = '00140002';			
			ob.sex="女";
		}else{
			ob.sexCode = '00140001';
			ob.sex="男";
		}
		age=d.getYear()+1900-nian;
		ob.age=age;
	}else{
		ob.sexCode = '00140003';			
		ob.sex="保密";
	}
	return ob;
}
	//封装jquery easyui combobox组件
var comboboxUtil = (function() {
	var util = util || {};

	// 根据url填充下拉框
	util.setComboboxByUrl = function(id, url, valueField, textField, width, required, onSelect) {
		$('#' + id).combobox({
			url : url,
			valueField : valueField,
			textField : textField,
			//panelHeight : 'auto',
			width : width,
			required : required,
			validType : 'selectValidator["' + id + '"]',
			filter : function(q, row) {
				return row[$(this).combobox('options').textField].indexOf(q) == 0;
			},
			onSelect : onSelect
		});

		$('#' + id).combobox('textbox').focus(function(){
			$('#' + id).combobox('showPanel');
			});
	},

	// 根据数据源填充下拉框
	util.setComboboxByData = function(id, data, valueField, textField, width, required, onSelect) {
		$('#' + id).combobox({
			data : data,
			valueField : valueField,
			textField : textField,
//			panelHeight : 'auto',
			width : width,
			required : required,
			validType : 'selectValidator["' + id + '"]',
			filter : function(q, row) {
				return row[$(this).combobox('options').textField].indexOf(q) == 0;
			},
			onSelect : onSelect
		});
		$('#' + id).combobox('textbox').focus(function(){
			$('#' + id).combobox('showPanel');
			});
	},
	
	// 给下拉框添加必填属性
	util.addRequiredAttr = function(id) {
		$('#' + id).combobox({
			'required' : true
		});
	},

	// 移除下拉框必填属性
	util.removeRequiredAttr = function(id) {
		$('#' + id).combobox({
			'required' : false
		});
	},

	// 移除下拉框必填属性并清空当前的value
	util.removeRequiredAttrAndClearVal = function(id) {
		this.removeRequiredAttr(id);
		this.clearVal(id);
	},

	// 清空下拉框当前的value
	util.clearVal = function(id) {
		$('#' + id).combobox('clear');
	},

	// 获得下拉框的值
	util.getValue = function(id) {
		return $("#" + id).combobox('getValue');
	},

	// 给下拉框赋值
	util.setValue = function(id, val) {
		$("#" + id).combobox('setValue', val);
	},

	// 获得下拉框Text
	util.getText = function(id) {
		return $("#" + id).combobox('getText');
	},

	util.formatter = function(id, formatter) {
		$('#' + id).combobox({
			formatter : formatter
		});
	},

	util.addOnSelectEvent = function(id, onSelect) {
		$('#' + id).combobox({
			onSelect : onSelect
		});
	},

	util.addOnChangeEvent = function(id, onChange) {
		$('#' + id).combobox({
			onChange : onChange
		});
	}

	return util;
})()

	
	/**
	 * 标准ajax提交
	 * @param url
	 * @param asyncStatus
	 * @param successFunction
	 * @param errorfunction
	 */
	function postAjax(url,asyncStatus,successFunction,errorfunction){
		$.ajax({
			url : url,
			async : asyncStatus,
			success : successFunction,
			error : errorfunction
		});
	}	

	/**
	 * 标准message弹窗框
	 * @param type
	 * @param title
	 * @param msg
	 * @param okFunction
	 * @param icon
	 */
	function showMessage(type,title, msg,okFunction, icon){
		if(type == 'show'){
			$.messager.show({
				title:title,
				msg:msg,
				showType:'show'
			});
		}
		if(type == 'alert'){
			$.messager.alert(title,msg,icon);
		}
		if(type == 'confirm'){
			$.messager.confirm(title,msg, function(r){
				if (r){
					okFunction();
				}
			});
		}
		if(type == 'prompt'){
			$.messager.confirm(title,msg, function(r){
				if (r){
					okFunction();
				}
			});
		}
		
	}
	
	/**
	 * 获取列表所选对象id集合
	 * @param datagrId
	 * @returns {Array}
	 */
	function getSelectIds(datagrId){
		var entityIds = new Array();
		var selects = $('#'+datagrId).datagrid('getChecked');
		if(selects.length < 1)$.messager.alert('提示', '请勾选数据后进行操作。', 'info');
		for(var i=0;i<selects.length;i++){
			var entityId = selects[i].id;
			entityIds.push(entityId);
		}
		return entityIds;
	}
	/**
	 * 获取列表全选
	 * @param datagrId
	 */
	function unSelectIds(datagrId){
		$('#'+datagrId).datagrid('unselectAll');
	}	
	/**
	 * 弹窗
	 * @param id
	 * @param areaId
	 * @param url
	 * @param title
	 * @param width
	 * @param height
	 * @param onCloseHandler
	 */
	function showCommonDialog(id,areaId,url,title,width,height,onCloseHandler){
		var dlg = $('#'+id);
		if (!dlg.length){  
			dlg = $('<div id="'+id+'"></div>').appendTo('body');
			dlg.dialog({
		        title: title,
		        iconCls:'icon-tab',
		        loadingMessage:'数据装载中......',
		        modal: true,
		        resizable: false,
		        minimizable: false,
		        maximizable: true,
		        shadow: true,
		        closed: true,
		        collapsible:true,
		        width: width,
		        height: height,
		        onMaximize:function(){
		    		dlg.dialog("move",{top:$(document).scrollTop()}); 
		        },
		        //buttons:crud_winButtons,
		        //toolbar:crud_winToolbar
			    onMove:function(left,top){},
				onClose: function () {
					$(this).dialog("destroy");
					if(onCloseHandler){
						onCloseHandler();
					}
				},
			    buttons: [{  
	                text:'关闭',  
	                handler:function(){  
	                	dlg.dialog('close');  
	                }  
	            }] 
		    });
		}
		dlg.dialog('open').dialog('refresh',url );
		dlg.dialog("move",{top:$(document).scrollTop() + (document.body.clientHeight-height) * 0.5}); 
	}
	/**
	 * 查询
	 * @param searchFormId
	 * @param datagrId
	 */
	function searchList(searchFormId,datagrId){
		var param = {};
		$('#'+searchFormId).find('.query').each(function(){
			var name = $(this).attr('name');
			var val = $(this).val();
			if($(this).attr('type')=='radio'){
				 val = $('input[name="'+name+'"]:checked').val();
			}
			
			if ($(this).hasClass('datebox-f')){
				name = $(this).attr('comboname');
				val = $(this).datebox('getValue');//alert(name+'00'+val);
			} else if ($(this).hasClass('combogrid-f')){
				name = $(this).attr('comboname');
				val = $(this).combogrid('getValue');
			} else if ($(this).hasClass('combobox-f')){
				name = $(this).attr('comboname');
				val = $(this).combobox('getValues');
			} 
			param[name] = val;
		});
		$('#'+datagrId).datagrid('load', param);
	}
	$(function() { 
		//文本框长度限制
		$("text[maxlength]").bind('input propertychange', function() {  
	        var maxLength = $(this).attr('maxlength');  
	        if ($(this).val().length > maxLength) {  
	            $(this).val($(this).val().substring(0, maxLength));  
	        }  
	    })  
		//文本框长度限制
		$("textarea[maxlength]").bind('input propertychange', function() {  
	        var maxLength = $(this).attr('maxlength');  
	        if ($(this).val().length > maxLength) {  
	            $(this).val($(this).val().substring(0, maxLength));  
	        }  
	    })  
	    //必填项红色星号
		$(".bitian").each(function(){
			var source = $(this).html();
			if(source.indexOf("※")==-1){
				$(this).html("<span style='color:red; font-size:13px;font-weight:bold;'>※</span>"+$(this).html())		
			}
		});
		//必填项但页面不作验证蓝色星号
		$(".bitian1").each(function(){
			var source = $(this).html();
			if(source.indexOf("※")==-1){
				$(this).html("<span style='color:blue; font-size:13px;font-weight:bold;'>※</span>"+$(this).html())	
			}
		});
		
		//下拉列表输入验证
		$.extend($.fn.validatebox.defaults.rules, {   
		    selectValidator: {   
		        validator: function(value,param){ 
		        	var i =$('#'+param).combobox('getText') ;
		        	var ii =$('#'+param).combobox('getValue') ;
		        	if(i!=ii){return true;}
		        },   
		        message: '请选择!'  
		    }   
		}); 
	});
