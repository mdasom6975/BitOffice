<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page pageEncoding="EUC-KR"%>

<!--  ///////////////////////// JSTL  ////////////////////////// -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>

<html lang="ko">
	
<head>
	<meta charset="EUC-KR">
	
	<!-- 참조 : http://getbootstrap.com/css/   참조 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<!--  ///////////////////////// Bootstrap, jQuery CDN ////////////////////////// -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="http://trentrichardson.com/examples/timepicker/jquery-ui-timepicker-addon.css">

<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
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
	
		//============= "수정"  Event 연결 =============
		 $(function() {
			//==> DOM Object GET 3가지 방법 ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
			$( "button.btn.btn-primary" ).on("click" , function() {
				fncUpdateReservation();
			});
		});	
		
		
		//============= "취소"  Event 처리 및  연결 =============
		$(function() {
			//==> DOM Object GET 3가지 방법 ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
			$("a[href='#' ]").on("click" , function() {
				$("form")[0].reset();
			});
		});	
		
		///////////////////////////////////////////////////////////////////////
		function fncUpdateReservation() {
			
			$("form").attr("method" , "POST").attr("action" , "/reservation/updateReservation").submit();
		}

		$(function(){
			
		 	$("#startTime").datepicker({
			
		 		dateFormat:"yy-mm-dd",
		 	    selectOtherMonths: true,
		 	    minDate: 0, 
		 	    maxDate: "+7D"
		 	});
		 });
		$(function(){
			
		 	$("#endTime").datepicker({
			
		 		dateFormat:"yy-mm-dd",
		 	    selectOtherMonths: true,
		 	    minDate: 0, 
		 	    maxDate: "+7D"
		 	});
		 });
	
	</script>
	
</head>

<body>

	<!-- ToolBar Start /////////////////////////////////////-->
	<jsp:include page="/layout/toolbar.jsp" />
   	<!-- ToolBar End /////////////////////////////////////-->
	
	<!--  화면구성 div Start /////////////////////////////////////-->
	<div class="container">
	
		<div class="page-header text-center">
	       <h3 class=" text-info">회의실 수정</h3>
	    
	    <!-- form Start /////////////////////////////////////-->
		<form class="form-horizontal">
		  
		  <div class="form-group">
		    <label for="reNum" class="col-sm-offset-1 col-sm-3 control-label">예약 SEQ</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="reNum" name="reNum" value="${reservation.reNum }" readonly>
		       <span id="helpBlock" class="help-block">
		      	<strong class="text-danger">SEQ 수정불가</strong>
		      </span>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="startTime" class="col-sm-offset-1 col-sm-3 control-label">시작 시간</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="startTime" name="startTime"  value="${reservation.startTime}" placeholder="변경 시작 시간">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="endTime" class="col-sm-offset-1 col-sm-3 control-label">종료 시간</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="endTime" name="endTime"  value="${reservation.endTime}" placeholder="변경 종료 시간">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="usePurpose" class="col-sm-offset-1 col-sm-3 control-label">이용 목적</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="usePurpose" name="usePurpose"  value="${reservation.usePurpose}" placeholder="변경 이용 목적">
		    </div>
		  </div>

		  <div class="form-group">
		    <div class="col-sm-offset-4  col-sm-4 text-center">
		      <button type="button" class="btn btn-primary"  >수 &nbsp;정</button>
			  <a class="btn btn-primary btn" href="#" role="button">취 &nbsp;소</a>
		    </div>
		  </div>
		</form>
		<!-- form Start /////////////////////////////////////-->
	    </div>
 	</div>
	<!--  화면구성 div Start /////////////////////////////////////-->
 	
</body>

</html>