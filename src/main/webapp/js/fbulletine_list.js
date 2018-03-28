


$(function(){
	getBulletineList(1);
})

function getBulletineList(nowPage){
	$.ajax({
		url : 'fbulletine.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getListPaging',
			nowPage:nowPage
		},
		success : function(data) {
			var result = data.result;
			var fbList = data.result.FBList;
			var pagingBean= data.result.pagingBean;
			if(fbList!= null){
				var innerHtml = "";
				
				innerHtml +=  '<tr>';
				innerHtml +=  '<th style="width:10%;">번호</th>';
				innerHtml +=  '<th style="width:50%;">제목</th>';
				innerHtml +=  '<th style="width:10%;">작성자</th>';
				innerHtml +=  '<th style="width:20%;">작성일자</th>';
				innerHtml +=  '<th style="width:10%;">조회</th>';
				innerHtml +=  '</tr>';

				for(var i=0; i<fbList.length;i++){
					innerHtml +=  '<tr onclick="getBulletineContent('+fbList[i].id+')" >';
					innerHtml += '<td>'+fbList[i].id+'</td>';
					innerHtml += '<td>'+fbList[i].title+'</td>';
					innerHtml += '<td>'+fbList[i].regid+'</td>';
					innerHtml += '<td>'+fbList[i].RegDateTime+'</td>';
					innerHtml += '<td>'+fbList[i].cnt+'</td>';
					innerHtml +=  '</tr>';

				}
				
				document.getElementById("bulletine_div").innerHTML = innerHtml;
				
				//paging
				innerHtml = "";
				
				if(pagingBean.previousPageGroup){
					innerHtml += '<li onclick="getBulletineList('+(pagingBean.startPageOfPageGroup - 1)+')"><a><img src="images/pager_01.png" /></a></li>';
//					innerHtml += "<a href='javascript:;' onclick='getBulletineList("+(pagingBean.startPageOfPageGroup - 1)+")'><<</a>";
				}
				for(var i=pagingBean.startPageOfPageGroup;i<=pagingBean.endPageOfPageGroup;i++){
					if(pagingBean.nowPage!=i)
						innerHtml += '<li onclick="getBulletineList('+i+')"><a>'+i+'</a></li>'
					else
						innerHtml += '<li onclick="getBulletineList('+i+')"><a class="active">'+i+'</a></li>'
				}
				if(pagingBean.nextPageGroup){
					innerHtml += '<li onclick="getBulletineList('+(pagingBean.endPageOfPageGroup + 1)+')"><a style="transform: rotate(180deg)"><img src="images/pager_01.png" /></a></li>';
				}
				
				document.getElementById("board_list_page_div").innerHTML = innerHtml;
				
			}
		},
		error: function(data){
			
		}
	});
}

function getBulletineContent(id){

	window.location.href = '/NPower/fbulletine_content?id='+id;
//	alert(id);
//	$.ajax({
//		url : 'fbulletine.do',
//		type : 'post',
//		dataType : 'json',
//		data : {
//			command:'getContent',
//			id:id
//		},
//		success : function(data) {
//			var result = data.result;
//			var fb = result.FB;
//			document.getElementById("vb_title").innerHTML = fb.title;
//			document.getElementById("vb_content").innerHTML = fb.contents;
//			$('#view_bulletine_modal').css('z-index', 3000);
//			$('#view_bulletine_modal').modal();
//		},
//		error: function(data){
//			
//		}
//	});
}

function newBulletine(){
	window.location.href = '/NPower/fbulletine_create';
}

//function newBulletineSave(){
//	$.ajax({
//		url : 'fbulletine.do',
//		type : 'post',
//		dataType : 'json',
//		data : {
//			command:'create',
//			title:$("#cb_title").val(),
//			contents:$("#cb_contents").val()
//		},
//		success : function(data) {
//			var result = data.result;
//			if(result.success == true){
//				alert(result.msg);
//				$('#create_bulletine_modal').modal('hide');
//				getBulletineList(1);
//			}
//		},
//		error: function(data){
//			
//		}
//	});
//
//}