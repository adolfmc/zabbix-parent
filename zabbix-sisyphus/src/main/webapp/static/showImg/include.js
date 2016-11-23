$(function(){
	var container = $$("idContainer"),
		options = {
			onPreLoad: function(){container.style.backgroundImage = "url('js/showImg/loading.gif')";},
			onLoad: function(){ container.style.backgroundImage = "";},
			mouseRotate: false
		},
		it = new ImageTrans( container, options );
	//����ת
	$$("idLeft").onclick = function(){ it.left(); };
	//����ת
	$$("idRight").onclick = function(){ it.right(); };
	//��һ��
	$$("idPrev").onclick = function(){
		Prev();
	};
	//��һ��
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




	//��ֹ��ת
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
			//it.load("upfile/1.jpg"); //��ʼͼƬ·��(src)
			$("#idContainer").find("img").attr("img-id","2");//��ʼͼƬid(id)
			$('.tree-node').each(function(){
				if($(this).attr("node-id")=="2"){
					$(this).addClass("tree-node-selected"); //��ʼͼƬ��ʽ(id)
				};
			});
		}
	});
	//ͼƬ�϶�
	var img  = $("#idContainer").find("img");
	var isClick=false; //��¼����Ƿ���
	var defaultX; //�������ʱ�������
	var defaultY; //�ƶ���ʱ�������
	var mouseX;	//�ƶ���ʱ���X����
	var mouseY;	//�ƶ���ʱ���Y����
	var imgTop;  //IMG���ϱߵľ���
	var imgLeft; //IMG����ߵľ���
	$("#idContainer").mousedown(function(e){ //��갴��
		isClick=true; 
		defaultX=e.pageX;
		defaultY=e.pageY;
		imgTop=parseFloat(img.css("top"));
		imgLeft=parseFloat(img.css("left"));
		return false;
    }).mousemove(function(e) { //����ƶ�
		mouseX=e.pageX;
		mouseY=e.pageY;
		if(isClick) { 
			var newTop=parseFloat(mouseY-defaultY);
			var newLeft=parseFloat(mouseX-defaultX);
			img.css({"top":newTop+imgTop});
			img.css({"left":newLeft+imgLeft});
		};
		return false;
	}).mouseup(function(){ //����ɿ�
		isClick=false; 
	}).mouseleave(function(){ //����뿪
		isClick=false; 
	});
});