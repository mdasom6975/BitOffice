//=============    �˻� / page �ΰ��� ��� ���  Event  ó�� =============	
		function fncGetList(currentPage) {
			$("#currentPage").val(currentPage)
			$("form").attr("method" , "POST").attr("action" , "/employee/resignList").submit();
		}
		
		
		//============= "�˻�"  Event  ó�� =============	
		 $(function() {
			$( "button.btn.btn-default:contains('�˻�')").on("click" , function() {
				fncGetList(1);
			}); 
		 });

			 