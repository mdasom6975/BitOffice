<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col-sm-12 col-md-5">
		<div class="dataTables_info" id="sampleTable_info" role="status"
			aria-live="polite"></div>
	</div>


	<div class="col-sm-12 col-md-7">
		<div class="dataTables_paginate paging_simple_numbers"
			id="sampleTable_paginate">

			<nav>
				<!-- 크기조절 :  pagination-lg pagination-sm-->
				<ul class="pagination">

					<!--  <<== 좌측 nav -->
					<c:if test="${ resultPage.currentPage <= resultPage.pageUnit }">
						<li class="page-item disabled">
					</c:if>
					<c:if test="${ resultPage.currentPage > resultPage.pageUnit }">
						<li>
					</c:if>
					<li class="page-item ">
						<a class="page-link"  href="javascript:fncGetList('${ resultPage.currentPage-1}')" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>

					<!--  중앙  -->
					<c:forEach var="i" begin="${resultPage.beginUnitPage}"
						end="${resultPage.endUnitPage}" step="1">

						<c:if test="${ resultPage.currentPage == i }">
							<!--  현재 page 가르킬경우 : active -->
							<li class="page-item active">
							<a class="page-link" href="javascript:fncGetList('${ i }');">${ i }
							<span class="sr-only">(current)</span></a></li>
						</c:if>

						<c:if test="${ resultPage.currentPage != i}">
							<li class="page-item ">
							<a class="page-link" href="javascript:fncGetList('${ i }');">${ i }</a></li>
						</c:if>
					</c:forEach>

					<!--  우측 nav==>> -->
					<c:if test="${ resultPage.endUnitPage >= resultPage.maxPage }">
						<li class="disabled">
					</c:if>
					<c:if test="${ resultPage.endUnitPage < resultPage.maxPage }">
						<li>
					</c:if>
					<li class="page-item">
						<a class="page-link"  href="javascript:fncGetList('${resultPage.endUnitPage+1}')"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a>
					</li>
				</ul>
			</nav>

		</div>
	</div>
	</div>