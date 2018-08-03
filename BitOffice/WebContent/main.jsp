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

<!--  justgage charts���  -->
<script src="/javascript/raphael-2.1.4.min.js"></script>
 <script src="/javascript/justgage.js"></script>

  <script src="/js/common.js"></script>
  
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
            <div class="info">
              <h4>���ϰ���</h4>
              <p><b>10</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-lg-3">
          <div class="widget-small danger coloured-icon"><i class="icon fa fa-star fa-3x"></i>
            <div class="info">
              <h4>���� ����</h4>
              <p><b>500</b></p>
            </div>
          </div>
        </div>
          <div class="col-md-6 col-lg-3">
          <div class="widget-small info coloured-icon"><i class="icon fa fa-thumbs-o-up fa-3x"></i>
            <div class="info">
              <h4>���� �Ϸ��</h4>
              <p><b>25</b></p>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
<div class="col-md-6">
          <div class="tile">
            <h3 class="tile-title">������</h3>
            <table class="table" >
						<thead>
							<tr>
								<th>��ȣ</th>
								<th>�μ�</th>
								<th>����</th>
								<th>�̸�</th>
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
            <h3 class="tile-title">�ֱ� ������Ʈ ��������</h3>
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
            <h3 class="tile-title">������ ������</h3>
            <ul>
              <li>Built with Bootstrap 4, SASS and PUG.js</li>
            </ul>
            <p>Vali is a free and responsive admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.</p>
            <p class="mt-4 mb-4"><a class="btn btn-primary mr-2 mb-2" href="http://pratikborsadiya.in/blog/vali-admin" target="_blank"><i class="fa fa-file"></i>Docs</a>
            <a class="btn btn-info mr-2 mb-2" href="https://github.com/pratikborsadiya/vali-admin" target="_blank"><i class="fa fa-github"></i>GitHub</a>
            <a class="btn btn-success mr-2 mb-2" href="https://github.com/pratikborsadiya/vali-admin/archive/master.zip" target="_blank"><i class="fa fa-download"></i>Download</a></p>
          </div>
        </div>
        <div class="col-md-6">
          <div class="tile">
            <h3 class="tile-title">���� ȸ�ǽ� ���� ��Ȳ</h3>
            <ul>
              <li>Built with Bootstrap 4, SASS and PUG.js</li>
            </ul>
            <p>Vali is a free and responsive admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.</p>
            <p class="mt-4 mb-4"><a class="btn btn-primary mr-2 mb-2" href="http://pratikborsadiya.in/blog/vali-admin" target="_blank"><i class="fa fa-file"></i>Docs</a>
            <a class="btn btn-info mr-2 mb-2" href="https://github.com/pratikborsadiya/vali-admin" target="_blank"><i class="fa fa-github"></i>GitHub</a>
            <a class="btn btn-success mr-2 mb-2" href="https://github.com/pratikborsadiya/vali-admin/archive/master.zip" target="_blank"><i class="fa fa-download"></i>Download</a></p>
          </div>
        </div>
      </div>
    </main>
    
    <!-- Essential javascripts for application to work-->

    <script src="/js/main.js"></script>
    
  </body>
</html>
