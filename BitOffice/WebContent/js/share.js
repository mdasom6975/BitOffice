		//=============    �˻� / page �ΰ��� ��� ���  Event  ó�� =============	
		function fncGetList(currentPage) {
			$("#currentPage").val(currentPage)
			$("form").attr("method" , "POST").attr("action" , "/share/updateShareView").submit();
		}		
	
		//============= "�˻�"  Event  ó�� =============	
		 $(function() {
			 //==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
			 $( "button.btn.btn-default, #modalClose" ).on("click" , function() {
				fncGetList(1);
			});
		 });
		
	
		 //���ڸ�	
		function onlyNumber(obj) {
			    $(obj).keyup(function(){
			         $(this).val($(this).val().replace(/[^0-9]/g,""));
			    }); 
		}
		 
		//���� 
		function delShare(share_No) {
            $.ajax( 
				{
					
					//url : "/ip/json/addIp",	
					url : "/share/json/deleteShare/"+share_No,	
					method : "GET" ,
					dataType : "text" ,
					headers : {
						"Accept" : "application/json",
						"Content-Type" : "application/json"
					},					
					success : function() {
							$("#modalmessage").text("�����Ǿ����ϴ�");
							jQuery("#getMessageModal").modal('show');	

					},	
					error : function() {
						$("#modalmessage").text("��������! �����ڿ��� ����!");
						jQuery("#getMessageModal").modal('show');	
				    }							
			
			}); //ajax */ 			
	    }	
		
		function fnc_accept(status, shareNo) {	
				var msg;
				if(status.indexOf('N')>=0){
					var msg = "����";
				}else{
					var msg = "����";
				}			
			
	        	$.ajax({
	        		url : "/share/json/updateShare",
					method : "POST" ,
					data : { 	
						shareNo: shareNo,
						acceptStatus: status,
						shareColor: '#ABF200'
					} ,	
					contentType : "application/x-www-form-urlencoded; charset=UTF-8",
					dataType : "text" ,
					success : function(JSONData , status) {	
						//�⼮ ó�� ��ȸ�Ǵ� ���
						$("#modalmessage").text(msg+"ó�� �Ǿ����ϴ�");
						jQuery("#getMessageModal").modal('show');	
					
					},    	
					error : function(request, error) {
						$("#modalmessage").text(msg+" ó�� ����");
						jQuery("#getMessageModal").modal('show');		    						       
				    }	
				}); 			
			
		   }