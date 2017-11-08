function getStyle(obj,attr){
	if(obj.currentStyle){
		return obj.currentStyle[attr];
	}
	else{
		return getComputedStyle(obj,false)[attr];
	}
}
function startMove(obj,json,fn){
	clearInterval(obj.timer);

	obj.timer=setInterval(function(){
		var bStop=true; //这一次运动结束——所有值都到达了
		for(attr in json){
			//1、取当前值
			var iCur=0;
			if(attr=='opacity'){
				iCur=parseFloat(getStyle(obj,attr))*100;
			}
			else{
				iCur=parseInt(getStyle(obj,attr));
			}

			//2、算速度
			var iSpeed=0;
			iSpeed=(json[attr]-iCur)/8;
			iSpeed=iSpeed>0?Math.ceil(iSpeed):Math.floor(iSpeed);

			//3、检测停止
			if(iCur!=json[attr]){
				bStop=false;  //有一个没到达，则bStop为false
			}
			if(attr=='opacity'){
				obj.style.filter='alpha(opacity:'+(iCur+iSpeed)+')';
				obj.style.opacity=(iCur+iSpeed)/100;
			}
			else{
				obj.style[attr]=iCur+iSpeed+'px';
			}
				
		}
		if(bStop){  //所有的都到达了，则关闭定时器
			clearInterval(obj.timer);
			if(fn){
				fn();
			}
		}
	},30)
}