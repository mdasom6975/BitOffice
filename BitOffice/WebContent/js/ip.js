		//=============    �˻� / page �ΰ��� ��� ���  Event  ó�� =============	
		function fncGetList(currentPage) {
			$("#currentPage").val(currentPage)
			$("form").attr("method" , "POST").attr("action" , "/ip/updateIpView").submit();
		}		
	
		//============= "�˻�"  Event  ó�� =============	
		 $(function() {
			 //==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
			 $( "button.btn.btn-default, #modalClose" ).on("click" , function() {
				fncGetList(1);
			});
		 });
		
			//============= "IP���"  Event  ó�� =============	
		 $(function() {
			 //==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
				$("#ipsubmit").on("click" , function() {				
					
					var startIp = $("#startip1").val().trim()+"."+$("#startip2").val().trim()+"."+$("#startip3").val().trim()+"."+$("#startip4").val().trim();
					var endIp = $("#endip1").val().trim()+"."+$("#endip2").val().trim()+"."+$("#endip3").val().trim()+"."+$("#endip4").val().trim();
					var employeeNo = $('#employeeNo').val();
					
					if ($("#startip1").val().trim().length<1){
						alert("����IP 1��° �Է��ϼ���");
						$("#startip1").focus();
						return;
					}	
					
					if ($("#startip2").val().trim().length<1){
						alert("����IP 2��° �Է��ϼ���");
						$("#startip2").focus();
						return;
					}	
					
					if ($("#startip3").val().trim().length<1){
						alert("����IP 3��° �Է��ϼ���");
						$("#startip3").focus();
						return;
					}	
					
					if ($("#startip4").val().trim().length<1){
						alert("����IP 4��° �Է��ϼ���");
						$("#startip4").focus();
						return;
					}
					
					if ($("#endip1").val().trim().length<1){
						alert("��IP 1��° �Է��ϼ���");
						$("#endip1").focus();
						return;
					}	
					
					if ($("#endip2").val().trim().length<1){
						alert("��IP 2��° �Է��ϼ���");
						$("#endip2").focus();
						return;
					}	
					
					if ($("#endip3").val().trim().length<1){
						alert("��IP 3��° �Է��ϼ���");
						$("#endip3").focus();
						return;
					}	
					
					if ($("#endip4").val().trim().length<1){
						alert("��IP 4��° �Է��ϼ���");
						$("#endip4").focus();
						return;
					}						
					
					if (startIp.replace(",","")> endIp.replace(",","")){
						alert("����IP�� ���� IP���� Ŀ�� �մϴ�");
						$("#endip4").focus();
						return;
					}						
					    //IP�ߺ�ü üũ, �ߺ��� �ԷºҰ�
/* 		 	            $.ajax( 
								{
									
									url : "/ip/json/getIp",										
									method : "GET" ,
									dataType : "text" ,
									headers : {
										"Accept" : "application/json",
										"Content-Type" : "application/json"
									},								
									data : {
		 								startIp: startIp,
										endIp: endIp,																		
									},
									success : function() {
										//IP�ߺ��� ó�� �Ұ�
										$("#modalmessage").text("IP�ߺ����� ���� ó�� �Ұ��մϴ�");
										jQuery("#getMessageModal").modal('show');	
									},	
									error : function() { */
										//IP������ �ȵɶ� ��ϰ���

							
					            	$.ajax({
					            		url : "/ip/json/addIp",
										method : "POST" ,
										data : { 	
				 								"startIp": startIp,
												"endIp": endIp,
												"regId": employeeNo	
													} ,	
										contentType : "application/x-www-form-urlencoded; charset=UTF-8",
										dataType : "text" ,
										success : function(resultValue,status) {
											//alert("::"+resultValue+"::");
											if(resultValue.indexOf('1')>=0){
												$("#modalmessage").text("��ϵǾ����ϴ�");
											}else{
												$("#modalmessage").text("���ó�� ����! �����ڿ��� ����!");
											}	
											jQuery("#getMessageModal").modal('show');
										},	
										error : function(request, error) {
											alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
											   

											
											$("#modalmessage").text("������� error");
											jQuery("#getMessageModal").modal('show');	
									    }						
									}); 
									

									

/* 								    }
										
						
						}); //ajax */  

	 	            
				});
		 });
		
		 //���ڸ�	
		 function onlyNumber(obj) {
			    $(obj).keyup(function(){
			         $(this).val($(this).val().replace(/[^0-9]/g,""));
			    }); 
			}
		 
		//���� 
		function delIp(serialNo) {
        	$.ajax({
        		url : "/ip/json/deleteIp",
				method : "POST" ,
				data : { 	
					"serialNo": serialNo
				} ,	
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				dataType : "text" ,
				success : function(resultValue) {
					//alert("resultValue: "+resultValue);
				    if (resultValue.indexOf('1')>=0){
				    	$("#modalmessage").text("�����Ǿ����ϴ�");
				    }else{
				    	$("#modalmessage").text("����ó�� ����! �����ڿ��� ����!");
				    }
					
					jQuery("#getMessageModal").modal('show');	
	
				},	
				error : function() {
					$("#modalmessage").text("�������� error");
					jQuery("#getMessageModal").modal('show');	
			    }
		});
        	
			
	}		