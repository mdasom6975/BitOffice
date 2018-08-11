
	//============= 내 정보보기에서 버튼 Event  처리 =============	
	$(function() {
		//==> DOM Object GET 3가지 방법 ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
		$("button.btn.btn-primary:contains('수정')").on("click",function() {
		self.location = "/employee/updateEmployee?employeeNo="+ $(this).attr("value");
		});
		$( "button.btn.btn-primary:contains('확인')" ).on("click" , function() {
			 self.location ="/employee/listEmployee?orderby="
			});
	});
	
	//============= "updateEmployee"  Event 연결 =============

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
	$(function() {
		//==> DOM Object GET 3가지 방법 ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
		$("#updateEmployee").on("click", function() {
			fncUpdateEmployee();
		});
		
		$("#updateByAdmin").on("click", function() {
			fncUpdateByAdmin();
		});
	});

	function fncUpdateEmployee() {

		var pw = $("input[name='password']").val();
		var pw_confirm = $("input[name='password2']").val();
		
		if(pw == null || pw.length <1){
			alert("정보변경을 위해 패스워드는  반드시 입력하셔야 합니다.");
			$("input:text[name='password1']").focus();
			return;
		}

		if (pw != pw_confirm) {
			alert("비밀번호 확인이 일치하지 않습니다.");
			$("input:text[name='password2']").focus();
			return;
		}

		var value = "";
		if ($("input:text[name='phone2']").val() != ""
				&& $("input:text[name='phone3']").val() != "") {
			var value = $("option:selected").val() + "-"
					+ $("input[name='phone2']").val() + "-"
					+ $("input[name='phone3']").val();
		}

		$("input:hidden[name='phone']").val(value);
		

		$(".overlay").css("visibility", "visible");

		$("form").attr("method", "POST").attr("action",
				"/employee/updateEmployee").submit();
	}
	
	function fncUpdateByAdmin() {
		

		$("form").attr("method", "POST").attr("action",
				"/employee/updateByAdmin").submit();
	}
	
	//====주소 API 사용을 위한=====================
  $(function() { $("#postcodify").postcodify({
        insertPostcode5 : "#postcode",
        insertAddress : "#address",
        insertDetails : "#details",
        insertExtraInfo : "#extra_info",
        hideOldAddresses : false
    }); });

	

	//=========임직원 리스트========================
	//=============    검색 / page 두가지 경우 모두  Event  처리 =============	
	function fncGetList(currentPage) {
		$("#currentPage").val(currentPage)
		$("form").attr("method" , "POST").attr("action" , "/employee/listEmployee?orderby=").submit();
	}
	
	
	//============= "검색"  Event  처리 ===============================	
	 $(function() {
		$( "button.btn.btn-default:contains('검색')").on("click" , function() {
			fncGetList(1);
		}); 
	 
	
	 $(".sDepartment").on("click", function() {
			self.location = "/employee/listEmployee?orderby=sDepartment"
		});
	 $(".sPosition").on("click", function() {
			self.location = "/employee/listEmployee?orderby=sPosition"
			
		});
	 $(".sHire").on("click", function() {
			self.location = "/employee/listEmployee?orderby=sHire"
			
		});
	 
	 });
	 
	 $(function() {
		$( ".getEmployee" ).on("click" , function() {
			
			 self.location ="/employee/getEmployee?employeeNo="+$(this).attr("value")
		});
		
		//퇴사 Event 처리
		$(".resignationEmp" ).on("click", function() {
			if(confirm("사번 : "+$(this).attr("value")+"인 임직원을 퇴사처리를 하시겠습니까?")==true){
				self.location=	"/employee/resignationEmp?employeeNo="+$(this).attr("value");
			}else{
				return false;
			}
			
			});
	});	

	 $(document).ready(
		function() {
			$.ajax({
				url : "/employee/json/listEmployee",
				method : "GET",
				datatype : "json",
				headers : {
					"Accept" : "application/json",
					"Content-Type" : "application/json"
				},
				success : function(data) {
				console.log(data.empList)
				var name="";
				for(var i=0; i<data.empList.length; i++){
					name +=
					
					data.empList[i]
					
				
				}
				console.log(name)
					var availableTags = [name];
					$("#searchKeyword").autocomplete({
						source : availableTags
					});

				}
			});
		});
	 

		
