<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


	<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
<div class="container" style="background-color: white;">

	<div class="page-header">
		<h3 class=" text-info">${employee.employeeName}���� ������ ������ ����
			��ϵǾ����ϴ�</h3>
	</div>

	<div class="row">
		<img class="rounded-circle"
			src="/signFiles/${employee.signImage}"
			alt="${employee.signImage}"  width="140" height="140">
	</div>

	<div class="row">
		<div class="col-xs-4 col-md-2">
			<strong>�μ�</strong>
		</div>
		<div class="col-xs-8 col-md-4">${employee.departmentName}</div>
	</div>

	<hr />

	<div class="row">
		<div class="col-xs-4 col-md-2">
			<strong>����</strong>
		</div>
		<div class="col-xs-8 col-md-4">${employee.positionName}</div>
	</div>

	<hr />

	<div class="row">
		<div class="col-xs-4 col-md-2">
			<strong>���</strong>
		</div>
		<div class="col-xs-8 col-md-4">${employee.employeeNo}</div>
	</div>

	<hr />

	<div class="row">
		<div class="col-xs-4 col-md-2">
			<strong>�Ի���</strong>
		</div>
		<div class="col-xs-8 col-md-4">${employee.hireDate}</div>
	</div>

	<hr />

	<div class="row">
		<div class="col-xs-4 col-md-2">
			<strong>�����</strong>
		</div>
		<div class="col-xs-8 col-md-4">${employee.employeeName}</div>
	</div>

	<hr />

	<div class="row">
		<div class="col-xs-4 col-md-2">
			<strong>�������</strong>
		</div>
		<div class="col-xs-8 col-md-4">${employee.birthDate}</div>
	</div>

	<hr />

	<div class="row">
		<div class="col-xs-4 col-md-2">
			<strong>�� �� ��</strong>
		</div>
		<div class="col-xs-8 col-md-4">${employee.email}</div>
	</div>

	<hr />
	
	<div class="row">
		<div class="col-xs-4 col-md-2">
			<strong>����</strong>
		</div>
		<div class="col-xs-8 col-md-4">${employee.annualLeave}</div>
	</div>

	<hr />

	<div class="col-md-12 text-center">
		<button type="button" class="btn btn-primary">Ȯ��</button>
		<button type="button" class="btn btn-primary">�߰����</button>
	</div>

	<br />

</div>
<!--  ȭ�鱸�� div end /////////////////////////////////////-->
