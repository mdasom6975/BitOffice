<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page pageEncoding="EUC-KR"%>

<!--  ///////////////////////// JSTL  ////////////////////////// -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html lang="ko">

<head>
<meta name="description"
	content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
<title>Bit Office</title>
<meta charset="EUC-KR">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Main CSS-->
<link rel="stylesheet" type="text/css" href="/css/main.css">
<!-- Font-icon css-->
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Essential javascripts for application to work-->
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>

<!-- The javascript plugin to display page loading on top-->
<script src="/js/plugins/pace.min.js"></script>

<!--����Ʈ ����� ���� ����-->
<script type="text/javascript" src="/js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/js/plugins/dataTables.bootstrap.min.js"></script>
<script type="text/javascript">
$('#sampleTable').DataTable();
</script>


<!-- include summernote css/js -->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>

<!-- Board ���� function ����� ���� ���� -->
<script src="/js/board.js"></script>
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

	<main class="app-content"> <c:choose>
		<c:when test="${menu=='addBoard'}">
			<%@include file="/board/boardView.jsp"%>
		</c:when>
		<c:when test="${menu=='listBoard'}">
			<%@include file="/board/listBoard.jsp"%>
		</c:when>
		<c:when test="${menu=='updateBoard'}">
			<%@include file="/board/updateBoard.jsp"%>
		</c:when>
				<c:when test="${menu=='getBoard'}">
			<%@include file="/board/getBoard.jsp"%>
		</c:when>
		<c:otherwise>
			<%@include file="/board/listBoard.jsp"%>
		</c:otherwise>
	</c:choose> 
	</main>

<script src="/js/main.js"></script>


</body>
</html>