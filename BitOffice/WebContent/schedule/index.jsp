<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<script src="/js/schedule.js"></script>

	<div class="app-title">
		<div>
			<h1>��������</h1>		
			<p><span class="label label-primary"">������</span>
			   <span class="label label-warning"">��ü����</span>
				������ �������� ���� ���� ���氡���մϴ�</p>
		</div>
	</div>
		    
	<!-- Modal -->
	<div class="modal fade" id="getMessageModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Bitoffice</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <form>
		      <div id="modalmessage" class="modal-body">
		       
		      </div>
	      </form>
	      <div class="modal-footer">
	        <button type="button" id="modalClose" class="btn btn-secondary" data-dismiss="modal">�ݱ�</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!--//Modal -->

	<div class="container">   
		
			<div class="container-fluid">
				<div class="row content">	    		
					<div class="col-sm-3">	
							<input type="hidden" name="employeeNo" id="employeeNo" value="${sessionScope.employee.employeeNo}">	
				      <!--  table Start /////////////////////////////////////-->
				      <table class="table table-hover table-striped" >
				      
				        <thead>
				          <tr>      
				            <th align="left" colspan="2">��������������� / ��������</th>           
				          </tr>
				        </thead >
				       
						<tbody id="shareList">
				<!--  		        <div class="input-group" id="cp0">
						          <input type="text" class="form-control" name="title0" id="title0" value="#ABF200">
						          <span class="input-group-addon colorpicker-component"><i id="cp-icon0"></i></span>
						        </div>		 --> 
<!-- 							<div class='input-group' id='cp0'>
							<input type='text' class='form-control' name='colorpick0' id='colorpick0' value='#ABF200'>
							<span class='input-group-addon colorpicker-component'><i id='cp-icon0'></i></span>
							</div> -->
				
				        </tbody> 
				      
				      </table>
		  <!--  table End /////////////////////////////////////-->												
						    <div id="allsee">[������û��ġ��]</div>
						    <div id="SimpleJSTree"></div>   
							<div id="dvTreeStructure"></div>
	
						    
					</div>
					<div class="col-sm-9" style="background-color:#F6F6F6">
						  <jsp:include page='/schedule/listSchedule.jsp' flush="false"></jsp:include>   
		  			</div>
		  		</div>
			</div>		
		</form>	
	</div>
