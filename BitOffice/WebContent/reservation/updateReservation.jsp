<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
         <div class="tab-pane fade active show" id="user-settings">
              <div class="tile user-settings">
                <h4 class="line-head">
                <i class="fa fa-pencil "></i>
                ${reservation.mettingRoomName } &nbsp; ${reservation.startTime }-${reservation.endTime }Ÿ�� ����</h4>
                <form>


			<div class="row mb-4">
				<div class="col-md-4">
					<label>���� �ð�</label><input type="text" class="form-control" id="startTime" name="startTime" value="${reservation.startTime }">
				</div>
				<div class="col-md-4">
					<label>���� �ð�</label> <input type="text" class="form-control" id="endTime" name="endTime" value="${reservation.endTime }">
				</div>
				<div class="col-md-4">
					<label>�̿� ����</label> <input type="text" class="form-control" id="usePurpose" name="usePurpose" value="${reservation.usePurpose }">
				</div>
			</div>
	<input type="hidden" name="reNum" value="${reservation.reNum }"/>

			<div class="row mb-10">
				<div class="col-md-12">
					<button type="button" class="btn btn-info" id="updateRVV">
						<i class="fa fa-fw fa-lg fa-check-circle"></i>����
					</button>
					<a class="btn btn-danger btn" href="#" role="button">
						<i class="fa fa-fw fa-lg fa-check-circle"></i>���
					</a>
				</div>
			</div>

		</form>
      <!-- form End /////////////////////////////////////-->
      </div>
      </div>
   <!--  ȭ�鱸�� div end /////////////////////////////////////-->