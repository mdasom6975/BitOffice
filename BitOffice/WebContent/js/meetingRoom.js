
			$(function(){
				$('#deleteMR').on("click", function(){
					var meetingRoomCode=$(this).attr("value")
	
					self.location= '/meetingRoom/deleteMeetingRoom?meetingRoomCode='+meetingRoomCode
				})
				
			});


							
			$(function(){
				
				$("#clickAdd").on("click", function() {
					$('#myModal').modal('show');
				});
				
				$("#addMeetingRoom").on("click", function() {
					var meetingRoomCode = $("input[name='meetingRoomCode']").val();
					var mettingRoomName = $("input[name='mettingRoomName']").val();
					if(meetingRoomCode == null || meetingRoomCode.length<1 ){
						$('#chkMsg').html("<p style=\"COLOR: red\">회의실 코드를 입력해주세요.</p>"); 
						return;
					} if(mettingRoomName == null || mettingRoomName.length<1){				
						$('#chkMsg').html("<p style=\"COLOR: red\">회의실 이름을 입력해주세요.</p>"); 
						return;
					}else{
						self.location= '/meetingRoom/addMeetingRoom?meetingRoomCode='
							+ meetingRoomCode
							+ "&mettingRoomName="
							+ mettingRoomName
					}
				});
				
			});

			$(function() {
				
				$('#updateModal').on('show.bs.modal', function(event){
					
					var button  = $(event.relatedTarget);
			        var modal = $(this);
			        
			        var meetingRoom = button.data('whatever').split(',');
			        
			        console.log(meetingRoom[0])
			        console.log(meetingRoom[1])
			        console.log(meetingRoom[2])
			        
			        modal.find('#meetingRoomCode').val(meetingRoom[0])
			         modal.find('#mettingRoomName').val(meetingRoom[1])
			         modal.find('#mR').val(meetingRoom[2])

					
				})
				
				$('#updateMeetingRoom').on("click", function(){
					$("#updateForm").attr("method","POST").attr("action","/meetingRoom/updateMeetingRoom").submit();
				})	

		});
		
		$(function() {
			$("a[href='#' ]").on("click" , function() {
				$("form")[0].reset();
			});
		});	

		

	