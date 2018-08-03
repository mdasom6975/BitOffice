<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page pageEncoding="EUC-KR"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- ���ڰ��� ���� function ����� ���� ���� -->
<script src="/js/approval_list.js"></script>

	<div class="app-title">
		<div>
			<h1>�����⹮��</h1>			
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

	<!-- �������� 1�ܰ� Modal -->
	<div class="modal fade" id="selectTypeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel2" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel2">Bitoffice</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div style="padding-left:20px;">
		        * ������� : �Ⱓ&����ϼ� �ʼ� �Է� ex)����,�ϰ��ް� ��<br>
		        * �������: �Ⱓ&����ϼ� �Է¾��� ex)���ó��, ���� ��û ��<br>      
	      	 	* �������� : ������ ������� ����<br>
	      	 	* �������� : �������� �������� ����<br>
	      </div>
	      <div class="modal-body">
	      		 <form class="form-inline" id="modalForm" name="modalForm">
					  <div class="form-group">					   
					    <select id="docType" name="docType" class="form-control">
							<option value="1">��������</option>
							<option value="2">��������</option>					
						</select>
					  </div>
					  <div class="form-group">					   
					    <select id=approvalOrder name="approvalOrder" class="form-control">
							<option value="1">��������</option>
							<option value="2">��������</option>					
						</select>
					  </div> 
				  				  					  
				  </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">�ݱ�</button>
 	        <button type="button" id="myFormSubmit" class="btn btn-primary">����</button> 
	      </div>
	    </div>
	  </div>
	</div>	

	<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
	<div class="tab-pane fade active show">
	    
	    <!-- table ���� �˻� Start /////////////////////////////////////-->
	    <div class="row" style="padding-left:30px">
	    	<div class="form-group row"> 
			  <div class="col-xs-1">
	    		<button type="button" id="writeApproval" class="btn btn"  >��������</button>
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
						<option value="0"  ${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>����</option>
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
      <table class="table table-hover table-striped" id="myTable2">
      
        <thead>
          <tr>
            <th align="center" >No</th>
            <th align="left" onclick="sortTable(1);" style="cursor:pointer">�����</th>
            <th align="left" onclick="sortTable(2);" style="cursor:pointer">������ȣ</th>
            <th align="left" onclick="sortTable(3);" style="cursor:pointer">������</th>
          	<th align="left" onclick="sortTable(4);" style="cursor:pointer">���ǹ��</th>            
            <th align="left" onclick="sortTable(5);" style="cursor:pointer">����</th>  
            <th align="left" onclick="sortTable(6);" style="cursor:pointer">�������</th>
            <th align="left" onclick="sortTable(7);" style="cursor:pointer">�ۼ���</th>         
          </tr>
        </thead>
       
		<tbody>
		
		  <c:set var="i" value="0" />
		  <c:forEach var="approval" items="${list}">
			<c:set var="i" value="${ i+1 }" />
			<tr>
			  <td align="center">${ i }</td>
			  <td align="left">${approval.regDate}</td> 
			  <td align="left" style="color:#0054FF;cursor:pointer;"><c:out value="${fn:substring(approval.docNo,0,8)}-${fn:substring(approval.docNo,8,12)}"/></td>
			  <td align="left"><c:if test = "${fn:trim(approval.docType) == '1'}">����</c:if>
			  				   <c:if test = "${fn:trim(approval.docType) == '2'}">�Ϲ�</c:if></td> 
			  <td align="left"><c:if test = "${fn:trim(approval.docApprovalOrder) == '1'}">����</c:if>
			  				   <c:if test = "${fn:trim(approval.docApprovalOrder) == '2'}">����</c:if></td> 				   
			  <td align="left">${approval.title}</td>			   
			  <td align="left"><c:choose><c:when test = "${fn:trim(approval.docStatus) == '1'}">���</c:when>
			  							 <c:when test = "${fn:trim(approval.docStatus) == '2'}">������</c:when>
			  							 <c:when test = "${fn:trim(approval.docStatus) == '3'}">�Ϸ�</c:when>
			  							 <c:when test = "${fn:trim(approval.docStatus) == '9'}">�ݷ�</c:when></c:choose></td>
			  <td align="left">${approval.departmentName} ${fn:trim(approval.positionName)} ${approval.regEmployeeName}</td>	
			</tr>
          </c:forEach>
        
        
        </tbody>
      
	
		   
      </table>
	  <!--  table End /////////////////////////////////////-->
	  
	 	<!-- PageNavigation Start... -->
		<jsp:include page="../common/pageNavigator_new.jsp"/>
		<!-- PageNavigation End... -->   
				  
 	</div>
 	<!--  ȭ�鱸�� div End /////////////////////////////////////-->
 	
 	

