<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page pageEncoding="EUC-KR"%>

<!--  ///////////////////////// JSTL  ////////////////////////// -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html lang="ko">

<head>
<meta charset="EUC-KR">

<!-- 참조 : http://getbootstrap.com/css/   참조 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!--  ///////////////////////// Bootstrap, jQuery CDN ////////////////////////// -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="/javascript/datedropper.js"></script>
<link rel="stylesheet" href="/css/datedropper.css" type="text/css">

<!-- Bootstrap Dropdown Hover CSS -->
<link href="/css/animate.min.css" rel="stylesheet">
<link href="/css/bootstrap-dropdownhover.min.css" rel="stylesheet">
<!-- Bootstrap Dropdown Hover JS -->
<script src="/javascript/bootstrap-dropdownhover.min.js"></script>

<!-- jQuery UI toolTip 사용 CSS-->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- jQuery UI toolTip 사용 JS-->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!--  ///////////////////////// CSS ////////////////////////// -->
<style>
body {
	padding-top: 50px;
}

label, input {
	display: block;
}

input.text {
	margin-bottom: 12px;
	width: 95%;
	padding: .4em;
}

fieldset {
	padding: 0;
	border: 0;
	margin-top: 25px;
}

h1 {
	font-size: 1.2em;
	margin: .6em 0;
}

.header {
	background-color: #327a81;
	color: white;
	font-size: 1.5em;
	padding: 1rem;
	text-align: center;
	text-transform: uppercase;
}

img {
	border-radius: 50%;
	height: 60px;
	width: 60px;
}

.table-reservation {
	border: 1px solid #327a81;
	border-radius: 10px;
	box-shadow: 3px 3px 0 rgba(0, 0, 0, 0.1);
	max-width: calc(100% - 2em);
	margin: 1em auto;
	overflow: hidden;
	width: 800px;
}

table {
	width: 100%;
}

table td, table th {
	color: #2b686e;
	padding: 10px;
}

table td {
	text-align: center;
	vertical-align: middle;
}

table td:last-child {
	font-size: 0.95em;
	line-height: 1.4;
	text-align: left;
}

table th {
	background-color: #daeff1;
	font-weight: 300;
	text-align: center;
}

table tr:nth-child(2n) {
	background-color: white;
}

table tr:nth-child(2n+1) {
	background-color: white;
}

@media screen and (max-width: 700px) {
	table, tr, td {
		display: block;
	}
	td:first-child {
		position: absolute;
		top: 50%;
		-webkit-transform: translateY(-50%);
		transform: translateY(-50%);
		width: 100px;
	}
	td:not (:first-child ) {
		clear: both;
		margin-left: 100px;
		padding: 4px 20px 4px 90px;
		position: relative;
		text-align: left;
	}
	td:not (:first-child ):before {
		color: #91ced4;
		content: '';
		display: block;
		left: 0;
		position: absolute;
	}
	td:nth-child(2):before {
		content: 'Name:';
	}
	td:nth-child(3):before {
		content: 'Email:';
	}
	td:nth-child(4):before {
		content: 'Phone:';
	}
	td:nth-child(5):before {
		content: 'Comments:';
	}
	tr {
		padding: 10px 0;
		position: relative;
	}
	tr:first-child {
		display: none;
	}
}

@media screen and (max-width: 500px) {
	.header {
		background-color: transparent;
		color: white;
		font-size: 2em;
		font-weight: 700;
		padding: 0;
		text-shadow: 2px 2px 0 rgba(0, 0, 0, 0.1);
	}
	img {
		border: 3px solid;
		border-color: #daeff1;
		height: 100px;
		margin: 0.5rem 0;
		width: 100px;
	}
	td:first-child {
		background-color: #c8e7ea;
		border-bottom: 1px solid #91ced4;
		border-radius: 10px 10px 0 0;
		position: relative;
		top: 0;
		-webkit-transform: translateY(0);
		transform: translateY(0);
		width: 100%;
	}
	td:not (:first-child ) {
		margin: 0;
		padding: 5px 1em;
		width: 100%;
	}
	td:not (:first-child ):before {
		font-size: .8em;
		padding-top: 0.3em;
		position: relative;
	}
	td:last-child {
		padding-bottom: 1rem !important;
	}
	tr {
		background-color: white !important;
		border: 1px solid #6cbec6;
		border-radius: 10px;
		box-shadow: 2px 2px 0 rgba(0, 0, 0, 0.1);
		margin: 0.5rem 0;
		padding: 0;
	}
	.table-reservation {
		border: none;
		box-shadow: none;
		overflow: visible;
	}
	
}
#slider-range .ui-state-default { border: 1px solid #aaaaaa; background: #ffffff; }
</style>

<!--  ///////////////////////// JavaScript ////////////////////////// -->
<script type="text/javascript">
	//=============    검색 / page 두가지 경우 모두  Event  처리 =============	
	function fncGetList(currentPage) {
		$("#currentPage").val(currentPage)
		$("form").attr("method", "POST").attr("action",
				"/reservation/listReservation").submit();
	}

	//============= "검색"  Event  처리 =============	
	$(function() {
		//==> DOM Object GET 3가지 방법 ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
		$("button.btn.btn-default").on("click", function() {
			fncGetList(1);
		});
	});
	
	//========== 회의실 예약 ==========
	$(function(){
		
		$("#addReservation").on("click", function(){
			
			self.location="../reservation/addReservation"
		});
	});
	
	
	
	//========== 회의실 셀렉트메뉴 ========
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
</script>

</head>

<body>

	<!-- ToolBar Start /////////////////////////////////////-->
	<jsp:include page="/layout/toolbar.jsp" />
	<!-- ToolBar End /////////////////////////////////////-->

	<div class="container">

		<script>
			//예약 슬라이더
			$( function() {
			    $( "#slider-range" ).slider({
			      range: true,
			      min: 0,
			      max: 500,
			      values: [ 75, 300 ],
			      slide: function( event, ui ) {
			        $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
			      }
			    });
			    $( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +
			      " - $" + $( "#slider-range" ).slider( "values", 1 ) );
			    $("#slider-range").slider("enable");
			  } );
		</script>

	</div>
	

	<div class="table-reservation">
		<div class="header">시간대별 예약 현황</div>

		<table>
			<thead>
				<tr>
					<th width="80">회의실</th>
					<th>9:00-10:00</th>
					<th>10:00-11:00</th>
					<th>11:00-12:00</th>
					<th>12:00-13:00</th>
					<th>13:00-14:00</th>
					<th>14:00-15:00</th>
					<th>15:00-16:00</th>
					<th>16:00-17:00</th>
					<th>17:00-18:00</th>
					<th>18:00-19:00</th>
					<th>19:00-20:00</th>
				</tr>
			</thead>

			<tr>
				<td><select class="form--control" id="mettingRoomName"></select></td>
				<td colspan="11" id="slider-range"></td>
			</tr>
		</table>
	
	</div>
		
		<table class="table table-hover table-striped" >
				<thead>
				<tr>
					<th align="center"><button id="addReservation">회의실 예약</button></th>
				</tr>
			</thead>
		</table>

</body>

</html>