<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!--  화면구성 div Start /////////////////////////////////////-->
<div class="col-md-8">
			<div class="tab-pane fade active show" id="user-settings">
              <div class="tile user-settings">
                <h4 class="line-head">
                <i class="fa fa-user-plus"></i>
                임직원 등록</h4>
                <form enctype="multipart/form-data">
                
                <div class="row mb-4">
                <div class="col-md-4">
                      <label>비밀번호</label>
                      <input class="form-control" name="password" id="password" value="${len}" placeholder="비밀번호" >
                    </div>
                    <div class="col-md-4">
                      <label>입사일</label>
                      <input class="form-control" type="text" id="hireDate"
						name="hireDate" placeholder="입사일">
                    </div>
                    </div>

                  <div class="row mb-4">
                    <div class="col-md-4">
                      <label>부서</label>
                      <select class="form-control" name="departmentNo" id="departmentNo">
                      </select>
                    </div>
                    <div class="col-md-4">
                      <label>직급</label>
                      <select class="form-control" name="positionNo" id="positionNo" >
                      </select>
                    </div>
                  </div>
                    
                    <div class="row mb-4">
                    <div class="col-md-4">
                      <label>사번</label>
                      <input class="form-control" type="text" id="employeeNo"
						name="employeeNo" placeholder="사번">
                    </div>
                    <div class="col-md-4">
                      <label>이름</label>
                      <input class="form-control" type="text" id="employeeName"
						name="employeeName" placeholder="이름">
                    </div>
                    </div>
                    
                    <div class="row mb-4">
                    <div class="col-md-4">
                      <label>이메일</label>
                      <input class="form-control" type="text" id="email"
						name="email" placeholder="이메일">
                    </div>
                    <div class="col-md-4">
                   <label>생년월일</label>
                      <input class="form-control" type="text" id="birthDate"
						name="birthDate" placeholder="생년월일">
                    </div>
                    </div>
                    
                    <div class="row mb-4">
                    <div class="col-md-4">
                      <label>연차</label>
                      <input class="form-control" type="text" id="annualLeave"
						name="annualLeave" placeholder="연차">
                    </div>
                    <div class="col-md-4">
                      <label>전자서명이미지</label>
                      <input class="form-control" type="file" id="fileName"
						name="file" placeholder="전자서명이미지" onchange="readURL(this);" >
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
              <h3 class="l-text">정보저장중입니다...</h3>
            </div>

				<div class="tile-footer">
<!--                   <div class="row mb-10"> -->
<!--                     <div class="col-md-12"> -->
                      <button class="btn btn-primary" type="button"><i class="fa fa-fw fa-lg fa-check-circle"></i>제출</button>
                    <button class="btn btn-secondary" type="button"><i class="fa fa-fw fa-lg fa-check-circle"></i>취소</button>
                    </div>
<!--                   </div> -->

			
		</form>
		<!-- form End /////////////////////////////////////-->
		</div>
	</div>
	</div>
	<!--  화면구성 div end /////////////////////////////////////-->
