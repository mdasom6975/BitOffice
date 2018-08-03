<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page pageEncoding="EUC-KR"%>

<!--  ///////////////////////// JSTL  ////////////////////////// -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- ToolBar Start /////////////////////////////////////-->
<div class="navbar  navbar-default navbar-fixed-top">

	<div class="container">


		<a class="navbar-brand" href="/main.jsp">Bit Office</a>

		<!-- toolBar Button Start //////////////////////// -->
		<div class="navbar-header">
			<button class="navbar-toggle collapsed" data-toggle="collapse"
				data-target="#target">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<!-- toolBar Button End //////////////////////// -->

		<!--  dropdown hover Start -->
		<div class="collapse navbar-collapse" id="target"
			data-hover="dropdown"
			data-animations="fadeInDownNew fadeInRightNew fadeInUpNew fadeInLeftNew">

			<!-- Tool Bar �� �پ��ϰ� ����ϸ�.... -->
			<ul class="nav navbar-nav">

				<!--  ������ DrowDown -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"> <span>������</span>
						<span class="caret"></span>
				</a>
<!-- 					<ul class="dropdown-menu"> -->
<!-- 						<li><a href="#">����������Ʈ</a></li> -->
<!-- 						<li><a href="#">������볻��</a></li> -->
<!-- 						<li><a href="#">����������</a></li> -->
			

<%-- 						<c:if test="${sessionScope.employee.role == 'admin'}"> --%>
<!-- 							<li class="divider"></li> -->
<!-- 							<li><a href="#">�μ����</a></li> -->
<!-- 							<li><a href="#">���޵��</a></li> -->
<!-- 							<li><a href="#">���������</a></li> -->
<!-- 							<li><a href="#">����ڸ��</a></li> -->
<%-- 						</c:if> --%>
<!-- 					</ul> -->
					</li>

				<!--  ���°��� DrowDown -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"> <span>���°���</span>
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<c:if test="${sessionScope.employee.role == 'admin'}">
							<li><a href="#">IP����</a></li>
							<li><a href="#">����ٱ��ؽð�����</a></li>
						</c:if>
						<li><a href="#">������Ȳ</a></li>
						<li><a href="#">������</a></li>
						<li><a href="http://192.168.0.40:8010">ä��</a></li>

					</ul></li>

				<!--  ȸ�ǽ� ���� DrowDown -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"> <span>ȸ�ǽ�</span>
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">ȸ�ǽ� ���� ���</a></li>
						<li><a href="#">ȸ�ǽ� ����</a></li>
					</ul></li>

				<!--  ���� ���� DrowDown -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"> <span>��������</span>
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">������ȸ</a></li>
						<li><a href="#">������û����ȸ</a></li>
					</ul></li>

				<!--  ���ڰ��� DrowDown -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"> <span>���ڰ���</span>
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">�����⹮��</a></li>
						<li><a href="#">������⹮��</a></li>
						<li><a href="#">��ȿϷ���</a></li>
						<li><a href="#">�����Ϸ���</a></li>
					</ul></li>

				<!--  �������� DrowDown -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"> <span>��������</span>
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">��������</a></li>
						<li><a href="#">���������ۼ�</a></li>
					</ul></li>

				<li><a href="#">�α׾ƿ�</a></li>
			</ul>
		</div>

		<!-- dropdown hover END -->


	</div>
</div>
<!-- ToolBar End /////////////////////////////////////-->



<script type="text/javascript">
	//============= logout Event  ó�� =============	
	$(function() {
		$("a:contains('�α׾ƿ�')").on("click", function() {
			$(self.location).attr("href", "/employee/logout");

		});
	});
	//============= �μ���� Event  ó�� =============
	$(function() {
		$("a:contains('�μ����')").on("click", function() {
			self.location = "/department/listDepartment"
		});
	});
	//============= ���޵�� Event  ó�� =============
	$(function() {
		$("a:contains('���޵��')").on("click", function() {
			self.location = "/position/listPosition"
		});
	});
	//=============��������� Event  ó�� =============
	$(function() {

		$("a[href='#' ]:contains('���������')").on("click", function() {
			self.location = "/employee/addEmployee"
		});
	});
	//=============����������  Event  ó�� =============
	$(function() {

		$("a[href='#' ]:contains('����������')")
				.on("click",function() {
					self.location = "/employee/updateEmployee?employeeNo=${sessionScope.employee.employeeNo}"
		});
	});

	//============= ����������Ʈ Event  ó�� =============
	$(function() {

		$("a[href='#' ]:contains('����������Ʈ')").on("click", function() {
			self.location = "/employee/listEmployee"
		});
	});

	//============= ����� ��� Event  ó�� =============
	$(function() {

		$("a[href='#' ]:contains('����ڸ��')").on("click", function() {
			self.location = "/employee/resignList"
		});
	});

	//============= ������볻�� Event  ó�� =============
	$(function() {

		$("a[href='#' ]:contains('������볻��')").on("click", function() {
			self.location = "/employee/useAnnualLeave?employeeNo=${sessionScope.employee.employeeNo}"
		});
	});

	//============= ���°��� Event  ó�� =============

	$(function() {
		$("a:contains('IP����')").on("click", function() {
			self.location = "/ip/updateIpView"
		});
	});

	$(function() {
		$("a:contains('����ٱ��ؽð�����')").on("click", function() {
			self.location = "/standardtime/updateStandardTimeView"
		});
	});

	$(function() {
		$("a:contains('������Ȳ')").on("click", function() {
			self.location = "/attendance/listAttendance"
		});
	});

	$(function() {
		$("a:contains('������')").on("click", function() {
			self.location = "/organization/listOrganization"
		});
	});

	//============= ȸ�ǽǰ��� Event  ó�� =============
	$(function() {
		$("a:contains('ȸ�ǽ� ���� ���')").on("click", function() {
			self.location = "/meetingRoom/listMeetingRoom"
		})

	})

	//============== ȸ�ǽǿ��� Event ó�� =============
	$(function() {

		$("a:contains('ȸ�ǽ� ����')").on("click", function() {
			self.location = "/reservation/listReservation"
		})
	})

	//============= �������� Event  ó�� =============	
	$(function() {
		$("a:contains('������ȸ')").on("click", function() {
			self.location = "/schedule/index"
		})

	})

	//============= �������� Event  ó�� =============	
	$(function() {
		$("a:contains('������û����ȸ')").on("click", function() {
			self.location = "/share/updateShareView"
		})

	})

	//============= ���ڰ��� Event  ó�� =============

	$(function() {
		$("a:contains('�����⹮��')").on("click", function() {
			self.location = "/approval/listApproval"
		})

	})

	$(function() {
		$("a:contains('������⹮��')").on("click", function() {
			self.location = "/approval/listApproval"
		})

	})

	$(function() {
		$("a:contains('��ȿϷ���')").on("click", function() {
			self.location = "/approval/listApproval"
		})

	})

	$(function() {
		$("a:contains('�����Ϸ���')").on("click", function() {
			self.location = "/approval/listApproval"
		})

	})
	//============= �������� Event  ó�� =============	
	$(function() {
		$("a:contains('��������')").on("click", function() {
			self.location = "/board/listBoard?orderby="
		})

		$("a:contains('���������ۼ�')").on("click", function() {
			self.location = "/board/addBoard"
	
		})

	})
</script>
