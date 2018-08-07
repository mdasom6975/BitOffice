	//=============    검색 / page 두가지 경우 모두  Event  처리 =============	
	function fncGetList(currentPage) {
		$("#currentPage").val(currentPage)
		$("form").attr("method", "POST").attr("action",
				"/department/listDepartment").submit();
	}

	//============= "검색 및 부서추가"  Event  처리 =============	
	$(function() {
		$("button.btn.btn-default:contains('검색')").on("click", function() {
			fncGetList(1);
		});
		
		$("#clickAdd").on("click", function() {
			$('#myModal').modal('show');
		});
		
		$("#addDepartment").on("click", function() {
			var departmentNo = $("input[name='departmentNo']").val();
			var departmentName = $("input[name='departmentName']").val();
			if(departmentNo == null || departmentNo.length<1 ){
				$('#chkMsg').html("<p style=\"COLOR: red\">부서번호를 입력해주세요.</p>"); 
				return;
			} if(departmentName == null || departmentName.length<1){				
				$('#chkMsg').html("<p style=\"COLOR: red\">부서명을 입력해주세요.</p>"); 
				return;
			}else{
				self.location= '/department/addDepartment?departmentNo='
					+ departmentNo
					+ "&departmentName="
					+ departmentName
			}
			
		});
	});


	//=======수정삭제 Event 처리 ========================
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
		            	alert("근무중인 임직원이 존재하여 삭제가 불가능합니다.");  
		            }
		        },
		        error:function(){
		                alert("에러입니다");
		        }
		    });
		});

	});
