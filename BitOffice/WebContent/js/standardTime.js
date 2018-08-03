       $(function() {	
    	 //����ٱ��ؽð� �ð� timepicker
	       $("#starts-at, #ends-at").timepicker({
	    	    timeFormat: 'HH:mm',
	    	    interval: 15,
	    	    minTime: '60',
	    	    maxTime: '23:00 p',
	    	    defaultTime: '05:00',
	    	    startTime: '05:00',
	    	    dynamic: false,
	    	    dropdown: true,
	    	    scrollbar: true
	    	});
	       
	       
			//���
			$("button.btn.btn-primary").on("click" , function() {
				fncAddStandardTime();
			});
			
			//���â �ݱ� Ŭ���� ȭ�� reload
			$("#modalClose").on("click" , function() {
				$("form").attr("method" , "POST").attr("action" , "/standardtime/updateStandardTime").submit();
			});			
	  	 
	       
       });
         
        

		function fncAddStandardTime() {
			
			var startTime=$("#starts-at").val();
			var endTime=$("#ends-at").val();
			
			if(startTime == null || startTime.trim().length <1){
				alert("��ٽð��� �ݵ�� �Է��ϼž� �մϴ�.");				
				return;
			}
			
			if(endTime == null || endTime.trim().length <1){
				alert("��ٽð��� �ݵ�� �Է��ϼž� �մϴ�.");				
				return;
			}	
			
			if(startTime.replace(':','') >= endTime.replace(':','')){
				alert("��ٽð��� ��ٽð����� Ŀ���մϴ�");				
				return;
			}
	
			if($("button.btn.btn-primary").text().trim()=="���"){				

				//���
		            	$.ajax({
		            		url : "/standardtime/json/addStandardTime",
							method : "POST" ,
							data : { 	
  								stdStartTime: $("#starts-at").val(),
  								stdEndTime: $("#ends-at").val(),
  								regEmployeeNo:  $("#regEmployeeNo").val()
										} ,	
							contentType : "application/x-www-form-urlencoded; charset=UTF-8",
							dataType : "text" ,
							success : function(returnValue, status) {
								if (returnValue.indexOf(1)){ 
  								    $("#modalmessage").text("��ϵǾ����ϴ�");
  								 	jQuery("#getMessageModal").modal('show');	
								}else{
									alert("��� ����! �����ڿ��� ����!");									
								}
							},
							error : function(error) {
						        alert("��� ���� error");
						    }							
					}); 
				
				
			}else{		
				//����
				//$("form").attr("method" , "POST").attr("action" , "/standardtime/updateStandardTime").submit();
		            	$.ajax({
		            		url : "/standardtime/json/updateStandardTime",
							method : "POST" ,
							data : { 	
  								serialNo: $("#serialNo").val(),
  								stdStartTime: $("#starts-at").val(),
  								stdEndTime: $("#ends-at").val(),
  								regEmployeeNo:  $("#regEmployeeNo").val()
										} ,	
							contentType : "application/x-www-form-urlencoded; charset=UTF-8",
							dataType : "text" ,
							success : function(returnValue, status) {
								if (returnValue.indexOf(1)){ 
  								    $("#modalmessage").text("�����Ǿ����ϴ�");
  								 	jQuery("#getMessageModal").modal('show');
								}else{
									alert("���� ����! �����ڿ��� ����!");									
								}
							},
							error : function(error) {
						        alert("���� ���� error");
						    }							
					}); 	            	
			
			}

		}