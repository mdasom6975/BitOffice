<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- Sidebar menu-->
<!-- ������ ����  -->
    <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
	<div class="app-sidebar__user">
     <img class="app-sidebar__user-avatar" src="/profileFiles/${employee.profileImage}" alt="User Image" style="width: 80px; height: 80px;">
        <div>
          <p class="app-sidebar__user-name">�̸� : ${employee.employeeName}</p>
          <p class="app-sidebar__user-designation">�μ� : ${employee.departmentName}</p>
        </div>
      </div>
<!-- ������ ����  -->

<!-- sidebar �޴� ���� -->      
      <ul class="app-menu">
        
        <li class="treeview"><a class="app-menu__item active" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-laptop"></i><span class="app-menu__label">�� ����</span>
        <i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul class="treeview-menu">
            <li><a class="treeview-item" href="/employee/updateEmployee?employeeNo=${employee.employeeNo}"><i class="icon fa fa-circle-o"></i>�� ���� ����</a></li>
            <li><a class="treeview-item" href="/employee/useAnnualLeave?employeeNo=${employee.employeeNo}"><i class="icon fa fa-circle-o"></i>���� ��� ����</a></li>
          </ul>
        </li>
        
        <li><a class="app-menu__item" href="/employee/listEmployee"><i class="app-menu__icon fa fa-address-card"></i><span class="app-menu__label">������ ���</span></a></li>

        <li class="treeview"><a class="app-menu__item" href="" data-toggle="treeview"><i class="app-menu__icon fa fa-dashboard"></i><span class="app-menu__label">����</span>
        <i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul class="treeview-menu">
            <li><a class="treeview-item" href="/ip/updateIpView"><i class="icon fa fa-circle-o"></i>IP ����</a></li>
            <li><a class="treeview-item" href="/attendance/listAttendance"><i class="icon fa fa-circle-o"></i>������Ȳ</a></li>
          </ul>
        </li>
        
        <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-users"></i><span class="app-menu__label">ȸ�ǽ�</span>
        <i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul class="treeview-menu">
            <li><a class="treeview-item" href="/reservation/listReservation"><i class="icon fa fa-circle-o"></i>ȸ�ǽ� ����</a></li>
            <li><a class="treeview-item" href="/reservation/myReservation"><i class="icon fa fa-circle-o"></i>�� ���� ����</a></li>
            </ul>
        </li>
            
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
            <li><a class="treeview-item" href="/approval/listApproval"><i class="icon fa fa-circle-o"></i>�����⹮��</a></li>
            <li><a class="treeview-item" href="table-data-table.html"><i class="icon fa fa-circle-o"></i>������⹮��</a></li>
          <li><a class="treeview-item" href="table-data-table.html"><i class="icon fa fa-circle-o"></i>��ȿϷ���</a></li>
          <li><a class="treeview-item" href="table-data-table.html"><i class="icon fa fa-circle-o"></i>�����Ϸ���</a></li>
          </ul>
        </li>
        
        <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-cloud"></i><span class="app-menu__label">���ϰ���</span>
        <i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul class="treeview-menu">
            <li><a class="treeview-item" href="table-basic.html"><i class="icon fa fa-circle-o"></i> Basic Tables</a></li>
            <li><a class="treeview-item" href="table-data-table.html"><i class="icon fa fa-circle-o"></i> Data Tables</a></li>
          </ul>
        </li>

        <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-th-list"></i><span class="app-menu__label">��������</span>
        <i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul class="treeview-menu">
            <li><a class="treeview-item" href="/board/listBoard?orderby="><i class="icon fa fa-circle-o"></i>�������� ���</a></li>
            <li><a class="treeview-item" href="/board/addBoard"><i class="icon fa fa-circle-o"></i>�������� �ۼ�</a></li>
          </ul>
        </li>
        
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
      </ul>
  