/**
 * 
 */
function  displaypodata(){
	alert("wah chal gaya");
	fDate = $("#FromDate").val();
	tDate = $("#ToDate").val();
	var PONo=$("#PONo").val();
	var request =$.ajax({
		type:'POST',
		data:{PONO:PONo,  fromDate:fDate,toDate:tDate, Action:"POList"},
   	    dataType: 'json',
		url:'../POSummary',
		success:function(result){
			if ($("#ActionType").val()=='2'){
				alert("wah kamal zero one");
   			POListForEdit(result);
			}else{
				alert("wah kamal zero");
   			tableItemsView(result);
			}
		}	
	});
}


alert('karunanidhirai');
$(document).ready(function(){
	//$("#PONo").val($.urlParam('Id') );
	var act='del';
	var tPONo=$("#PONo").val();

	$("#sub01").hide();
	

	$('#addTempPOItem').click(function(){
		if($("#ItemName").val()!="" && $("#Unit").val()!="" && $("#Quantity").val()!="" && $("#PONo").val()!=""  ){
	   		ICode= $('#ItmCode').val();
	   		IName= $('#ItemName').val();
	   		Brand= $('#Brand').val();
	   		Qty= $('#Quantity').val();
	   		Unt=$('#Unit').val();
	   		Note= $('#Note').val();
	   		PONo=$("#PONo").val();
	   		txtInit();
			var request =$.ajax({
	   			type:'POST',
	   			data:{PONO:PONo,ItemCode:ICode,ItemName:IName, BrandName:Brand, Quantity:Qty, Unit:Unt, Remark:Note, Action:"NEW"},
   	   		    dataType: 'json',
	   			url:'../EditPO',
	   			success:function(result){
	   				tableItems(result);
	   			}	
			});// End Of the $.Ajax()
		}
	});	// End Of Add New Item

   $(document).on('click', "Button[name='POList']", function(){ 
   		PONo=$("#PONo").val();
		var Sno=$(this).val();
		var request =$.ajax({
   			type:'POST',
   			data:{SNo:Sno, PONO:PONo, Action:"DELETE"},
   		    dataType: 'json',
   			url:'../TempPOInfo',
   			success:function(result){
   				tableItems(result);
   			}	
		});// End Of the $.Ajax()
		
   	});// end of remove item
   $(document).on('click', "Button[name='PODelItem']", function(){ 
		var SNo=$(this).val();
  		PONo=$("#PONo").val();
		alert('PONO :' + PONo + " SNo : " +  SNo );
		var request =$.ajax({
  			type:'POST',
  			data:{PONO:PONo, SNO:SNo, Action:"PODELITEM"},
	   		    dataType: 'json',
  			url:'../EditPO',
  			success:function(result){
  				tableItems(result);			   				
  			}	
		});// End Of the $.Ajax()
   });

	
	function txtInit(){
	    $("#ItmCode").val("");
		$("#ItemName").val("");
        $("#Brand").val("");
        $("#Quantity").val("");
        $("#Unit").val("");
        $("#Note").val("");
	}
	function tableItems(result){
		$('#POItemDetails').dataTable({
		    destroy: true,
		    "scrollX": true,
	        "scrollY": 300,
	        "data":result,
			 columnDefs: [
	    		{	targets: -1,
	        		className: 'dt-body-right'
	    		},
	    		{ "width": "10%", "targets": 0 },
	    		{ "width": "10%", "targets": 1 },
	    		{ "width": "10%", "targets": 2 },
	    		{ "width": "20%", "targets": 3 },
	    		{ "width": "10%",  "targets":4 },
	    		{ "width": "10%", "targets": 5 },
	    		{ "width": "15%", "targets": 6 },
	    		{ "width": "5%", "targets": 7 },
	  		],
		    "columns": [
				 { title:	'SNo.'           ,data:"SNo" },
    			 { title:	'PONO'          ,data:"PONO" },  
				 { title:	'Item Code'	 ,data:"ItemCode"},  
				 { title:	'Item Name'  ,data:"ItemName"},
				 { title:	'Brand'         ,data:"Brand"}, 
				 { title:	'QTY'		 ,data:"Quantity"},  
				 { title:	'Unit'           ,data:"Unit"},
				 { title:	'Remove'		  ,data:"SNo",
					 "render": function(data,type,row,meta){
						 return	'<button type="button" name="PODelItem"  value="'+data+'" class="btn btn-warning"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
					 },
				 }
		  ],
	    "footerCallback": function( row, data, start, end, display ) {
	    	// Remove the formatting to get integer data for summation
	          var api = this.api(), data;
            // converting to interger to find total
            var intVal = function ( i ) {
                return typeof i === 'string' ?
                    i.replace(/[\$,]/g, '')*1 :
                    typeof i === 'number' ?
                        i : 0;
	            };
		    }, // eof footer
		}); // eof dtable
	}// eof  function
    function ViewPOItemList(result){
		$('#POItemsList').dataTable({
		    destroy: true,
		    "scrollX": true,
	        "scrollY": 200,
		    "data":result,
			 columnDefs: [
	    		{	targets: -1,
	        		className: 'dt-body-right'
	    		},
	    		{ "width": "4%", "targets": 0 },
	    		{ "width": "7%", "targets": 1 },
	    		{ "width": "12%", "targets":2 },
	    		{ "width": "13%", "targets":3 },
	    		{ "width": "10%", "targets":4 },
	    		{ "width": "5%",  "targets":5 },
	    		{ "width": "5%",  "targets":6 },
    		],
		    "columns": [
    			 { title:	'SNo.'           ,data:"SNo" },
    			 { title:	'PONO'          ,data:"PONO" },  
    			 { title:	'Item Code'	 ,data:"ItemCode"},  
   				 { title:	'Item Name'  ,data:"ItemName"},
    			 { title:	'Brand'         ,data:"Brand"}, 
    			 { title:	'QTY'		 ,data:"Quantity"},  
   				 { title:	'Unit'           ,data:"Unit"},
    		],
		}); // eof datatable
	}// eof ViewPoItemList
	$(document).on('click', "Button[name='ViewPOItems']", function(){ 
		var PONo=$(this).val();
		tPONo=PONo;
		var request =$.ajax({
   			type:'POST',
   			data:{PONO:PONo,  Action:"POItemList"},
	   		    dataType: 'json',
   			url:'../POSummary',
   			success:function(result){
   				if ($("#ActionType").val()=='2'){
   					POItemListDataTable(result);
   				}else{
	   				ViewPOItemList(result);
   				}
   			}	
		});// End Of the $.Ajax()
    });


    
    
    
});// eof ready()
