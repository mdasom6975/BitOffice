<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page pageEncoding="EUC-KR"%>


    <!--  ȭ�鱸�� div Start /////////////////////////////////////-->
		<div class="tab-pane fade active show" id="user-settings" style="width: 1100px; height: 680px;">
              <div class="tile user-settings">
                <h4 class="line-head">
                 <i class="fa fa-pencil-square-o"></i>
                 �������� ���</h4>
                <form enctype="multipart/form-data">
                
                    <div class="row mb-9">
                    <div class="col-md-9">
                      <label>&nbsp;&nbsp;&nbsp;</label>
                      <input class="form-control" type="text" id="boardTitle"
						name="boardTitle" placeholder="Title">
                    </div>
                    </div>
                    
                     <div class="row mb-9">
                    <div class="col-md-9">
                      <label>&nbsp;&nbsp;&nbsp;</label>
                      <textarea class="form-control" type="text" id="boardContent"
						name="boardContent" ></textarea>
                    </div>
                    </div>
                    
                    <div class="overlay" style="visibility: hidden;" >
              <div class="m-loader mr-4">
                <svg class="m-circular" viewBox="25 25 50 50">
                	<circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="4" stroke-miterlimit="10"></circle>
                </svg>
              </div>
              <h3 class="l-text">�̹����� �ҷ����� ���Դϴ�...</h3>
            </div>
                                        
                  <div class="row mb-10">
                    <div class="col-md-12">
                      <button class="btn btn-primary" type="button" style="margin-top: 10px;"><i class="fa fa-fw fa-lg fa-check-circle"></i>����</button>
                    
                    </div>
                  </div>
			
		</form>
		<!-- form End /////////////////////////////////////-->
		</div>
	</div>
	<!--  ȭ�鱸�� div end /////////////////////////////////////-->
