<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
<div class="col-md-8">
			<div class="tab-pane fade active show" id="user-settings">
              <div class="tile user-settings">
                <h4 class="line-head">
                <i class="fa fa-user-plus"></i>
                ������ ���</h4>
                <form enctype="multipart/form-data">
                
                <div class="row mb-4">
                <div class="col-md-4">
                      <label>��й�ȣ</label>
                      <input class="form-control" name="password" id="password" value="${len}" placeholder="��й�ȣ" >
                    </div>
                    <div class="col-md-4">
                      <label>�Ի���</label>
                      <input class="form-control" type="text" id="hireDate"
						name="hireDate" placeholder="�Ի���">
                    </div>
                    </div>

                  <div class="row mb-4">
                    <div class="col-md-4">
                      <label>�μ�</label>
                      <select class="form-control" name="departmentNo" id="departmentNo">
                      </select>
                    </div>
                    <div class="col-md-4">
                      <label>����</label>
                      <select class="form-control" name="positionNo" id="positionNo" >
                      </select>
                    </div>
                  </div>
                    
                    <div class="row mb-4">
                    <div class="col-md-4">
                      <label>���</label>
                      <input class="form-control" type="text" id="employeeNo"
						name="employeeNo" placeholder="���">
                    </div>
                    <div class="col-md-4">
                      <label>�̸�</label>
                      <input class="form-control" type="text" id="employeeName"
						name="employeeName" placeholder="�̸�">
                    </div>
                    </div>
                    
                    <div class="row mb-4">
                    <div class="col-md-4">
                      <label>�̸���</label>
                      <input class="form-control" type="text" id="email"
						name="email" placeholder="�̸���">
                    </div>
                    <div class="col-md-4">
                   <label>�������</label>
                      <input class="form-control" type="text" id="birthDate"
						name="birthDate" placeholder="�������">
                    </div>
                    </div>
                    
                    <div class="row mb-4">
                    <div class="col-md-4">
                      <label>����</label>
                      <input class="form-control" type="text" id="annualLeave"
						name="annualLeave" placeholder="����">
                    </div>
                    <div class="col-md-4">
                      <label>���ڼ����̹���</label>
                      <input class="form-control" type="file" id="fileName"
						name="file" placeholder="���ڼ����̹���" onchange="readURL(this);" >
<%-- 						<input class="form-control" type="hidden" name="profileImage" id="profileImage" value="${employee.profileImage}"> --%>
<%-- 						<input class="form-control" type="hidden" name="signImage" id="signImage" value="${employee.signImage}"> --%>
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

				<div class="tile-footer">
<!--                   <div class="row mb-10"> -->
<!--                     <div class="col-md-12"> -->
                      <button class="btn btn-primary" type="button"><i class="fa fa-fw fa-lg fa-check-circle"></i>����</button>
                    <button class="btn btn-secondary" type="button"><i class="fa fa-fw fa-lg fa-check-circle"></i>���</button>
                    </div>
<!--                   </div> -->

			
		</form>
		<!-- form End /////////////////////////////////////-->
		</div>
	</div>
	</div>
	<!--  ȭ�鱸�� div end /////////////////////////////////////-->
