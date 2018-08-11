  $(document).ready(function() { 				

    initThemeChooser({

      init: function(themeSystem) {
        $('#calendar').fullCalendar({
        	
        /*******************/	
        
        
       	local: 'ko',			
		lang: 'ko',			
		firstDay: '0',  
		//nowIndicator: true,
	    //now: '2018-06-20T09:25:00', // just for demo
		displayEventTime: true,
		
		//height:700,
		contentHeight: 650,
		selectable: true, 
		//selectHelper: false,
		eventLimit: true,
		
		/*******************/
		
          //themeSystem: 'bootstrap3',
          header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay,listMonth'
          },
          
          //defaultDate: '2018-06-12',          

          weekNumbers: false,
          navLinks: true, // can click day/week names to navigate views
          editable: false,
          eventLimit: true, // allow "more" link when too many events   

          googleCalendarApiKey : "AIzaSyDcnW6WejpTOCffshGDDb4neIrXVUA1EAE",      // Google API KEY

          eventSources : [
                      
              {            	  
                   googleCalendarId : "ko.south_korea#holiday@group.v.calendar.google.com"
                 , className : "koHolidays"
                 , color : "#FF0000"
                 , textColor : "#FFFFFF"                
              }
 		   ]
          ,events: 	 '/schedule/json/listSchedule/'+$('#employeeNo').val()       
          
  
       	  ,eventTextColor: '#000000'
		//, eventColor: '#378006'	
		//, eventBackgroundColor: '#378006'
		//, eventBorderColor: '#378006'          
           ,timeFormat: 'HH(:mm)'
        
          
     		   // ,select: function(startDate, endDate) {
     		   //       alert('selected ' + startDate.format() + ' to ' + endDate.format());
     		   //     } 
   			
        	   ,select: function(startDate, endDate	) {
              
                   var view = $('#calendar').fullCalendar('getView');                   
                                    
                   $('#schedule_modal').modal('show');                   
                   $('#schedule_modal').find('input').val('');
                   $('#schedule_modal').find('#starts-at').val(startDate.format());
                   if (view.name == 'month'){
                  	 $('#schedule_modal').find('#ends-at').val(date_add(endDate.format(), -1));
                   }else{
                	 $('#schedule_modal').find('#ends-at').val(endDate.format());  
                   } 
                   
                   $('#shareGubun').val('2').prop("selected", true);                   
                   $('#headerTitle').text('일정작성'); 
                   $('#save-event').text('등록');                 
                   $('#save-event').show();  
                   $('#delete-event').hide();
                   $('#writer_title').hide(); 
                   $('#writername').hide(); 
  

               }
               ,eventClick: function(event, element) {
             	   $('#schedule_modal').modal('show');   
                   $('#schedule_modal').find('input').val('');                   
                   $('#schedule_modal').find('#scheduleNo').val(event.id);
                   $('#schedule_modal').find('#title').val(event.title);
                   $('#schedule_modal').find('#content').val(event.description);
                   $('#schedule_modal').find('#starts-at').val(event.start.format('YYYY-MM-DD'));
                   $('#schedule_modal').find('#ends-at').val(event.end.format('YYYY-MM-DD'));
                   $('#schedule_modal').find('#start-time').val(event.start.format('HH:mm'));
                   $('#schedule_modal').find('#end-time').val(event.end.format('HH:mm'));    
                   $('#schedule_modal').find('#writername').val(event.writername);  
                   $('#schedule_modal').find('#writer').val(event.writer);     
                   
                   hearBgColor
                   $('#hearBgColor').css('background-color',event.backgroundColor);
                   $('#headerTitle').text('일정조회');   
                   $('#shareGubun').val(event.sharerange).prop("selected", true);
              		$('#writername').show();
               		$('#writer_title').show(); 			
            	   //alert( $('#employeeNo').val()+"=="+$('#writer').val());
            	   
            	   //작성자와 세션 일치할 경우
            	   if ($('#employeeNo').val().indexOf($('#writer').val())>=0){                  		
    					$('#schedule_modal').find('#save-event').text('수정'); 
            		    $('#save-event').show();                   	
                   		$('#delete-event').show();
            	   }else{
                  		$('#save-event').hide();
                   		$('#delete-event').hide();  
            	   }
               },
               
/* 		  eventClick: function(calEvent, jsEvent, view) {

			    alert('Event: ' + calEvent.title);
			    //alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
			    //alert('View: ' + view.name);

			    // change the border color just for fun
			    //$(this).css('border-color', 'red');
			    



			  }  */		
  			
  			/* 			
  			,
  			dayClick: function(date, jsEvent, view) {
  				alert('Clicked on: ' + date.format());
  				//alert('Resource ID: ' + resourceObj.id);
  				//alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
  				//alert('Current view: ' + view.name);
  				//alert('Current id: ' + resourceObj.id);
  			}
  			
  			
  			
  			,
  			dayClick: function(date, jsEvent, view) {
  				alert('Clicked on: ' + date.format());
  				var m = moment();
  				//alert('Resource ID: ' + resourceObj.id);
  				//alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
  				//alert('Current view: ' + view.name);
  				//alert('Current id: ' + resourceObj.id);
  			}
  			
  			,
  			eventMouseover: function(event, jsEvent, view) {
  				alert('Mouse over: ' + date.format());
  				//alert('Resource ID: ' + resourceObj.id);
  				//alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
  				//alert('Current view: ' + view.name);
  				//alert('Current id: ' + resourceObj.id);
  			}	 	

  			,
  			unselect: function(jsEvent, view) {
  				alert('Clicked on: ' + view.name);
  				//alert('Resource ID: ' + resourceObj.id);
  				//alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
  				//alert('Current view: ' + view.name);
  				//alert('Current id: ' + resourceObj.id);
  			}	*/          
        });
        
        //$("#starts-at, #ends-at").datetimepicker({
        	//format: 'LT',
        //	locale: 'ru',
        //	sideBySide:true        	
        //});

        $("#starts-at, #ends-at").datetimepicker({
        	format: 'YYYY-MM-DD',
        	sideBySide:false  
        	//pick12HourFormat: false
        });
    
       
       $("#start-time, #end-time").datetimepicker({
       	format: 'HH:mm',
       	sideBySide:false  
       	//pick12HourFormat: false
       });       
        
        
        // 일정등록
        $('#save-event').on('click', function() {
        	var scheduleNo = $('#scheduleNo').val();
        	var title = $('#title').val(); 
            var content = $('#content').val();      
            var sdate = $('#starts-at').val();   
            var edate = $('#ends-at').val();
            var stime = $('#start-time').val();   
            var etime = $('#end-time').val();            
            var title = $('#title').val();     
            var employeeNo = $('#employeeNo').val();
            var shareGubun =  $( "#shareGubun option:selected" ).val();    

            //alert("shareGubun:"+shareGubun);
            
            if(sdate.length<8){
            	alert("Insert Start-time");
            	$('#starts-at').focus();
            	return
            }
            
            if(edate.length<8){
            	alert("Insert End-time");
            	$('#ends-at').focus();
            	return
            }
            
            if(sdate > edate){
            	alert("rewrite sdate <= edate ");
            	$('#ends-at').focus();
            	return
            }            
            
            if(stime.length<5){
            	alert("Insert Start-time");
            	$('#start-time').focus();
            	return
            }
            
            if(etime.length<5){
            	alert("Insert End-time");
            	$('#end-time').focus();
            	return
            }
            
            if(stime > etime){
            	alert("rewrite star-time <=End-time");
            	$('#end-time').focus();
            	return
            }            
            
            if(title.length<1){
            	alert("Insert Title");
            	$('#title').focus();
            	return
            }             
            
            
            if (title) {
	            //save  

	            if ($('#save-event').text().trim().indexOf('등록')>=0){	            	
		            	$.ajax({
		            		url : "/schedule/json/addSchedule",
							method : "POST" ,
							data : { 	
								"title": title,
								"content": content,
								"startDate":sdate ,
								"endDate":edate ,
								"startTime":stime ,
								"endTime":etime ,									
								"shareRange":shareGubun,
								"color": '#0099ff',							
								"employeeNo":employeeNo
										} ,	
							contentType : "application/x-www-form-urlencoded; charset=EUC-KR",
							dataType : "json" ,
							success : function(returnValue, status) {
								if (returnValue == 1){ 
									alert("등록되었습니다");
									location.reload();
								}else{
									alert("등록 실패! 관리자에게 문의!");									
								}
							},
							error : function(request, status,error) {
						        alert("등록 접속 error");
						        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
						    }							
					}); 	            	
	            	
	            }else{  //moify
	            	
			            	$.ajax({
			            		url : "/schedule/json/updateSchedule",
								method : "POST" ,
								data : { 	
									"scheSerialNo":scheduleNo,
									"title": title,
									"content": content,
									"startDate":sdate ,
									"endDate":edate ,
									"startTime":stime ,
									"endTime":etime ,	
									"shareRange":shareGubun,
									"color": '#0099ff'
								} ,	
								contentType : "application/x-www-form-urlencoded; charset=UTF-8",
								dataType : "json" ,
								success : function(returnValue, status) {
									if (returnValue == 1){ 
										alert("수정되었습니다");
										location.reload();
									}else{
										alert("수정 실패! 관리자에게 문의!");									
									}
								},
								error : function(error) {
							        alert("수정 접속 error");
							    }	
						}); 
          

	            }//if
            }
            
            // Clear modal inputs
            $('#schedule_modal').find('input').val('');

            // hide modal
            $('#schedule_modal').modal('hide');
        });
        /////end save-event

        // 일정 삭제
        $('#delete-event').on('click', function() {
            var scheduleNo = $('#scheduleNo').val();
        	//var title = $('#title').val();            
            var employeeNo = $('#employeeNo').val().trim();
            //var shareGubun =  $('input[name=shareGubun]:checked').val();         
            var writer = $('#writer').val();

             if (scheduleNo.length>0 && employeeNo.indexOf(writer)>=0) {

	            //delete  	          
	            
	 	            $.ajax( 
							{
								
								url : "/schedule/json/deleteSchedule/"+scheduleNo,	
								method : "POST" ,
								dataType : "json" ,
								headers : {
									"Accept" : "application/json",
									"Content-Type" : "application/json"
								},								
								success : function(returnValue, status) {
									if (returnValue == 1){ 
										alert("삭제되었습니다");
										location.reload();
									}else{
										alert("삭제 실패! 관리자에게 문의!");									
									}
								},
								error : function(error) {
							        alert("삭제 접속 error");
							    }	
									
					
				});             

                
            }else{
            	alert("자신이 작성한 글만 삭제가능합니다");	 
            }
            
         
           // $('#calendar').fullCalendar('unselect');

            // Clear modal inputs
            $('#schedule_modal').find('input').val('');

            // hide modal
            $('#schedule_modal').modal('hide');
        });   //  $('#delete-event')    
        
        
      },  //init: function(themeSystem)   
   

      change: function(themeSystem) {
        $('#calendar').fullCalendar('option', 'themeSystem', 'bootstrap4');
      }  

    });  //initThemeChooser({

  });//$(document).ready(function() { 


  
  function date_add(sDate, nDays) {

	    var yy = parseInt(sDate.substr(0, 4), 10);
	    var mm = parseInt(sDate.substr(5, 2), 10);
	    var dd = parseInt(sDate.substr(8), 10);	 

	    d = new Date(yy, mm - 1, dd + nDays);	 

	    yy = d.getFullYear();
	    mm = d.getMonth() + 1; mm = (mm < 10) ? '0' + mm : mm;
	    dd = d.getDate(); dd = (dd < 10) ? '0' + dd : dd;	 

	    return '' + yy + '-' +  mm  + '-' + dd;

	}