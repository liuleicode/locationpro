
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
		<meta charset="utf-8"/>
		<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<title>评价</title>
		<link rel="stylesheet" href="/css/evalution.css" type="text/css"></link>
		<script type="text/javascript" src="/js/jquery-2.0.0.min.js"></script>
		
</head>
	
	<body>
		<!--头部  star-->
		<header>
			<a href="javascript:history.go(-1);">
				<div class="_left"><img src="/images/left.png"/></div>
				   评价
			</a>
		</header>
		<!--头部 end-->
        <!--内容 star-->
		<div class="contaniner fixed-cont">
            <input type="hidden" th:value="${localnum}"/>
			<!--1-->
			<section class="assess">
				<p>
					<textarea rows="7" placeholder="请写下对这个地方的感受吧，对他人帮助很大哦～～"></textarea>
				</p>
				<ul>
					<li>评价</li>
					<li class="assess-right">
						<div><input type="radio" name="radio" value="radio1"></input><img src="/images/hua.png" /></div>
						<div><input type="radio" name="radio" value="radio2"></input><img src="/images/huah.png" /></div>
						<div><input type="radio" name="radio" value="radio3"></input><img src="/images/huae.png"  /></div>
					</li>
				</ul>
			</section>
			<!--2-->
			<section class="main">
			<div class="main-wrap">
				<span class="revtit">综合评分:</span>
				<div id="mydiv1" currentindex="4" class="mydiv">
	    			<ul class="star_ul">
				        <li num="1"><img src="/images/star_full.png" class="xing_hui"/></li>
				        <li num="2"><img src="/images/star_full.png" class="xing_hui"/></li>
				        <li num="3"><img src="/images/star_full.png" class="xing_hui"/></li>
				        <li num="4"><img src="/images/star_full.png" class="xing_hui"/></li>
				        <li num="5"><img src="/images/star_empty.png" class="xing_hui"/></li>
			   		</ul>
				</div>
			</div>
			
			<div class="main-wrap">
				<span class="revtit">&nbsp;&nbsp;   环   境:</span>
				<div id="mydiv2" currentindex="4" class="mydiv">
	    			<ul class="star_ul">
						<li num="1"><img src="/images/star_full.png" class="xing_hui"/>  </li>
				        <li num="2"><img src="/images/star_full.png" class="xing_hui"/></li>
				        <li num="3"><img src="/images/star_full.png" class="xing_hui"/></li>
				        <li num="4"><img src="/images/star_full.png" class="xing_hui"/></li>
				        <li num="5"><img src="/images/star_empty.png" class="xing_hui"/></li>
			   		</ul>
				</div>
			</div>
		
			<div class="main-wrap">
				<span class="revtit">&nbsp;&nbsp;   风   貌:</span>
				<div id="mydiv3" currentindex="4" class="mydiv">
	    			<ul class="star_ul">
				        <li num="1"><img src="/images/star_full.png" class="xing_hui"/></li>
				        <li num="2"><img src="/images/star_full.png" class="xing_hui"/></li>
				        <li num="3"><img src="/images/star_full.png" class="xing_hui"/></li>
				        <li num="4"><img src="/images/star_full.png" class="xing_hui"/></li>
				        <li num="5"><img src="/images/star_empty.png" class="xing_hui"/></li>
			   		</ul>
				</div>
			</div>
	</section>
		</div>
		<!--内容 end-->
        
        <!--底部 star-->
		<footer class="assess-footer fixed-footer ">
			<ul>
				<li>
					<input type="checkbox" id="ass"  ></input>
					<label for="ass" onselectstart="return false">匿名评价</label>
				</li>
				<input type="button" value="发表评论" ></input>
			</ul>
		</footer>
       <!--底部  end-->

</body>
<script type="text/javascript">
    $(".assess-footer ul li label").on('touchstart',function(){
        if($(this).hasClass('assd')){
            $(".assess-footer ul li label").removeClass("assd")
        }else{
            $(".assess-footer ul li label").addClass("assd")
        };
    });


    //匿名评价
    var isclick = false;
    function change(mydivid,number) {
        var num=number;
        if (isclick) {
        } else {
            var divuli = mydivid + " ul li";
            var tds = $("#" + divuli);

            for (var i = 0; num > i ; i++) {
                var td = tds[i];
                $(td).find("img").attr("src", "/images/star_full.png");
            }
            var tindex = $("#" + mydivid).attr("currentIndex");
            tindex = tindex == 0 ? 0 : tindex + 1;
            for (var j = num; tindex > j; j++) {
                var td = tds[j];
                $(td).find("img").attr("src", "/images/star_empty.png");
            }
            $("#" + mydivid).attr("currentIndex", num);
        }
    };
    function repeal(mydivid,num) {
        if (!isclick) {
            var divuli=mydivid+" ul li";
            var tds = $("#"+divuli);
            var tindex = $("#"+mydivid).attr("currentIndex");
            tindex = tindex != 0 ? tindex + 1 : 0;
            for (var i = tindex; num > i; i++) {
                var td = tds[i];
                $(td).find("img").attr("src","/images/star_empty.png");
            }
            $("#"+mydivid).attr("currentIndex",num);
        }
    }
    function change1(mydivid,num) {
        if (!isclick) {
            change(mydivid,num);

        }
        else {
            alert("Sorry,You had clicked me!");
        }
    }
    $(function(){
        initEvent('mydiv1');
        initEvent('mydiv2');
        initEvent('mydiv3');
    });
    function initEvent(mydivid) {
        var divuli=mydivid+" ul li";
        var tds = $("#" + divuli);
        for (var i = 0; tds.length > i; i++) {
            var td = tds[i];
            $(td).on('mouseover',function(){var num = $(this).attr("num");change(mydivid,num);});
            $(td).on('click',function(){var num = $(this).attr("num");change1(mydivid,num);});
        }
    }
</script>
</html>