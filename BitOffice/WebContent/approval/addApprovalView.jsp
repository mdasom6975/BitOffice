<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!--  ///////////////////////// CSS ////////////////////////// -->
<style>

.ui-datepicker {
	margin-top:-260px;
	z-index: 1000;
}
  
</style>
<!-- ���ڰ��� ���� function ����� ���� ���� -->
<script src="/js/approval_addView.js"></script>

	<div class="app-title">
		<div>
			<h1>��� �ۼ�</h1>			
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
	      <div class="modal-body" border="">
	      		 <form class="form-inline" name="modalForm">
					  <div class="form-horizontal">					   
						    <div id="allsee">[��������ġ��]</div>
						    <div id="SimpleJSTree"></div>	
					    				
					  </div>	
					  <div class="form-group">					  		
							<div><button type="button" id="sel1" class="btn btn-info">������>></button>	
							<br>
							<br>
							<button type="button" id="sel2" class="btn btn" >������>></button>	</div>	
					  </div>					  
					  <div class="card-group">	
					  		<div class="card bg-primary">
						  		<div style="width:200px;height:150px;background-color:#B2EBF4" class='text-primary'>������</div>				  		
						  		<div style="width:200px;height:150px;background-color:#B2EBF4;vertical-align: top;" class="card-body text-center"><ul id="authorizationPerson" ></ul></div>
					  		</div>
					  </div>
					  <div class="card-group">	
					  		<div class="card bg-primary">
						  	    <div style="width:200px;height:150px;background-color:#D5D5D5" class='text-primary'>������</div>					  		
						  		<div style="width:200px;height:150px;background-color:#D5D5D5;vertical-align: top;" class="card-body text-center"><ul id="referencePerson" class="align-top" ></ul></div>
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
				<input type="hidden" id="docType" value="${docType}">
				<input type="hidden" id="approvalOrder" value="${approvalOrder}">
				<input type="hidden" id="employeeNo" name="employeeNo" value="${sessionScope.employee.employeeNo}">
				<input type="hidden" class="border-0" id=reqDate name="reqDate" value="${nowDate}">
				<div id="approval_member"></div>
				<div id="reference_member"></div>

				<!-- 		<input type="submit"  class="btn btn-primary pull-right" value="�۾���"> -->
				<button type="button" id="listApproval" class="btn btn">���</button>
				<button type="button" id="writeApproval" class="btn btn" >���</button>
				<button type="button" id="myFormSubmit" class="btn btn">�������</button>				

				<table class="table table-striped" style="text-align: center; boder: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">����ۼ�</th>
						</tr>
					</thead>
				</table>				
				<table class="table table-bordered" style="text-align: center; boder: 0px solid #dddddd; background-color:#FFFFFF">						
					<tbody >
						<tr>
							<td style="width:25%">
								<table width="100%" height="100%" class="table table-bordered" style="text-align: center; boder: 1px solid #dddddd;" cellpadding=0 cellspacing=0>							

									<tr>	
										<td style="background-color:#D5D5D5;">�����</td>
										<td class="text-left">${sessionScope.employee.employeeName}</td>	
								    </tr>
								    <tr>								
										<td style="background-color:#D5D5D5;">�� ��</td>
										<td class="text-left">${sessionScope.employee.departmentNo}</td>							
									</tr>	
									<tr>
										<td style="background-color:#D5D5D5;">�����</td>
										<td class="text-left">${nowDate}</td>							
									</tr>	
									<tr>
										<td style="background-color:#D5D5D5;">������ȣ</td>
										<td class="text-left">��Ͻ� �ڵ��ο�</td>							
									</tr>

								</table>	
							</td>
							<td id="middleTd">
							</td>
							<td>
								<table class="table table-bordered" style="text-align: center; boder: 1px solid #dddddd">
									<tr id="approvalLine">
																					
									</tr>											
								</table>										
							</td>																			
						</tr>						
					</tbody>
					
				</table>
								
				<table class="table table-bordered" style="text-align: center; boder: 1px solid #dddddd;background-color:#FFFFFF;">
					<tbody  id="fileTableTbody">	
				
						<tr>
							<td width="10%" style="background-color:#D5D5D5;">�� ��</td>						
							<td><input type="text" class="form-control" id="title" name="title" maxlength="50"></td>						
						</tr>
						<c:if test = "${fn:trim(param.docType) =='1'}">
							<tr>
								<td style="background-color:#D5D5D5;">�� ��</td>						
								<td class="text-left"><input type="text" class="col-xs-2" id="start_date" name="start_date">
									<input type="text" class="col-xs-2" id="end_date" name="end_date" ></td></tr>	
							<tr>
								<td style="background-color:#D5D5D5;">����ϼ�</td>						
								<td class="text-left"><input type="text" class="col-xs-2" id="use_day" name="use_day" onclick="getDateDiff();" onkeydown="onlyNumber(this)" maxlength="3"></td>						
							</tr>
						</c:if>							
						<tr>
							<td style="background-color:#D5D5D5;">�� ��</td>						
							<td><textarea class="form-control" id="content" name="content" maxlength="2048" style="height: 250px;"></textarea></td>
						</tr>	
						<tr>
							<td style="background-color:#D5D5D5;">÷������</td>
						    <td  id="dropZone">
							    <input type="file" id="fileName1" name="fileName1" />
							    <input type="file" id="fileName2" name="fileName2" />
							    <input type="file" id="fileName3" name="fileName3" /></td>
						</tr>
						<tr>
							<td width="10%" style="background-color:#D5D5D5;">�� ��</td>						
							<td><input type="text" class="form-control" id="memo" name="memo" maxlength="50"></td>						
						</tr>						
			
					</tbody>
					
				</table>
				
			</form>
		</div>
	</div>