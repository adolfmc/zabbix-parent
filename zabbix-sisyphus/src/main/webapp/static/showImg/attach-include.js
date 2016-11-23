$(function(){
	var container = $$("idContainer"),
		options = {
			onPreLoad: function(){container.style.backgroundImage = "url('js/showImg/loading.gif')";},
			onLoad: function(){ container.style.backgroundImage = "";},
			mouseRotate: false
		},
		it = new ImageTrans( container, options );
	//左旋转
	$$("idLeft").onclick = function(){ it.left(); };
	//右旋转
	$$("idRight").onclick = function(){ it.right(); };
	//上一张
	$$("idPrev").onclick = function(){
		Prev();
	};
	//下一张
	$$("idNext").onclick = function(){
		Next();
	};



		$("#idTree").fancybox({
				'width'				: '90%',
				'height'			: '90%',
				'autoScale'			: false,
				'transitionIn'		: 'none',
				'transitionOut'		: 'none',
				'type'				: 'iframe'
			});


	
	function Prev(){
		$(".tree-node").each(function(){
			var prevli = $(this).parent("li").prev("li");
			if($(this).attr("node-id")==$("#idContainer").find("img").attr("img-id") && prevli.length>0){
				prevli.children(".tree-node").click();
			};
		});
	}
	
  function Next(){ 	
		var treenode = $(".tree-node");
		for(var i=treenode.length;i>0;i--){
			var nextli = treenode.eq(i-1).parent("li").next("li");
			if(treenode.eq(i-1).attr("node-id")==$("#idContainer").find("img").attr("img-id") && nextli.length>0){
				nextli.children(".tree-node").click();
			};
		};
	}
	
	document.onkeydown = pageEvent;
	function pageEvent(evt){ 
		evt = evt ||window.event; 
		var key=evt.which||evt.keyCode;
		if (key == 37) Prev();
		if (key == 39) Next(); 
	}; 




	//禁止跳转
	$('a').click(function(){
		return false;
	});
	$('#showTree').tree({
		url : 'json/showImg.json',
		onClick : function(node){
			if(node.attributes && node.attributes.src){
				it.load(node.attributes.src);
				$("#idContainer").find("img").attr("img-id",node.id)
			};
		},
		onLoadSuccess : function(node){
			//it.load("upfile/1.jpg"); //初始图片路径(src)
			$("#idContainer").find("img").attr("img-id","2");//初始图片id(id)
			$('.tree-node').each(function(){
				if($(this).attr("node-id")=="2"){
					$(this).addClass("tree-node-selected"); //初始图片样式(id)
				};
			});
		}
	});
	//图片拖动
	var img  = $("#idContainer").find("img");
	var isClick=false; //记录鼠标是否按下
	var defaultX; //按下鼠标时候的坐标
	var defaultY; //移动的时候的坐标
	var mouseX;	//移动的时候的X坐标
	var mouseY;	//移动的时候的Y坐标
	var imgTop;  //IMG离上边的距离
	var imgLeft; //IMG离左边的距离
	$("#idContainer").mousedown(function(e){ //鼠标按下
		isClick=true; 
		defaultX=e.pageX;
		defaultY=e.pageY;
		imgTop=parseFloat(img.css("top"));
		imgLeft=parseFloat(img.css("left"));
		return false;
    }).mousemove(function(e) { //鼠标移动
		mouseX=e.pageX;
		mouseY=e.pageY;
		if(isClick) { 
			var newTop=parseFloat(mouseY-defaultY);
			var newLeft=parseFloat(mouseX-defaultX);
			img.css({"top":newTop+imgTop});
			img.css({"left":newLeft+imgLeft});
		};
		return false;
	}).mouseup(function(){ //鼠标松开
		isClick=false; 
	}).mouseleave(function(){ //鼠标离开
		isClick=false; 
	});
});