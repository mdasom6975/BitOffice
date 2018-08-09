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
			                        <label class="col-xs-4" for="starts-at">��������</label>
			                        <input type="text" name="starts_at" id="starts-at" />		                                        
			                    </div>
			                </div>
			                <div class="row">
			                    <div class="col-xs-12">
			                        <label class="col-xs-4" for="ends-at">��������</label>
			                        <input type="text" name="ends_at" id="ends-at" />
			                    </div>
			                </div>
			                <div class="row">
			                    <div class="col-xs-12">
			                         <label class="col-xs-4" for="start-time">���۽ð�</label>
			                        <input type="text" name="start_time" id="start-time" />		                                        
			                    </div>
			                </div>
			                <div class="row">
			                    <div class="col-xs-12">
			                        <label class="col-xs-4" for="end-time">����ð�</label>
			                        <input type="text" name="end_time" id="end-time" />
			                    </div>
			                </div>   
			                <div class="row">
			                    <div class="col-xs-12">
			                        <label class="col-xs-4" for="share">��������</label>		                        
									    <select id="shareGubun" class="selectpicke" name="shareGubun" id="shareGubun" style="width:auto;">
											<option value="1">��������</option>
											<option value="2" >��&������û��</option>	
											<option value="3" >��ü����</option>			
										</select>
								                  
			                    </div>
			                </div>                               
			                <div class="row">
			                    <div class="col-xs-12">
			                        <label class="col-xs-4" for="title">����</label>
			                        <input type="text" name="title" id="title" maxlength="40"/>
			                        
			                    </div>
			                </div>
			                <div class="row">
			                    <div class="col-xs-12">
			                        <label class="col-xs-4" for="content">����</label>
			                        <input type=text name="content" id="content" maxlength="70" />
			                    </div>
			                </div> 
			                <div class="row">
			                    <div class="col-xs-12">
			                        <label class="col-xs-4" for="writername" id="writer_title">�ۼ���</label>
			                        <input type=text name="writername" id="writername" style="border:0"/>
			                    </div>
			                </div> 
			                <input type=hidden name="writer" id="writer"/>               	                  
			            </div>
			            <div class="modal-footer">
			            	<button type="button" class="btn btn-primary" id="save-event">���</button> 
			            	<button type="button" class="btn btn-primary" id="delete-event">����</button> 
			                <button type="button" class="btn btn-default" data-dismiss="modal">�ݱ�</button>                
			            </div>
			        </div><!-- /.modal-content -->
			    </div><!-- /.modal-dialog -->
		</form>		
	</div><!-- /.modal -->

