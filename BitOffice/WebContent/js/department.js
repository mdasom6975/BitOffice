	//=============    �˻� / page �ΰ��� ��� ���  Event  ó�� =============	
	function fncGetList(currentPage) {
		$("#currentPage").val(currentPage)
		$("form").attr("method", "POST").attr("action",
				"/department/listDepartment").submit();
	}

	//============= "�˻� �� �μ��߰�"  Event  ó�� =============	
	$(function() {
		$("button.btn.btn-default:contains('�˻�')").on("click", function() {
			fncGetList(1);
		});
		
		$("#clickAdd").on("click", function() {
			$('#myModal').modal('show');
		});
		
		$("#addDepartment").on("click", function() {
			var departmentNo = $("input[name='departmentNo']").val();
			var departmentName = $("input[name='departmentName']").val();
			if(departmentNo == null || departmentNo.length<1 ){
				$('#chkMsg').html("<p style=\"COLOR: red\">�μ���ȣ�� �Է����ּ���.</p>"); 
				return;
			} if(departmentName == null || departmentName.length<1){				
				$('#chkMsg').html("<p style=\"COLOR: red\">�μ����� �Է����ּ���.</p>"); 
				return;
			}else{
				self.location= '/department/addDepartment?departmentNo='
					+ departmentNo
					+ "&departmentName="
					+ departmentName
			}
			
		});
	});


	//=======�������� Event ó�� ========================
	$(function() {
		
		$('#updateModal').on('show.bs.modal', function(event){
			
			var button  = $(event.relatedTarget);
	        var modal = $(this);
	        
	        var department = button.data('whatever').split(',');
	        
	        console.log(department[0])
	        console.log(department[1])
	        
	        modal.find('#departmentNo').val(department[0])
	         modal.find('#departmentName').val(department[1])

			
		})
		
		$('#updateDepartment').on("click", function(){
			$("#updateForm").attr("method","POST").attr("action","/department/updateDepartment").submit();
		})

	$(".deleteDepartment").on("click", function() {
			var departmentNo=$(this).attr("value")
		    $.ajax({
		        url:'/employee/json/useDepartmentCheck',
		        type:'post',
		        data:{"departmentNo":departmentNo},
		        success:function(data){
		        	
		            if(data==0){
		            	self.location ="/department/deleteDepartment?departmentNo="+departmentNo;              
		            }else{
		            	alert("�ٹ����� �������� �����Ͽ� ������ �Ұ����մϴ�.");  
		            }
		        },
		        error:function(){
		                alert("�����Դϴ�");
		        }
		    });
		});

	});
