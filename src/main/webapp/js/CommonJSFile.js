/** 
 *  coommon function used for all JSP PAGE.
 */
var countryOptions = " ";
var colbOptions = "";
var pfdOptions = "";
var athCountryOptions= "";
alert("welcome");


$(document).ready(function(){
	$("#country").click(function(){
		if (countryOptions!=" "){
			return;
		}
		countryList();
	});
	function countryList(){
		var request =$.ajax({
			type:'POST',
			data:{Action:"CountryList"},
	 		dataType: 'json',
			url:'../ContactUsInfo',
			success:function(result){
				countryOptions+=" <option value=1>Select Country Name</option>";
				$.each(result, function(id, name){
					countryOptions+=" <option value='"+name.id +"'>"+ name.name + "</option>";
					//alert("id : " +name.id  + " Name : " + name.name );
				});
				$("#country").html(countryOptions);
			}	
		});// End Of the $.Ajax()
	}
	$("#athCountry").click(function(){
		if (athCountryOptions!=""){
			retrun;
		}
		athCountryList();
	});
	function athCountryList(){
		var request =$.ajax({
			type:'POST',
			data:{Action:"CountryList"},
	 		dataType: 'json',
			url:'../ContactUsInfo',
			success:function(result){
				athCountryOptions+=" <option value=1>Select Country Name</option>";
				$.each(result, function(id, name){
					athCountryOptions+=" <option value='"+name.id +"'>"+ name.name + "</option>";
					//alert("id : " +name.id  + " Name : " + name.name );
				});
				$("#athCountry").html(athCountryOptions);
			}	
		});// End Of the $.Ajax()
	}

	$("#Collaboration").click(function(){
		if (colbOptions!=""){
			retrun;
		}
		collaborationList();
	});
	function collaborationList(){
		var request =$.ajax({
			type:'POST',
			data:{Action:"colbList"},
	 		dataType: 'json',
			url:'../ContactUsInfo',
			success:function(result){
				colbOptions+=" <option value=1>Select Collaboration Option</option>";
				$.each(result, function(id, name){
					colbOptions+=" <option value='"+name.id +"'>"+ name.name + "</option>";
				});
				$("#Collaboration").html(colbOptions);
			}	
		});// End Of the $.Ajax()
	}

	$("#prodDemo").click(function(){
		if (pfdOptions!=""){
			retrun;
		}
		itemList();
	});
	function itemList(){
		var request =$.ajax({
			type:'POST',
			data:{Action:"ProductList"},
	 		dataType: 'json',
			url:'../ContactUsInfo',
			success:function(result){
				pfdOptions+=" <option value=1>Select Product for Demo</option>";
				$.each(result, function(id, name){
					pfdOptions+=" <option value='"+name.id +"'>"+ name.name + "</option>";
					//alert("id : " +name.id  + " Name : " + name.name );
				});
				$("#prodDemo").html(pfdOptions);
			}	
		});// End Of the $.Ajax()
	}
	
	
	$("#textareaMsg").keyup( function(){
		$('#rchars').text(500 - $(this).val().length);
	});
	$("#BEsub01").click(function() {
		var title    = $("#title option:selected").text();
		var fnm      = $("#fName").val();
		var lnm      = $("#lName").val();
		var email    = $("#email").val();
		var compName = $("#companyName").val();
		var country  = $("#country option:selected").text();
		var city     = $("#city").val();
		var phone    = $("#phoneNo").val();
		var enqMsgLen= $("#textareaMsg").val().length;
		if (title=='Title' || title==null){
			 $("#title").focus();
			alert("Title can't be Empty");
			return false;
		 }else if(fnm=="" || fnm==null){
			 $("#fName").focus();
			 alert("First Name can't be Empty");
			return false;
		}else if(lnm=="" || lnm==null  ){
			 $("#lName").focus();
			alert("Last Name cannot be Empty");
			return false;
		 }else if(email=="" || email==null){
			alert("Email Id can't be Empty");
			 $("#email").focus();
			return false;
		 }else  if(IsEmail(email)==false){
			alert("Enter valid email id! Check email id format[?%@.??%]");
         	return false;
		}else if(country=="0" || country=="Select Country Name" ){
			alert("Country Name cannot be Empty");
			return false;
		 }else if(city=="" || city==null){
			alert("City Name can't be Empty");
			 $("#city").focus();
			return false;
		}else if(phone=="" || phone==null){
			alert("Phone No. cannot be Empty");
			 $("#phoneNo").focus();
			return false;
		}else if(enqMsgLen <=1)	{
			alert(" Your enquiry message cannot be Empty");
				return false;
		}else{
			return true;
		}
	});
	
	function validEmail(emailId){
		return IsEmail(emailId)?  true :  false;
	}

	function IsEmail(email) {
		alert("Hindustan123");
		var regex = /^([a-zA-Z0-9\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		 if(!regex.test(email)) {
			 return false;
		 }else{
		    return true;
		 }
	}

	$("#clSub01").click(function() {
		var title    = $("#title option:selected").text();
		var fnm      = $("#fName").val();
		var lnm      = $("#lName").val();
		var email    = $("#email").val();
		var country  = $("#country option:selected").text();
		var city     = $("#city").val();
		var phone    = $("#phoneNo").val();
		var enqMsgLen= $("#textareaMsg").val().length;
		if (title=='Title*' || title==null){
			 $("#title").focusin();
			alert("Title can't be Empty");
			return false;
		 }else if(fnm=="" || fnm==null){
			 $("#fName").focusin();
			 alert("First Name can't be Empty");
			return false;
		}else if(lnm=="" || lnm==null  ){
			 $("#lName").focusIn();
			alert("Last Name cannot be Empty");
			return false;
		 }else if(email=="" || email==null){
			alert("Email Id can't be Empty");
			 $("#email").focusin();
			return false;
		 }else  if(IsEmail(email)==false){
			alert("Enter valid email id! Check email id format[?%@.??%]");
         	return false;
		}else if(country=="0" || country=="Select Country Name" ){
			alert("Country Name cannot be Empty");
			return false;
		 }else if(city=="" || city==null){
			alert("City Name can't be Empty");
			 $("#city").focusin();
			return false;
		}else if(phone=="" || phone==null){
			alert("Phone No. cannot be Empty");
			 $("#phoneNo").focusIn();
			return false;
		}else if(enqMsgLen <=1)	{
			alert(" Your enquiry message cannot be Empty");
				return false;
		}else{
			return true;
		}
	});

	$("#contUsX").click(function(){
		var title    = $("#title option:selected").text();
		var fnm      = $("#fName").val();
		var lnm      = $("#lName").val();
		var email    = $("#email").val();
		var company  = $("#companyName").val();
		var country  = $("#country option:selected").text();
		var city     = $("#city").val();
		var phone    = $("#phoneNo").val();
		var zipCode  = $("#postalCode").val();
		var enqMsgLen= $.trim($("#textareaMsg").val()).length;
		var enqMsg = $("#textareaMsg").val()
		
		if(validateEnqFormValue(title,fnm,lnm,email,country,city,phone,enqMsgLen)){
			var request =$.ajax({
				type:'POST',
				data:{Action:"ContactUs",title:title,fName:fnm, lName:lnm, phoneNo:phone,email:email,companyName:company,country:country,city:city,phoneNo:phone,postalCode:zipCode,enquiryMsg:enqMsg },
		 		dataType: 'json',
				url:'../ContactUsInfo',
				success:function(result){
					alert("rr " + result);
				}
			});// End Of the $.Ajax()
		};
	});
	function validateEnqFormValue(title,fnm,lnm,email,country,city,phone,enqMsgLen){
		if (title=='Title' || title==null){
			 $("#title").focusin();
			alert("Title can't be Empty");
			return false;
		 }else if(fnm=="" || fnm==null){
			 $("#fName").focusin();
			 alert("First Name can't be Empty");
			return false;
		}else if(lnm=="" || lnm==null  ){
			 $("#lName").focusIn();
			alert("Last Name cannot be Empty");
			return false;
		 }else if(email=="" || email==null){
			alert("Email Id can't be Empty");
			 $("#email").focusin();
			return false;
		 }else  if(IsEmail(email)==false){
			alert("Enter valid email id! Check email id format[?%@.??%]");
         	return false;
		}else if(country=="Country Name*" || country=="Select Country Name" ){
			alert("Country Name cannot be Empty");
			return false;
		 }else if(city=="" || city==null){
			alert("City Name can't be Empty");
			 $("#city").focusin();
			return false;
		}else if(phone=="" || phone==null){
			alert("Phone No. cannot be Empty");
			 $("#phoneNo").focusIn();
			return false;
		}else if(enqMsgLen <=1 )	{
			alert(" Your enquiry message cannot be Empty");
				return false;
		}else{
			return true;
		}
		
	}

	$("#subsDate").datepicker();
	
	$("#ViewSubscription").click(function(){
		var request =$.ajax({
			type:'POST',
			data:{Action:"subView"},
		 	dataType: 'Json',
			url:'../SubscriptionInfo',
			success:function(result){
				subsList(result);
			}	
		});	 // eof AJAX
	});

	$(document).on('click', "Button[name='DelSubsInventory']", function(){ 
		var con = confirm("Do you really want to delete? ");
		alert("checking");
		if(con){
			var subsDelID  = $(this).val();
			alert("checking del id:" +subsDelID);
			var request =$.ajax({
				type:'POST',
				data:{ subsdel : subsDelID, Action:"subscriptionDel"},
			 	dataType: 'json',
				url:'../SubscriptionInfo',
				success:function(result){
					subsList(result);
				}	
			});	 // eof AJAX
		}
	});
			
	function subsList(result){
		$('#nwItm').dataTable({
		    destroy: true,
			"data":result,
			 columnDefs: [
				 {	targets: -1, className: 'dt-body-right'	},
			 ],
		    "columns": [
				 { title:	'SNO'	            ,data:"SNO"},
				 { title:	'RWA Reg No'        ,data:"rwaNo"},
				 { title:	'Subscription Type'  ,data:"subType"},  
				 { title:	'Eff Date'          ,data:"efDate"},
				 { title:	'Scription'	        ,data:"subscription"}, 
				 { title:	'Amount'			,data:"amount"}, 
				 { title:	'Type'	            ,data:"expType"}, 
	    		 { title:	'Del'		  ,data:"iDNO",
			     	"render": function(data,type,row,meta){
			       	 	return	'<button type="button" name="DelSubsInventory"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
		        	},
		        }
			]
		}); // EOF table
	}// EOF table FUNCTION	
	$("#subsAdd").click(function(){
		var subscriptionType  = $("#SubscriptionType").val();
		var subsDate = $("#subsDate").val();
		var subscription  = $("#subscription").val();
		var subAmt = $("#subAmt").val();
		var fixFloat  = $("#fixFloat").val();
		if(subsValid(subscriptionType, subsDate , subscription,subAmt, fixFloat )){
			addSubs(subscriptionType, subsDate , subscription,subAmt, fixFloat);
		}
	});
	function subsValid(subscriptionType, subsDate , subscription,subAmt, fixFloat){
		if(subscriptionType==0){
			$("#SubscriptionType").focusin();
			$("#SubscriptionType").val("Subscription Type can't be blank");
			return false;
		}else if(subsDate==0){
			$("#subsDate").focusin();
			$("#subsDate").val("subscription Date can't be blank");
			return false;
		}else if(subscription==0){
			$("#subscription").focusin();
			$("#subscription").val("subscription can't be blank");
			return false;
		}else if(subAmt==0){
			$("#subAmt").focusin();
			$("#subAmt").val("sub Amt can't be blank");
			return false;
		}else if(fixFloat==0){
			$("#fixFloat").focusin();
			$("#fixFloat").val("fixFloat can't be blank");
			return false;
		}
    	$("#SubscriptionType option[value='0']").attr('selected', 'selected');				    	
		$("#subsDate").val("");
    	$("#Subscription option[value='0']").attr('selected', 'selected');				    	
		$("#subAmt").val("");
    	$("#fixFloat option[value='0']").attr('selected', 'selected');				    	
		return true;
	}
	function addSubs(subscriptionType, subsDate , subscription,subAmt, fixFloat){
		var request =$.ajax({
			type:'POST',
			data:{Action:"NewSubscription", "SubscriptionType" : subscriptionType, "subsDate" : subsDate,
				 "subscription" :subscription, "subAmt" :subAmt ,"fixFloat" :fixFloat},
		 	dataType: 'Json',
			url:'../SubscriptionInfo',
			success:function(result){
				subsList(result);
			}	
		});	 // eof AJAX
	}// eof ValidateUserEmail()	
	$(document).on('click', "Button[name='vehInfoDel']", function(){ 
		var con = confirm("Do you really want to delete? ");
		if(con){
			var vehInfoDelID  = $(this).val();
			var aptNo = $("#apartment").val();
			var fltNo = $("#flatInfo").val();
			alert (aptNo +" , " + fltNo );
			if(vehVeiwInfoValid(aptNo, fltNo)){
				var request =$.ajax({
					type:'POST',
					data:{"Action":"VehInfoDel",  "aptNo" : aptNo, "flatNo" : fltNo,"vehInoDelId":vehInfoDelID, },
				 	dataType: 'Json',
					url:'../VehicleInfo',
					success:function(result){
						vehicleList(result);
					}	
				});	 // eof AJAX
			}	
		}
	});	
	function vehicleList(result){
		$('#vehOwnerList').dataTable({
		    destroy: true,
			"data":result,
			 columnDefs: [
				 {	targets: -1, className: 'dt-body-right'	},
			 ],
		    "columns": [
				 { title:	'SNO'	       ,data:"SNO"},
				 { title:	'RWA Reg.No.'  ,data:"RwaNo"},
				 { title:	'Apt.No'       ,data:"AptartmentNo"},
				 { title:	'Flat No.'     ,data:"FlatNo"},  
				 { title:	'Vehicle Type' ,data:"VehicleType"},
				 { title:	'Manufacturer' ,data:"Manufacturer"}, 
				 { title:	'Vehicle Name' ,data:"VehicleName"}, 
				 { title:	'Vehicel No'   ,data:"VehicleNo"}, 
				 { title:	'Color'	       ,data:"VehicleColor"}, 
	    		 { title:	'Del'		   ,data:"iDNO",
			     	"render": function(data,type,row,meta){
			       	 	return	'<button type="button" name="vehInfoDel"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
		        	},
		        }
			]
		}); // EOF table
	}// EOF table FUNCTION	
	$("#vehlist01").click(function(){
		var aptNo = $("#apartment").val();
		var fltNo = $("#flatInfo").val();
		if(vehVeiwInfoValid(aptNo, fltNo)){
			alert("Validation is ok");
			ViewVehInfo(aptNo, fltNo);
		}
	});

	function vehVeiwInfoValid(aptNo, fltNo){
		if(aptNo=="" || aptNo==0){
			$("#apartment").focusin();
			$("#apartment").val("Apt No can't be blank");
			return false;
		}else if(fltNo=="" || fltNo==0 ){
			$("#flatInfo").focusin();
			$("#flatInfo").val("Flat No can't be blank");
			return false;
		}
		return true;
	}
	function ViewVehInfo(aptNo, fltNo){
		var request =$.ajax({
			type:'POST',
			data:{"Action":"VehView", "aptNo" : aptNo, "flatNo" : fltNo},
		 	dataType: 'Json',
			url:'../VehicleInfo',
			success:function(result){
				vehicleList(result);
			}	
		});	 // eof AJAX
	}// eof ViewVehInfo()	
	/* create vehicle  ----------------------------------*/
	$("#vehAdd01").click(function(){
		var aptNo = $("#apartment").val();
		var fltNo = $("#flatInfo").val();
		var vtype = $("#VehType").val();
		var manuf = $("#vehManfacturer").val();
		var Model = $("#vehModel").val();
		var vehNo = $("#vehNo").val();
		var color  =$("#vehColor").val();
		if(vehInfoValid(aptNo, fltNo , vtype, manuf, Model, vehNo, color )){
			addVehInfo(aptNo, fltNo , vtype, manuf, Model, vehNo, color);
		}
	});
	function addVehInfo(aptNo, fltNo , vtype,manuf, Model, vehNo, color){
		var request =$.ajax({
			type:'POST',
			data:{"Action":"VehNew", "aptNo" : aptNo, "flatNo" : fltNo, "VehType" :vtype, "vehManfacturer" :manuf ,
				  "vehModel" :Model, "vehNo":vehNo, "vehColor":color},
		 	dataType: 'Json',
			url:'../VehicleInfo',
			success:function(result){
				vehicleList(result);
			}	
		});	 // eof AJAX
	}// eof ValidateUserEmail()	
	function vehInfoValid(aptNo, fltNo , vtype,manuf, Model, vehNo, color ){
		if(aptNo=="" || aptNo==0){
			$("#apartment").focusin();
			alert("Apartment No can't be blank");
			return false;
		}else if(fltNo=="" || fltNo==0){
			$("#flatInfo").focusin();
			alert("Flat No can't be blank");
			return false;
		}else if(vtype==0){
			$("#VehType").focusin();
			alert("Vehicle Type can't be blank");
			return false;
		}else if(manuf==0){
			$("#vehManfacturer").focusin();
			alert("Manfacturer can't be blank");
			return false;
		}else if(Model==0){
			$("#vehModel").focusin();
			alert("Vehicle Name can't be blank");
			return false;
		}else if(vehNo==0){
			$("#vehNo").focusin();
			alert("Vehicle No can't be blank");
			return false;
		}else if(color==0){
			$("#vehColor").focusin();
			alert("Vehicle color can't be blank");
			return false;
		}
		$("#VehType").val("");
		$("#vehManfacturer").val("");
		$("#vehModel").val("");
		$("#vehNo").val("");
		$("#vehColor").val("");
		return true;
	}
	$("#shiftInOn").datetimepicker({
		timepicker: false,
		datepicker: true,
		format: 'd-m-yy', // formate date
		value:  visitTime(), //defaultTime
		step: 5,	
		yearStart:yearStart(),
		yearEnd:'2030',
		weeks:true	
	});
	$("#shiftOutOn").datetimepicker({
		timepicker: false,
		datepicker: true,
		format: 'd-m-yy', // formate date
//		value:  visitTime(), //defaultTime
		step: 5,	
		yearStart:yearStart(),
		yearEnd:'2030',
		weeks:true	
	});
	function yearStart(){
		var cdate = new Date();
		return cdate.getFullYear();
	}
	var vTime = visitTime();
	function visitTime(){
		var vDate = new Date();
		var vInTime = vDate.getHours()+":"+ vDate.getMinutes();
		return 	vInTime;
	}	
	
	/* -------------------------------------------------*/
}); // end of documen ready function
function ulInfo() {
	countryList();
	var request =$.ajax({
		type:'POST',
		data:{Action:"UserInfo"},
	 	dataType: 'Json',
		url: '../UserLoginInfo',
		success:function(result){
			$.each(result, function(key,value) {
				$('#RwaNo').val(value.RWA);
				$('#Fname').val(value.FName);
				$('#Lname').val(value.LName);
				$('#mobileNo').val(value.Mobile);
				$('#email').val(value.ULID);
		    	$("#Security").val(value.Security);
		    	$("#Mobile").val(value.Mobile);
		    	$("#Address").val(value.Address);
		    	$("#Sector").val(value.Sector);
		    	$("#City").val(value.City) ;
		    	$("#State").val(value.State);
		    	$("#country option[value='"+value.Country+"']+").attr('selected', 'selected');				    	
		    	$("#postalCode").val(value.PinCode);
			});
		}	
	});	 // eof AJAX
}
function countryList(){
	var request =$.ajax({
		type:'POST',
		data:{Action:"CountryList"},
 		dataType: 'json',
		url:'../ContactUsInfo',
		success:function(result){
			countryOptions+=" <option value=1>Select Country Name</option>";
			$.each(result, function(id, name){
				countryOptions+=" <option value='"+name.id +"'>"+ name.name + "</option>";
				//alert("id : " +name.id  + " Name : " + name.name );
			});
			$("#country").html(countryOptions);
		}	
	});// End Of the $.Ajax()
}
