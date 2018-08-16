<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


	<!--  화면구성 div Start /////////////////////////////////////-->
<div class="container" style="background-color: white;">

	<div class="page-header">
		<h3 class=" text-info">${employee.employeeName}님의 정보가 다음과 같이
			등록되었습니다</h3>
	</div>

	<div class="row">
		<img class="rounded-circle"
			src="/signFiles/${employee.signImage}"
			alt="${employee.signImage}"  width="140" height="140">
	</div>

	<div class="row">
		<div class="col-xs-4 col-md-2">
			<strong>부서</strong>
		</div>
		<div class="col-xs-8 col-md-4">${employee.departmentName}</div>
	</div>

	<hr />

	<div class="row">
		<div class="col-xs-4 col-md-2">
			<strong>직급</strong>
		</div>
		<div class="col-xs-8 col-md-4">${employee.positionName}</div>
	</div>

	<hr />

	<div class="row">
		<div class="col-xs-4 col-md-2">
			<strong>사번</strong>
		</div>
		<div class="col-xs-8 col-md-4">${employee.employeeNo}</div>
	</div>

	<hr />

	<div class="row">
		<div class="col-xs-4 col-md-2">
			<strong>입사일</strong>
		</div>
		<div class="col-xs-8 col-md-4">${employee.hireDate}</div>
	</div>

	<hr />

	<div class="row">
		<div class="col-xs-4 col-md-2">
			<strong>사원명</strong>
		</div>
		<div class="col-xs-8 col-md-4">${employee.employeeName}</div>
	</div>

	<hr />

	<div class="row">
		<div class="col-xs-4 col-md-2">
			<strong>생년월일</strong>
		</div>
		<div class="col-xs-8 col-md-4">${employee.birthDate}</div>
	</div>

	<hr />

	<div class="row">
		<div class="col-xs-4 col-md-2">
			<strong>이 메 일</strong>
		</div>
		<div class="col-xs-8 col-md-4">${employee.email}</div>
	</div>

	<hr />
	
	<div class="row">
		<div class="col-xs-4 col-md-2">
			<strong>연차</strong>
		</div>
		<div class="col-xs-8 col-md-4">${employee.annualLeave}</div>
	</div>

	<hr />

	<div class="col-md-12 text-center">
		<button type="button" class="btn btn-primary">확인</button>
		<button type="button" class="btn btn-primary">추가등록</button>
	</div>

	<br />

</div>
<!--  화면구성 div end /////////////////////////////////////-->
