		//=============    �˻� / page �ΰ��� ��� ���  Event  ó�� =============	
		function fncGetList(currentPage) {
			$("#currentPage").val(currentPage)
			$("form").attr("method" , "POST").attr("action" , "/share/updateShareView").submit();
		}		
	
		//============= "�˻�"  Event  ó�� =============	
		 $(function() {
			 //==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
			 $( "button.btn.btn-default, #modalClose" ).on("click" , function() {
				fncGetList(1);
			});
		 });
		
	
		 //���ڸ�	
		function onlyNumber(obj) {
			    $(obj).keyup(function(){
			         $(this).val($(this).val().replace(/[^0-9]/g,""));
			    }); 
		}
		 
		//���� 
		function delShare(share_No) {
            $.ajax( 
				{
					
					//url : "/ip/json/addIp",	
					url : "/share/json/deleteShare/"+share_No,	
					method : "GET" ,
					dataType : "text" ,
					headers : {
						"Accept" : "application/json",
						"Content-Type" : "application/json"
					},					
					success : function() {
							$("#modalmessage").text("�����Ǿ����ϴ�");
							jQuery("#getMessageModal").modal('show');	

					},	
					error : function() {
						$("#modalmessage").text("��������! �����ڿ��� ����!");
						jQuery("#getMessageModal").modal('show');	
				    }							
			
			}); //ajax */ 			
	    }	
		
		function fnc_accept(status, shareNo) {	
				var msg;
				if(status.indexOf('N')>=0){
					var msg = "����";
				}else{
					var msg = "����";
				}			
			
	        	$.ajax({
	        		url : "/share/json/updateShare",
					method : "POST" ,
					data : { 	
						shareNo: shareNo,
						acceptStatus: status,
						shareColor: '#ABF200'
					} ,	
					contentType : "application/x-www-form-urlencoded; charset=UTF-8",
					dataType : "text" ,
					success : function(JSONData , status) {	
						//�⼮ ó�� ��ȸ�Ǵ� ���
						$("#modalmessage").text(msg+"ó�� �Ǿ����ϴ�");
						jQuery("#getMessageModal").modal('show');	
					
					},    	
					error : function(request, error) {
						$("#modalmessage").text(msg+" ó�� ����");
						jQuery("#getMessageModal").modal('show');		    						       
				    }	
				}); 			
			
		   }
		
	    //���̺� ����
	    function sortTable(n) {
	    	  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
	    	  table = document.getElementById("myTable2");
	    	  switching = true;
	    	  // Set the sorting direction to ascending:
	    	  dir = "asc"; 
	    	  /* Make a loop that will continue until
	    	  no switching has been done: */
	    	  while (switching) {
	    	    // Start by saying: no switching is done:
	    	    switching = false;
	    	    rows = table.getElementsByTagName("TR");
	    	    /* Loop through all table rows (except the
	    	    first, which contains table headers): */
	    	    for (i = 1; i < (rows.length - 1); i++) {
	    	      // Start by saying there should be no switching:
	    	      shouldSwitch = false;
	    	      /* Get the two elements you want to compare,
	    	      one from current row and one from the next: */
	    	      x = rows[i].getElementsByTagName("TD")[n];
	    	      y = rows[i + 1].getElementsByTagName("TD")[n];
	    	      /* Check if the two rows should switch place,
	    	      based on the direction, asc or desc: */
	    	      if (dir == "asc") {
	    	        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
	    	          // If so, mark as a switch and break the loop:
	    	          shouldSwitch = true;
	    	          break;
	    	        }
	    	      } else if (dir == "desc") {
	    	        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
	    	          // If so, mark as a switch and break the loop:
	    	          shouldSwitch = true;
	    	          break;
	    	        }
	    	      }
	    	    }
	    	    if (shouldSwitch) {
	    	      /* If a switch has been marked, make the switch
	    	      and mark that a switch has been done: */
	    	      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
	    	      switching = true;
	    	      // Each time a switch is done, increase this count by 1:
	    	      switchcount ++; 
	    	    } else {
	    	      /* If no switching has been done AND the direction is "asc",
	    	      set the direction to "desc" and run the while loop again. */
	    	      if (switchcount == 0 && dir == "asc") {
	    	        dir = "desc";
	    	        switching = true;
	    	      }
	    	    }
	    	  }
	    	}   		