<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page pageEncoding="EUC-KR"%>

    <!--  ȭ�鱸�� div Start /////////////////////////////////////-->
		<div class="tab-pane fade active show" id="user-settings">
              <div class="tile user-settings">
                <h4 class="line-head">�������� ����</h4>
                <form enctype="multipart/form-data">
                
                    <div class="row mb-8">
                    <div class="col-md-8">
                      <label>Title</label>
	      <input type="hidden" name="boardNo" value="${board.boardNo}">
                      <input class="form-control" type="text" id="boardTitle"
						name="boardTitle" value="${board.boardTitle}">
                    </div>
                    </div>
                    
                     <div class="row mb-8">
                    <div class="col-md-8">
                      <label>contents</label>
                      <textarea class="form-control" type="text" id="boardContent"
						name="boardContent" >${board.boardContent}</textarea>
                    </div>
                    </div>
                    
                  <div class="row mb-10">
                    <div class="col-md-12">
                      <button class="btn btn-primary" type="button" style="margin-top: 10px;"><i class="fa fa-fw fa-lg fa-check-circle"></i>Ȯ��</button>
                    
                    </div>
                  </div>
			
		</form>
		<!-- form End /////////////////////////////////////-->
		</div>
	</div>
	<!--  ȭ�鱸�� div end /////////////////////////////////////-->
