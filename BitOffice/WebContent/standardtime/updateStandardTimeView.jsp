<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page pageEncoding="EUC-KR"%>

	<div class="app-title">
		<div>
			<h1>����ٽð� ����(������)</h1>
			<p>�츮 ȸ�� ����� �ð��� �Է��ϼ���. �������� ����� �ð��� ���ڷῡ Ȱ��˴ϴ�</p>
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
	


	
	<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
	<div class="tab-pane fade active show">

	      		
		<!-- form Start /////////////////////////////////////-->
		<form class="form-horizontal">
			
		    <div class="row">   			
				<div >
			     		<input type="hidden" id="regEmployeeNo" name="regEmployeeNo" value="${sessionScope.employee.employeeNo}"/>	
						 <c:if test = "${!empty list[0].stdStartTime}"><input type="hidden" id="serialNo" name="serialNo" value ="${list[0].serialNo }"/></c:if> 
				    	
				    		<label>��ٽð�</label>     	
							<input type="text" class="form-control form-control-lg" name="stdStartTime" id="starts-at" value="${list[0].stdStartTime }"/>
							<br>
							<label>��ٽð�</label>   	
							<input type="text" class="form-control form-control-lg" name="stdEndTime" id="ends-at" value="${list[0].stdEndTime }"/>				  
							
							<br>
					  		<button type="button" class="btn btn-primary"><c:if test = "${empty list[0].stdStartTime}">���</c:if>
					  													  <c:if test = "${!empty list[0].stdStartTime}">����</c:if></button>
			    	  		
			  	</div>
			</div>
		</form>	        

	  <!--  form End /////////////////////////////////////-->
	  
 	</div>
