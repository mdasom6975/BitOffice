<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page pageEncoding="EUC-KR"%>

	
	<div class="app-title">
		<div>
			<h1>IP��ϼ���</h1>
			 <p>������� ������ IP ���������� ��ϰ����մϴ�. �����ڴ� IP�� �����ϼ���. ex)183.98.215.114~ 183.98.215.120</p>
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
	<!--// Modal -->

			
	<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
	<div class="tab-pane fade active show">
		<c:if test="${sessionScope.employee.role=='admin'}">         
		    <!-- table ���� �˻� Start /////////////////////////////////////-->
		    <div class="row">
	
			    	<div class="form-group row">     	
					  <div class="col-lg-6">			  
					    <input type="text" class="col-lg-1" id="startip1" name="startip1" maxlength="3" onkeydown="onlyNumber(this)" placeholder="">
				    
					    <input type="text" class="col-lg-1" id="startip2" name="startip2" maxlength="3" onkeydown="onlyNumber(this)" placeholder="">
										   
					    <input type="text" class="col-lg-1" id="startip3" name="startip3" maxlength="3" onkeydown="onlyNumber(this)" placeholder="">
					 						  
					    <input type="text" class="col-lg-1" id="startip4" name="startip4" maxlength="3" onkeydown="onlyNumber(this)" placeholder="">
				  
					    <label>~</label>							  
							  
					    <input type="text" class="col-lg-1" id="endip1" name="endip1" maxlength="3" onkeydown="onlyNumber(this)" placeholder="">
			    
					    <input type="text" class="col-lg-1" id="endip2" name="endip2" maxlength="3" onkeydown="onlyNumber(this)" placeholder="">
			   
					    <input type="text" class="col-lg-1" id="endip3" name="endip3" maxlength="3" onkeydown="onlyNumber(this)" placeholder="">
			  
					    <input type="text" class="col-lg-1" id="endip4" name="endip4" maxlength="3" onkeydown="onlyNumber(this)" placeholder="">
	
			    		<button type="button" id="ipsubmit" class="btn btn-primary"  >�� ��</button>
			    	  </div>	
					</div>
				
			</div>
	    </c:if>
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
						<option value="0"  ${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>IP����</option>
						<option value="1"  ${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }></option>
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
            <th align="left" >����IP</th>
            <th align="left">����IP</th>
            <th align="left">�������</th>
            <th align="left">����</th>
          </tr>
        </thead>
       
		<tbody>
		
		  <c:set var="i" value="0" />
		  <c:forEach var="ip" items="${list}">
			<c:set var="i" value="${ i+1 }" />
			<tr>
			  <td align="center">${ i }</td>
			   <td align="left">${ip.startIp}</td>
			  <td align="left">${ip.endIp}</td>
			  <td align="left">${ip.regDate}</td> 
			  <td align="left"><a onclick="delIp('${ip.serialNo}')"><button type="button" class=��btn��>����</button></a>
			  	</td> 			  	
			</tr>
          </c:forEach>
        
        </tbody>
      
      </table>
	  <!--  table End /////////////////////////////////////-->
			<!-- <!-- PageNavigation Start... -->
			<jsp:include page="../common/pageNavigator_new.jsp" />
			<!-- <!-- PageNavigation End... -->	  
 	</div>
 	<!--  ȭ�鱸�� div End /////////////////////////////////////-->
