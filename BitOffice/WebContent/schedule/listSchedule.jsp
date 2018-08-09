<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page pageEncoding="EUC-KR"%>



  <div id='top' style="display:none;">

    <div class='left'>

      <div id='theme-system-selector' class='selector'>
        Theme System:

        <select>
          <option value='bootstrap4' selected>Bootstrap 4</option>
          <option value='bootstrap3'>Bootstrap 3</option>
          <option value='jquery-ui'>jQuery UI</option>
          <option value='standard'>unthemed</option>
        </select>
      </div>

      <span id='loading' style='display:none'>loading theme...</span>

    </div>


  </div>

  <div id='calendar'><input type="hidden" id="employeeNo" name="employeeNo" value="${sessionScope.sessionEmployee.employeeNo}"/>		</div>



	<div id='datepicker'></div>
	
		<!-- Modal -->
	
	
	<div id="schedule_modal" class="modal fade" tabindex="-1" role="dialog">
		<form name="detailForm">	
			    	<br><br><br><br><br><br><br>
			  		<br><br><br><br><br><br><br>						
			    <div class="modal-dialog" role="document">
			        <div class="modal-content">
			            <div class="modal-header p-3 mb-2 bg-success text-white" id="hearBgColor" >                
			                <h4 class="modal-title text-center" id="headerTitle"></h4>
			            </div>
			            <div class="modal-body">   
			                <div class="row">
			                    <div class="col-xs-12">
			                        
			                        <input type="hidden" name="scheduleNo" id="scheduleNo"/>		                                        
			                    </div>
			                </div>		                              
			                <div class="row">
			                    <div class="col-xs-12">
			                        <label class="col-xs-4" for="starts-at">시작일자</label>
			                        <input type="text" name="starts_at" id="starts-at" />		                                        
			                    </div>
			                </div>
			                <div class="row">
			                    <div class="col-xs-12">
			                        <label class="col-xs-4" for="ends-at">종료일자</label>
			                        <input type="text" name="ends_at" id="ends-at" />
			                    </div>
			                </div>
			                <div class="row">
			                    <div class="col-xs-12">
			                         <label class="col-xs-4" for="start-time">시작시간</label>
			                        <input type="text" name="start_time" id="start-time" />		                                        
			                    </div>
			                </div>
			                <div class="row">
			                    <div class="col-xs-12">
			                        <label class="col-xs-4" for="end-time">종료시간</label>
			                        <input type="text" name="end_time" id="end-time" />
			                    </div>
			                </div>   
			                <div class="row">
			                    <div class="col-xs-12">
			                        <label class="col-xs-4" for="share">공유범위</label>		                        
									    <select id="shareGubun" class="selectpicke" name="shareGubun" id="shareGubun" style="width:auto;">
											<option value="1">나만보기</option>
											<option value="2" >나&공유요청자</option>	
											<option value="3" >전체공유</option>			
										</select>
								                  
			                    </div>
			                </div>                               
			                <div class="row">
			                    <div class="col-xs-12">
			                        <label class="col-xs-4" for="title">제목</label>
			                        <input type="text" name="title" id="title" maxlength="40"/>
			                        
			                    </div>
			                </div>
			                <div class="row">
			                    <div class="col-xs-12">
			                        <label class="col-xs-4" for="content">내용</label>
			                        <input type=text name="content" id="content" maxlength="70" />
			                    </div>
			                </div> 
			                <div class="row">
			                    <div class="col-xs-12">
			                        <label class="col-xs-4" for="writername" id="writer_title">작성자</label>
			                        <input type=text name="writername" id="writername" style="border:0"/>
			                    </div>
			                </div> 
			                <input type=hidden name="writer" id="writer"/>               	                  
			            </div>
			            <div class="modal-footer">
			            	<button type="button" class="btn btn-primary" id="save-event">등록</button> 
			            	<button type="button" class="btn btn-primary" id="delete-event">삭제</button> 
			                <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>                
			            </div>
			        </div><!-- /.modal-content -->
			    </div><!-- /.modal-dialog -->
		</form>		
	</div><!-- /.modal -->

