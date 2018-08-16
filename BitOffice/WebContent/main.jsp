<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page pageEncoding="EUC-KR"%>

<!--  ///////////////////////// JSTL  ////////////////////////// -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html lang="ko">

<head>
    <title>Bit Office</title>
    <meta charset="EUC-KR">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
   
    <!-- Essential javascripts for application to work-->
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/popper.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    
   	<!-- The javascript plugin to display page loading on top-->
    <script src="/js/plugins/pace.min.js"></script>
    
	 <!--����Ʈ ����� ���� ����-->
	<script type="text/javascript" src="/js/plugins/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="/js/plugins/dataTables.bootstrap.min.js"></script>
	
	<!--  fullcalendar ����� ���� ���� -->
<!-- 	<link type="text/css" href='/css/fullcalendar.min.css' rel='stylesheet' /> -->
<!-- 	<link href='/css/fullcalendar.print.min.css' rel='stylesheet' -->
<!-- 		media='print' /> -->
<!-- 	<link type="text/css" href='/css/testSchedule.css' rel='stylesheet' /> -->
<!-- 	<script type="text/javascript" src='/js/moment.min.js'></script> -->
<!-- 	<script type="text/javascript" src='/js/fullcalendar.min.js'></script> -->
<!-- 	<script type="text/javascript" src='/js/theme-chooser.js'></script> -->
	<!-- ������ ����� ���� ���� -->
<!-- 	<script type="text/javascript" src='/js/gcal.js'></script> -->
<!-- 	<script type="text/javascript" src='/js/locale-all.js'></script> -->
	
	<!-- color picker -->
	<!-- <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.css" rel="stylesheet"/> -->
<!-- 	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-colorpicker/2.5.1/css/bootstrap-colorpicker.css" rel="stylesheet"/> -->
<!-- 	<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script> -->
<!-- 	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-colorpicker/2.5.1/js/bootstrap-colorpicker.min.js"></script> -->
	
	<!-- bootstrap datetimepicker -->
<!-- 	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" integrity="sha256-yMjaV542P+q1RnH6XByCPDfUFhmOafWbeLPmqKh11zo=" crossorigin="anonymous" /> -->
<!-- 	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js" integrity="sha256-5YmaxAwMjIpMrVlK84Y/+NjCpKnFYa8bWWBbUHSBGfU=" crossorigin="anonymous"></script> -->
	
  	<script src="/js/common.js"></script>
  	<!-- Schedule ���� function ����� ���� ���� -->
<!-- 	<script src="/js/schedule.js"></script> -->
<!-- 	<script src="/js/testSchedule.js"></script> -->
  	<script type="text/javascript">

	</script>

  </head>
  <body class="app sidebar-mini rtl">
    <!-- Navbar-->
    <header class="app-header">
<%@include file="/layout/header.jsp"%>
    </header>
   	
   	<!-- Sidebar menu-->
<!-- ������ ����  -->
    <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
    <aside class="app-sidebar">
      <%@include file="/layout/side.jsp"%>
 <!-- sidebar �޴� ���� -->    
    </aside>

    <main class="app-content">

      <div class="row">
        <div class="col-md-6 col-lg-3">
          <div class="widget-small primary coloured-icon"><i class="icon fa fa-users fa-3x"></i>
            <div class="info" id="countEmployee">
<!--               <h4>������</h4> -->
<!--               <p><b>5</b></p> -->
            </div>
          </div>
        </div>
      
        <div class="col-md-6 col-lg-3">
          <div class="widget-small warning coloured-icon"><i class="icon fa fa-files-o fa-3x"></i>
            <div class="info" id="countFile">
            </div>
          </div>
        </div>
       <div class="col-md-6 col-lg-3">
          <div class="widget-small danger coloured-icon"><i class="icon fa fa-star fa-3x"></i>
            <div class="info" id="countGetApprovalWait">
<!--               <h4>���� ����</h4>
              <p><b>500</b></p>-->
            </div> 
          </div>
        </div>
          <div class="col-md-6 col-lg-3">
          <div class="widget-small info coloured-icon"><i class="icon fa fa-thumbs-o-up fa-3x"></i>
            <div class="info" id="countGetApprovalComplete">
<!--               <h4>���� �Ϸ��</h4>
              <p><b>25</b></p> -->
            </div>
          </div>
        </div>
      </div>
      <div class="row">
<div class="col-md-6">
          <div class="tile">
				<h3 class="tile-title"><b>������</b></h3>
				<h5 class="tile-subtitle" style="text-align: right;"id="moreEmployee"><b>more��</b></h5>
            <table class="table" >
						<thead>
							<tr>
								<th>��ȣ</th>
								<th>�μ�</th>
								<th>����</th>
								<th>�̸�</th>
								<th>���</th>
								<th>�̸���</th>
								<th>������ȣ</th>
							</tr>
						</thead>
						<tbody id="listEmployee">
							
						</tbody>
					</table>
            </div>
          </div>

        
        <div class="col-md-6">
          <div class="tile">
            <h3 class="tile-title"><b>�ֱ� ������Ʈ ��������</b></h3>
            <h5 class="tile-subtitle" style="text-align: right;" id="moreBoard"><b>more��</b></h5>
            <table class="table" >
						<thead>
							<tr>
								<th>��ȣ</th>
								<th>����</th>
								<th>�ۼ���</th>
								<th>�ۼ���</th>
								<th>��ȸ��</th>
							</tr>
						</thead>
						<tbody id="listBoard">
							
						</tbody>
					</table>
            </div>
            
          </div>
</div>
      <div class="row">
        <div class="col-md-6">
          <div class="tile">
            <h3 class="tile-title"><b>��������</b></h3>
            <p id="shareList">
            <span class="label label-warning" style="background-color:#FFBB00">��ü����</span>
             <span class="label label-primary" style="background-color:#0099ff"> ������</span></p>
			<div><jsp:include page="/schedule/listSchedule.jsp"></jsp:include>
<%-- 			<%@include file="/schedule/listSchedule.jsp"%> --%>
			</div>
          </div>
        </div>
        
       	<div class="col-md-6">
          <div class="tile">

            <h3 class="tile-title"><b>������ ����</b></h3>
            <table class="table" >
						<thead>
							<tr>
								<th>FileNo</th>
	            				<th>���ϸ�</th>
	            				<th>�ۼ���</th>
	            				<th>&nbsp;</th>
							</tr>
						</thead>
            		<tbody id="listFile">
            		
            		</tbody>
					</table>
            </div>
            

          </div>

      </div>
    </main>
    
    <!-- Essential javascripts for application to work-->

    <script src="/js/main.js"></script>
    
  </body>
</html>
