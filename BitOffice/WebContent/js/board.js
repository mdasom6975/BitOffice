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
		focus : true, // �������� ������ ��Ŀ���� ������
		lang : 'ko-KR' // �ѱ��� ����(�⺻���� en-US)
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
	$("button.btn.btn-primary:contains('����')").on("click", function() {
		fncAddBoard();
	});
});

//=============    �˻� / page �ΰ��� ��� ���  Event  ó�� =============	
function fncGetList(currentPage) {
	$("#currentPage").val(currentPage)
	$("form").attr("method", "POST").attr("action",
			"/board/listBoard?orderby=").submit();
}

//============= "�˻�"  Event  ó�� ===============================	
$(function() {
	$("button.btn.btn-secondary:contains('�˻�')").on("click", function() {
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

	$("button.btn.btn-default:contains('�۾���')").on("click", function() {
		self.location = "/board/addBoard"
	});


	$(".deleteBoard").on("click",function() {
		
				if (confirm("�ش� ���������� �����Ͻðڽ��ϱ�?") == true) {
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
	$("button.btn.btn-primary:contains('Ȯ��')").on("click", function() {
		
		alert("aa");
		fncUpdateBoard();
	});
	
});


	

$(function() {
	$("button.btn.btn-primary:contains('�������')").on("click", function() {
		self.location = "/board/listBoard?orderby="
	});
	
	$("button.btn.btn-primary:contains('����')").on("click", function() {
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
						"�μ� : "+data.employee.departmentName
						+" ���� : "+data.employee.positionName
						+" ��� : "+data.employee.employeeNo
						+" �̸� : "+data.employee.employeeName
						+" ������ȣ : "+data.employee.extension;
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
			1. div ���� ��� �±׵��� innerHTML�� ����Ͽ� �Ű������� �޴´�.
			2. window.open() �� ����Ͽ� �� �˾�â�� ����.
			3. ���� �� �˾�â�� �⺻ <html><head><body>�� �߰��Ѵ�.
			4. <body> �ȿ� �Ű������� ���� printArea�� �߰��Ѵ�.
			5. window.print() �� �μ�
			6. �μ� Ȯ���� �Ǹ� �˾�â�� �ڵ����� window.close()�� ȣ���Ͽ� ����
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



