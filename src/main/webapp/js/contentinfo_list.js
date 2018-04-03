


$(function(){
	getContentInfoList(1);
})

function getContentInfoList(nowPage){
	$.ajax({
		url : 'contentinfo.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getListPaging',
			nowPage:nowPage
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.dataList;
			var pagingBean= data.result.pagingBean;
			if(dataList.length>0){
				var innerHtml = "";
				
				innerHtml +=  '<tr>';
				innerHtml +=  '<th style="width:10%;">번호</th>';
				innerHtml +=  '<th style="width:50%;">제목</th>';
				innerHtml +=  '<th style="width:10%;">작성자</th>';
				innerHtml +=  '<th style="width:20%;">작성일자</th>';
				innerHtml +=  '<th style="width:10%;">조회</th>';
				innerHtml +=  '</tr>';

				for(var i=0; i<dataList.length;i++){
					innerHtml +=  '<tr onclick="getContentInfoContent('+dataList[i].id+')" >';
					innerHtml += '<td>'+dataList[i].id+'</td>';
					innerHtml += '<td>'+dataList[i].subject+'</td>';
					innerHtml += '<td>'+dataList[i].RegID+'</td>';
					innerHtml += '<td>'+dataList[i].RegDateTime+'</td>';
					innerHtml += '<td>'+dataList[i].ViewCount+'</td>';
					innerHtml +=  '</tr>';

				}
				
				document.getElementById("contentinfo_div").innerHTML = innerHtml;
				
				//paging
				innerHtml = "";
				
				if(pagingBean.previousPageGroup){
					innerHtml += '<li onclick="getContentInfoList('+(pagingBean.startPageOfPageGroup - 1)+')"><a><img src="images/bnBtn_prev.gif" /></a></li>';
//					innerHtml += "<a href='javascript:;' onclick='getBulletineList("+(pagingBean.startPageOfPageGroup - 1)+")'><<</a>";
				}
				for(var i=pagingBean.startPageOfPageGroup;i<=pagingBean.endPageOfPageGroup;i++){
					if(pagingBean.nowPage!=i)
						innerHtml += '<li onclick="getContentInfoList('+i+')"><a>'+i+'</a></li>'
					else
						innerHtml += '<li onclick="getContentInfoList('+i+')"><a class="active">'+i+'</a></li>'
				}
				if(pagingBean.nextPageGroup){
					innerHtml += '<li onclick="getContentInfoList('+(pagingBean.endPageOfPageGroup + 1)+')"><a style="transform: rotate(180deg)"><img src="images/bnBtn_prev.gif" /></a></li>';
				}
				
				document.getElementById("board_list_page_div").innerHTML = innerHtml;
				
			}
		},
		error: function(data){
			
		}
	});
}

function getContentInfoContent(id){
	window.location.href = '/NPower/contentinfo_content?id='+id;
}

function newContentInfo(){
	window.location.href = '/NPower/contentinfo_create';
}
