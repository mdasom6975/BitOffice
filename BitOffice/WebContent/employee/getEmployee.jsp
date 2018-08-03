<%@ page contentType="text/html; charset=EUC-KR"%>
	

	<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
	<div class="container" style="background-color: white;">

		<div class="page-header">
			<h3 class=" text-info">������ ���� ����ȸ</h3>
			<h5 class="text-muted">
				�� ������ <strong class="text-danger">�ֽ������� ����</strong>�� �ּ���.
			</h5>
		</div>

		<div class="row">
				<img class="rounded-circle"
				src="/profileFiles/${employee.profileImage}"
				alt="Generic placeholder image" width="140" height="140">
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
			<div class="col-xs-4 col-md-2 ">
				<strong>��ȭ��ȣ</strong>
			</div>
			<div class="col-xs-8 col-md-4">${ !empty employee.phone ? employee.phone : ''}
			</div>
		</div>

		<hr />

		<div class="row">
			<div class="col-xs-4 col-md-2">
				<strong>������ȣ</strong>
			</div>
			<div class="col-xs-8 col-md-4">${employee.extension}</div>
		</div>

		<hr />

		<div class="row">
			<div class="col-xs-4 col-md-2 ">
				<strong>�ּ�</strong>
			</div>
			<div class="col-xs-8 col-md-4">${employee.address}</div>
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
<div class="col-md-12 text-center ">

<c:if test="${sessionScope.employee.employeeNo == employee.employeeNo}">
<button type="button" class="btn btn-primary" value="${employee.employeeNo}">��������</button> 
</c:if>
<button type="button" class="btn btn-primary">Ȯ��</button>    
</div>
</div>
			<br />

		</div>
		<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
