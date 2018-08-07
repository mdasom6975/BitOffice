	//=============    검색 / page 두가지 경우 모두  Event  처리 =============	
	function fncGetList(currentPage) {
		$("#currentPage").val(currentPage)
		$("form").attr("method", "POST").attr("action",
				"/position/listPosition").submit();
	}

	//============= "검색 및 직급 추가"  Event  처리 =============	
	$(function() {
		$("button.btn.btn-default:contains('검색')").on("click", function() {
			fncGetList(1);
		});
		
		$("#clickAdd").on("click", function() {
			$('#myModal').modal('show');
		});
		
		$("#addPosition").on("click", function() {
			var positionNo =$("input[name='positionNo']").val();
			var positionName =$("input[name='positionName']").val();
			var rankCode =$("input[name='rankCode']").val();
			
			if (positionNo == null || positionNo.length < 1) {
				$('#chkMsg').html("<p style=\"COLOR: red\">직급번호를 입력해주세요.</p>"); 
				return;
			}if( positionName == null || positionName.length < 1){
				$('#chkMsg').html("<p style=\"COLOR: red\">직급명을 입력해주세요.</p>"); 
				return;
			}
				if( rankCode == null || rankCode.length < 1){
					$('#chkMsg').html("<p style=\"COLOR: red\">직급순차번호를 입력해주세요.</p>"); 
					return;
				}else{
	
				self.location= '/position/addPosition?positionNo='
					+ positionNo
					+ "&positionName="
					+ positionName
					+"&rankCode="
					+rankCode
			}
			
		});
	});
	
	//=======수정 Event 처리 ========================
	$(function() {

$('#updateModal').on('show.bs.modal', function(event){
			
			var button  = $(event.relatedTarget);
	        var modal = $(this);
	        
	        var position = button.data('whatever').split(',');
	        
	        console.log(position[0])
	        console.log(position[1])
	        console.log(position[2])
	        
	        modal.find('#positionNo').val(position[0])
	         modal.find('#positionName').val(position[1])
	         modal.find('#rankCode').val(position[2])

			
		})
		
		$('#updatePosition').on("click", function(){
			$("#updateForm").attr("method","POST").attr("action","/position/updatePosition").submit();
		})
		
		$(".deletePosition").on("click", function() {
			var positionNo=$(this).attr("value")
		    $.ajax({
		        url:'/employee/json/usePositionCheck',
		        type:'post',
		        data:{"positionNo":positionNo},
		        success:function(data){
		            if(data==0){
		            	self.location ="/position/deletePosition?positionNo="+positionNo;              
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
