/** knrai
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
		alert("testig");
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
		alert("India");
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
	

	
});
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
