
$(function(){
})

function newContentInfoEditSave(){
	$.ajax({
		url : 'contentinfo.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'edit',
			id:$("#id").val(),
			subject:$("#subject").val(),
			Contents:$("#Contents").val(),
			FileName:$("#uploadFileName").val()
		},
		success : function(data) {
			var result = data.result;
			if(result.success == true){
				alert(result.msg);
				window.location.href = '/NPower/contentinfo';
//				$('#create_bulletine_modal').modal('hide');
//				getBulletineList(1);
			}
		},
		error: function(data){
			
		}
	});
}

function UploadFileFunc(obj){

 	var pos = obj.value.lastIndexOf("\\")*1;
	$("#uploadFileName").val(obj.value.substring(pos+1));
	
    var formData = new FormData($( "#FileUploadForm" )[0]);  
    var ajaxUrl = "uploadContentFile";
    
    var str = document.getElementById("uploadFile").value;
    if(str.length == 0){
    	return;
    }
    //alert(ajaxUrl);
    //$('#uploadPic').serialize() 无法序列化二进制文件，这里采用formData上传
    //需要浏览器支持：Chrome 7+、Firefox 4+、IE 10+、Opera 12+、Safari 5+。
    $.ajax({
        type: "POST",
        //dataType: "text",
        url: ajaxUrl,
        data: formData,
        async: false,  
        cache: false,  
        contentType: false,  
        processData: false,
        success: function (data) {
        	alert("파일을 성공적으로 올렸습니다.");
        	$("#uploadFileName").val(data);
        },
        error: function(data) {
            alert("파일을 올리는데 실패하였습니다.");

         }
    });
    return false;
}
