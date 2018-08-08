//=========게시판 목록 구성 ===================================
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
//=========임직원 목록 구성 ====================================
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
            		  '<h4>임직원</h4><p><b>'+
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
	
	//=========전자결재 상태별 건수 docStatus: 1 대기 2 진행 3 완료  9 반려 목록 구성 ====================================
	$(document).ready(function(){     
		        
		    	$.ajax({
		    		url : "/approval/json/getTotalCountStatus",
					method : "POST" ,
					data : { 
						"docStatus": 	 '1',			
						"regEmployeeNo": $("#employeeNo").val()			
								} ,	
					contentType : "application/x-www-form-urlencoded; charset=UTF-8",
					dataType : "text" ,
					success : function(resultValue, status) {						
			              $("#countGetApprovalWait").append(
			            		  '<h4>결재대기건</h4><p><b>'+
			            		  resultValue+
			            		  '</b></p>'
			              
			              );			              
					}
						
			}); ////ajax 
	    });	
	
	$(document).ready(function(){     
        
    	$.ajax({
    		url : "/approval/json/getTotalCountStatus",
			method : "POST" ,
			data : { 
				"docStatus": 	 '2',			
				"regEmployeeNo": $("#employeeNo").val()			
						} ,	
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			dataType : "text" ,
			success : function(resultValue, status) {						
	              $("#countGetApprovalComplete").append(
	            		  '<h4>결재진행건</h4><p><b>'+
	            		  resultValue+
	            		  '</b></p>'
	              
	              );			              
			}
				
	}); ////ajax 
});	
	
	
//=========일정공유 ====================================
	$(document).ready(function(){     	
		    //공유 수락자 조회
		    $.ajax( 
					{
						
						url : "/share/json/listShare2/"+$("#employeeNo").val()	,
						method : "GET" ,
						dataType : "json" ,
						headers : {
							"Accept" : "application/json",
							"Content-Type" : "application/json"
						},
						success : function(jsonInfo , status) {
							
								if (jsonInfo){
									
							    	var displayValue="";
		
							    	 
									$.each(jsonInfo,function(key,value) {								
										displayValue += " <span class='label label-warning' style='background-color:"+value.shareColor+"'>"+value.acceptDepartmentName+" "+value.acceptPositionName+" "+value.acceptEmployeeName+"</span>";						
									});									
									
									$('#shareList').append(displayValue);
									
								}
								//alert('key:'+key+', acceptDepartmentName:'+value.acceptDepartmentName+',acceptEmployeeName:'+value.acceptEmployeeName);									
		
						},error : function(error) {
					        //alert("공유자조회실패!");
					    }
		
				});  //////////공유 수락자 조회			
	});
