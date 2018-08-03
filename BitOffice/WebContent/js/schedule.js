
		$(function () {  
				

			    
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
		        //���� ������ ��ȸ
		        $.ajax( 
						{
							
							url : "/share/json/listShare2/"+$('#employeeNo').val(),	
							method : "GET" ,
							dataType : "json" ,
							headers : {
								"Accept" : "application/json",
								"Content-Type" : "application/json"
							},
							success : function(jsonInfo , status) {
								
									if (jsonInfo){
										
								    	var displayValue="";
								    	//var titleText= new Array();
								    	var titleText;
								    	var colorPicked = "";	
								    	 
										$.each(jsonInfo,function(key,value) {											
											
											//if (key==0){
											 ////////////////// color picker 
  											    
												displayValue += "<tr><td style='background-color:#ffffff;width:190px;height:30px;'>"+value.acceptDepartmentName+" "+value.acceptPositionName+" "+value.acceptEmployeeName+"</td>";
												if (value.acceptStatus.indexOf('N')<0){
													displayValue += "<td style='background-color:#ffffff;'>����</td></tr>";
												}else{
													displayValue += "<td style='background-color:#ffffff;'>���</td></tr>";
												}
												//displayValue += "<td>"+value.acceptStatus+"</td></tr>";
												displayValue += "<tr><td style='background-color:#e5e5e5;'><div class='input-group' id='cp"+key+"'>";
												displayValue += "<input type='text' class='form-control' name='colorpick"+key+"' id='colorpick"+key+"' style='background-color:"+value.shareColor+"' value='"+value.shareColor+"' onClick='fun_colorPicker("+key+","+value.shareNo+")'>";
												displayValue += "<span class='input-group-addon colorpicker-component'><i id='cp-icon"+key+"' onClick='fun_colorPicker("+key+","+value.shareNo+")'></i></span>";											
												displayValue += "</div></td></tr>";
												displayValue += "<tr><td style='background-color:#e5e5e5;border: 0;heigh:0'>";
												displayValue += "<input type='hidden' id='preColor"+key+"' value="+value.shareColor+">";													
												displayValue += "<input type='hidden' id='afterColor"+key+"'>";
												displayValue += "<input type='hidden' id="+value.shareNo+" value="+value.shareNo+">";
												displayValue += "<input type='hidden' id='accStatus"+key+"' value="+value.acceptStatus+"></td></tr>";												
											
											//}							 
											 
										});
										
										$('#shareList').html(displayValue);
										
									}
									//alert('key:'+key+', acceptDepartmentName:'+value.acceptDepartmentName+',acceptEmployeeName:'+value.acceptEmployeeName);									
	
							},error : function(error) {
						        //alert("��������ȸ����!");
						    }
			
					});  //////////���� ������ ��ȸ		        
      
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
                     ,"contextmenu":{         
                    	    "items": function($node) {
                    	        var tree = $("#tree").jstree(true);
                    	        return {
                    	            "email": {
                    	                "separator_before": false,
                    	                "separator_after": false,
                    	                "label": "����",
                    	                "action": function (obj) {                    	                	                 	                	
                    	                	alert("����ȣ��");
                    	                    //$node = tree.create_node($node);
                    	                    //tree.edit($node);
                    	                }
                    	            },
                    	            "ä��": {
                    	                "separator_before": false,
                    	                "separator_after": false,
                    	                "label": "ä��",
                    	                "action": function (obj) { 
                    	                	alert("ä��ȣ��");
                    	                }
                    	            },                         
                    	            "ȭ��ȸ��": {
                    	                "separator_before": false,
                    	                "separator_after": false,
                    	                "label": "ȭ��ȸ��",
                    	                "action": function (obj) { 
                    	                	alert("ȭ��ȸ��ȣ��");
                    	                }
                    	            }
                    	        };
                    	    }
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
            
               //������û�ϱ�
               $('#SimpleJSTree').bind('select_node.jstree', function(event, data){
                var id = data.instance.get_node(data.selected).id;        //id ��������
                var parent = data.instance.get_node(data.selected).parent;        //id ��������
                var text = data.instance.get_node(data.selected).text;        //id ��������
                var id2 = data.node.id;
                
                var employeeNo = $('#employeeNo').val();
                	if(employeeNo.length>0){
               	 		if(id.length>3){
               	 			
               	 			//���� ��û
	   				 		 $.ajax({							
	   	 					
	   	 						url : "/share/json/addShare",	
	   	 						method : "GET" ,
	   	 						dataType : "TEXT" ,	    							
	   	 						headers : {
	   	 							"Accept" : "application/json",
	   	 							"Content-Type" : "application/json"
	   	 						},data:{	   	 							
	   	 							shareNo: employeeNo+id,
	   	 							requestEmployeeNo: employeeNo,
	   	 							acceptEmployeeNo: id,
	   	 							acceptStatus: 'N',
	   	 							shareColor:	'#ABF200'   	 							
	   	 						},success : function(status) {					
									$("#modalmessage").text("��û�Ǿ����ϴ�");
	  								jQuery("#getMessageModal").modal('show');		  	   	 							

	   	 						},error	 : function(error) {	   	 							
									$("#modalmessage").text("error");
	  								jQuery("#getMessageModal").modal('show');	   	 							 
	   	 						}   								
	
	   	 					}); //ajax 
	   	 					
	   	 					
               	 		}else{
               	 			alert("�μ� ��ü������ �Ұ��մϴ�");
               	 		}
	                }else{
	                	alert("���ǲ���. �ٽ� �α������ּ���");
	                }
            }); 
               
/*               //���� 
               $('#SimpleJSTree').on('hover_node.jstree',function(e,data){ 
            	   
 				  //�⼮ ó��
 				  $.ajax( 
 					{							
 					
 						url : "/employee/json/getEmployee",	
 						method : "GET" ,
 						dataType : "TEXT" ,	    							
 						headers : {
 							"Accept" : "application/json",
 							"Content-Type" : "application/json"
 						},data:{
 							
 							employeeNo:data.node.id
 							
 						},success : function(employee ,status) {
 							
 								var JSONData = $.parseJSON(employee); 	
 								var name = JSONData.employeeName;
 								var extension = JSONData.extension;
 								var phone = JSONData.phone;
 								var email = JSONData.email;
 								
 								if(name == null){var  name = ""}
 								if(extension == null){var  extension = ""}
 								if(phone == null){var  phone = ""} 								
 								if(email == null){var  email = ""} 								
 								
 								$("#"+data.node.id).prop('title', name+"/"+email+"/ "+extension+" / "+phone);
 							 
 						}	    								

 					});  
 				  
            	   	//$("#"+data.node.id).prop('title', "����ó, ���� �߰�����");
            	   
               }); */
       	   

       		//============= "��ȸ"  Event  ó�� =============	
       		 $(function() {
       			 //==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
       			 $( "#modalClose" ).on("click" , function() {
       				location.reload();
       			});
       		 });
       		
             $("#btn1").click(function(){

            	var jsfields = $('#SimpleJSTree').jstree('get_selected'); 
            	
            	var obj = $('#dvTreeStructure p');
            	
            	
            	alert(obj.length);
           	
    			obj.each( function(){
     				alert($(this).text());
    			});
    			
            	//$("ol").append("<li>"+jsfields+"</li>");                   	
            	
             	for (var i=0;i<jsfields.length;i++) {
             		if (jsfields[i].length>2){
            			$("#dvTreeStructure").append("<p id='#"+jsfields[i]+"'>"+jsfields[i]+" <a onclick=del('"+jsfields[i]+"')>����</a></p>");
             		}
            	}  

            	$('#SimpleJSTree').jstree(true).deselect_all();
            		
 			}); 
             
             $("#allsee").click(function(){           	 
            	 if ($('#allsee').text() == '[������û��ġ��]'){      
            		$('#SimpleJSTree').jstree('open_all');					
					$('#allsee').text('[������û����]');             	 	
            	 }else{       
            		$('#SimpleJSTree').jstree('close_all');    
            		$('#allsee').text('[������û��ġ��]');
            	 }
            	 
            	 
             });
             

        }
        
        function del(a){
       	 alert("��������:"+a);
       		$("p").remove(":contains("+a+")");
        }     
        
       //colorpicker rgba ->rgb ������ 
	   function rgba2rgb(RGB_background, RGBA_color)
	   {
	       var alpha = RGBA_color.a;

	       return new Color(
	           (1 - alpha) * RGB_background.r + alpha * RGBA_color.r,
	           (1 - alpha) * RGB_background.g + alpha * RGBA_color.g,
	           (1 - alpha) * RGB_background.b + alpha * RGBA_color.b
	       );
	   }	
       
        //color picker �ҷ�����
	    function fun_colorPicker(key, share_No ){ 
	    	
 			$("#cp"+key).colorpicker();	 	
 			 
    		$("#cp"+key).on("changeColor",function(){  			
    			
    			colorPicked = $('#cp'+key).data('colorpicker').input[0].value;
     			$("#colorpick"+key).val(colorPicked).css("background-color",colorPicked);
     			$("#afterColor"+key).val(colorPicked); 
     			
        		
    		});  		
 		
    		//���� ���� ajax
 			$('#cp-icon'+key).on("dblclick",function(){

 	    		    $.ajax({
					
					url : "/share/json/updateShare",	
					method : "POST" ,
					dataType : "text" ,
					data :{
						shareNo : $("#"+share_No).val(),
						acceptStatus : $("#accStatus"+key).val(),
						shareColor : $("#afterColor"+key).val()
					},
					success : function() {
						 
						
							$("#modalmessage").text("���󺯰�Ǿ����ϴ�");
							jQuery("#getMessageModal").modal('show');											
	
					},
					error : function(error) {
						$("#modalmessage").text("���󺯰� ajax���� error");
							jQuery("#getMessageModal").modal('show');
				    }	
						
		
					});   //ajax  
 			});    		
 		


            // if ($("#afterColor"+key).val().indexOf($("#preColor"+key).val())!=0){
			 			//���󺯰�
/* 			            $.ajax( 
							{
								
								url : "/share/json/updateShare",	
								method : "POST" ,
								dataType : "text" ,
								headers : {
									"Accept" : "application/json",
									"Content-Type" : "application/json"
								},	
								data :{
									shareNo : $("#"+share_No).val(),
									acceptStatus : $("#accStatus"+key).val(),
									shareColor : $("#afterColor"+key).val()
								},
								success : function(returnValue, status) {
									 
									
										$("#modalmessage").text("���󺯰�Ǿ����ϴ�");
		  								jQuery("#getMessageModal").modal('show');											
		
								},
								error : function(error) {
									$("#modalmessage").text("���󺯰� ajax���� error");
										jQuery("#getMessageModal").modal('show');
							    }	
									
					
				});   //ajax   */
             //} //if
	    }     