$(document).ready(function() {
	
	// 부서
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

	// 직급
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
	
	//직원리스트
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
//							'전체 ' + data.resultPage.totalCount + ' 건수, 현재'
//									+ data.resultPage.currentPage + ' 페이지');
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
//========== 임직원 등록 Event 처리 및 연결=========
function fncAddEmployee() {
	
	
	var pw=$("input[name='password']").val();
	var no=$("input[name='employeeNo']").val();
	var date=$("input[name='hireDate']").val();
	var name=$("input[name='employeeName']").val();
	var email=$("input[name='email']").val();
	var annualLeave=$("input[name='annualLeave']").val();
	var birth=$("input[name='birthDate']").val();
	
	if(pw == null || pw.length <1){
		alert("패스워드는  반드시 입력하셔야 합니다.");
		return;
	}
	if(no == null || no.length <1){
		alert("사번은  반드시 입력하셔야 합니다.");
		return;
	}
	if(date== null || date.length <1){
		alert("입사일은  반드시 입력하셔야 합니다.");
		return;
	}
	if(name== null || name.length <1){
		alert("이름은  반드시 입력하셔야 합니다.");
		return;
	}
	if(email== null || email.length <1){
		alert("이메일은  반드시 입력하셔야 합니다.");
		return;
	}
	if(annualLeave== null || annualLeave.length <1){
		alert("연차는  반드시 입력하셔야 합니다.");
		return;
	}
	if(birth== null || birth.length <1){
		alert("연차는  반드시 입력하셔야 합니다.");
		return;
	}

		$("form").attr("method", "POST")
				.attr("action", "/employee/addEmployee").submit();
	}

	
	$(function() {

		$("button.btn.btn-default:contains('비밀번호생성')").on("click", function() {
			self.location = "/employee/getRandomPassword"
		});
	});

	$(function() {
		$("button.btn.btn-primary:contains('제출')").on("click", function() {
			fncAddEmployee();
		});

		$("button.btn.btn-secondary:contains('취소')").on("click", function() {
			$(".tab-pane fade active show")[0].reset();
		});
	});

		$(function() {
			$("#hireDate").datepicker({
				dateFormat : "yy-mm-dd"
			});
			$("#birthDate").datepicker({
				dateFormat : "yy-mm-dd"
			});
		
		});
		$.datepicker.setDefaults({
			prevText : '이전 달',
			nextText : '다음 달',
			changeYear : true,
			yearRange : 'c-80:c+100',
			monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
					'9월', '10월', '11월', '12월' ], //월 이름
			monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
					'9월', '10월', '11월', '12월' ], //
			dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
			dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
			dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
			showMonthAfterYear : true,
			yearSuffix : '년'
		});


	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#LoadImg').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}

	}