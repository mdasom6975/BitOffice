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
       body > div.container{
        	border: 3px solid #D6CDB7;
            margin-top: 10px;
        }
        
        body{
        padding-top : 70px;
        }
    </style>
    
     <!--  ///////////////////////// JavaScript ////////////////////////// -->
     <!--  CDN(Content Delivery Network) ȣ��Ʈ ��� -->
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
 <script type="text/javascript" src="../javascript/calendar.js"></script>
<script type="text/javascript">

function fncUpdatePosition(){
	
	//Form ��ȿ�� ����
	var positionNo = $("input[name='positionNo']").val();
	var positionName = $("input[name='positionName']").val();
	var rankCode = $("input[name='rankCode']").val();
	
	
	
	if(positionNo == null || positionNo.length<1){
		alert("���޹�ȣ�� �ݵ�� �Է��Ͽ��� �մϴ�.");
		return;
	}
	
	if(positionName == null || positionName.length<1){
		alert("���޸��� �ݵ�� �Է��ϼž� �մϴ�.");
		return;
	}
	
	if(rankCode == null || rankCode.length<1){
		alert("�������Ĺ�ȣ�� �ݵ�� �Է��ϼž� �մϴ�.");
		return;
	}
	
	$("form").attr("method","POST").attr("action","/position/updatePosition").submit();
}

$(function() {
	$("button.btn.btn-default:contains('���')").on("click",function(){
		fncUpdatePosition();
	});
	
	$( "button.btn.btn-default:contains('���')" ).on("click" , function() {
		$("form")[0].reset();
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
	
		<h1 class="bg-default text-center">�� �� �� ��</h1>
	    
	    <!-- form Start /////////////////////////////////////-->
		<form class="form-horizontal" >
		
	    <div class="form-group">
		    <label for="ssn" class="col-sm-offset-1 col-sm-3 control-label">���޹�ȣ</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="positionNo" name="positionNo" value="${position.positionNo}" readonly="readonly">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="ssn" class="col-sm-offset-1 col-sm-3 control-label">���޸�</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="positionName" name="positionName" value="${position.positionName}" >
		    </div>
		  </div>
	    
	     <div class="form-group">
		    <label for="ssn" class="col-sm-offset-1 col-sm-3 control-label">�������Ĺ�ȣ</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="rankCode" name="rankCode" value="${position.rankCode}" >
		    </div>
		  </div>

		  
		  	<div class="col-md-12 text-center">
	  			<button type="button" class="btn btn-default">���</button>
	  			<button type="button" class="btn btn-default">���</button>
	  		</div>
	  		</form>
	  		</div>
	</body>
	</html>