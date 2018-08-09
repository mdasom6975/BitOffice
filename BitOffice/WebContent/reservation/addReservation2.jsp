<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="ko">
	
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	
	<!-- 참조 : http://getbootstrap.com/css/   참조 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!--  ///////////////////////// Bootstrap, jQuery CDN ////////////////////////// -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!-- 달력 사용을 위한 CDN -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="http://trentrichardson.com/examples/timepicker/jquery-ui-timepicker-addon.css">

<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com"></script>  


<!-- Bootstrap Dropdown Hover CSS -->
<link href="/css/animate.min.css" rel="stylesheet">
<link href="/css/bootstrap-dropdownhover.min.css" rel="stylesheet">

<!-- Bootstrap Dropdown Hover JS -->
<script src="/javascript/bootstrap-dropdownhover.min.js"></script>

<!--  ///////////////////////// CSS ////////////////////////// -->
	<style>
       body > div.container{
        	border: 3px solid #D6CDB7;
            margin-top: 10px;
        }
        
        body{
        padding-top : 70px;
        }
    </style>
    
     <!--  ///////////////////////// JavaScript ////////////////////////// -->
     <!--  CDN(Content Delivery Network) 호스트 사용 -->
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>

<script type="text/javascript">

//버튼처리

function fncAddReservation(){	
	$("form").attr("method","POST").attr("action","/reservation/addReservation").submit();
}

$(function(){		
	
	$("button.btn.btn-default:contains('예약')").on("click",function(){
		
		fncAddReservation();
});
	
	$( "button.btn.btn-default:contains('취소')" ).on("click" , function() {
		$("form")[0].reset();
	});
	
});

//이름 셀렉터
$(function () {

	$.ajax({
		url:"/meetingRoom/json/getReserveMeetingRoom",
		method:"GET",
		datatype : "json",
		headers:{
			"Accept" : "application/json",
			"Content-Type" : "application/json"
			
		},
		success:function(data){
			console.log(data)

			for(var i=0; i<data.meetingRoom.length; i++ ){
				$("#mettingRoomName").append($('<option value='+data.meetingRoom[i].mettingRoomName+'>'+data.meetingRoom[i].mettingRoomName+'</option>'));
			}
		}
	});
});


//예약날짜

$(function(){
	
 	$("#reserveDate").datepicker({
	
 		dateFormat:"yy-mm-dd",
 	    selectOtherMonths: true,
 	    minDate: 0, 
 	    maxDate: "+7D"
 	});
 });

$(function(){
	
	$("#startTime").timepicker({
		
		timeFormat : 'HH:mm',
		interval : 60,
		minTime : '9',
		maxTime : '19',
		dropdown: true,
	    scrollbar: true
	});

});

 	$(function(){
 		
 		$("#endTime").timepicker({
 			
 			timeFormat : 'HH:mm',
 			interval : 60,
 			minTime : '10',
 			maxTime : '20',
 			dropdown: true,
 		    scrollbar: true
 		});
 	});
	
//유효성 및 컨트롤러

	</script>
	</head>
	<body>
	
	<!-- ToolBar Start /////////////////////////////////////-->
	<jsp:include page="/layout/toolbar.jsp" />
   	<!-- ToolBar End /////////////////////////////////////-->
	
	<!--  화면구성 div Start /////////////////////////////////////-->
	<div class="container">

		<h1 class="bg-default text-center">회의실 예약</h1>

		<!-- form Start /////////////////////////////////////-->
		<form class="form-horizontal" enctype="multipart/form-data">
			<%-- 	    <input type="hidden" name="reserveEmployee" value="${employee.EmployeeNo}" /> --%>
<!-- 			<div class="form-group"> -->
<!-- 				<div class="col-sm-offset-1 col-sm-3 control-label"> -->
<!-- 					<strong>예약자</strong> -->
<!-- 				</div> -->
<%-- 				<div class="col-xs-8 col-md-4">${reserveEmployee.employeeNo}</div> --%>
<!-- 			</div> -->
			<div class="form-group">
				<label for="reserveEmployee" class="col-sm-offset-1 col-sm-3 control-label">예약자</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="employeeNo"
						name="employeeNo" value="${employee.employeeNo}">
				</div>
			</div>

			<div class="form-group">
				<label for="meetingRoom" class="col-sm-offset-1 col-sm-3 control-label">회의실</label>
				<div class="col-sm-2">
					<select class="form-control" name="mettingRoomName" id="mettingRoomName">
					<option disabled selected>회의실 선택</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="reserveDate" class="col-sm-offset-1 col-sm-3 control-label">예약 날짜</label>
				<div class="col-xs-8 col-md-4">
					<input type="text" class="form-control" id="reserveDate" name="reserveDate">
				</div>
			</div>

			<div class="form-group">
				<label for="startTime" class="col-sm-offset-1 col-sm-3 control-label">시작 시간</label>
				<div class="col-xs-8 col-md-4">
					<input type="text" class="form-control" id="startTime" name="startTime">
				</div>
			</div>

			<div class="form-group">
				<label for="endTime" class="col-sm-offset-1 col-sm-3 control-label">종료 시간</label>
				<div class="col-xs-8 col-md-4">
					<input type="text" class="form-control" id="endTime" name="endTime">
				</div>
			</div>

			<div class="form-group">
				<label for="usePurpose" class="col-sm-offset-1 col-sm-3 control-label">이용 목적</label>
				<div class="col-xs-8 col-md-4">
					<input type="text" class="form-control" id="usePurpose" name="usePurpose">
				</div>
			</div>

			<div class="col-md-12 text-center">
				<button type="button" class="btn btn-default">예약</button>
				<button type="button" class="btn btn-default">취소</button>
			</div>
		</form>
	</div>

</body>
	</html>