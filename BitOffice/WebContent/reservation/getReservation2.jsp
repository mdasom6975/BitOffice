<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page pageEncoding="EUC-KR"%>


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
	
	<!--  ///////////////////////// CSS ////////////////////////// -->
	<style>
 		body {
            padding-top : 50px;
        }
     </style>
    
     <!--  ///////////////////////// JavaScript ////////////////////////// -->
	<script type="text/javascript">
		
		//============= ���� GET ó�� =============	
		 $(function() {
			//==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
			 $( "button.btn.btn-primary:contains('����')" ).on("click" , function() {
					self.location = "/reservation/updateReservation?reNum=${reservation.reNum}"
				});
		});
		
		 $(function(){
			
			 $("button.btn.btn-cancel:contains('���')").on("click",function(){
				
				 self.location = "/reservation/listReservation"	 
			 });
		 });
		
	</script>
	
</head>

<body>

	<!-- ToolBar Start /////////////////////////////////////-->
	<jsp:include page="/layout/toolbar.jsp" />
   	<!-- ToolBar End /////////////////////////////////////-->
	
	<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
	<div class="container">
	
		<div class="page-header">
	       <h3 class=" text-info">���� ��ȸ</h3>
	    </div>
	
		<div class="row">
	  		<div class="col-xs-4 col-md-2"><strong>ȸ�ǽ�</strong></div>
			<div class="col-xs-8 col-md-4">${reservation.mettingRoomName}</div>
		</div>
		
		<hr/>
		
		<div class="row">
	  		<div class="col-xs-4 col-md-2 "><strong>���� ��¥</strong></div>
			<div class="col-xs-8 col-md-4">${reservation.reserveDate}</div>
		</div>
		
		<hr/>
		
		<div class="row">
	  		<div class="col-xs-4 col-md-2 "><strong>���� �ð�</strong></div>
			<div class="col-xs-8 col-md-4">${reservation.startTime}</div>
		</div>
		
		<hr/>
		
		<div class="row">
	  		<div class="col-xs-4 col-md-2 "><strong>���� �ð�</strong></div>
			<div class="col-xs-8 col-md-4">${reservation.endTime}</div>
		</div>
		
		<hr/>
			
		<div class="row">
	  		<div class="col-xs-4 col-md-2 "><strong>�̿� ����</strong></div>
			<div class="col-xs-8 col-md-4">${reservation.usePurpose}</div>
		</div>
		
		<hr/>
		
		<div class="row">
	  		<div class="col-md-12 text-center ">
	  			<button type="button" class="btn btn-primary">����</button>
	  			<button type="button" class="btn btn-cancel">���</button>
	  		</div>
		</div>
		
		
		<br/>
		
 	</div>
 	<!--  ȭ�鱸�� div Start /////////////////////////////////////-->

</body>

</html>