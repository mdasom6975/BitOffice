

$(document).ready(function() {
	
	// �μ�
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

	// ����
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
	$.ajax({
				url : "/employee/json/listEmployee",
				method : "GET",
				datatype : "json",
				headers : {
					"Accept" : "application/json",
					"Content-Type" : "application/json"
				},
				success : function(data) {

					$(".text-primary").append(
							'��ü ' + data.resultPage.totalCount + ' �Ǽ�, ����'
									+ data.resultPage.currentPage + ' ������');

					for (var i = 0; i < data.list.list.length; i++) {

						$("#listEmployee").append(

								'<tr><td>' + (i + 1) + '</td><td>'
										+ data.list.list[i].departmentName
										+ '</td><td>'
										+ data.list.list[i].positionName
										+ '</td><td>'
										+ data.list.list[i].employeeNo
										+ '</td><td id="getEmployee" value="'
										+ data.list.list[i].employeeNo + '">'
										+ data.list.list[i].employeeName
										+ '</td></tr>');

					}
				}
			});

			
		});
//========== ������ ��� Event ó�� �� ����=========
function fncAddEmployee() {

		$("form").attr("method", "POST")
				.attr("action", "/employee/addEmployee").submit();
	}

	
	$(function() {

		$("button.btn.btn-default:contains('��й�ȣ����')").on("click", function() {
			self.location = "/employee/getRandomPassword"
		});
	});

	$(function() {
		$("button.btn.btn-primary:contains('����')").on("click", function() {
			fncAddEmployee();
		});

		$("button.btn.btn-secondary:contains('���')").on("click", function() {
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
	
	//============= �������������� Event  ó�� =============	
	$(function() {
		//==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
		$("button.btn.btn-primary:contains('����')").on("click",function() {
		self.location = "/employee/updateEmployee?employeeNo="+ $(this).attr("value");
		});
		$( "button.btn.btn-primary:contains('Ȯ��')" ).on("click" , function() {
			 self.location ="/employee/listEmployee"
			});
	});
	

	function goPopup() {
		// ȣ��� ������(jusopopup.jsp)���� ���� �ּҰ˻�URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)�� ȣ���ϰ� �˴ϴ�.
		var pop = window.open("/employee/jusoPopup.jsp", "pop",
				"width=570,height=420, scrollbars=yes, resizable=yes");

		// ����� ���� ���, ȣ��� ������(jusopopup.jsp)���� ���� �ּҰ˻�URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)�� ȣ���ϰ� �˴ϴ�.
		//var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
	}
	/** API ���� �����׸� Ȯ�� (2017.02) **/
	function jusoCallBack(roadFullAddr, roadAddrPart1, addrDetail,
			roadAddrPart2, engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,
			detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn,
			buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo) {
		// �˾����������� �ּ��Է��� ������ �޾Ƽ�, �� �������� ������ ����մϴ�.
		document.form.roadAddrPart1.value = roadAddrPart1;
		document.form.addrDetail.value = addrDetail;
		document.form.zipNo.value = zipNo;
	}

	//============= "����"  Event ���� =============
	$(function() {
		//==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
		$("button.btn.btn-primary:contains('���')").on("click", function() {
			fncUpdateEmployee();
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
		
//		var addr="";
//		if($("input:text[name='roadAddrPart1']").val() !=""
//				&& $("input:text[name='addrDetail']").val() !=""){
//			var addr=$("input[name='zipNo']").val()+"/"
//			+$("input[name='roadAddrPart1']").val()+"/"
//			+$("input[name='addrDetail']").val()
//		}
//		
//		$("input:hidden[name='address']").val(addr);
		

		$("form").attr("method", "POST").attr("action",
				"/employee/updateEmployee").submit();
	}
	

	//=========������ ����Ʈ========================
	//=============    �˻� / page �ΰ��� ��� ���  Event  ó�� =============	
	function fncGetList(currentPage) {
		$("#currentPage").val(currentPage)
		$("form").attr("method" , "POST").attr("action" , "/employee/listEmployee").submit();
	}
	
	
	//============= "�˻�"  Event  ó�� ===============================	
	 $(function() {
		$( "button.btn.btn-default:contains('�˻�')").on("click" , function() {
			fncGetList(1);
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
		
