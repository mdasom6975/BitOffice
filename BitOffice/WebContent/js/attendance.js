//=============    �˻� / page �ΰ��� ��� ���  Event  ó�� =============	
 		function fncGetUserList(currentPage) {
			$("#currentPage").val(currentPage)
			$("form").attr("method" , "POST").attr("action" , "/attendance/listAttendance").submit();
		}		
	
		//============= "�˻�"  Event  ó�� =============	
		 $(function() {
			 //==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
			 $( "button.btn.btn-default, #modalClose" ).on("click" , function() {
				fncGetUserList(1);
			});
		 }); 
		

			//============= "�⼮ ���"  Event  ó�� =============	
		 $(function() {
			 //==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
				$("#checkin").on("click" , function() {					
					if ($('#employeeNo').val().trim().length<1){
						alert("session ����! �ٽ÷α������ּ���.");
						return;
					}				    
                      
				    //���糯¥ call         
	                fnc_getDate();	                
	                //����ð� call
					fnc_getTime();                

	                //�� ������ ��������
	                $.getJSON("http://jsonip.com?callback=?", function (data) {	

					    /////////IP�ߺ�ü üũ, �ߺ��� �ԷºҰ�
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
		 								startIp: data.ip,
										endIp: data.ip																		
									},	       
									success : function() { */
							                	/////////������ IP������ �ش�Ǵ� ���///////
							                	
												$.ajax( 
														{
															url : "/attendance/json/getAttendance/"+fnc_getDate()+$('#employeeNo').val(),
															method : "GET" ,
															dataType : "json" ,
															headers : {
																"Accept" : "application/json",
																"Content-Type" : "application/json"
															},
															success : function(JSONData , status) {	
																//�⼮ ó�� ��ȸ�Ǵ� ���
																$("#modalmessage").text("�̹� �⼮ó�� �Ǿ����ϴ�");
																jQuery("#getMessageModal").modal('show');	
															
															},    	
							    							error : function(request, error) {
							    								  //�⼮ ó��
								    							  $.ajax( 
										    						{							
										    						
										    							url : "/attendance/json/addAttendance",	
										    							method : "GET" ,
										    							dataType : "text" ,	    							
										    							headers : {
										    								"Accept" : "application/json",
										    								"Content-Type" : "application/json"
										    							},								
										    							data : {
										    								attendanceNo: fnc_getDate()+$('#employeeNo').val(),
										    								attendateDate: fnc_getDate(),
										    								employeeNo: $('#employeeNo').val(),										 
										    								startTime: fnc_getTime(),  
										    								startIp: data.ip
										    							},
										    							success : function(status) {	 
										    								    $("#modalmessage").text("�⼮�Ǿ����ϴ�");
										    								 	jQuery("#getMessageModal").modal('show');	    									
										    							},	
										    							error : function(status) {
									    								    $("#modalmessage").text("�⼮��Ͻ���! �����ڿ��� ����");
									    								 	jQuery("#getMessageModal").modal('show');	
										    						       
										    						    }	    								
										
										    						}); 	    						       
							    						    }										
															
													});						
												//////////////////
												
/* 									},//IP�ߺ�ü üũ success
									error : function() {
										//IP���� ��� ��� ��ó��
										$("#modalmessage").text(data.ip+"�� ������ IP������ ���� �ʽ��ϴ�. �����ڿ��� �����ϼ���.  ");
										jQuery("#getMessageModal").modal('show');											
									} 
	            	});*/
		 	         //////////IP�ߺ�ü üũ, �ߺ��� �ԷºҰ�
	 	            
				});
		 	});
		 });	
			
			//============= "��� ó��"  Event  ó�� =============	
		 $(function() {
			 //==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
				$("#checkout").on("click" , function() {					
					if ($('#employeeNo').val().trim().length<1){
						alert("session ����! �ٽ÷α������ּ���.");
						return;
					}              

					jQuery("#getCheckOutModal").modal('show');
   
				});
			 
			    $('#myFormSubmit').click(function(e){
			        e.preventDefault();

			        var memo = $('#memo').val();
			        
				    //���糯¥ call         
	                fnc_getDate();               
	                //����ð� call
					fnc_getTime(); 
	                
	                //�� ������ ��������
	                $.getJSON("http://jsonip.com?callback=?", function (data) {	                	
					    /////////IP�ߺ�ü üũ, �ߺ��� �ԷºҰ�
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
		 								startIp: data.ip,
										endIp: data.ip																		
									},	       
									success : function() {	 */									
								   //-----�⼮����Ȯ��--------
											$.ajax( 
													{
														url : "/attendance/json/getAttendance/"+fnc_getDate()+$('#employeeNo').val(),
														method : "GET" ,
														dataType : "json" ,
														headers : {
															"Accept" : "application/json",
															"Content-Type" : "application/json"
														},
														success : function(JSONData , status) {	
															//�⼮ ó�� ��ȸ�Ǵ� ���
										                	//////////////
										    	            $.ajax( 
										    						{							
										    						
										    							url : "/attendance/json/updateAttendance",	
										    							method : "GET" ,
										    							dataType : "text" , 
																		headers : {
										    								"Accept" : "application/json",
										    								"Content-Type" : "application/json"
										    							},								
										    							data : {
										    								attendanceNo: fnc_getDate()+$('#employeeNo').val(),
										    								leaveDate: fnc_getDate(),
										    								employeeNo: $('#employeeNo').val(),										 
										    								endTime: fnc_getTime(),  
										    								endIp: data.ip,
										    								memo:$('#memo').val()
										    							},
										    							success : function(status) {	    								 	
									    								    $("#modalmessage").text("ó���Ǿ����ϴ�");
									    								 	jQuery("#getMessageModal").modal('show');	     									
										    							},	
										    							error : function(status) {
									    								    $("#modalmessage").text("���ó�� ����! �����ڿ��� ����!");
									    								 	jQuery("#getMessageModal").modal('show');	
										    						       
										    						    }	    								
										
										    				});
														
														},    	
						    							error : function(request, error) {
						    								  //��� ����� ���� ���
					    								    $("#modalmessage").text("��� ����� �����ϴ�. ��ٹ�ư�� �����ּ���");
					    								 	jQuery("#getMessageModal").modal('show');	    						       
						    						    }										
														
												});	
											//-----//�⼮����Ȯ��--------
/* 									},
									error : function() {	
										//IP���� ��� ��� ��ó��
										$("#modalmessage").text(data.ip+"������ IP������ ���� �ʽ��ϴ�. �����ڿ��� �����ϼ���.  ");
										jQuery("#getMessageModal").modal('show');										
									}
									
								});// /////////IP�ߺ�ü üũ, �ߺ��� �ԷºҰ� */
	            	});
	                
			        $('#getCheckOutModal').modal('hide');

			      });	            
						 
		 });
			
		 
	//���糯¥
	 function fnc_getDate(){
			var fullDate = new Date();     
	              
		    //���糯¥ 20170711           
	                    
				var twoDigitMonth = fullDate.getMonth()+1+"";
	              	if(twoDigitMonth.length==1)	twoDigitMonth="0" +twoDigitMonth;
	            var twoDigitDate = fullDate.getDate()+"";
	              	if(twoDigitDate.length==1)	twoDigitDate="0" +twoDigitDate;
	            var currentDate = fullDate.getFullYear()+ twoDigitMonth +  twoDigitDate;
	              
		 return currentDate;
	 }
	 
	//����ð�
	 function fnc_getTime(){
		 
			var fullDate = new Date();     
	           
	        //����ð� 1536
			var twoDigitHour = fullDate.getHours()+"";
			if(twoDigitHour.length==1)	twoDigitHour="0" +twoDigitHour;
			var twoDigitMinutes = fullDate.getMinutes()+"";
			if(twoDigitMinutes.length==1)	twoDigitMinutes="0" +twoDigitMinutes;
			var currentTime = twoDigitHour +":"+ twoDigitMinutes;	
			
			return currentTime;
	 }		 
	
	
	//���ڸ�	
	function onlyNumber(obj) {
		    $(obj).keyup(function(){
		         $(this).val($(this).val().replace(/[^0-9]/g,""));
		    }); 
	}
		
		
		 
		
		