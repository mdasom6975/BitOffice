
$(function () {

	$.ajax({
		url:"/meetingRoom/json/getReserveMeetingRoom",
		method:"GET",
		datatype : "json",
		headers:{
			"Accept" : "application/json",
			"Content-Type" : "application/json"
			
		},
		success:function(data){
			console.log(data)

			for(var i=0; i<data.meetingRoom.length; i++ ){
				$("#mettingRoomName").append($('<option value='+data.meetingRoom[i].mettingRoomName+'>'+data.meetingRoom[i].mettingRoomName+'</option>'));
			}
		}
	});
});

//예약날짜

$(function(){
	
	$("#reserveDate").datepicker({
	
		dateFormat:"yy-mm-dd",
	    selectOtherMonths: true,
	    minDate: 0, 
	    maxDate: "+7D"
	});
});

$(function(){
	
	$("#startTime").timepicker({
		
		timeFormat : 'HH:mm',
		interval : 60,
		minTime : '9',
		maxTime : '20',
		dropdown: true,
	    scrollbar: true
	});

});

	$(function(){
		
		$("#endTime").timepicker({
			
			timeFormat : 'HH:mm',
			interval : 60,
			minTime : '10',
			maxTime : '21',
			dropdown: true,
		    scrollbar: true
		});
	});

$(function(){
	$("td:nth-child(1)").css("color", "black");
})
	
		
		//============= "취소"  Event 처리 및  연결 =============
		$(function() {
			//==> DOM Object GET 3가지 방법 ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
			$("a[href='#' ]").on("click" , function() {
				$("form")[0].reset();
			});
		});	
		
		$(function(){
			$('#updateRVV').on("click", function(){
				
				fncUpdateReservation();

			})
		});
		function fncUpdateReservation(){
		
			$("form").attr("method","POST").attr("action","/reservation/updateReservation").submit();
		}
		///////////////////////////////////////////////////////////////////////
		$(function(){
			$('#updateRV').on("click", function(){
				var reNum=$(this).attr("value")

				self.location= '/reservation/updateReservation?reNum='+reNum
			})
			
		});
		
		$(function(){
			$('#deleteRV').on("click", function(){
				var reNum=$(this).attr("value")

				self.location= '/reservation/cancelReservation?reNum='+reNum
			})
			
		});

		function fncAddReservation(){	
			$("form").attr("method","POST").attr("action","/reservation/addReservation").submit();
		}

		$(function(){		
			
//			$("button.btn.btn-success:contains('예약')").on("click",function(){
			$("#reserve").on("click", function(){
				
				fncAddReservation();
		});
			
			$( "button.btn.btn-default:contains('취소')" ).on("click" , function() {
				$("form")[0].reset();
			});
			
		});