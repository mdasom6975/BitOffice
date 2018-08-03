<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page pageEncoding="EUC-KR"%>

<!--  ///////////////////////// JSTL  ////////////////////////// -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>

<html lang="ko">
	
<head>
	<meta charset="EUC-KR">
	
	<!-- ���� : http://getbootstrap.com/css/   ���� -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<!--  ///////////////////////// Bootstrap, jQuery CDN ////////////////////////// -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>



    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/themes/default/style.min.css" />
     <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.1/jquery.min.js"></script> 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script>	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
	
	 <!-- tree -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script> 	
	
	<!-- Bootstrap Dropdown Hover CSS -->
   <link href="/css/animate.min.css" rel="stylesheet">
   <link href="/css/bootstrap-dropdownhover.min.css" rel="stylesheet">
    <!-- Bootstrap Dropdown Hover JS -->
   <script src="/javascript/bootstrap-dropdownhover.min.js"></script>
   
   <!-- jQuery UI toolTip ��� CSS-->
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <!-- jQuery UI toolTip ��� JS-->
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<!--  ///////////////////////// CSS ////////////////////////// -->
	<style>
	  body {
            padding-top : 50px;
        }
    </style>
    
     <!--  ///////////////////////// JavaScript ////////////////////////// -->
   <script type="text/javascript">
    
        $(function () {       	
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
					        alert("��ȸ����!");
					    }
		
				});    
      
        });

        function createJSTree(jsondata) {        	
            $('#SimpleJSTree').jstree({
                'core': {
                    'data':
                    		jsondata                    		
                    	} 
                    ,'types': {
                    'default' : {
                        'icon' : {
                            'image' : '/admin/views/images/file.png'
                        }
                    }
              	  }               
                ,'plugins' : [
                	//"checkbox",
                	//"contextmenu",
                	//"dnd",
                	//"massload",
                	//"search",
                	//"sort",
                	//"state",
                	//"types",
                	//"unique",
                	//"wholerow",
                	//"changed",
                	//"conditionalselect"
                ]
            });  
            
/*               $('#SimpleJSTree').bind('select_node.jstree', function(event, data){
                var id = data.instance.get_node(data.selected).id;        //id ��������
                var parent = data.instance.get_node(data.selected).parent;        //id ��������
                var text = data.instance.get_node(data.selected).text;        //id ��������
                var id2 = data.node.id;
                
                
                if(parent !="#"){
               	 //$("ol").append("<li>"+text+"</li>");
                }
            });    */
            
              $('#SimpleJSTree').on("hover_node.jstree", function (node, data) {     	
            	
                //alert("�ȳ�");
                //alert(data.rslt.obj.attr("id"));
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
            	 if ($('#allsee').text() == '[��������ġ��]'){      
            		$('#SimpleJSTree').jstree('open_all');					
					$('#allsee').text('[����������]');             	 	
            	 }else{       
            		$('#SimpleJSTree').jstree('close_all');    
            		$('#allsee').text('[��������ġ��]');
            	 }
            	 
            	 
             });
             

        }
        
        function del(a){
       	 alert("��������:"+a);
       		$("p").remove(":contains("+a+")");
        }        
    </script>
	
</head>

<body>
	<!-- ToolBar Start /////////////////////////////////////-->
	<jsp:include page="/layout/toolbar.jsp" />
   	<!-- ToolBar End /////////////////////////////////////-->
	<br>
	<br>
	<br>
	<br>
	<div class="container">
	    <div id="allsee">[��������ġ��]</div>
	    <div id="SimpleJSTree"></div>   
		<div id="dvTreeStructure"> 
		</div>		
	</div>
	<!-- <button id="btn1">������</button> 
	<button id="btn2">������</button>   	 -->
	
</body>

</html>