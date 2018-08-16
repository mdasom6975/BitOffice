<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- Sidebar menu-->
<!-- ������ ����  -->
    <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
	<div class="app-sidebar__user">
     <img class="app-sidebar__user-avatar" src="../images/profileFiles/${sessionEmployee.profileImage}" alt="User Image" style="width: 80px; height: 80px;">
        <div>
          <p class="app-sidebar__user-name">�̸� : ${sessionEmployee.employeeName}</p>
          <p class="app-sidebar__user-designation">�μ� : ${sessionEmployee.departmentName}</p>

        </div>
      </div>
<!-- ������ ����  -->

<!-- sidebar �޴� ���� -->      
      <ul class="app-menu">
        
        <li class="treeview"><a class="app-menu__item active" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-laptop"></i><span class="app-menu__label">�� ����</span>
        <i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul class="treeview-menu">
            <li><a class="treeview-item" href="/employee/updateEmployee?employeeNo=${sessionEmployee.employeeNo}"><i class="icon fa fa-circle-o"></i>�� ���� ����</a></li>
            <li><a class="treeview-item" href="/employee/useAnnualLeave?employeeNo=${sessionEmployee.employeeNo}"><i class="icon fa fa-circle-o"></i>���� ��� ����</a></li>
          </ul>
        </li>
        
		<li><a class="app-menu__item" href="/employee/listEmployee?orderby="><i class="app-menu__icon fa fa-address-card"></i><span class="app-menu__label">������ ���</span></a></li>

        <li class="treeview"><a class="app-menu__item" href="" data-toggle="treeview"><i class="app-menu__icon fa fa-dashboard"></i><span class="app-menu__label">����</span>
        <i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul class="treeview-menu">
            <li><a class="treeview-item" href="/ip/updateIpView"><i class="icon fa fa-circle-o"></i>IP ����</a></li>
            <li><a class="treeview-item" href="/attendance/listAttendance"><i class="icon fa fa-circle-o"></i>������Ȳ</a></li>
          </ul>
        </li>
        
        <li><a class="app-menu__item" href="/reservation/myReservation"><i class="app-menu__icon fa fa-users"></i><span class="app-menu__label">ȸ�ǽ� ����</span></a></li>
            
        <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-calendar"></i><span class="app-menu__label">����</span>
        <i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul class="treeview-menu">
            <li><a class="treeview-item" href="/schedule/schedule"><i class="icon fa fa-circle-o"></i> ���� ����</a></li>
            <li><a class="treeview-item" href="/share/updateShareView"><i class="icon fa fa-circle-o"></i>���� ���� ��Ȳ</a></li>
          </ul>
        </li>
        
        <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-exchange"></i><span class="app-menu__label">���ڰ���</span>
        <i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul class="treeview-menu">
            <li><a class="treeview-item" href="/approval/listApproval?searchType=1"><i class="icon fa fa-circle-o"></i>�����⹮��</a></li>
            <li><a class="treeview-item" href="/approval/listApproval?searchType=2"><i class="icon fa fa-circle-o"></i>������⹮��</a></li>
          <li><a class="treeview-item" href="/approval/listApproval?searchType=3"><i class="icon fa fa-circle-o"></i>��ȿϷ���</a></li>
          <li><a class="treeview-item" href="/approval/listApproval?searchType=4"><i class="icon fa fa-circle-o"></i>�����Ϸ���</a></li>
          </ul>
        </li>
        
	  <li><a class="app-menu__item" href="/document/list"><i class="app-menu__icon fa fa-cloud"></i><span class="app-menu__label">���ϰ���</span></a></li>

	  <li><a class="app-menu__item" href="/chat/chat.jsp"><i class="app-menu__icon fa fa-comments" ariahidden="true"></i><span class="app-menu__label">ä��</span></a></li>

        <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-th-list"></i><span class="app-menu__label">��������</span>
        <i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul class="treeview-menu">
            <li><a class="treeview-item" href="/board/listBoard?orderby="><i class="icon fa fa-circle-o"></i>�������� ���</a></li>
            <li><a class="treeview-item" href="/board/addBoard"><i class="icon fa fa-circle-o"></i>�������� �ۼ�</a></li>
          </ul>
        </li>
        
  
        <c:if test="${sessionEmployee.role=='admin'}">
        <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-cogs"></i><span class="app-menu__label">������</span>
        <i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul class="treeview-menu">
            <li><a class="treeview-item" href="/department/listDepartment"><i class="icon fa fa-circle-o"></i> �μ����</a></li>
            <li><a class="treeview-item" href="/position/listPosition"><i class="icon fa fa-circle-o"></i>���޵��</a></li>
            <li><a class="treeview-item" href="/employee/addEmployee"><i class="icon fa fa-circle-o"></i> ���������</a></li>
            <li><a class="treeview-item" href="/standardtime/updateStandardTimeView"><i class="icon fa fa-circle-o"></i> ����� ���ؽð�</a></li>
           <li><a class="treeview-item" href="/meetingRoom/listMeetingRoom"><i class="icon fa fa-circle-o"></i>ȸ�ǽ� ����</a></li>
           <li><a class="treeview-item" href="/employee/resignList"><i class="icon fa fa-circle-o"></i>����� ���</a></li>
          </ul>
        </li>
        </c:if>
      </ul>
