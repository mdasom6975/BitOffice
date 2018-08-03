<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<div class="row">
	<div class="col-md-6">
		<div class="tab-pane fade active show" id="user-settings">
			<div class="tile user-settings" style="height: 680px;">
				<h4 class="line-head">������ ���</h4>
				<form enctype="multipart/form-data">

					<div class="row mb-4">
						<div class="col-md-4">
							<label>��й�ȣ</label> <input class="form-control" name="password"
								id="password" value="" placeholder="��й�ȣ">
						</div>
						<!--                     <div class="col-sm-3"> -->
						<!-- 					<button type="button" class="btn btn-default">��й�ȣ����</button> -->
						<!-- 				</div> -->
						<div class="col-md-4">
							<label>�Ի���</label> <input class="form-control hasDatepicker"
								type="text" id="hireDate" name="hireDate" placeholder="�Ի���">
						</div>
					</div>

					<div class="row mb-4">
						<div class="col-md-4">
							<label>�μ�</label> <select class="form-control"
								name="departmentNo" id="departmentNo">
								
							</select>
						</div>
						<div class="col-md-4">
							<label>����</label> <select class="form-control" name="positionNo"
								id="positionNo">
								
							</select>
						</div>
					</div>

					<div class="row mb-4">
						<div class="col-md-4">
							<label>���</label> <input class="form-control" type="text"
								id="employeeNo" name="employeeNo" placeholder="���">
						</div>
						<div class="col-md-4">
							<label>�̸�</label> <input class="form-control" type="text"
								id="employeeName" name="employeeName" placeholder="�̸�">
						</div>
					</div>

					<div class="row mb-4">
						<div class="col-md-4">
							<label>�̸���</label> <input class="form-control" type="text"
								id="email" name="email" placeholder="�̸���">
						</div>
						<div class="col-md-4">
							<label>�������</label> <input class="form-control hasDatepicker"
								type="text" id="birthDate" name="birthDate" placeholder="�������">
						</div>
					</div>

					<div class="row mb-4">
						<div class="col-md-4">
							<label>����</label> <input class="form-control" type="text"
								id="annualLeave" name="annualLeave" placeholder="����">
						</div>
						<div class="col-md-4">
							<label>���ڼ����̹���</label> <input class="form-control" type="file"
								id="fileName" name="file" placeholder="���ڼ����̹���"
								onchange="readURL(this);">
						</div>
						<img id="LoadImg" class="img-thumbnail"
							src="http://placehold.it/180"
							style="width: 100px; height: 100px;">
					</div>

					<div class="row mb-10">
						<div class="col-md-12">
							<button class="btn btn-primary" type="button">
								<i class="fa fa-fw fa-lg fa-check-circle"></i>����
							</button>
							<button class="btn btn-secondary" type="button">
								<i class="fa fa-fw fa-lg fa-check-circle"></i>���
							</button>
						</div>
					</div>
				</form>

			</div>

		</div>
	</div>
	<div class="col-md-6">
	<!-- PageNavigation ���� ������ ���� ������ �κ� -->
	<input type="hidden" id="currentPage" name="currentPage"
		value="0" />
		<div class="tile">
			<h4 class="line-head">������ ���</h4>
			<div class="col-md-6 text-left">
				<p class="text-primary"></p>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>��ȣ</th>
						<th>�μ�</th>
						<th>����</th>
						<th>���</th>
						<th>�̸�</th>
					</tr>
				</thead>
				<tbody id="listEmployee">
			</table>
			<!-- <!-- PageNavigation Start... -->
			<jsp:include page="../common/pageNavigator_new.jsp" />
			<!-- <!-- PageNavigation End... -->
		</div>

	</div>
</div>
