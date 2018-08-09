$(document).ready(function() {
	
	// �μ� select box ������ ����
	$.ajax({
		url : "/department/json/getAllDepartment",
		method : "GET",
		datatype : "json",
		headers : {
			"Accept" : "application/json",
			"Content-Type" : "application/json"

		},
		success : function(data) {

			console.log(data)

			for (var i = 0; i < data.department.length; i++) {
				$("#departmentNo").append(
						$('<option value='
								+ data.department[i].departmentNo + '>'
								+ data.department[i].departmentName
								+ '</option>'));
			}
		}
	});

	// ���� select box ������ ����
	$.ajax({
		url : "/position/json/getAllPosition",
		method : "GET",
		datatype : "json",
		headers : {
			"Accept" : "application/json",
			"Content-Type" : "application/json"

		},
		success : function(data) {

			console.log(data)

			for (var i = 0; i < data.position.length; i++) {
				$("#positionNo").append(
						$('<option value='
								+ data.position[i].positionNo + '>'
								+ data.position[i].positionName
								+ '</option>'));
			}
		}
	});
	
	//��������Ʈ
//	$.ajax({
//				url : "/employee/json/listEmployee",
//				method : "GET",
//				datatype : "json",
//				headers : {
//					"Accept" : "application/json",
//					"Content-Type" : "application/json"
//				},
//				success : function(data) {
//
//					$(".text-primary").append(
//							'��ü ' + data.resultPage.totalCount + ' �Ǽ�, ����'
//									+ data.resultPage.currentPage + ' ������');
//
//					for (var i = 0; i < data.list.list.length; i++) {
//
//						$("#listEmployee").append(
//
//								'<tr><td>' + (i + 1) + '</td><td>'
//										+ data.list.list[i].departmentName
//										+ '</td><td>'
//										+ data.list.list[i].positionName
//										+ '</td><td>'
//										+ data.list.list[i].employeeNo
//										+ '</td><td id="getEmployee" value="'
//										+ data.list.list[i].employeeNo + '">'
//										+ data.list.list[i].employeeName
//										+ '</td></tr>');
//
//					}
//				}
//			});
//
//			
		});
//========== ������ ��� Event ó�� �� ����=========
function fncAddEmployee() {
	
	
	var pw=$("input[name='password']").val();
	var no=$("input[name='employeeNo']").val();
	var date=$("input[name='hireDate']").val();
	var name=$("input[name='employeeName']").val();
	var email=$("input[name='email']").val();
	var annualLeave=$("input[name='annualLeave']").val();
	var birth=$("input[name='birthDate']").val();
	
	if(pw == null || pw.length <1){
		alert("�н������  �ݵ�� �Է��ϼž� �մϴ�.");
		return;
	}
	if(no == null || no.length <1){
		alert("�����  �ݵ�� �Է��ϼž� �մϴ�.");
		return;
	}
	if(date== null || date.length <1){
		alert("�Ի�����  �ݵ�� �Է��ϼž� �մϴ�.");
		return;
	}
	if(name== null || name.length <1){
		alert("�̸���  �ݵ�� �Է��ϼž� �մϴ�.");
		return;
	}
	if(email== null || email.length <1){
		alert("�̸�����  �ݵ�� �Է��ϼž� �մϴ�.");
		return;
	}
	if(annualLeave== null || annualLeave.length <1){
		alert("������  �ݵ�� �Է��ϼž� �մϴ�.");
		return;
	}
	if(birth== null || birth.length <1){
		alert("������  �ݵ�� �Է��ϼž� �մϴ�.");
		return;
	}
	
	$(".overlay").css("visibility", "visible");

		$("form").attr("method", "POST")
				.attr("action", "/employee/addEmployee").submit();
	}

	$(function() {
		$("button.btn.btn-primary:contains('����')").on("click", function() {
			fncAddEmployee();
		});

		$("button.btn.btn-secondary:contains('���')").on("click", function() {
			$(".tab-pane fade active show")[0].reset();
		});
	});

	//==========datepicker ����� ���� ����===================
		$(function() {
			$("#hireDate").datepicker({
				dateFormat : "yy-mm-dd"
			});
			$("#birthDate").datepicker({
				dateFormat : "yy-mm-dd"
			});
		
		});
		$.datepicker.setDefaults({
			prevText : '���� ��',
			nextText : '���� ��',
			changeYear : true,
			yearRange : 'c-80:c+100',
			monthNames : [ '1��', '2��', '3��', '4��', '5��', '6��', '7��', '8��',
					'9��', '10��', '11��', '12��' ], //�� �̸�
			monthNamesShort : [ '1��', '2��', '3��', '4��', '5��', '6��', '7��', '8��',
					'9��', '10��', '11��', '12��' ], //
			dayNames : [ '��', '��', 'ȭ', '��', '��', '��', '��' ],
			dayNamesShort : [ '��', '��', 'ȭ', '��', '��', '��', '��' ],
			dayNamesMin : [ '��', '��', 'ȭ', '��', '��', '��', '��' ],
			showMonthAfterYear : true,
			yearSuffix : '��'
		});

//===========�̹��� �̸����⸦ ���� ����==================
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#LoadImg').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}

	}
	
//=========������ ��� Ȯ�� ������  event====================
	$(function() {
		
		$("button.btn.btn-primary:contains('Ȯ��')").on("click",function(){
			self.location ="/employee/listEmployee?orderby="
		});
		
		$("button.btn.btn-primary:contains('�߰����')").on("click",function(){
			self.location ="/employee/addEmployee"
		});
		
		//�ߺ� INSERT �� ���� ���� F5Ű ����
		 function noRefresh()
		 {
		     if (event.keyCode == 116) 
		     {
		         alert("���ΰ�ħ�� �� �� �����ϴ�.");
		         event.keyCode = 2;
		         return false;
		     } 
		     else if(event.ctrlKey && (event.keyCode == 78 || event.keyCode == 82)) 
		     {
		         return false;
		     }
		 }
		 document.onkeydown = noRefresh;
		
	});	
	
	
	 
	