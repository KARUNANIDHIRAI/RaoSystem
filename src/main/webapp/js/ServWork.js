/**
 * 
 */
$(document).ready(function(){
	alert('wah re hindustan');
	loadWorkTypeOption();
	//loadItemList();

	$("select.service").change(function(){
  	    var selectedCountry =   $(this).children("option:selected").val();
  	     alert(selectedCountry);
   	});
	$("#sub01").hide();
	$('#AddSW').hide();
	$("#SDate").focusout(function(){
		if ($("#SDate").val()!=""){
			$('#AddSW').show();
		}else{
			$('#AddSW').hide();
		}
	});
	$('#addTempSW').click(function(){
		if($("#wName").val()!="" && $("#wDate").val()!="" ){
   			$("#sub01").show();
   			var SNo='';
   			var sCode=$("#SerNo").val();
	   		var wName= $('#wName').val();
	   		var wDate= $('#wDate').val();
	   		var wMobileNo= $('#wMobile').val();
	   		alert('Mobile No: '+ wMobileNo);
	   		var wCharge= $('#wCharge').val();
	   		servWorktxtInit();
			var request =$.ajax({
	   			type:'POST',
	   			data:{SNo:SNo, SCode:sCode, Name:wName, Date:wDate, MobileNo:wMobileNo, Charge:wCharge, Action:"NEW"},
   	   		    dataType: 'json',
	   			url:'../TempNewServWork',
	   			success:function(result){
	   				serviceWorkerInfo(result);
	   			}	
			});
		}
    	alert("moorkh 1");
	});	// End Of Add New Item
    $(document).on('click', "Button[name='SOList']", function(){ 
		$("#sub01").show();
		var sCode=$("#SerNo").val();   		
		var SNo=$(this).val();
    	alert('SNo :' + SNo);
		var request =$.ajax({
   			type:'POST',
   			data:{SNo:SNo, SCode:sCode, Action:"DELETE"},
   		    dataType: 'json',
   			url:'../TempNewServWork',
   			success:function(result){
   				serviceWorkerInfo(result);
   			}	

		});// End Of the $.Ajax()
   		request.done(function(msg) {
   			alert(msg);
   			$.each(msg.d, function(key, value) {
   				    alert(key +" : "+ value);
   			});
   		});		   		
   	});// end of remove item


	function servWorktxtInit(){
		$("#wName").val("");
		$("#wDate").val("");
		$("#wMobile").val("");
		$("#wCharge").val("");
	}
	function serviceWorkerInfo(result){
		alert("wah wah");
		$('#POItemDetails').dataTable({
		    destroy: true,
			"data":result,
			 columnDefs: [
	    		{	targets: -1,
	        		className: 'dt-body-right'
	    		},
	    		{ "width": "10%", "targets": 0 },
	    		{ "width": "20%", "targets": 1 },
	    		{ "width": "20%", "targets": 2 },
	    		{ "width": "15%", "targets": 3 },
	    		{ "width": "10%",  "targets":4 },
	    		{ "width": "5%", "targets": 5 },
	  		],
		    "columns": [
				 { title:	'SNO'             ,data:"SNo"  },
				 { title:	'Name'		      ,data:"Name" },
				 { title:	'Mobile No'   ,data:"MobileNo" },  
				 { title:	'Date'          ,data:"Date"   },
				 { title:	'Wages'		     ,data:"Wages" }, 

				 { title:	'Remove'		  ,data:"SNo",
				 	"render": function(data,type,row,meta){
				 	return	'<button type="button" name="SOList"  value="'+data+'" class="btn btn-warning"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
				 	},
				 }
			]
		}); // end of data table
	}// end of the table items function
   	
	function loadWorkTypeOption(){
		var workTypeOptions;
		var request =$.ajax({
			type:'POST',
			data:{RwaRegNo:'MK106', Action:"WORKTYPE"},
	 		dataType: 'json',
			url:'../MainMWorkPage',
			success:function(result){
				$.each(result, function(id, name){
					workTypeOptions+=" <option value='"+name.id +"'>"+ name.name + "</option>";
					//alert("id : " +name.id  + " Name : " + name.name );
				});
				$("#ServiceType").html(workTypeOptions);
			}	
		});// End Of the $.Ajax()
	}
	$('#submitMainServicePage01').click(function(){
		alert('wah wah re');
		var soNo=    $("#ServNo").val();
		var spName=  $("#ServProvider").val();
		var sDate=   $("#FromDate").val();
		var eDate=   $("#ToDate").val();
		var serType= $("#ServiceType").val();
		var action=  $("#ActionType").val();
		alert("soNo :" + soNo +" spName :" + spName + " sDate: " +sDate +" eDate :" + eDate + " serType :" +serType + " :action - " +action )
		var request= $.ajax({
			type:'POST',
			data:{SONO:soNo, SPName:spName,SDate:sDate,EDate:eDate,MWorkType:serType, Action:"1"},
	 		dataType: 'json',
			url:'../MainMWorkPage',
			success:function(result){
				mWorkInfo(result);
			}
		});	
	});	

	$('#submitMainItemPage').click(function(){
		alert('wah wah re');
		var request =$.ajax({
			type:'POST',
			data:{ICode:'',IName:'', Action:"SEARCH"},
	 		dataType: 'json',
			url:'../ItemMainInfo',
			success:function(result){
				loadItemList(result);
			}	
		});// EOF $.Ajax()

	});	
	
	function loadItemList(){
		var request =$.ajax({
			type:'POST',
			data:{ICode:'',IName:'', Action:"SEARCH"},
	 		dataType: 'json',
			url:'../ItemMainInfo',
			success:function(result){
				$('#mwList').dataTable({
					destroy: true,
					"data":result,
					"columns": [
						{ title:	'Item Code'             ,data:"Code" },
						{ title:	'Item Name'	            ,data:"Name" },
						{ title:	'Minimum Level'     ,data:"MinLevel" },
						{ title:	'Max Level'	        ,data:"MaxLevel" },
						{ title:	'Reorder Level' ,data:"ReOrderLevel" },
		    			{ title:	'Edit'		  ,data:"Code",
		    			 	"render": function(data,type,row,meta){
		    			 	return	'<button type="button" name="ItemEdit"  value="'+data+'" class="btn btn-secondary text-light btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#xf044;</span></button>'; 
		    			 	},
		    			 },
		    			 { title:	'Del'		  ,data:"Code",
			        		 	"render": function(data,type,row,meta){
			        		 	return	'<button type="button" name="PODEL"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
		        		 	},
		        		}
					]
				}); // EOF Dtable
			}	
		});// EOF $.Ajax()
	} // eof()  	
	
	function knloadItemList(){
		var request =$.ajax({
			type:'POST',
			data:{ICode:'',IName:'', Action:"SEARCH"},
	 		dataType: 'json',
			url:'../ItemMainInfo',
			success:function(result){
				$('#mwList').dataTable({
					destroy: true,
					"data":result,
					"columns": [
						{ title:	'Item Code'             ,data:"Code" },
						{ title:	'Item Name'	            ,data:"Name" },
						{ title:	'Minimum Level'     ,data:"MinLevel" },
						{ title:	'Max Level'	        ,data:"MaxLevel" },
						{ title:	'Reorder Level' ,data:"ReOrderLevel" },
		    			{ title:	'Edit'		  ,data:"Code",
		    			 	"render": function(data,type,row,meta){
		    			 	return	'<button type="button" name="ItemEdit"  value="'+data+'" class="btn btn-secondary text-light btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#xf044;</span></button>'; 
		    			 	},
		    			 },
		    			 { title:	'Del'		  ,data:"Code",
			        		 	"render": function(data,type,row,meta){
			        		 	return	'<button type="button" name="PODEL"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
		        		 	},
		        		}
					]
				}); // EOF Dtable
			}	
		});// EOF $.Ajax()
	} // eof()  	
	

	function mWorkInfo(result){
		alert("wah wah");
		$('#mwList').dataTable({
		    destroy: true,
			"data":result,
			 columnDefs: [
	    		{	targets: -1,
	        		className: 'dt-body-right'
	    		},
	  		],
		    "columns": [
				 { title:	'RwaRegNo'       ,data:"RwaRegNo"},
				 { title:	'SONO'	             ,data:"SONO"},
				 { title:	'SERVICE TYPE'      ,data:"SName"},  
				 { title:	'SDate'             ,data:"SDate"},
				 { title:	'EDate'		        ,data:"EDate"}, 
				 { title:	'Tot Charges'      ,data:"Charge"}, 
				 { title:	'Service Provider' ,data:"SPName"}, 
				 { title:	'Contact'        ,data:"MobileNo"}, 
				 { title:	'City'               ,data:"City"}, 
				 { title:	'Edit'	             ,data:"SONO",
				 	"render": function(data,type,row,meta){
	    			 	return	'<button type="button" name="MWEdit"  value="'+data+'" class="btn btn-secondary text-light btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#xf044;</span></button>'; 
	    			 	},
	    			 },
	    			 { title:	'Del'		  ,data:"SONO",
			        	 	"render": function(data,type,row,meta){
			        	 	return	'<button type="button" name="MWDEL"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
		        		},
		        	}
				]
		}); // end of data table
	}// end of the table items function

    $(document).on('click', "Button[name='MWDEL']", function(){ 
		var delSNo=$(this).val();
    	alert('SNo :' + delSNo);
    	var soNo=    $("#ServNo").val();
    	var spName=  $("#ServProvider").val();
    	var sDate=   $("#FromDate").val();
    	var eDate=   $("#ToDate").val();
    	var serType= $("#ServiceType").val();
    	var action=  $("#ActionType").val();
    	alert("soNo :" + soNo +" spName :" + spName + " sDate: " +sDate +" eDate :" + eDate + " serType :" +serType + " :action - " +action + " delSONO " + delSNo )
    	var request= $.ajax({
    		type:'POST',
    		data:{SONO:soNo, SPName:spName,SDate:sDate,EDate:eDate,MWorkType:serType, Action:"3", "delMWNO":delSNo},
     		dataType: 'json',
    		url:'../MainMWorkPage',
    		success:function(result){
    			mWorkInfo(result);
    		}
    	});	
   	});// end of remove item
    
    $(document).on('click', "Button[name='MWEdit']", function(){ 
		var editSNo=$(this).val();
		alert(editSNo);
		var url='../Service/EditServiceWork.jsp?SoNo='+ editSNo;
		window.open(url, 'popUpWindow', 'height=600, width=1000,left=100,top=30,scrollbars=yes,menubar=no'); return false;
   	});// end of Edit MW    
 
	$("#mwWorkerView").click(function(){
		alert('chal gaya');
	 	editSNo=$("#SerNo").val();
	 	alert(editSNo);
		var request= $.ajax({
			type:'POST',
			data : {SONO:editSNo,  Action:"MWWorkerInfo" },
	 		dataType: 'json',
			url:'../MainMWorkPage',
			success:function(result){
				serviceWorkerInfo(result);
			}
		});	
	});	

	$("#SerNo").focusout(function(){
	 	editSNo=$("#SerNo").val();
		var request =$.ajax({
			type:'POST',
			data : {SONO:editSNo,  Action:"2" },
			datatype:'json',
			url:'../MainMWorkPage',
			success:function(result){
				var obj = jQuery.parseJSON(result);
				$.each(obj, function(key,value) {
					$('#SerCharge').val(value.Charges)      ;
					$('#SDate').val(value.SDate)            ;
					$('#EDate').val(value.EDate)            ;
					$('#SerStatus').val(value.ServicStatus) ;
					$('#SPName').val(value.SPName)          ;
					$('#VAddress').val(value.Address)       ;
					$('#City').val(value.City)              ;
					$('#State').val(value.State)            ;
					$('#Country').val(value.Country)        ;
					$('#ZipCode').val(value.PinCode)        ;
					$('#CMobileNo').val(value.MobileNo)     ;
				}); 
			}
		});// End Of AJAX
	});
  
    
});
