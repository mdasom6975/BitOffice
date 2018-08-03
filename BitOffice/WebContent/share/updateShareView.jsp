<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page pageEncoding="EUC-KR"%>

	<div class="app-title">
		<div>
			<h1>������û����ȸ</h1>			
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
	        
	    <!-- table ���� �˻� Start /////////////////////////////////////-->	
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
						<option value="0"  ${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>�̸�</option>
						<option value="1"  ${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>�μ�</option>
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
            <th align="center">NO</th>
            <th align="center">��û����</th>
            <th align="left">�μ�</th>
            <th align="left">����</th>
            <th align="left">������û��</th>
            <th align="left">��������</th>
            <th align="left">����</th>
          </tr>
        </thead>
       
		<tbody>
		
		  <c:set var="i" value="0" />
		  <c:forEach var="share" items="${list}"> 
					
			<c:set var="employ_No" value="${sessionScope.employee.employeeNo}" />
				 <c:if test="${employ_No eq share.acceptEmployeeNo}"> 
					<c:set var="i" value="${ i+1 }" />
					<tr>
					  <td align="center">${i}</td>
					   <td align="left">${share.regDate}</td>
					  <td align="left">${share.requestDepartmentName}</td>
					  <td align="left">${share.requestPostionName}</td> 
					  <td align="left">${share.requestEmployeeName}</td> 	
					  <td align="left">			  								   
								    <select id="shareStatus" class="form-control" name="shareStatus" onchange="fnc_accept(this.value, '${share.shareNo}');">
										<option value="N" ${share.acceptStatus== 'N' ? 'selected="selected"' : '' }>NO</option>
										<option value="Y" ${share.acceptStatus== 'Y' ? 'selected="selected"' : '' }>YES</option>				
									</select></td>					 	  
					  <td align="left"><a onclick="delShare('${share.shareNo}')"><button type="button" class=��btn��>����</button></a>
					  	</td> 			  	
					</tr>
				 </c:if>				 
          </c:forEach>
        
        </tbody>
      
      </table>
	  <!--  table End /////////////////////////////////////-->
	  
 	<!-- PageNavigation Start... -->
	<jsp:include page="../common/pageNavigator_new.jsp"/>
	<!-- PageNavigation End... -->
	
		  
 	</div>
 	<!--  ȭ�鱸�� div End /////////////////////////////////////-->
 	

