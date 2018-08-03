<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page pageEncoding="EUC-KR"%>

<!--  ///////////////////////// JSTL  ////////////////////////// -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="toDay" class="java.util.Date" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:formatDate value='${toDay}' pattern='yyyyMMdd' var="nowDate"/>

<!DOCTYPE html>

<html lang="ko">
	
<head>
	<meta charset="EUC-KR">
	
	<!-- ���� : http://getbootstrap.com/css/   ���� -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<!--  ///////////////////////// Bootstrap, jQuery CDN ////////////////////////// -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
	
	
	<!-- Bootstrap Dropdown Hover CSS -->
   <link href="/css/animate.min.css" rel="stylesheet">
   <link href="/css/bootstrap-dropdownhover.min.css" rel="stylesheet">
    <!-- Bootstrap Dropdown Hover JS -->
   <script src="/javascript/bootstrap-dropdownhover.min.js"></script>
   
   

 <!-- bootstrap datetimepicker -->
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
 
 <!-- tree -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script> 	 
   
   <!-- jQuery UI toolTip ��� CSS-->
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <!-- jQuery UI toolTip ��� JS-->
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<!--  ///////////////////////// CSS ////////////////////////// -->
	<style>
	  body {
            padding-top : 50px;
        }
      .aa {
      	color:red;
      }  
    </style>
    
     <!--  ///////////////////////// JavaScript ////////////////////////// -->
	<script type="text/javascript">
     
	            		
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
		
		
		 
		
		 
		//============= userId �� ȸ����������  Event  ó��(Click) =============	
	

	
	</script>
	
</head>

<body>
	<!-- Modal -->
	<div class="modal fade" id="getMessageModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Bitoffice</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <form>
		      <div id="modalmessage" class="modal-body">
		       
		      </div>
	      </form>
	      <div class="modal-footer">
	        <button type="button" id="modalClose" class="btn btn-secondary" data-dismiss="modal">�ݱ�</button>
	      </div>
	    </div>
	  </div>
	</div>

	<!-- ��� Modal -->
	<div class="modal fade" id="getCheckOutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel2" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel2">Bitoffice</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      		 <form class="form-inline" name="modalForm">
					  <div class="form-group">					   
					    <select id="memo" name="memo" class="form-control" name="memo" >
							<option value="">���</option>
							<option value="�ܱ�">�ܱ�</option>
							<option value="����">����</option>
							<option value="����">����</option>						
							<option value="����">����</option>	
							<option value="��Ÿ">��Ÿ</option>						
						</select>
					  </div>
				  </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">�ݱ�</button>
 	        <button type="button" id="myFormSubmit" class="btn btn-primary">���</button> 
	      </div>
	    </div>
	  </div>
	</div>	
 
	<!-- Timepicker Start /////////////////////////////////////-->
	<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>	
	
	<!-- ToolBar Start /////////////////////////////////////-->
	<jsp:include page="/layout/toolbar.jsp" />
   	<!-- ToolBar End /////////////////////////////////////-->
	
	<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
	<div class="container">
	
		<div class="page-header text-info">
	       <h3>������Ȳ</h3>
	    </div>
    
	    <!-- table ���� �˻� Start /////////////////////////////////////-->
	    <div class="row">
	    	<div class="form-group row"> 
			  <div class="col-xs-1">
	    		<button type="button" id="checkin" class="btn btn"  >�⼮</button>
	    	  </div>
			  <div class="col-xs-1">
	    		<button type="button" id="checkout" class="btn btn">���</button>
	    	  </div>		    	  	
			</div>			
		</div>
		
		<div class="row">	    		    
		    <div class="col-md-6 text-left">
		    	<p class="text-primary">
		    		��ü  ${resultPage.totalCount } �Ǽ�, ���� ${resultPage.currentPage}  ������
		    	</p>
		    </div>
		    
		    <div class="col-md-6 text-right">
			    <form class="form-inline" name="detailForm">	    			      
			      
				  <div class="form-group">
				    <select class="form-control" name="searchCondition" >
						<option value="0"  ${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>�μ�</option>
						<option value="1"  ${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>�̸�</option>
					</select>
				  </div>
				  
				  <div class="form-group">
				    <label class="sr-only" for="searchKeyword">�˻���</label>
				    <input type="text" class="form-control" id="searchKeyword" name="searchKeyword"  placeholder="�˻���"
				    			 value="${! empty search.searchKeyword ? search.searchKeyword : '' }"  >
				  </div>
				  
				  <button type="button" class="btn btn-default">�˻�</button>
				  
				  <!-- PageNavigation ���� ������ ���� ������ �κ� -->
				  <input type="hidden" id="currentPage" name="currentPage" value=""/>				  
				  <input type="hidden" id="employeeNo" name="employeeNo" value="${sessionScope.employee.employeeNo}"/>
				</form>
	    	</div>
	    	
		</div>
		<!-- table ���� �˻� Start /////////////////////////////////////-->
		
		
      <!--  table Start /////////////////////////////////////-->
      <table class="table table-hover table-striped" >
      
        <thead>
          <tr>
            <th align="center">No</th>
            <th align="left" >�μ�</th>
            <th align="left">����</th>
            <th align="left">�̸�</th>
            <th align="left">�������</th>
            <th align="left">��ٽð�</th>
            <th align="left">���IP</th>
            <th align="left">�������</th>
            <th align="left">��ٽð�</th> 
            <th align="left">���IP</th>
            <th align="left">���</th>           
          </tr>
        </thead>
       
		<tbody>
		
		  <c:set var="i" value="0" />
		  <c:forEach var="attendance" items="${list}">
			<c:set var="i" value="${ i+1 }" />
			<tr>
			  <td align="center">${ i }</td>
			   <td align="left" >${attendance.departmentName}</td>
			  <td align="left">${attendance.positionName}</td>
			  <td align="left">${attendance.employeeName}</td> 
			  <td align="left">${attendance.attendateDate}</td>				  
			  <td align="left">${attendance.startTime}</td>	
			  <td align="left">${attendance.startIp}</td> 
			  <td align="left">${attendance.leaveDate}</td> 
			  <td align="left">${attendance.endTime}</td> 
			  <td align="left">${attendance.endIp}</td>	
			  <td align="left">${attendance.memo}</td>
			</tr>
          </c:forEach>
        
        </tbody>
      
      </table>
	  <!--  table End /////////////////////////////////////-->
	  
 	</div>
 	<!--  ȭ�鱸�� div End /////////////////////////////////////-->
 	
 	
 	<!-- PageNavigation Start... -->
	<jsp:include page="../common/pageNavigator_new.jsp"/>
	<!-- PageNavigation End... -->
	
</body>

</html>