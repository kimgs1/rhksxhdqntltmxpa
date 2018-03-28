
var userId;
var codeAllInfo;
var sessionVar;
var loginflag;
$(function(){
})

function logout(){
	location.href = "home.do?command=logout";
}

function imgBig(obj){
	var pos = obj.src.lastIndexOf("/")*1;
	window.open("./DownLoadImg/" + obj.src.substring(pos+1));
}
function menuClick(tagName){
	/*tagNum
	 *FBUL 공지사항 
	 *PTBI 관통부기본정보
	 *PTI  관통부정보
	 *PTISP 관통부점검정보
	 *PFEV 관통부성능평가정보
	 *SEAL 밀폐재정보
	 *CDMNG 코드관리
	 *PTISC 관통부정보 검색
	 *USMNG 사용자관리
	*/
	

	var page = $('#homeContentDiv');
	switch(tagName){
		case "FBUL":
			window.location.href = '/NPower/fbulletine';
//			moveToBulletineList();
			break;
		case "QNA":
			window.location.href = '/NPower/qna';
			break;	
		case "PTBI":
//			 page.load('views/penetrationbaseinfo.jsp');
			window.location.href = '/NPower/penetrationbaseinfo';
//			moveToPenetrationbaseinfoList();
			break;
		case "PTI":
			window.location.href = '/NPower/penetrationinfo';
//			moveToPenetrationbaseinfoList();
			break;
		case "PTISP":
			window.location.href = '/NPower/penetrationinspect';
			break;
		case "PFEV":
			window.location.href = '/NPower/performanceEvaluation';
			break;
		case "CDMNG":
			window.location.href = '/NPower/codeManage';
			break;	
		case "SEAL":
			window.location.href = '/NPower/sealantinfo';
			break;	
		case "PTISC":
			window.location.href = '/NPower/penetrationsearch';
			break;	
		case "USMNG":
			window.location.href = '/NPower/usermanage';
			break;	
		case "CNT":
			window.location.href = '/NPower/contentinfo';
			break;	
		default:
			break;
	
	}
}

function getCodeAllInfo(){
	$.ajax({
		url : 'home.do',
		type : 'post',
		dataType : 'json',
		async: false,
		data : {
			command:"getCodeAllInfo"
		},
		success : function(data) {
			codeAllInfo = data.result;
		},
		error: function(data){
		}
	});
}

function tagBind(tagType,colName,tagName,value,valueList){
	if(tagType == "radio"){
		var tag=$("#"+colName+"_tag");
		var innerHtml = "<label>"+tagName+"</label>";
		var checkFlag = false;
		for(var i=0;i<valueList.length;i++){
			if((value == null || value == valueList[i].CodeID) && checkFlag!=true){
				innerHtml += '<input type="radio" id="'+colName+'"name="'+colName+'" value="'+valueList[i].CodeID+'" checked/><label>'+valueList[i].CodeName+'</label>';
				checkFlag = true;
			}
			else{
				innerHtml += '<input type="radio" id="'+colName+'"name="'+colName+'" value="'+valueList[i].CodeID+'"/><label>'+valueList[i].CodeName+'</label>';
			}
		}
		document.getElementById(colName+"_tag").innerHTML = innerHtml;
	}
	if(tagType == "selectBox"){
		var tag=$("#"+colName+"_tag");
		var innerHtml = "<label>"+tagName+"</label>";
		innerHtml += '<select id="'+colName+'">';
		
		var checkFlag = false;
		for(var i=0;i<valueList.length;i++){ 
			if(value == valueList[i].CodeID){
				innerHtml +='<option value="'+valueList[i].CodeID+'" selected>'+valueList[i].CodeName+'</option>';
			}else{
				innerHtml +='<option value="'+valueList[i].CodeID+'">'+valueList[i].CodeName+'</option>';
			}
		}
		innerHtml += '</select>';
		document.getElementById(colName+"_tag").innerHTML = innerHtml;
	}
	
	if(tagType == "selectBox_All"){
		var tag=$("#"+colName+"_tag");
		var innerHtml = "<label>"+tagName+"</label>";
		innerHtml += '<select id="'+colName+'">';
		
		var checkFlag = false;
		innerHtml +='<option value="" selected>'+'전체'+'</option>';
		for(var i=0;i<valueList.length;i++){ 
			if(value == valueList[i].CodeID){
				innerHtml +='<option value="'+valueList[i].CodeID+'" selected>'+valueList[i].CodeName+'</option>';
			}else{
				innerHtml +='<option value="'+valueList[i].CodeID+'">'+valueList[i].CodeName+'</option>';
			}
		}
		innerHtml += '</select>';
		document.getElementById(colName+"_tag").innerHTML = innerHtml;
	}
	
	if(tagType == "checkBoxMulti"){
		var tag=$("#"+colName+"_tag");
		var innerHtml ="<label>"+tagName+"</label>"+ "<ol>" ;
		var checkFlag = false;
		for(var i=0;i<valueList.length;i++){
			innerHtml +='<li><input  type="checkbox" name="'+colName+'" value="'+valueList[i].CodeID+'">'+valueList[i].CodeName+'</option></li>';
		}
		innerHtml += '</ol>';
		document.getElementById(colName+"_tag").innerHTML = innerHtml;
	}
}

function getRadioValueByTagName(tagName){  
    // method 1   
    var radio = document.getElementsByName(tagName);  
    for (i=0; i<radio.length; i++) {  
        if (radio[i].checked) {  
            return radio[i].value;  
        }  
    }  
} 
function getCheckBoxValueByTagname(tagName){
	var test = $("input[name='"+tagName+"']:checked");  
    var checkBoxValue = "";   
    test.each(function(){  
        checkBoxValue += "'" + $(this).val()+"',";  
    })  
    checkBoxValue = checkBoxValue.substring(0,checkBoxValue.length-1); 
    return checkBoxValue;
}




function HashMap() {  
  var size = 0;  
  var entry = new Object();  
    
  this.put = function (key, value) {  
      entry[key] = value;  
      size++;  
  };  
    
  this.putAll = function (map) {  
      if (typeof map == "object" && !map.sort) {  
          for (var key in map) {  
              this.put(key, map[key]);  
          }  
      } else {  
          throw "입력이 정확하지 않습니다. 입력데이터는 무조건 HashMap타입이 되어야 합니다.";  
      }  
  };  
    
  this.get = function (key) {  
      return entry[key];  
  };  
    
  this.remove = function (key) {  
      if (size == 0)  
          return;  
      delete entry[key];  
      size--;  
  };  
    
  this.containsKey = function (key) {  
      if (entry[key]) {  
          return true;  
      }  
      return false;  
  };  
    
  this.containsValue = function (value) {  
      for (var key in entry) {  
          if (entry[key] == value) {  
              return true;  
          }  
      }  
      return false;  
  };  
    
  this.clear = function () {  
      entry = new Object();  
      size = 0;  
  };  
    
  this.isEmpty = function () {  
      return size == 0;  
  };  
    
  this.size = function () {  
      return size;  
  };  
    
  this.keySet = function () {  
      var keys = new Array();  
      for (var key in entry) {  
          keys.push(key);  
      }  
      return keys;  
  };  
    
  this.entrySet = function () {  
      var entrys = new Array();  
      for (var key in entry) {  
          var et = new Object();  
          et[key] = entry[key];  
          entrys.push(et);  
      }  
      return entrys;  
  };  
    
  this.values = function () {  
      var values = new Array();  
      for (var key in entry) {  
          values.push(entry[key]);  
      }  
      return values;  
  };  
    
  this.each = function (cb) {  
      for (var key in entry) {  
          cb.call(this, key, entry[key]);  
      }  
  };  
    
  this.toString = function () {  
      return obj2str(entry);  
  };  
    
  function obj2str(o) {  
      var r = [];  
      if (typeof o == "string")  
          return "\"" + o.replace(/([\'\"\\])/g, "\\$1").replace(/(\n)/g, "\\n").replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\"";  
      if (typeof o == "object") {  
          for (var i in o)  
              r.push("\"" + i + "\":" + obj2str(o[i]));  
          if (!!document.all && !/^\n?function\s*toString\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString)) {  
              r.push("toString:" + o.toString.toString());  
          }  
          r = "{" + r.join() + "}";  
          return r;  
      }  
      return o.toString();  
  }  
}  

function clearNoNum_2(obj) {     
	obj.value = obj.value.replace(/[^\d.]/g,""); //清除"数字"和"."以外的字符  
	obj.value = obj.value.replace(/^\./g,""); //验证第一个字符是数字而不是  
	obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的  
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");  
	obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'); //只能输入两个小数 
}  


function OpenPdfFiles(fileName){

	window.open("./PDFFiles/" + fileName);
}

