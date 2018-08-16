<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	         <div class="tab-pane fade active show" id="user-settings">
              <div class="tile user-settings">
                <h4 class="line-head">
<!--                 <i class="fas fa-archive"></i> -->
				<i class="fa fa-folder open" aria-hidden="true"></i>
                ${sessionEmployee.employeeName }님의 저장소</h4>
                
	<button type="button" class="btn btn-outline-primary" id="clickAdd" >파일업로드</button>
	<div class="row">
        	<div class="col-sm-12">
				<table
					class="table table-hover table-bordered dataTable no-footer"
					id="sampleTable" role="grid" aria-describedby="sampleTable_info">        	
	            <thead>
	            <tr role="row">
				<th class="sorting" tabindex="0" aria-controls="sampleTable"
					rowspan="1" colspan="1"
					aria-label="Position: activate to sort column ascending"
					style="width: 70px;">No</th>
				<th class="sorting" tabindex="0" aria-controls="sampleTable"
					rowspan="1" colspan="1"
					aria-label="Position: activate to sort column ascending"
					style="width: 70px;">파일명</th>
				<th class="sorting" tabindex="0" aria-controls="sampleTable"
					rowspan="1" colspan="1"
					aria-label="Position: activate to sort column ascending"
					style="width: 70px;">메모</th>
				<th class="sorting" tabindex="0" aria-controls="sampleTable"
					rowspan="1" colspan="1"
					aria-label="Position: activate to sort column ascending"
					style="width: 70px;">작성자</th>
				<th class="sorting" tabindex="0" aria-controls="sampleTable"
					rowspan="1" colspan="1"
					aria-label="Position: activate to sort column ascending"
					style="width: 70px;">다운로드/삭제</th>
	            </tr>
	            </thead>
	            <tbody>
       			 <c:set var="i" value="0"/>

                 <c:forEach var="files" items="${list}" varStatus="counter">
                    <c:set var="i" value="${i+1 }"/>
                    <tr role="row" class="odd">
                        <td>${i }</td>
                        <td>${files.filename}</td>
                        <td>${files.notes}</td>
                        <td>${files.emp }</td>
                        <td><div align="center"><a href="download?id=${files.id}"><i class="fa fa-cloud-download fa-5" aria-hidden="true"></i></a> /
                            <a href="delete?id=${files.id}"><i class="fa fa-times fa-5" aria-hidden="true"></i></a></div>
                        </td>
                    </tr>
              		  </c:forEach>
				</tbody>
				</table>
</div>



<!-- 		<div class="mb-3 bs-component"> -->
 	
<!--               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->

<!--               <div class="btn-group" role="group" aria-label="Button group with nested dropdown"> -->
<!--               <form action="upload" method="post" enctype="multipart/form-data">  -->
<!--                 <div class="btn-group" role="group"> -->
<!--                   <button class="btn btn-info" id="btnGroupDrop3" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cloud-upload" aria-hidden="true"></i>파일업로드</button> -->
<!--                   <div class="dropdown-menu dropdown-menu-center" x-placement="bottom-end" style="position: absolute; transform: translate3d(-124px, 120px, 120px); top: 0px; left: 0px; will-change: transform;"> -->
<!--                   <div class="form-group"> -->
<!--                   <div class="row mb-2"> -->
<!--                   <label for="file">파일</label> -->
<!--                   <input type="file" name="file" /> -->
<!--                   </div> -->
<!--                   <div class="row mb-2"> -->
<!--                   <label for="notes">메모</label> -->
<!--                   <textarea class="form-control"  rows="" cols=""name="notes"  placeholder="100자 이내로 작성"></textarea> -->
<!--                  </div> -->
<!--                  <div class="row mb-2"> -->
<!--                    <label for="notes">작성자</label> -->
<%--                   <input class="form-control"  type="text" name="emp" value="${sessionEmployee.employeeName }" readonly="readonly"/> --%>
<!--                   </div> -->
<!--                   </div> -->
<!--                   <a class="dropdown-item" href="#"> -->
<!--                   <input type="submit" name="submit" value="Add"/> -->
<!--                   </a> -->
<!--                   </div> -->
<!--                 </div> -->
<!--                 </form> -->
<!--               </div> -->
<!--             </div> -->
            
   <!-- 파일 업로드 Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
      <form id="updateForm" enctype="multipart/form-data">
        <div class="modal-header">
        
        <h4 class="modal-title">파일 공유</h4>
          <button type="button" class="close" data-dismiss="modal">×</button>
        </div>
        <div class="modal-body">
          <div class="form-group">	
          	<label for="emp">작성자</label> 
			<input class="form-control" type="text" name="emp" id="emp" value="${sessionEmployee.employeeName }" readonly="readonly"style="width: 270px; height: 37px;">
			<label for="notes">메모</label>
			<textarea rows="" cols=""class="form-control" name="notes"  id="notes"placeholder="필요한 메모사항을 100자 이내로 작성해 주세요."  style="width: 270px; height: 100px;"></textarea>
				<label for="file">&nbsp;&nbsp;</label> 
				<input class="form-control"type="file" name="file" id="file"  style="width: 270px; height: 37px;">
			</div> 
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" id="uploadFile">등록</button>
        </div>
        </form>
      </div>     
    </div>
  </div>
	<!--  모달창 End /////////////////////////////////////-->
		</div>
	</div>
	</div>

