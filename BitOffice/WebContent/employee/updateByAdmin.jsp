<%@ page contentType="text/html; charset=EUC-KR"%>

<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
			<div class="tab-pane fade active show" id="user-settings">
              <div class="tile user-settings">
                <h4 class="line-head">
                <i class="fa fa-pencil "></i>
                ������ ���� ����</h4>
                <form enctype="multipart/form-data">
			
			<div class="row mb-4">
                    <div class="col-md-4">
                      <label>�μ�</label>
                      <select class="form-control" name="departmentNo" id="departmentNo">
                      <c:set var="i" value="0" />
					<c:forEach var="department" items="${departmentList}">
					<c:set var="i" value="${ i+1 }" />
					<option value="${department.departmentNo }"
					${getEmployee.departmentNo==department.departmentNo ? "selected" :' '}
					>${department.departmentName }</option>
					</c:forEach>
                      
                      </select>
                    </div>
                    <div class="col-md-4">
                      <label>����</label>
                      <select class="form-control" name="positionNo" id="positionNo" >
                      <c:set var="i" value="0" />
					<c:forEach var="position" items="${positionList}">
					<c:set var="i" value="${ i+1 }" />
					<option value="${position.positionNo }"
					${ getEmployee.positionNo == position.positionNo  ? "selected" :' '}
					>${position.positionName }</option>
					</c:forEach>
                      </select>
                    </div>
                  </div>

			<div class="row mb-4">
				<div class="col-md-4">
					<label>�Ի���</label> <input class="form-control" type="text"
						name="hireDate" id="hireDate" value="${getEmployee.hireDate}">
				</div>
				<div class="col-md-4">
					<label>����</label> <input class="form-control" type="text"
						name="annualLeave" id="annualLeave"
						value="${getEmployee.annualLeave}">
				</div>
			</div>

			<div class="row mb-4">
				<div class="col-md-4">
					<label>���</label> <input class="form-control" type="text"
						id="employeeNo" name="employeeNo"
						value="${getEmployee.employeeNo }">
				</div>
				<div class="col-md-4">
					<label>�̸�</label> <input class="form-control" type="text"
						id="employeeName" name="employeeName"
						value="${getEmployee.employeeName }"> 
						<input
						class="form-control" type="hidden" id="password" name="password"
						value="${getEmployee.password}"> <input
						class="form-control" type="hidden" id="password2" name="password2"
						value="${getEmployee.password}">
				</div>
			</div>


			<div class="row mb-4">
	<div class="col-md-4">
		<label>�̸���</label> 
		<input class="form-control" type="text" id="email"
			name="email" value="${getEmployee.email }" >
	</div>
	<div class="col-md-4">
		<label>�������</label> <input class="form-control" type="text"
			name="birthDate" value="${getEmployee.birthDate }" readonly="readonly">
	</div>
</div>

<div class="row mb-4">
	<div class="col-md-4">
		<label>������ȣ</label> 
		<input class="form-control" type="text"
			id="extension" name="extension" value="${getEmployee.extension }" readonly="readonly">
	</div>
	<div class="col-md-4">
		<label> �޴��� ��ȣ</label> 
		<input class="form-control" type="text" name="phone"  value="${getEmployee.phone }" readonly="readonly">
	</div>
</div>

			<div class="row mb-4">
				<div class="col-md-4">
					<label>�� �ּ�</label> <input class="form-control" type="text"
						name="address" id="address" value="${getEmployee.address}"  readonly="readonly"/><br />
<!-- 					<div id="postcodify"></div> -->
				</div>
				<div class="col-md-4">
					<label>���ڼ��� �̹���</label> 
					<input class="form-control" type="file"
						id="fileName" name="file" onchange="readURL(this);"> 
						<input
						class="form-control" type="hidden" name="profileImage"
						id="profileImage" value="${getEmployee.profileImage}"> 
						<input
						class="form-control" type="hidden" name="signImage" id="signImage"
						value="${getEmployee.signImage}">
				</div>
				<img id="LoadImg" class="img-thumbnail"
					src="http://placehold.it/180" style="width: 100px; height: 100px;">
			</div>
			
			<div class="overlay" style="visibility: hidden;" >
              <div class="m-loader mr-4">
                <svg class="m-circular" viewBox="25 25 50 50">
                	<circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="4" stroke-miterlimit="10"></circle>
                </svg>
              </div>
              <h3 class="l-text">�����������Դϴ�...</h3>
            </div>

			<div class="row mb-10">
				<div class="col-md-12">
					<button class="btn btn-primary" type="button"
						value="${getEmployee.employeeNo }" id="updateByAdmin">
						<i class="fa fa-fw fa-lg fa-check-circle"></i>����
					</button>
					<button class="btn btn-secondary" type="button">
						<i class="fa fa-fw fa-lg fa-check-circle"></i>���
					</button>
				</div>
			</div>

		</form>
<!-- form End /////////////////////////////////////-->
</div>
</div>
<!--  ȭ�鱸�� div end /////////////////////////////////////-->
