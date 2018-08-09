<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!--  ///////////////////////// CSS ////////////////////////// -->
<style>

.ui-datepicker {
	margin-top:-260px;
	z-index: 1000;
}
  
.table01 {
	width:980px
}
  
</style>

<!-- ���ڰ��� ���� function ����� ���� ���� -->
<script src="/js/approval_add.js"></script>

	<div class="app-title">
		<div>
			<h1>����󼼺���
			       <c:if test="${fn:trim(approval.docStatus)=='1'}">(���</c:if>
			       <c:if test="${fn:trim(approval.docStatus)=='2'}">(����</c:if>
			       <c:if test="${fn:trim(approval.docStatus)=='3'}">(�Ϸ�</c:if>
			       <c:if test="${fn:trim(approval.docStatus)=='9'}">(�ݷ�</c:if>
			       <c:if test="${fn:trim(approval.docApprovalOrder)=='1'}">/��������)</c:if>
				   <c:if test="${fn:trim(approval.docApprovalOrder)=='2'}">/��������)</c:if></h1>			
		</div>
	</div>
	
	<!-- ������� Modal -->
	<div class="modal fade" id="selectTypeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel2" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <div><h5 class="modal-title" id="exampleModalLabel2">������ ������ or ������ ��ư�� ��������</h5></div>
	        
            
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-header"><h6>������ BOX������ �巡�׸� ���� ���� ���氡���մϴ�</h6></div>
	      <div class="modal-body" border="1" style="padding-left:130px;">
	      		 <form class="form-inline" name="modalForm">
					  <div class="form-horizontal">					   
						    <div  style="cursor:pointer;color:#0000FF;"><span class="badge badge-dark" id="allsee" style="background-color:#336633;font-size:13px;">[��������ġ��]</span></div>
						    <div id="SimpleJSTree" style="overflow-y: auto; width:210px;height:600px;background-color:#99CC99;border:1;border-color:#003300;"></div>	
					    				
					  </div>	
					  <div class="form-group" style="padding-left:20px;">					  		
							<div><button type="button" id="sel1" class="btn btn-info">������>></button>	
							<br>
							<br>
							<button type="button" id="sel2" class="btn btn" >������>></button>	</div>	
					  </div>	
					  
					  <div class="form-horizontal" style="padding-top:20px;padding-left:20px;">					  
						  <div class="card-group">	
						  		<div class="card bg-primary">
							  		<div style="width:200px;height:40px;background-color:#B2EBF4;text-align:center;" class='text-primary'><span class="badge badge-pill badge-info" style="font-size:13px;">������</span></div>				  		
							  		<div style="width:200px;height:250px;background-color:#99CCFF;" class="card-body text-center"><ul id="authorizationPerson" ></ul></div>
						  		</div>
						  </div>
						  <br>
						  <div class="card-group text-left">	
						  		<div class="card bg-primary">
							  	    <div style="width:200px;height:40px;background-color:#D5D5D5;text-align:center;" class='text-primary'><span class="badge badge-pill badge-secondary" style="font-size:13px;">������</span></div>					  		
							  		<div style="width:200px;height:250px;background-color:#CCCCCC;" class="card-body text-center"><ul id="referencePerson" style="text-align:left"></ul></div>
							  	</div>
						  </div>
					  </div>					  						  				  					  
				  </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">�ݱ�</button> 	
	        <button type="button" id="personSubmit" class="btn btn-primary">����</button> 	                
	      </div>
	    </div>
	  </div>
	</div>		
	

	<div class="tab-pane fade active show">	
		
		<div class="row">
			<form class="form-horizontal" enctype="multipart/form-data">
				<input type="hidden" id="docType" value="${approval.docType}">
				<input type="hidden" id="approvalOrder" value="${approval.docApprovalOrder}">
				<input type="hidden" id="employeeNo" name="employeeNo" value="${sessionScope.sessionEmployee.employeeNo}">
				<input type="hidden" id="approvalNo" name="approvalNo" value="${approval.docNo}">
				<input type="hidden" class="border-0" id=reqDate name="reqDate" value="${nowDate}">
				<input type="hidden" id="searchType" name="searchType" value="${param.searchType}">
				<div id="approval_member"></div>
				<div id="reference_member"></div>

				<!-- 		<input type="submit"  class="btn btn-primary pull-right" value="�۾���"> -->
				<button type="button" class="btn btn-default" >���</button>
				<c:if test = "${fn:trim(sessionScope.sessionEmployee.employeeNo) == fn:trim(approval.regEmployeeNo) }">
				    <button type="button" id="updateApproval" class="btn btn" >����</button>
				    <button type="button" id="myFormSubmit" class="btn btn"  >�������</button></c:if>
				<table class="table table-bordered" style="text-align: center; boder: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">
								<c:if test="${fn:trim(approval.docType)=='1'}">�������</c:if>
								<c:if test="${fn:trim(approval.docType)=='2'}">�Ϲݱ��</c:if>
								</th>
						</tr>
						
					</thead>
				</table>				
				<table class="table01" style="text-align: center; boder: 1px solid #dddddd;background-color:#FFFFFF;">						
					<tbody >
						<tr>
							<td style="width:25%">
								<table width="100%" height="100%" class="table table-bordered" style="text-align: center; boder: 1px solid #dddddd;" cellpadding=0 cellspacing=0>							
										<tr>	
											<td style="background-color:#D5D5D5;">�����</td>
											<td class="text-left">${approval.regEmployeeName}</td>	
									    </tr>
									    <tr>								
											<td style="background-color:#D5D5D5;">�Ҽ�</td>
											<td class="text-left">${approval.departmentName}</td>							
										</tr>	
										<tr>
											<td style="background-color:#D5D5D5;">�����</td>
											<td class="text-left">${approval.regDate}</td>							
										</tr>	
										<tr>
											<td style="background-color:#D5D5D5;">������ȣ</td>
											<td class="text-left">${fn:substring(approval.docNo,0,8)}-${fn:substring(approval.docNo,8,13)}</td>							
										</tr>
								</table>	
							</td>
							<td id="middleTd">
							</td>
							<td id="rightTd">
								<table class="table table-bordered" style="text-align: center; boder: 1px solid #dddddd">
									<tr id="approvalLine">
																													
									</tr>											
								</table>										
							</td>																			
						</tr>						
					</tbody>
					
				</table>
								
				<table class="table table-bordered" style="width:980px;text-align: center; boder: 1px solid #dddddd;background-color:#FFFFFF;">
					<tbody  id="fileTableTbody">	
				
						<tr>
							<td width="10%" style="background-color:#D5D5D5;">�� ��</td>						
							<td class="text-left"><input type="text" class="col-lg-4" id="title" name="title" value="${approval.title}"></td>						
						</tr>
						<c:if test = "${fn:trim(approval.docType) =='1'}">
							<tr>
								<td style="background-color:#D5D5D5;">�� ��</td>						
								<td class="text-left"><input type="text" class="col-xs-2" id="start_date" name="start_date" style="text-align:center" value="${fn:substring(approval.startDate,0,4) }-${fn:substring(approval.startDate,4,6) }-${fn:substring(approval.startDate,6,8) }">
									<input type="text" class="col-xs-2" id="end_date" name="end_date" style="text-align:center" value="${fn:substring(approval.endDate,0,4) }-${fn:substring(approval.endDate,4,6) }-${fn:substring(approval.endDate,6,8) }"></td></tr>	
							<tr>
								<td style="background-color:#D5D5D5;">����ϼ�</td>						
								<td class="text-left"><input type="text" class="col-xs-2" id="use_day" name="use_day" style="text-align:center" onclick="getDateDiff();" onkeydown="onlyNumber(this)" maxlength="3" value="${approval.useDay }"></td>						
							</tr>
						</c:if>							
						<tr>
							<td style="background-color:#D5D5D5;vertical-align: middle;">�� ��</td>						
							<td height="250px"><textarea class="form-control" id="content" name="content" maxlength="2048" style="height: 250px;">${approval.content}</textarea></td>
						</tr>						
						<tr>
							<td style="background-color:#D5D5D5;">÷������</td>
						    <td  id="dropZone" class="text-left">
							    <input type="file" id="fileName1" name="fileName1" /> ${approval.fileName1}<br>
							    <input type="file" id="fileName2" name="fileName2" /> ${approval.fileName2}<br>
							    <input type="file" id="fileName3" name="fileName3" /> ${approval.fileName3}</td>
						</tr>
						<tr>
							<td width="10%" style="background-color:#D5D5D5;">�� ��</td>						
							<td class="text-left"><input type="text" class="col-lg-8" id="memo" name="memo" maxlength="50" value="${approval.memo}"></td>						
						</tr>							
					</tbody>
					
				</table>
				
			</form>
		</div>
	</div>
	
