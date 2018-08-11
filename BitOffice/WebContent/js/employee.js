
	//============= �� �������⿡�� ��ư Event  ó�� =============	
	$(function() {
		//==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
		$("button.btn.btn-primary:contains('����')").on("click",function() {
		self.location = "/employee/updateEmployee?employeeNo="+ $(this).attr("value");
		});
		$( "button.btn.btn-primary:contains('Ȯ��')" ).on("click" , function() {
			 self.location ="/employee/listEmployee?orderby="
			});
	});
	
	//============= "updateEmployee"  Event ���� =============

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
		//==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
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
			alert("���������� ���� �н������  �ݵ�� �Է��ϼž� �մϴ�.");
			$("input:text[name='password1']").focus();
			return;
		}

		if (pw != pw_confirm) {
			alert("��й�ȣ Ȯ���� ��ġ���� �ʽ��ϴ�.");
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
	
	//====�ּ� API ����� ����=====================
  $(function() { $("#postcodify").postcodify({
        insertPostcode5 : "#postcode",
        insertAddress : "#address",
        insertDetails : "#details",
        insertExtraInfo : "#extra_info",
        hideOldAddresses : false
    }); });

	

	//=========������ ����Ʈ========================
	//=============    �˻� / page �ΰ��� ��� ���  Event  ó�� =============	
	function fncGetList(currentPage) {
		$("#currentPage").val(currentPage)
		$("form").attr("method" , "POST").attr("action" , "/employee/listEmployee?orderby=").submit();
	}
	
	
	//============= "�˻�"  Event  ó�� ===============================	
	 $(function() {
		$( "button.btn.btn-default:contains('�˻�')").on("click" , function() {
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
		
		//��� Event ó��
		$(".resignationEmp" ).on("click", function() {
			if(confirm("��� : "+$(this).attr("value")+"�� �������� ���ó���� �Ͻðڽ��ϱ�?")==true){
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
	 

		
