


$(function(){
//	getQNAList(1);
})

function getQNAList(nowPage){
	$.ajax({
		url : 'qna.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getListPaging',
			nowPage:nowPage
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.DataList;
			var pagingBean= data.result.pagingBean;
			if(dataList!= null){
				alert(dataList);
				var innerHtml = "";
				if(pagingBean.previousPageGroup){
					innerHtml += "<a href='javascript:;' onclick='getQNAList("+(pagingBean.startPageOfPageGroup - 1)+")'><<</a>";
				}
				for(var i=pagingBean.startPageOfPageGroup;i<=pagingBean.endPageOfPageGroup;i++){
					if(pagingBean.nowPage!=i)
						innerHtml += "<a href='javascript:;' onclick='getQNAList("+i+")'>"+" "+i+" "+"</a>";
					else
						innerHtml += "<a href='javascript:;' onclick='getQNAList("+i+")'><strong>"+" "+i+" "+"</strong></a>";
				}
				if(pagingBean.nextPageGroup){
					innerHtml += "<a href='javascript:;' onclick='getQNAList("+(pagingBean.endPageOfPageGroup + 1) +")'>>></a>";
				}
				document.getElementById("qna_paging_div").innerHTML = innerHtml;
				
				
				innerHtml = "";
				for(var i=0; i<dataList.length;i++){
					innerHtml += '<div style="color: blue" onclick="getQNAContent('+dataList[i].ID+')" ">'+dataList[i].subject+'</div>';
				}
				
				document.getElementById("qna_div").innerHTML = innerHtml;
				
			}
		},
		error: function(data){
			
		}
	});
}

function getQNAContent(id){
	alert(id);
	$.ajax({
		url : 'qna.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getContent',
			id:id
		},
		success : function(data) {
			var result = data.result;
			var qnaObject = result.QNAObject;
			document.getElementById("vq_id").innerHTML = qnaObject.ID;
			document.getElementById("vq_subject").innerHTML = qnaObject.subject;
			document.getElementById("vq_Content").innerHTML = qnaObject.Content;
			document.getElementById("vq_regid").innerHTML = qnaObject.regid;
			
			
			getReviewList(qnaObject.ID,1);
			
			$('#view_qna_modal').css('z-index', 3000);
			$('#view_qna_modal').modal();
		},
		error: function(data){
			
		}
	});
}

function newQNA(){
	$('#create_qna_modal').css('z-index', 3000);
	$('#create_qna_modal').modal();
}

function newQNASave(){
	$.ajax({
		url : 'qna.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'create',
			subject:$("#cq_subject").val(),
			Content:$("#cq_Content").val()
		},
		success : function(data) {
			var result = data.result;
			if(result.success == true){
				alert(result.msg);
				$('#create_qna_modal').modal('hide');
				getQNAList(1);
			}
		},
		error: function(data){
			
		}
	});
}

function getReviewList(qnaid,nowPage){
	$.ajax({
		url : 'qna.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getQNAReviewList',
			qnaid:qnaid,
			nowPage:nowPage,
		},
		success : function(data) {
			var result = data.result;
			var dataList = result.dataList;
			var innerHtml = "";
			for(var i=0; i < dataList.length; i++){
				innerHtml+='<div class="col-sm-12">';
				innerHtml+='<div class="col-sm-2">'+dataList[i].regid+'</div>';
				innerHtml+='<div class="col-sm-7">'+dataList[i].content+'</div>';
				innerHtml+='<div class="col-sm-2">'+dataList[i].writtenDate+'</div>';
				innerHtml+='<div class="col-sm-2"><button class="close" type="button" onclick="removeQNAReview('+dataList[i].ID+')">x</button></div>';
				innerHtml+='</div>';
			}
			document.getElementById("vq_review_list").innerHTML = innerHtml;
		},
		error: function(data){
			
		}
	});
}

function saveReview(){
	$.ajax({
		url : 'qna.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'createReview',
			qnaid:$("#vq_id").text(),
			content:$("#vq_crv_content").val()
		},
		success : function(data) {
			var result = data.result;
			if(result.success == true){
				alert(result.msg);
//				getReviewList(1);
			}
		},
		error: function(data){
			
		}
	});
}

function removeQNAReview(id){
	$.ajax({
		url : 'qna.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'deleteQNAReview',
			id:id,
		},
		success : function(data) {
			var result = data.result;
			if(result.success == true){
				alert(result.msg);
				getReviewList(1);
			}
		},
		error: function(data){
			
		}
	});
}
