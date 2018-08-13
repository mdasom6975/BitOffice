<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	         <div class="tab-pane fade active show" id="user-settings">
              <div class="tile user-settings">
                <h4 class="line-head">
<!--                 <i class="fas fa-archive"></i> -->
				<i class="fa fa-folder open" aria-hidden="true"></i>
                ${sessionEmployee.employeeNo }님의 저장소</h4>
                
	
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
					style="width: 70px;">올린 직원</th>
				<th class="sorting" tabindex="0" aria-controls="sampleTable"
					rowspan="1" colspan="1"
					aria-label="Position: activate to sort column ascending"
					style="width: 70px;">&nbsp;</th>
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
		<div class="mb-3 bs-component">
 	
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

              <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
              <form action="upload" method="post" enctype="multipart/form-data"> 
                <button class="btn btn-info" type="button"><i class="fa fa-cloud-upload" aria-hidden="true"></i>파일업로드</button>
                <div class="btn-group" role="group">
                  <button class="btn btn-info dropdown-toggle" id="btnGroupDrop3" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></button>
                  <div class="dropdown-menu dropdown-menu-right" x-placement="bottom-end" style="position: absolute; transform: translate3d(-124px, 120px, 120px); top: 0px; left: 0px; will-change: transform;">
                  <a class="dropdown-item" href="#">
                  <input type="file" name="file" />
                  </a>
                  <a class="dropdown-item" href="#">
                  <input type="text" name="notes" width="60" />
                  </a>
                  <a class="dropdown-item" href="#">
                  <input type="text" name="emp" width="60" value="${sessionEmployee.employeeName }" readonly="readonly"/>
                  </a>
                  <a class="dropdown-item" href="#">
                  <input type="submit" name="submit" value="Add"/>
                  </a>
                  </div>
                </div>
                </form>
              </div>
            </div>
<!-- 			<button type="button" class="btn btn-primary btn-sm" id="clickAdd" style="height:30;"><p><i class="fa fa-cloud-upload" aria-hidden="true"></i>파일업로드</p></button>	 -->
		</div>
	</div>
	</div>

<!-- 	<div class="row mb-4"> -->
<!-- 			    <h2>Add New File</h2> -->
<!--     <form action="upload" method="post" enctype="multipart/form-data"> -->
<!--         <table width="60%" border="1" cellspacing="0"> -->
<!--             <tr> -->
<!--                 <td width="35%"><strong>File to upload</strong></td> -->
<!--                 <td width="65%"><input type="file" name="file" /></td> -->
<!--             </tr> -->
<!--             <tr> -->
<!--                 <td><strong>Notes</strong></td> -->
<!--                 <td><input type="text" name="notes" width="60" /></td> -->
<!--             </tr>	 -->
<!--             <tr> -->
<!--                 <td>&nbsp;</td> -->
<!--                 <td><input type="submit" name="submit" value="Add"/></td> -->
<!--             </tr> -->
<!--         </table> -->
<!--     </form> -->
<!-- 	</div> -->