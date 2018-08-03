	$(function () {  
		
		

		
		   
		if ($("#employeeNo").val().trim().length<1){
			alert("���� ��������! �ٽ� �α����ϼ���!");
		}
		
		//����, �ݷ� ��ư �����
		jQuery("#permitApproval").hide();
		jQuery("#rejectApproval").hide();
		
	    $("#authorizationPerson").sortable();
	    $("#authorizationPerson").disableSelection();
	    $("#referencePerson").sortable();
	    $("#referencePerson").disableSelection();	
	    
   		//������ ��ȸ
        $.ajax( 
			{				
				url : "/organization/json/listOrganization",	
				method : "POST" ,
				dataType : "json" ,
				headers : {
					"Accept" : "application/json",
					"Content-Type" : "application/json"
				},
				success : function(JSONData , status) {
						createJSTree(JSONData);		
				},	
				error : function(error) {
			        alert("��������ȸ����!");
			    }

		});  //////////������ ��ȸ
		
		
   		//������� ��ȸ
        $.ajax( 
			{				

				url : "/approvalEmployee/json/listApprovalEmployee/"+$('#approvalNo').val(),
				method : "GET" ,
				dataType : "json" ,
				headers : {
					"Accept" : "application/json",
					"Content-Type" : "application/json"			
				},
				success : function(jsonInfo , status) {						
						
						//alert("����:"+jsonInfo);
						
						if (jsonInfo){
							
							//�������
							var approvalTable="";	
							
							//������� ���� �߰�
							var app_member="";
							//�������� ���� �߰�
							var ref_member="";
							
							//
							var memoApproval="";

							var middleTdWidth=50;
							
							$.each(jsonInfo,function(key,value) {
								var approvalDate="";
								var signImage="";
								middleTdWidth-=(key*10);
								
								if (value.gubun==1){//�������
									 if (value.approvalDate!=null){
									 	approvalDate = value.approvalDate;
									 }
									 if (value.status=="1"){
										 status = "";
									 }else if(value.status=="2"){
										 status = "����";
									 }else if(value.status=="3"){
										 status = "�ݷ�";
									 }									 

									 
									 //������ο� ���� ����& ���������� ��� ����, �ݷ� ��ư ���̱�
									 //alert($('#employeeNo').val()+"=="+value.employeeNo);
									 if ($('#employeeNo').val().indexOf(value.employeeNo)>=0){
										//alert(key+"=="+value.employeeNo);
									 	jQuery("#permitApproval").show();
									 	jQuery("#rejectApproval").show();
									 }
									 
					       	        if (key==0){
						       	    	approvalTable+="<td style='width:5%;vertical-align:middle;background-color:#D5D5D5;'>��<br><br><br>��</td>";					       	    	
					       	        }	
					       	        
						       	        
				       	      		 approvalTable+="<td style='width:100px;' name='eachApprovalPerson'><table class='table table-bordered' style='text-align: center; vertical-align:middle;boder: 1px solid #dddddd'>";
				        		 	 approvalTable+="<tr><td>"+value.positionName+"</td></tr>";											
				        		 	 approvalTable+="<tr><td>"+value.employeeName+"</td></tr>";
				        		 	 approvalTable+="<tr height='50px'><td>"+approvalDate+"</td></tr>";	
				        		 	 approvalTable+="<tr height='50px'><td style='color:#FF0000;'>"+status+"</td></tr>";        		 	
				        		 	 approvalTable+="</table></td>"; 
				        		 	 
				        		 	 app_member+="<input type='hidden' name='approvalArray' value='"+value.employeeNo+"'>";
				        		 	 app_member+="<input type='hidden' name='statuslArray' value='"+value.status+"'>";
				        		 	 
				        		 	 if(value.memo!=null){
				        		 	 	memoApproval+="<span class='badge badge-pill badge-info'>"+value.departmentName+" "+value.positionName+" "+value.employeeName+"</span> "+ value.memo+" ["+value.regDate+"]<br><br>";
				        		 	 }
				        		 	 
								}else{//��������
									 ref_member+="<input type='hidden' name='referenceArray' value='"+value.employeeNo+"'>";
								}
								
							});							
						    
						    $("#middleTd").css('width',middleTdWidth+'%');
							
							$("#approvalLine").append(approvalTable);
							$("#approval_member").append(app_member);
							$("#reference_member").append(ref_member);							
							$("#approvalMemo").append(memoApproval);
							
							//����, �ݷ� ��ư ���̱� ����

							$("input[name='approvalArray']").each(function (i) {	
						    	
						    	//alert($("input[name='statuslArray']").length+"=="+i);
						    	
								 if ($('#employeeNo').val().indexOf($("input[name='approvalArray']").eq(i).attr('value'))>=0){		
									 
									if ($("input[name='statuslArray']").eq(i).attr('value').indexOf('2')>=0){//����, �ݷ��� ��ư �Ⱥ��̱�	
										//alert("aaa");
									 	jQuery("#permitApproval").hide();
									 	jQuery("#rejectApproval").hide();											 	
									}else{										
										if($("#approvalOrder").val().indexOf('2')>=0){//�������Ǵ� �� �����ֱ�
											//alert("bbb");
										 	jQuery("#permitApproval").show();
										 	jQuery("#rejectApproval").show();
										}else{//�������Ǵ� ������� �����ֱ�											
											if($("input[name='statuslArray']").length>=2){	//���� �����ڰ� �����ؾ� ��ư �����ֱ�
												if (i!=0){
													if($("input[name='statuslArray']").eq(i-1).attr('value').indexOf('2')>=0){
														//alert("ccc");
													 	jQuery("#permitApproval").show();
													 	jQuery("#rejectApproval").show();													 	
													}else{	//���� �����ڰ� ������ ��� �����ֱ�
														//alert("ddd");
													 	jQuery("#permitApproval").hide();
													 	jQuery("#rejectApproval").hide();												
													}
												}else{//������ ���� 1��°
													//alert("eee");
												 	jQuery("#permitApproval").show();
												 	jQuery("#rejectApproval").show();														
												}
											}else{//���簡 1���� ���
												//alert("fff");
											 	jQuery("#permitApproval").show();
											 	jQuery("#rejectApproval").show();												
											}				
											
										} 
	
									}
									
								 }								 
						    });									
						}
				},	
				error : function(request, status,error) {
			        alert("���������ȸ����!");
			        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	
			    }


		});  //////////������� ��ȸ		
	
	});

	
    function createJSTree(jsondata) {        	
        $('#SimpleJSTree').jstree({
            'core': {        	
                'data':
                		jsondata                    		
                	} 
                 ,'types': {
	                    'default' : {
                        'icon' :  'glyphicon glyphicon-user'
                    },                  	

          	      }
                                  
            ,'plugins' : [                	
            	"checkbox",
            	"contextmenu",
            	//"dnd",
            	//"massload",
            	//"search",
            	//"sort",
            	//"state",
            	//"html_data",
            	//"ui",
            	//"themes",                	
            	//"unique",
            	//"wholerow",
            	//"changed",
            	//"conditionalselect",
            	"types"
            ]
        }); 
        
           //�������ϱ�
           $('#SimpleJSTree').bind('select_node.jstree', function(event, data){
            var id = data.instance.get_node(data.selected).id;        //id ��������
            var parent = data.instance.get_node(data.selected).parent;        //parent ��������
            var text = data.instance.get_node(data.selected).text;        //text ��������
            var id2 = data.node.id;
           
            var employeeNo = $('#employeeNo').val();
            	if(employeeNo.length>0){
/*            	 		if(id.length>3){

                        if(parent !="#"){
                        	
                           }   	 					
   	 					
           	 		}else{
           	 			alert("�μ� ��ü������ �Ұ��մϴ�");
           	 		} */
                }else{
                	alert("���ǲ���. �ٽ� �α������ּ���");
                }
        }); 
           
   		//============= "��ȸ"  Event  ó�� =============	
   		 $(function() {
   			 //==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
   			 $( "#modalClose" ).on("click" , function() {
   				location.reload();
   			});
   		 });
     

   		
   		//============= "������ ����"  Event  ó�� =============	
         $("#sel1").click(function(){

           	var approvalEmployeeNo = $('#SimpleJSTree').jstree('get_selected');      	               	
         
          
          	for (var i=0;i<approvalEmployeeNo.length;i++) {
          		if (approvalEmployeeNo[i].length>2){
          			
          			var approvalEmployeeName = $("#SimpleJSTree").jstree('get_selected', true)[i].text;	
          			var li_span ="";
          				li_span +="<li class='ui-state-default' id='auth_"+approvalEmployeeNo[i]+"' employInfo='"+approvalEmployeeName+"'>";
          				li_span +="<span class='ui-icon ui-icon-arrowthick-2-n-s'></span>"+approvalEmployeeName+"<a onclick=del('auth_"+approvalEmployeeNo[i]+"')>����</a></li>";
         			$("#authorizationPerson").append(li_span);
         		
         			
          		}
         	}  

         	$('#SimpleJSTree').jstree(true).deselect_all();
         		
		}); 
   		
   		
       //============= "������ ����"  Event  ó�� =============	 
         $("#sel2").click(function(){

          	var approvalEmployeeNo = $('#SimpleJSTree').jstree('get_selected');
               	
          
           	for (var i=0;i<approvalEmployeeNo.length;i++) {           		
           		if (approvalEmployeeNo[i].length>2){           			
           			
          			var approvalEmployeeName = $("#SimpleJSTree").jstree('get_selected', true)[i].text;	
          			var li_span ="";
          				li_span +="<li class='ui-state-default' id='ref_"+approvalEmployeeNo[i]+"'>";
          				li_span +="<span class='ui-icon ui-icon-arrowthick-2-n-s'></span>"+approvalEmployeeName+"<a onclick=del('ref_"+approvalEmployeeNo[i]+"')>����</a></li>";
         			$("#referencePerson").append(li_span); 
     			
           		}
          	}  

          	$('#SimpleJSTree').jstree(true).deselect_all();
          		
 		});   
         
        //���â���� ���õ� ������, ������ ��������� ������ 
         $("#personSubmit").click(function(){
       	 	
       	 	//���� ������ �ʱ�ȭ
       	 	$("td[name=eachApprovalPerson]").remove();
       	 	
       	 	//���â ������� �ʱ�ȭ
       	    $("input[name=approvalArray]").remove();
       	 
       	 	//���� ������  ���� �������� �������� 
       	    $($('#authorizationPerson li').get().reverse()).each(function(i){       	       
       	         
       	         var approvalTable ="";       	      	 
       	         var thisId = $(this).attr('id').replace('auth_','');       	         
       	         var employInfo = $(this).attr('employInfo').split(' ');
	       	     var thisPosion = employInfo[0];
	       	   	 var thisName = employInfo[1];

       	        
       	         if (thisId.trim().length>5){           	    
       	      		 approvalTable+="<td name='eachApprovalPerson'><table class='table table-bordered' style='text-align: center; boder: 1px solid #dddddd'>";
        		 	 approvalTable+="<tr><td >1111"+thisPosion+"</td></tr>";											
        		 	 approvalTable+="<tr><td >"+thisName+"</td></tr>";
        		 	 approvalTable+="<tr height='25px'><td ></td></tr>";	
        		 	 approvalTable+="<tr height='25px' style='height:70%'><td></td></tr>";        		 	
        		 	 approvalTable+="</table></td>";  
        		 	 
        		 	$("#approvalLine").append(approvalTable); 
        		 	$("#approval_member").append("<input type='text' name='approvalArray' value='"+thisId+"'>");
        		 	
       	         }
	   			      	        
       	    });	
			
			//�������� Hiddenm���� �߰�
       	 	//���â ������� �ʱ�ȭ
       	    $("input[name=referenceArray]").remove();
			
       	    $('#referencePerson li').each(function(){
       	    	
       	    	var thisId = $(this).attr('id').replace('ref_','');
       	    	$("#reference_member").append("<input type='text' name='referenceArray' value='"+thisId+"'>"); 
       	    	
       	    });	        	  

          	$('#selectTypeModal').modal('hide');
         });        
         
         
        //������ ����,���
         $("#allsee").click(function(){           	 
        	 if ($('#allsee').text() == '[��������ġ��]'){      
        		$('#SimpleJSTree').jstree('open_all');					
				$('#allsee').text('[����������]');             	 	
        	 }else{       
        		$('#SimpleJSTree').jstree('close_all');    
        		$('#allsee').text('[��������ġ��]');
        	 }
        	 
        	 
         });
         
         

    }	
    
    //���õ� ������ ,������ ������
    function del(a){
      	 alert("����~"+a);
      		$("li").remove("#"+a);
       }      

	function fncAddApproval() {		

		var docType = $("#docType").val().trim();
		var approvalOrder = $("#approvalOrder").val().trim();
		
		var title = $("#title").val().trim();
		var content = $("#content").val().trim();		

		var cnt = 0;
		
		var reqDate = $("#reqDate").val().trim().replace(/-/g,'');
				
		
		
 		$("input[name='approvalArray']").each(function(i){
			//alert("hello"+$("input[name='approvalArray']").eq(i).val());		
 			cnt += i;
		});
		
 		if(cnt==0){
 			alert("��������� �����ϼ���");
 			return;
 		}
		
		
		if(docType.indexOf("1")>=0){
			var start_date = $("#start_date").val().trim();
			var end_date = $("#end_date").val().trim();
			var use_day = $("#use_day").val().trim();
			
			if(start_date.length<10){
				alert("�������ڸ� �Է��ϼ���");
				$("#start_date").focus();
				return;
			}
			
			if(end_date.length<10){
				alert("�������ڸ� �Է��ϼ���");
				$("#end_date").focus();
				return;
			}			
		}
		
		if(title.length<1){
			alert("������ �Է��ϼ���");
			$("#title").focus();
			return;
			
		}
		
		if(content.length<1){
			alert("������ �Է��ϼ���");
			$("#content").focus();
			return;
		}
	
			//��� ���
 	    	$.ajax({
	    		url : "/approval/json/addApproval",
				method : "POST" ,
				data : { 	
					"docNo": 			reqDate,
					"docType": 			$("#docType").val(),
					"docApprovalOrder": $("#approvalOrder").val(),
					"docStatus": 		'1' ,
					"startDate": 		$("#start_date").val().replace(/-/g,''),
					"endDate": 			$("#end_date").val().replace(/-/g,''),									
					"useDay":			$("#use_day").val(),
					"title": 			$("#title").val().trim(),							
					"content": 			$("#content").val().trim(),	
					"regEmployeeNo":	$("#employeeNo").val().trim(),	
					"modEmployeeNo":	$("#employeeNo").val().trim(),
					"memo": 			null,
					"fileName1": 		null,
					"fileName2": 		null,
					"fileName3": 		null				
							} ,	
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				dataType : "text" ,
				success : function(resultValue, status) {
					alert("returnValue:"+returnValue);
					if (returnValue.indexOf(1)>=0){ 
						
						alert("��ϵǾ����ϴ�");
						location.href = "/approval/listApproval";
						
					}else{
						alert("��� ����! �����ڿ��� ����!");									
					}
				},
				error : function(error) {
			        alert("��� ���� error");
			    }							
		}); ////ajax 
		
	}////fncAddApproval

	//��� ��� 
	$(function() {
		$("#writeApproval").on("click", function() {
			fncAddApproval();
		});
	});
	
    //���� �ݷ� ��ư Ŭ����
	$(function() {
		 $("#permitApproval, #rejectApproval").on("click", function() {
			
			$('#permit_modal').modal('show');
			
			if ($(this).attr('id')=="permitApproval"){
			   $("#headerTitle").css("color","#0099FF")
			   $("#headerTitle").text('����');
			   $("#say").val("Y");
			}else{
			   $("#headerTitle").css("color","#CC3333")
			   $("#headerTitle").text('�ݷ�');
			   $("#say").val("N");
			}

		});
		
		//���θ�޴ݱ�
		 $( "#modalClose" ).on("click" , function() {
			 $('#permit_modal').modal('show');    
		});
		
		//����, �ݷ�ó��
	     $('#save-event').on('click', function() {
	    	   
	    	   // 1: ��� 2: ���� 3: �ݷ�
	    	   var myStatus = "";
	    	   ($("#say").val() == "Y") ? myStatus="2" : myStatus="3";	    	   
	    	   
	    	   if($("#say").val() == "N" &&  $("#memo").val().length<1){
	    		   alert("�ݷ��� �޸�� �ʼ��Է��Դϴ�");
	    		   $("#memo").focus();
				   return;
	    	   }
	    	   
	    	   $.ajax( 
				{						
					url : "/approvalEmployee/json/updateApprovalEmployeeStatus",	
					method : "POST" ,
					data : { 	
						"docNo" : $('#approvalNo').val(),
						"status": myStatus,
						"memo"  : $("#memo").val(),
						"employeeNo": $('#employeeNo').val()							
								} ,	
					contentType : "application/x-www-form-urlencoded; charset=UTF-8",
					dataType : "text" ,							
					success : function(returnValue, status) {
						//alert("����ó�� returnValue:"+returnValue);
						
							//��� ���� ����  1. ���   2. ������   3. �Ϸ�
					    	   $.ajax( 
								{						
									url : "/approval/json/updateApprovalStatus",	
									method : "POST" ,
									data : { 	
										"docNo" : $('#approvalNo').val(),
										"modEmployeeNo": $('#employeeNo').val()							
												} ,	
									contentType : "application/x-www-form-urlencoded; charset=UTF-8",
									dataType : "text" ,							
									success : function(returnValue, status) {
										//alert("����ó�� returnValue:"+returnValue);
										
										
										
										
										location.reload();
									},
									error : function(request, statu, error) {
								        alert("����ó�� ���� error");
								        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
								    }			
								});  						
						
						
						location.reload();
					},
					error : function(request, statu, error) {
				        alert("����ó�� ���� error");
				        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				    }			
				});  	   	 
	     });
	});	
    
		
		
	$(function() {
		 //==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
			$("#myFormSubmit").on("click" , function() {					
				if ($('#employeeNo').val().trim().length<1){
					alert("session ����! �ٽ÷α������ּ���.");
					return;
				}              
			
				jQuery("#selectTypeModal").modal('show');
			});

					 
	 });
	
	//=============    �˻� / page �ΰ��� ��� ���  Event  ó�� =============	
	function fncGetList(currentPage) {
		$("#currentPage").val(currentPage)
		$("form").attr("method" , "POST").attr("action" , "/approval/listApproval").submit();
	}		

	//============= "�˻�"  Event  ó�� =============	
	 $(function() {
		 //==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
		 $( "button.btn.btn-default, #modalClose" ).on("click" , function() {
			fncGetList(1);
		});
 
	 }); 


	 
	
	 $(function() {
		 //==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
		 $( "#deleteApproval" ).on("click" , function() {
			  var approvalNo = $('#approvalNo').val();
			  
			  
			    //�������, ������ ����
	            $.ajax( 
						{
							
							url : "/approvalEmployee/json/deleteApprovalEmployee",	
							method : "POST" ,
							data : { 	
								"docNo": approvalNo			
										} ,	
							contentType : "application/x-www-form-urlencoded; charset=UTF-8",
							dataType : "text" ,							
							success : function(returnValue, status) {
							},
							error : function(request, statu, error) {
						        alert("������, ������ ���� ���� error");
						        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
						    }			
				
				}); 			    
			  
			    //��ȹ� ����
	            $.ajax( 
						{
							
							url : "/approval/json/deleteApproval",	
							method : "POST" ,
							data : { 	
								"docNo": approvalNo			
										} ,	
							contentType : "application/x-www-form-urlencoded; charset=UTF-8",
							dataType : "text" ,							
							success : function(returnValue, status) {
								if (returnValue.indexOf(1)>=0){ 
									alert("�����Ǿ����ϴ�");
									fncGetList(1);
								}else{
									alert("���� ����! �����ڿ��� ����!");									
								}
							},
							error : function(error) {
						        alert("���� ���� error");
						    }			
				
				}); 
		});
	 }); 

	 
	 $(function() {
		 //==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
		 $( "#updateApproval" ).on("click" , function() { 
				$("form").attr("method" , "POST").attr("action" , "/approval/addApproval").submit();			  
			  
		});
	 }); 	 
	 
	 $(function() {	
	     //����,�ݷ� ���� ��ư ���̱� 
		 $("input[name='approvalArray']").each(function(i){			 
			 alert("��ư");
			// alert("thisId:"+$("input[name='approvalArray']").eq(i).val());
		 });    
	 });
	 	 
	

	
	 // ���� ����Ʈ ��ȣ
    var fileIndex = 0;
    // ����� ��ü ���� ������
    var totalFileSize = 0;
    // ���� ����Ʈ
    var fileList = new Array();
    // ���� ������ ����Ʈ
    var fileSizeList = new Array();
    // ��� ������ ���� ������ MB
    var uploadSize = 50;
    // ��� ������ �� ���� ������ MB
    var maxUploadSize = 500;
 
    $(function (){
        // ���� ��� �ٿ�
        fileDropDown();
    });
 
    // ���� ��� �ٿ�
    function fileDropDown(){
        var dropZone = $("#dropZone");
        //Drag��� 
        dropZone.on('dragenter',function(e){
            e.stopPropagation();
            e.preventDefault();
            // ��Ӵٿ� ���� css
            dropZone.css('background-color','#E3F2FC');
        });
        dropZone.on('dragleave',function(e){
            e.stopPropagation();
            e.preventDefault();
            // ��Ӵٿ� ���� css
            dropZone.css('background-color','#FFFFFF');
        });
        dropZone.on('dragover',function(e){
            e.stopPropagation();
            e.preventDefault();
            // ��Ӵٿ� ���� css
            dropZone.css('background-color','#E3F2FC');
        });
        dropZone.on('drop',function(e){
            e.preventDefault();
            // ��Ӵٿ� ���� css
            dropZone.css('background-color','#FFFFFF');
            
            var files = e.originalEvent.dataTransfer.files;
            if(files != null){
                if(files.length < 1){
                    alert("���� ���ε� �Ұ�");
                    return;
                }
                selectFile(files)
            }else{
                alert("ERROR");
            }
        });
    }
 
    // ���� ���ý�
    function selectFile(fileObject){
        var files = null;
 
        if(fileObject != null){
            // ���� Drag �̿��Ͽ� ��Ͻ�
            files = fileObject;
        }else{
            // ���� ���� ��Ͻ�
            files = $('#multipaartFileList_' + fileIndex)[0].files;
        }
        
     // �������� ���
        if(files != null){
            for(var i = 0; i < files.length; i++){
                // ���� �̸�
                var fileName = files[i].name;
                var fileNameArr = fileName.split("\.");
                // Ȯ����
                var ext = fileNameArr[fileNameArr.length - 1];
                // ���� ������(���� :MB)
                var fileSize = files[i].size / 1024 / 1024;

                if($.inArray(ext, ['exe', 'bat', 'sh', 'java', 'jsp', 'html', 'js', 'css', 'xml']) >= 0){
                    // Ȯ���� üũ
                    alert("��� �Ұ� Ȯ����");
                    break;
                }else if(fileSize > uploadSize){
                    // ���� ������ üũ
                    alert("�뷮 �ʰ�\n���ε� ���� �뷮 : " + uploadSize + " MB");
                    break;
                }else{
                    // ��ü ���� ������
                    totalFileSize += fileSize;
                    
                    // ���� �迭�� �ֱ�
                    fileList[fileIndex] = files[i];
                    
                    // ���� ������ �迭�� �ֱ�
                    fileSizeList[fileIndex] = fileSize;
 
                    // ���ε� ���� ��� ����
                    addFileList(fileIndex, fileName, fileSize);
 
                    // ���� ��ȣ ����
                    fileIndex++;
                }
            }
        }else{
            alert("ERROR");
        }
    }
 
    // ���ε� ���� ��� ����
    function addFileList(fIndex, fileName, fileSize){
        var html = "";
        html += "<tr id='fileTr_" + fIndex + "'>";
        html += "    <td colspan='2' class='left' >";
        html +=         fileName + " / " + fileSize + "MB "  + "<a href='#' onclick='deleteFile(" + fIndex + "); return false;' class='btn small bg_02'>����</a>"
        html += "    </td>"
        html += "</tr>"
 
        $('#fileTableTbody').append(html);
    }
 
    // ���ε� ���� ����
    function deleteFile(fIndex){
        // ��ü ���� ������ ����
        totalFileSize -= fileSizeList[fIndex];
        
        // ���� �迭���� ����
        delete fileList[fIndex];
        
        // ���� ������ �迭 ����
        delete fileSizeList[fIndex];
        
        // ���ε� ���� ���̺� ��Ͽ��� ����
        $("#fileTr_" + fIndex).remove();
    }
 
    // ���� ���
    function uploadFile(){
        // ����� ���� ����Ʈ
        var uploadFileList = Object.keys(fileList);
 
        // ������ �ִ��� üũ
        if(uploadFileList.length == 0){
            // ���ϵ�� ���â
            alert("������ �����ϴ�.");
            return;
        }
        
        // �뷮�� 500MB�� ���� ��� ���ε� �Ұ�
        if(totalFileSize > maxUploadSize){
            // ���� ������ �ʰ� ���â
            alert("�� �뷮 �ʰ�\n�� ���ε� ���� �뷮 : " + maxUploadSize + " MB");
            return;
        }
            
        if(confirm("��� �Ͻðڽ��ϱ�?")){
            // ����� ���� ����Ʈ�� formData�� ������ �Է�
            var form = $('#uploadForm');
            var formData = new FormData(form);
            for(var i = 0; i < uploadFileList.length; i++){
                formData.append('files', fileList[uploadFileList[i]]);
            }
            
            alert(formData);
            
//             $.ajax({
//                 url:"���ε� ���",
//                 data:formData,
//                 type:'POST',
//                 enctype:'multipart/form-data',
//                 processData:false,
//                 contentType:false,
//                 dataType:'json',
//                 cache:false,
//                 success:function(result){
//                     if(result.data.length > 0){
//                         alert("����");
//                         location.reload();
//                     }else{
//                         alert("����");
//                         location.reload();
//                     }
//                 }
//             });
        }
    }
    
  //���೯¥
    $(function(){  	
     	
        $("#start_date, #end_date").datepicker({
        	//format: 'YYYY-MM-DD',
        	dateFormat: "yy-mm-dd"
        	//sideBySide:false  
        	//pick12HourFormat: false
        });     	
     });   
  
	 //���ڸ�	
	 function onlyNumber(obj) {
		    $(obj).keyup(function(){
		         $(this).val($(this).val().replace(/[^0-9]/g,""));
		    }); 
		}  
