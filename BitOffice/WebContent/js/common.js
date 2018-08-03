//=========�Խ��� ��� ���� ===================================
$(document).ready(function(){
        $.ajax({
           url:"/board/json/listBoard",
           method:"GET",
           datatype:"json",
           headers : {
                  "Accept" : "application/json",
                  "Content-Type" : "application/json"
               },
               success:function(data){

                  
                  for(var i=0; i<data.list.list.length; i++){
                     
                     $("#listBoard").append(
                        
                              '<tr><td>'+
                                 (i+1)+
                                 '</td><td id="getBoard" value="'+data.list.list[i].boardNo+'">'+
                                 data.list.list[i].boardTitle+
                                 '</td><td>'+
                                 data.list.list[i].boardDate+
                                 '</td><td>'+
                                 data.list.list[i].employeeName+
                                 '</td><td>'+
                                 data.list.list[i].boardCount+
                                 '</td></tr>'
                           );
                     
                  }
               }
        });
        });


$(document).on("click","#getBoard", function() {

		self.location = "/board/countView?boardNo=" + $(this).attr("value")
	});
//=========������ ��� ���� ====================================
$(document).ready(function(){
    $.ajax({
       url:"/employee/json/listEmployee",
       method:"GET",
       datatype:"json",
       headers : {
              "Accept" : "application/json",
              "Content-Type" : "application/json"
           },
           success:function(data){

              $("#countEmployee").append(
            		  '<h4>������</h4><p><b>'+
            		  data.resultPage.totalCount+
            		  '</b></p>'
              
              );
              
        	   
              for(var i=0; i<data.list.list.length; i++){
                 
                 $("#listEmployee").append(
                    
                          '<tr><td>'+
                             (i+1)+
	    '</td><td>'+
                             data.list.list[i].departmentName+
	    '</td><td>'+
                             data.list.list[i].positionName+
                             '</td><td id="getEmployee" value="'+data.list.list[i].employeeNo+'">'+
                             data.list.list[i].employeeName+
                             '</td><td>'+
                             data.list.list[i].email+
                             '</td><td>'+
                             data.list.list[i].extension+
                             '</td></tr>'
                       );
                 
              }
           }
    });
    });


	$(document).on("click" ,"#getEmployee", function() {
		
		 self.location ="/employee/getEmployee?employeeNo="+$(this).attr("value")
	});
	
	//=========���ڰ��� ���º� �Ǽ� docStatus: 1 ��� 2 ���� 3 �Ϸ�  9 �ݷ� ��� ���� ====================================
	$(document).ready(function(){      
		      
		    	$.ajax({
		    		url : "/approval/json/getTotalCountStatus",
					method : "POST" ,
					data : { 
						"docStatus": 		'1' ,			
						"regEmployeeNo":	'333333'			
								} ,	
					contentType : "application/x-www-form-urlencoded; charset=UTF-8",
					dataType : "text" ,
					success : function(resultValue, status) {
						alert("returnValue:"+resultValue);
						if (resultValue.indexOf(1)>=0){ 							
							alert("���ڰ��� ����(1)��ȸ�Ǿ����ϴ�.");										
						}else{
							alert("���ڰ��� ����(1)��ȸ����! �����ڿ��� ����!");									
						}
					},
					error : function(request, status,error) {
				        alert("���ڰ��� ���� ��ȸ ���� error");
				        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				    }							
			}); ////ajax 
	    });	

