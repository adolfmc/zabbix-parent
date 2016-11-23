<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${ctx}/static/showImg/CJL.0.1.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/static/showImg/ImageTrans.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/static/showImg/jquery-mSlide.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/static/showImg/m_common.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/static/showImg/m_fuc.js" charset="utf-8"></script>
<style type="text/css">
#chooser{
	border: 1px solid #70C0E7;
	background-color: #EEEEFF;
	opacity: 0.5;
	position: absolute;
}
</style>
<script type="text/javascript">
var it = null;
var containerId;
var containerLeft;
var containerTop;
var containerWidth;
var containerHeight;
var chooser = null;
var img;
var imgTop;  //IMG离上边的距离
var imgLeft; //IMG离左边的距离
var imgWidth;
var imgHeight;
var defaultX; //按下鼠标时候的坐标
var defaultY; //移动的时候的坐标
var mouseX;	//移动的时候的X坐标
var mouseY;	//移动的时候的Y坐标
var isMouseDown = false;
var isZoom = false;
var lastUrl = "";
var focusBodyId;

if(!ImageTrans.prototype.getRotate){
	ImageTrans.prototype.getRotate = function(){
		return this._radian;
	}
}
if(!ImageTrans.prototype.setConfig){
	ImageTrans.prototype.setConfig = function(scale, rotate){
		this._radian = rotate;
		this._x = scale;
		this._y = scale;
		this._preConfig = true;
	}
}

function initImageBox(cid, focusBody){
	containerId = cid;
	focusBodyId = focusBody;
	var jcontainer = $("#"+containerId);
	var container = $$(containerId);
	var	options = {
			onPreLoad: function(){container.style.backgroundImage = "url('showImg/loading.gif')";},
			onLoad: function(){ container.style.backgroundImage = "";},
			mouseRotate: false
		};
	it = new ImageTrans( container, options );
	it.load("${ctx}/static/images/blank.png");
	
	img = jcontainer.children("img");
	var p = jcontainer.offset();
	containerLeft = parseFloat(p.left);
	containerTop = parseFloat(p.top);
	containerWidth = parseFloat(jcontainer.css("width"));
	containerHeight = parseFloat(jcontainer.css("height"));
	if(isNaN(containerLeft)){
		containerLeft = 0;
	}
	if(isNaN(containerTop)){
		containerTop = 0;
	}

	jcontainer.mousedown(onMouseDownImage);
	jcontainer.mousemove(onMouseMoveImage);
	jcontainer.mouseup(onMouseUpImage);
	jcontainer.mouseleave(onMouseLeaveImage);
}

function load(title, url){
	if(url == lastUrl){
		it.reset();
	}else{
		lastUrl = url;
		it.load(url);
		img.attr("title", title);
	}
}

function onMouseDownImage(e){
	isMouseDown = true;
	isZoom = e.ctrlKey;
	defaultX = e.pageX;
	defaultY = e.pageY;
	imgTop = parseFloat(img.css("top"));
	imgLeft = parseFloat(img.css("left"));
	imgWidth = parseFloat(img.css("width"));
	imgHeight = parseFloat(img.css("height"));
	return false;
}

function onMouseMoveImage(e){
	mouseX = e.pageX;
	mouseY = e.pageY;
	if(isMouseDown) {
		if(isZoom){
			drawRect();
		}else{
			var newTop = parseFloat(mouseY - defaultY);
			var newLeft = parseFloat(mouseX - defaultX);
			img.css({"top": newTop + imgTop});
			img.css({"left": newLeft + imgLeft});
		}
	};
	return false;
}

function onMouseUpImage(e){
	if(isMouseDown){
		isMouseDown = false;
		if(isZoom){
			clearRect();	
		}
		document.getElementById(focusBodyId).focus();
		// document.body.focus();
	}
}

function onMouseLeaveImage(e){
	if(isMouseDown){
		isMouseDown = false;
		if(isZoom){
			clearRect();	
		}
		document.getElementById(focusBodyId).focus();
	}
}

function drawRect(){
	if(chooser == null){
		chooser = $("<div id='chooser'></div>").appendTo("#"+containerId);
	}else{
		chooser.show();
	}
	var left = defaultX < mouseX ? defaultX : mouseX;
	var right = defaultX > mouseX ? defaultX : mouseX;
	var top = defaultY < mouseY ? defaultY : mouseY;
	var bottom = defaultY > mouseY ? defaultY : mouseY;
	chooser.css("left", left - containerLeft);
	chooser.css("top", top - containerTop);
	chooser.css("width", right - left);
	chooser.css("height", bottom - top);
}

function clearRect(){
	var scale = it.getScale();
	var originX = imgLeft + imgWidth / 2;
	var originY = imgTop + imgHeight / 2;
	var zoomOffsetX = (defaultX + mouseX) / 2 - originX;
	var zoomOffsetY = (defaultY + mouseY) / 2 - originY;
	var offsetX = zoomOffsetX / scale;
	var offsetY = zoomOffsetY / scale;
	var newX = (containerWidth - imgWidth) / 2 - offsetX;
	var newY = (containerHeight - imgHeight) / 2 - offsetY;
	if(newX + imgWidth < containerWidth){
		newX = containerWidth - imgWidth;
	}
	if(newX > 0){
		newX = 0;
	} 
	if(newY + imgHeight < containerHeight){
		newY = containerHeight - imgHeight;
	}
	if(newY > 0){
		newY = 0;
	} 
	it.reset2();
	img.css({"left": newX});
	img.css({"top": newY});
	if(chooser){
		chooser.hide();
	}
}
</script>
