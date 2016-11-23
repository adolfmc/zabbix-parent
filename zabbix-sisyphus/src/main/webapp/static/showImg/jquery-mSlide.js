(function($){ 
$.fn.mSlide = function(options){ 
	var defaults = { 
		effect:"fade",	// slide,fade
		timer:4000,	 //图片切换时间间隔
		actionTimer:400, //图片运动时间
		autoPlay:true  //自动播放
	} 
	var options = $.extend(defaults, options); 
	return this.each(function(){ 
		var _this = $(this),
			_li = $('ul li',_this),
			_num = $('.num span',_this),
			_lens =_li.length,
			_wd = _this.innerWidth(),
			i = 0,
			_timer;
		_this.children('.next').click(function(){
			if(!_li.is(":animated")){
				if(i<_lens-1){
					nextAction(i,i+1,i+1);
				}else{
					nextAction(_lens-1,0,0);
				};
				numClass(i);
			};
		});
		_this.children('.prev').click(function(){
			if(!_li.is(":animated")){
				if(i>0){
					prevAction(i,i-1,i-1);
				}else{
					prevAction(0,_lens-1,_lens-1);
				};
				numClass(i);
			}
		});
		_num.click(function(){
			var index = $(this).index();
			if (!_li.is(":animated")) {
				if (index < i) {
					prevAction(i,index,index);
				}else{
					nextAction(i,index,index);
				};
				numClass(index);
			};
		});

		if(options.autoPlay){
			_this.mouseenter(function(){autoStop()});
			_this.mouseleave(function(){autoPlay()});
			autoPlay();
		};
		function nextAction(a,b,c){
			if(options.effect=="slide"){
				_li.eq(a).animate({ left: "-"+_wd+"px"},options.actionTimer);//隐藏
				_li.eq(b).css({"left":_wd+"px"}).animate({left:"0"},options.actionTimer);//显示
			}else{
				_li.eq(a).css({"left":"-"+_wd+"px","opacity":0});//隐藏
				_li.eq(b).css({"left":"0","opacity":0}).animate({opacity:1},options.actionTimer);//显示
			};
			i = c;
		};
		function prevAction(a,b,c){
			if(options.effect=="slide"){
				_li.eq(a).animate({ left:_wd+"px"},options.actionTimer);//隐藏
				_li.eq(b).css({"left":"-"+_wd+"px"}).animate({ left:"0"},options.actionTimer);//显示
			}else{
				_li.eq(a).css({"left":"-"+_wd+"px","opacity":0});//隐藏
				_li.eq(b).css({"left":"0","opacity":0}).animate({opacity:1},options.actionTimer);//显示
			};
			i = c;
		};
		function numClass(i){
			_num.eq(i).addClass("on").siblings().removeClass("on");
		};
		function autoPlay(){
			if(_timer){autoStop();};
			_timer=setInterval(function(){_this.children('.next').click();},options.timer)
		};
		function autoStop(){
			clearInterval(_timer);	
		};
	});
}; 
})(jQuery); 