$(document).ready(function() {

	$('#boardContent').summernote({
		placeholder : 'Write contents',
		height : 300,
		callbacks : {
			onImageUpload : function(files, editor, welEditable) {
				for (var i = files.length - 1; i >= 0; i--) {
					sendFile(files[i], this);
				}
			}
		},
		minHeight : null, // set minimum height of editor
		maxHeight : null, // set maximum height of editor
		focus : true, // 페이지가 열릴때 포커스를 지정함
		lang : 'ko-KR' // 한국어 지정(기본값은 en-US)
	});

})

function sendFile(file, editor) {
	var form_data = new FormData();
	form_data.append('file', file);
	$(".overlay").css("visibility", "visible");
	$.ajax({
		data : form_data,
		type : "POST",
		url : "/board/json/imageUpload",
		cache : false,
		contentType : false,
		enctype : 'multipart/form-data',
		processData : false,
		success : function(url) {
			console.log(JSON.stringify(url));
			console.log(url.url);
			$(".overlay").css("visibility", "hidden");
			$('#boardContent').summernote('editor.insertImage', url.url);

		}
	});
}

function fncAddBoard() {

	$("form").attr("method", "POST").attr("action", "/board/addBoard")
			.submit();
}

$(function() {
	$("button.btn.btn-primary:contains('제출')").on("click", function() {
		fncAddBoard();
	});
});

//=============    검색 / page 두가지 경우 모두  Event  처리 =============	
function fncGetList(currentPage) {
	$("#currentPage").val(currentPage)
	$("form").attr("method", "POST").attr("action",
			"/board/listBoard?orderby=").submit();
}

//============= "검색"  Event  처리 ===============================	
$(function() {
	$("button.btn.btn-secondary:contains('검색')").on("click", function() {
		fncGetList(1);
	});

	$(".newBoard").on("click", function() {
		self.location = "/board/listBoard?orderby=newBoard"
		
	});

	$(".oldBoard").on("click", function() {
		self.location = "/board/listBoard?orderby=oldBoard"
		
	});

	$(".boardCount").on("click", function() {
		self.location = "/board/listBoard?orderby=boardCount"
		
	});

	$("button.btn.btn-default:contains('글쓰기')").on("click", function() {
		self.location = "/board/addBoard"
	});


	$(".deleteBoard").on("click",function() {
		
				if (confirm("해당 공지사항을 삭제하시겠습니까?") == true) {
					self.location = "/board/deleteBoard?boardNo="
							+ $(this).attr("value");
				} else {
					return false;
				}

			});

	$(".getBoard").on("click", function() {

		self.location = "/board/countView?boardNo=" + $(this).attr("value")
	});
});

function fncUpdateBoard() {
	
	$("form").attr("method", "POST").attr("action", "/board/updateBoard")
			.submit();
}

$(function() {
	$("button.btn.btn-primary:contains('확인')").on("click", function() {
		
		alert("aa");
		fncUpdateBoard();
	});
	
});


	

$(function() {
	$("button.btn.btn-primary:contains('목록으로')").on("click", function() {
		self.location = "/board/listBoard?orderby="
	});
	
	$("button.btn.btn-primary:contains('수정')").on("click", function() {
		self.location = "/board/updateBoard?boardNo="+ $(this).attr("value")
	});
	
	$("#getEmployee").on("mouseover",function() {
		var employeeNo= $(this).attr("value")
		$.ajax(
				{
					url:"/employee/json/getEmployee/",
					method:"POST",
					data:{"employeeNo":employeeNo},
					success : function(data) {
						console.log(data)
						console.log(data.employee)
						var displayValue=
						"부서 : "+data.employee.departmentName
						+" 직급 : "+data.employee.positionName
						+" 사번 : "+data.employee.employeeNo
						+" 이름 : "+data.employee.employeeName
						+" 내선번호 : "+data.employee.extension;
						$("#getEmployee").attr("title",displayValue);
//						$("#getEmployee").tooltip()
					}
				});
	})

	
});

function print(printArea)
{
		win = window.open(); 
		self.focus(); 
		win.document.open();
		
		/*
			1. div 안의 모든 태그들을 innerHTML을 사용하여 매개변수로 받는다.
			2. window.open() 을 사용하여 새 팝업창을 띄운다.
			3. 열린 새 팝업창에 기본 <html><head><body>를 추가한다.
			4. <body> 안에 매개변수로 받은 printArea를 추가한다.
			5. window.print() 로 인쇄
			6. 인쇄 확인이 되면 팝업창은 자동으로 window.close()를 호출하여 닫힘
		*/
		win.document.write('<html><head><title></title><style>');
		win.document.write('body, td {font-falmily: Verdana; font-size: 10pt;}');
		win.document.write('</style></haed><body>');
		win.document.write(printArea);
 		win.document.write('</body></html>');
		win.document.close();
		win.print();
		win.close();
}



