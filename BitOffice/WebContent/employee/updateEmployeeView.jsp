<%@ page contentType="text/html; charset=EUC-KR"%>



<!--  화면구성 div Start /////////////////////////////////////-->
			<div class="tab-pane fade active show" id="user-settings">
              <div class="tile user-settings">
                <h4 class="line-head">
                <i class="fa fa-pencil "></i>
                내 정보 수정</h4>
                <form enctype="multipart/form-data">

			<div class="row mb-4">
				<div class="col-md-4">
					<label>부서</label> 
					<input class="form-control" type="text" name="departmentName"
						id="departmentName" value="${getEmployee.departmentName}" readonly>
				</div>
				<div class="col-md-4">
					<label>직급</label> 
					<input class="form-control" type="text" id="positionName"
						name="positionName" value="${getEmployee.positionName}" readonly>
				</div>
			</div>

			<div class="row mb-4">
				<div class="col-md-4">
					<label>입사일</label> <input class="form-control" type="text"
						name="hireDate" id="hireDate" value="${getEmployee.hireDate}"
						readonly>
				</div>
				<div class="col-md-4">
					<label>연차</label> <input class="form-control" type="text"
						name="annualLeave" id="annualLeave"
						value="${getEmployee.annualLeave}" readonly>
				</div>
			</div>

			<div class="row mb-4">
				<div class="col-md-4">
					<label>사번</label> <input class="form-control" type="text"
						id="employeeNo" name="employeeNo"
						value="${getEmployee.employeeNo }" readonly>
				</div>
				<div class="col-md-4">
					<label>이름</label> <input class="form-control" type="text"
						id="employeeName" name="employeeName"
						value="${getEmployee.employeeName }" readonly>
				</div>
			</div>
			<div class="row mb-4">
				<div class="col-md-4">
					<label>비밀번호</label> <input class="form-control" type="password"
						id="password" name="password" placeholder="비밀번호">
				</div>
				<div class="col-md-4">
					<label>&nbsp;&nbsp;&nbsp;</label> <input class="form-control"
						type="password" id="password2" name="password2"
						placeholder="비밀번호 확인">
				</div>
			</div>

	<div class="row mb-4">
	<div class="col-md-4">
		<label>이메일</label> <input class="form-control" type="text" id="email"
			name="email" value="${getEmployee.email }">
	</div>
	<div class="col-md-4">
		<label>생년월일</label> <input class="form-control" type="text"
			id="birthDate" name="birthDate" value="${getEmployee.birthDate }">
	</div>
</div>

<div class="row mb-4">
	<div class="col-md-4">
		<label>내선번호</label> <input class="form-control" type="text"
			id="extension" name="extension" value="${getEmployee.extension }">
	</div>
	<div class="col-mb-4">
		<label> 휴대폰 번호</label>
		 <select class="form-control" name="phone1"id="phone1">
			<option value="010"
				${ !empty getEmployee.phone1&&getEmployee.phone1=="010" ? "selected" : ''}>010</option>
			<option value="011"
				${ !empty getEmployee.phone1&&getEmployee.phone1=="011" ? "selected" : ''}>011</option>
			<option value="016"
				${ !empty getEmployee.phone1&&getEmployee.phone1=="016" ? "selected" : ''}>016</option>
			<option value="018"
				${ !empty getEmployee.phone1&&getEmployee.phone1=="018" ? "selected" : ''}>018</option>
			<option value="019"
				${ !empty getEmployee.phone1&&getEmployee.phone1=="019" ? "selected" : ''}>019</option>
		</select>
	</div>
	<div class="col-mb-4">
		<label>&nbsp;&nbsp;&nbsp;</label> <input type="text"
			class="form-control" id="phone2" name="phone2"
			value="${ !empty getEmployee.phone2 ? getEmployee.phone2 : ''}">
	</div>
	<div class="col-mb-4">
		<label> &nbsp;&nbsp;&nbsp;</label> <input type="text"
			class="form-control" id="phone3" name="phone3"
			value="${ !empty getEmployee.phone3 ? getEmployee.phone3 : ''}">
	</div>
	<input type="hidden" name="phone" />


</div>

<div class="row mb-4">
	<div class="col-md-4">
		<label>집 주소</label> <input class="form-control" type="text"
			name="address" id="address" value="${getEmployee.address}" /><br />
		<div id="postcodify"></div>
	</div>
	<div class="col-md-4">
		<label>프로필 이미지</label> 
		<input class="form-control" type="file"
			id="fileName" name="file" onchange="readURL(this);"> 
			<input class="form-control" type="hidden" name="profileImage"
			id="profileImage" value="${getEmployee.profileImage}"> 
			<input class="form-control" type="hidden" name="signImage" id="signImage"
			value="${getEmployee.signImage}">
	</div>
	<img id="LoadImg" class="img-thumbnail" src="http://placehold.it/180"
		style="width: 100px; height: 100px;">
</div>

<div class="overlay" style="visibility: hidden;" >
              <div class="m-loader mr-4">
                <svg class="m-circular" viewBox="25 25 50 50">
                	<circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="4" stroke-miterlimit="10"></circle>
                </svg>
              </div>
              <h3 class="l-text">정보저장중입니다...</h3>
            </div>

<div class="row mb-10">
	<div class="col-md-12">
		<button class="btn btn-primary" type="button"
			value="${getEmployee.employeeNo }" id="updateEmployee">
			<i class="fa fa-fw fa-lg fa-check-circle"></i>등록
		</button>
		<button class="btn btn-secondary" type="button">
			<i class="fa fa-fw fa-lg fa-check-circle"></i>취소
		</button>
	</div>
</div>

</form>
<!-- form End /////////////////////////////////////-->
</div>
</div>
<!--  화면구성 div end /////////////////////////////////////-->
