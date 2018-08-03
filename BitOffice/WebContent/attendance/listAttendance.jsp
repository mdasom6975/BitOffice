<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page pageEncoding="EUC-KR"%>

	<div class="app-title">
		<div>
			<h1>������Ȳ</h1>
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

	<!-- ��� Modal -->
	<div class="modal fade" id="getCheckOutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel2" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel2">Bitoffice</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      		 <form class="form-inline" name="modalForm">
					  <div class="form-group">					   
					    <select id="memo" name="memo" class="form-control" name="memo" >
							<option value="">���</option>
							<option value="�ܱ�">�ܱ�</option>
							<option value="����">����</option>
							<option value="����">����</option>						
							<option value="����">����</option>	
							<option value="��Ÿ">��Ÿ</option>						
						</select>
					  </div>
				  </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">�ݱ�</button>
 	        <button type="button" id="myFormSubmit" class="btn btn-primary">���</button> 
	      </div>
	    </div>
	  </div>
	</div>	
 
	<!-- Timepicker Start /////////////////////////////////////-->
	<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>	
	

	
	<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
	<div class="tab-pane fade active show">
    
	    <!-- table ���� �˻� Start /////////////////////////////////////-->
	    <div class="row" style="padding-left:40px;">
	    	<div class="form-group row"> 
			  <div class="col-xs-1">
	    		<button type="button" id="checkin" class="btn btn"  >�⼮</button>
	    	  </div>
				&nbsp;&nbsp;&nbsp;&nbsp;		    	  
			  <div class="col-xs-1">
	    		<button type="button" id="checkout" class="btn btn">���</button>
	    	  </div>		    	  	
			</div>			
		</div>
		
		<div class="row">	    		    
		    <div class="col-md-6 text-left">
		    	<p class="text-primary">
		    		��ü  ${resultPage.totalCount } �Ǽ�, ���� ${resultPage.currentPage}  ������
		    	</p>
		    </div>
		    
		    <div class="col-md-6 text-right">
			    <form class="form-inline" name="detailForm">	    			      
			      
				  <div class="form-group">
				    <select class="form-control" name="searchCondition" >
						<option value="0"  ${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>�μ�</option>
						<option value="1"  ${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>�̸�</option>
					</select>
				  </div>
				  
				  <div class="form-group">
				    <label class="sr-only" for="searchKeyword">�˻���</label>
				    <input type="text" class="form-control" id="searchKeyword" name="searchKeyword"  placeholder="�˻���"
				    			 value="${! empty search.searchKeyword ? search.searchKeyword : '' }"  >
				  </div>
				  
				  <button type="button" class="btn btn-default">�˻�</button>
				  
				  <!-- PageNavigation ���� ������ ���� ������ �κ� -->
				  <input type="hidden" id="currentPage" name="currentPage" value=""/>				  
				  <input type="hidden" id="employeeNo" name="employeeNo" value="${sessionScope.employee.employeeNo}"/>
				</form>
	    	</div>
	    	
		</div>
		<!-- table ���� �˻� Start /////////////////////////////////////-->
		
		
      <!--  table Start /////////////////////////////////////-->
      <table class="table table-hover table-striped" >
      
        <thead>
          <tr>
            <th align="center">No</th>
            <th align="left" >�μ�</th>
            <th align="left">����</th>
            <th align="left">�̸�</th>
            <th align="left">�������</th>
            <th align="left">��ٽð�</th>
            <th align="left">���IP</th>
            <th align="left">�������</th>
            <th align="left">��ٽð�</th> 
            <th align="left">���IP</th>
            <th align="left">���</th>           
          </tr>
        </thead>
       
		<tbody>
		
		  <c:set var="i" value="0" />
		  <c:forEach var="attendance" items="${list}">
			<c:set var="i" value="${ i+1 }" />
			<tr>
			  <td align="center">${ i }</td>
			   <td align="left" >${attendance.departmentName}</td>
			  <td align="left">${attendance.positionName}</td>
			  <td align="left">${attendance.employeeName}</td> 
			  <td align="left">${attendance.attendateDate}</td>				  
			  <td align="left">${attendance.startTime}</td>	
			  <td align="left">${attendance.startIp}</td> 
			  <td align="left">${attendance.leaveDate}</td> 
			  <td align="left">${attendance.endTime}</td> 
			  <td align="left">${attendance.endIp}</td>	
			  <td align="left">${attendance.memo}</td>
			</tr>
          </c:forEach>
        
        </tbody>
      
      </table>
	  <!--  table End /////////////////////////////////////-->
	  
 	</div>
 	<!--  ȭ�鱸�� div End /////////////////////////////////////-->
 	
 	
 	<!-- PageNavigation Start... -->
	<jsp:include page="../common/pageNavigator_new.jsp"/>
	<!-- PageNavigation End... -->
