<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
.myButton {
	-moz-box-shadow:inset 0px 1px 3px 0px #91b8b3;
	-webkit-box-shadow:inset 0px 1px 3px 0px #91b8b3;
	box-shadow:inset 0px 1px 3px 0px #91b8b3;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #768d87), color-stop(1, #6c7c7c));
	background:-moz-linear-gradient(top, #768d87 5%, #6c7c7c 100%);
	background:-webkit-linear-gradient(top, #768d87 5%, #6c7c7c 100%);
	background:-o-linear-gradient(top, #768d87 5%, #6c7c7c 100%);
	background:-ms-linear-gradient(top, #768d87 5%, #6c7c7c 100%);
	background:linear-gradient(to bottom, #768d87 5%, #6c7c7c 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#768d87', endColorstr='#6c7c7c',GradientType=0);
	background-color:#768d87;
	-moz-border-radius:5px;
	-webkit-border-radius:5px;
	border-radius:5px;
	border:1px solid #566963;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:15px;
	font-weight:bold;
	padding:5px 15px;
	text-decoration:none;
	text-shadow:0px -1px 0px #2b665e;
}
.myButton:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #6c7c7c), color-stop(1, #768d87));
	background:-moz-linear-gradient(top, #6c7c7c 5%, #768d87 100%);
	background:-webkit-linear-gradient(top, #6c7c7c 5%, #768d87 100%);
	background:-o-linear-gradient(top, #6c7c7c 5%, #768d87 100%);
	background:-ms-linear-gradient(top, #6c7c7c 5%, #768d87 100%);
	background:linear-gradient(to bottom, #6c7c7c 5%, #768d87 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#6c7c7c', endColorstr='#768d87',GradientType=0);
	background-color:#6c7c7c;
}
.myButton:active {
	position:relative;
	top:1px;
}

.myButton1 {
	-moz-box-shadow:inset 0px 1px 3px 0px #3dc21b;
	-webkit-box-shadow:inset 0px 1px 3px 0px #3dc21b;
	box-shadow:inset 0px 1px 3px 0px #3dc21b;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #44c767), color-stop(1, #2c7d00));
	background:-moz-linear-gradient(top, #44c767 5%, #2c7d00 100%);
	background:-webkit-linear-gradient(top, #44c767 5%, #2c7d00 100%);
	background:-o-linear-gradient(top, #44c767 5%, #2c7d00 100%);
	background:-ms-linear-gradient(top, #44c767 5%, #2c7d00 100%);
	background:linear-gradient(to bottom, #44c767 5%, #2c7d00 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#44c767', endColorstr='#2c7d00',GradientType=0);
	background-color:#44c767;
	-moz-border-radius:5px;
	-webkit-border-radius:5px;
	border-radius:5px;
	border:1px solid #18ab29;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:12px;
	font-weight:bold;
	padding:5px 15px;
	text-decoration:none;
	text-shadow:0px -1px 0px #2f6627;
}

.myButton1:active {
	position:relative;
	top:1px;
}


.myButton2 {
	-moz-box-shadow:inset 0px 1px 3px 0px #9fb4f2;
	-webkit-box-shadow:inset 0px 1px 3px 0px #9fb4f2;
	box-shadow:inset 0px 1px 3px 0px #9fb4f2;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #7892c2), color-stop(1, #476e9e));
	background:-moz-linear-gradient(top, #7892c2 5%, #476e9e 100%);
	background:-webkit-linear-gradient(top, #7892c2 5%, #476e9e 100%);
	background:-o-linear-gradient(top, #7892c2 5%, #476e9e 100%);
	background:-ms-linear-gradient(top, #7892c2 5%, #476e9e 100%);
	background:linear-gradient(to bottom, #7892c2 5%, #476e9e 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#7892c2', endColorstr='#476e9e',GradientType=0);
	background-color:#7892c2;
	-moz-border-radius:5px;
	-webkit-border-radius:5px;
	border-radius:5px;
	border:1px solid #4e6096;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:12px;
	font-weight:bold;
	padding:5px 15px;
	text-decoration:none;
	text-shadow:0px -1px 0px #283966;
}

.myButton2:active {
	position:relative;
	top:1px;
}


.myButton3 {
	-moz-box-shadow:inset 0px 1px 3px 0px #f7c5c0;
	-webkit-box-shadow:inset 0px 1px 3px 0px #f7c5c0;
	box-shadow:inset 0px 1px 3px 0px #f7c5c0;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #870900), color-stop(1, #e4685d));
	background:-moz-linear-gradient(top, #870900 5%, #e4685d 100%);
	background:-webkit-linear-gradient(top, #870900 5%, #e4685d 100%);
	background:-o-linear-gradient(top, #870900 5%, #e4685d 100%);
	background:-ms-linear-gradient(top, #870900 5%, #e4685d 100%);
	background:linear-gradient(to bottom, #870900 5%, #e4685d 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#870900', endColorstr='#e4685d',GradientType=0);
	background-color:#870900;
	-moz-border-radius:5px;
	-webkit-border-radius:5px;
	border-radius:5px;
	border:1px solid #d83526;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:12px;
	font-weight:bold;
	padding:5px 15px;
	text-decoration:none;
	text-shadow:0px -1px 0px #b23e35;
}

.myButton3:active {
	position:relative;
	top:1px;
}

table.space{ border-collapse: collapse; }
table.space tr td { padding: 10px;}


/* 여기서 부터 시작 */
/* top menu */

#topMenu .fixed {position:fixed; margin:0 auto; top:0px; clear:both; height:45px; border-top:1px solid #373635; border-bottom:1px solid #373635; width:100%; background:url(./images/bg_navi.gif) center repeat ; z-index:99999;} 
/* 메뉴고정 */
#topMenu {position:fixed; margin:0 auto; top:50px; clear:both; width:calc(100% - 300px); min-width:1180px; height:40px; border-top:1px solid #373635; border-bottom:1px solid #373635; background:url(./images/bg_navi1.gif) center repeat ; z-index:99999;}

#topMenu .nav1 {width:100%; min-width:1180px; margin:0 auto;  text-align:center ;position: relative;  height:44px;}
#topMenu .navBox {width:100%; text-transform: uppercase; position: relative; margin:0 auto; min-width:1180px;}

#topMenu:hover .navSub_Box {display:block; opacity:1; filter:alpha(opacity=100)}
/*
#topMenu .nav1 :hover .navSub_Box {display:block; opacity:0; filter:alpha(opacity=100)}
*/
#topMenu .nav1 > ul {text-align:left; font-size:0;}

 /* 1230 전체크기 */

#topMenu .nav1 > ul > li { width:130px; display:inline-block; *display:inline; text-align:center; border-left: 1px solid #373635;  }
#topMenu .nav1 > ul > li.mmenu11 {border-right: 1px solid #373635;}
#topMenu .nav1 > ul > li  a { color:#ddd; line-height:44x; display:block;  font-family:'Yoon Gothic', 'Open Sans', 'malgun gothic','Nanum Gothic'; font-size:12px; letter-spacing: -1px; font-weight:normal; text-decoration:none;}
#topMenu .nav1 > ul > li  a:hover {color:#caac7d; line-height:44px;}

.navSub_Box {width:100%; text-align: left; display:none; clear:both; position: absolute; left: 0; z-index: 1; overflow: hidden; border-top:1px solid #AEAEAE; color:#222; padding:10px 0 20px 0;  background:url(./images/navi_bg.png) repeat-x left bottom;
            opacity:0; filter:alpha(opacity=0); transition:opacity .5s ease-out;}

.navSub { width:100%; margin:0 auto;}
.navSub .all_box {width:100%;}
.navSub .all_box li { float:left; width:125px; border-right:0px solid #DCDCDC; height:150px; text-align:center; border:0px solid #000;}

.navSub .all_box .all_m01 a { float:left; width:125px; color:#555;  font-family:'Yoon Gothic', 'Open Sans', 'malgun gothic','Nanum Gothic'; font-size:12px; letter-spacing: -1px; font-weight:normal;}
.navSub .all_box .all_m01 a { color:#777; text-decoration:none;}
.navSub .all_box .all_m01 a:hover { color:#000; text-decoration:underline;}
.navSub .all_box .all_m01 p { padding:13px; }

.navSub .all_box .all_m02 a { color:#666;  font-family:'Yoon Gothic', 'Open Sans', 'malgun gothic','NanumGothic'; font-size:12px; letter-spacing: -1px; font-weight:normal; text-transform:capitalize;}
.navSub .all_box .all_m02 a { color:#999; text-decoration:none;}
.navSub .all_box .all_m02 a:hover { color:#000; text-decoration:underline;}
.navSub .all_box .all_m02 p { padding:13px; }
/* top menu */

</style>

<!-- link href="css/import.css" rel="stylesheet" /-->

<style>
.body_color_top {
background: #c1d4f1; /* Old browsers */
background: -moz-linear-gradient(top, #c1d4f1 100%, #ffffff 0%); /* FF3.6+ */
background: -webkit-gradient(linear, left top, left bottom, color-stop(100%,#c1d4f1), color-stop(0%,#ffffff)); /* Chrome,Safari4+ */
background: -webkit-linear-gradient(top, #c1d4f1 100%,#ffffff 0%); /* Chrome10+,Safari5.1+ */
background: -o-linear-gradient(top, #c1d4f1 100%,#ffffff 0%); /* Opera11.10+ */
background: -ms-linear-gradient(top, #c1d4f1 100%,#ffffff 0%); /* IE10+ */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#c1d4f1',GradientType=0 ); /* IE6-9 */
background: linear-gradient(top, #c1d4f1 100%,#ffffff 0%); /* W3C */
font-family:Arial, Helvetica, sans-serif;
font-size:14px;
color:#000;
}
</style>


<div class=body_color_top>

<table class=space border="0" width="100%">
<td align="right" valign="top">

<b><font size=2 color=3f3f9f>관리자</font><font size=2>님의 입장을 환영 합니다.</font></b>

<input type=button value="로그인" onClick="parent.location='/NPower/'" class=myButton2>

<!--
<input type=button value="로그아웃" onClick="parent.location='/NPower/'" class=myButton>
-->
<!--
<input type=button value="정보수정" onclick="parent.location='/NPower/'" class=myButton2>
<input type=button value="환경설정" onClick="parent.location='/NPower/'" class=myButton3>
 -->
</td>
</table>
</div>
     
<!-------------------------- 카테고리메뉴시작 ----------------------->
    <script>
        $(document).ready(function () {
            $(".tab_content").hide();
            $(".tab_content:first").show();

            $(".tabs li").click(function () {
                $(".tabs li").removeClass("active");
                $(this).addClass("active");
                $(".tab_content").hide();
                var activeTab = $(this).attr("rel");
                $("#" + activeTab).fadeIn();
            });
        });       
        $(document).ready(function () {
            $(".tab_content2").hide();
            $(".tab_content2:first").show();

            $(".tabs2 li").click(function () {
                $(".tabs2 li").removeClass("active");
                $(this).addClass("active");
                $(".tab_content2").hide();
                var activeTab = $(this).attr("rel");
                $("#" + activeTab).fadeIn();
            });
        });
    </script><!--탭스크립트-->


<script>
(function($) {

$(function(){
	$('.nav1 ul').hover(
		function () {
			//show its submenu
			$('.navSub_Box', this).slideDown(200);
		}, 
		function () {
			//hide its submenu
			$('.navSub_Box', this).slideUp(200);			
		}
	);
});

})(jQuery);

</script>


<div id="topMenu">
<div class="navBox">
<div class="nav1">

<ul>
<li><a href="/NPower/"><img src=./images/m_1.gif border=0 valign=middle></a></li>
<li><img src=./images/m_2.gif border=0></li>
<li><img src=./images/m_3.gif border=0></li>
<li><img src=./images/m_4.gif border=0></li>
<li class="mmenu11"><a href="#"><img src=./images/m_5.gif border=0></li>

<div class="navSub_Box">
<div class="navSub">
<div class="all_box">
<ul>

<!--------- 표기 ------------->

<li>
<div class="all_m01"><!-- Home side link null -->
</div>
</li>


<li>
<div class="all_m01">
<p><a href="adm01.html">관통부검색</a></p>
<p><a href="adm01.html">기본정보</a></p>
<p><a href="adm02.html">밀폐재정보</a></p>
<p><a href="adm03.html">관통재정보</a></p>
<p><a href="adm04.html">성능평가</a></p>
<p><a href="adm05.html">관통부점검</a></p>
</div>
</li>

<li>
<div class="all_m01">
<p><a href="#">관련문서</a></p>
<p><a href="#">업데이트 공유프로그램</a></p>
</div>
</li>

<li>
<div class="all_m01">
<p><a href="#">공지사항</a></p>
<p><a href="#">Q&amp;A</a></p>
</div>
</li>

<li>
<div class="all_m01">
<p><a href="#">사용자관리</a></p>
<p><a href="#">코드관리</a></p>
</div>
</li>

<!--------- 표기 ------------->

</ul>
</div> <!-- all_box -->
</div> <!-- navSub -->
</div> <!-- navSub_Box -->

<!-- //전체메뉴 -->
</ul>

</div><!-- #nav1 -->
</div><!-- #navBox -->
</div><!-- #topMenu -->

<!------------ //카테고리메뉴끝 ----------->


<div>
<br><br><br><br>
</div>




