/*Shikha Rai*
 * Second March 2021
 */
var countryOptions=" ";
var athCountryOptions=" ";
$(document).ready(function(){
	$("#ulpwd").load("../UserLogin/UserLoginPwdRest.jsp", function(){
		getRefreshCaptcha();
		$("#email").focus();
	});
	$("#country").click(function(){
		countryOptions!=" "?retrun:countryList('C');
	});
	$("#athCountry").click(function(){
		athCountryOptions!=" "?retrun:countryList('A');
	});
	function countryList( ctyp){
		countryOptions="";
		var request =$.ajax({
			type:'POST',
			data:{Action:"CountryList"},
	 		dataType: 'json',
			url:'../../ContactUsInfo',
			success:function(result){
				countryOptions+=" <option value=1>Select Country Name</option>";
				$.each(result, function(id, name){
					countryOptions+=" <option value='"+name.id +"'>"+ name.name + "</option>";
					//alert("id : " +name.id  + " Name : " + name.name );
				});
				ctyp=='C'?$("#country").html(countryOptions):$("#athCountry").html(countryOptions);
			}	
		});// End Of the $.Ajax()
	}
	$("#Kemail").focusout(function() {
		var email = $("#email").val();
		if(!IsEmail(email)){
			$("#email").val(' Invalid email format');
			$("#email").focus();
		}
	});
	function IsEmail(email) {
		var regex = /^([a-zA-Z0-9\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if(!regex.test(email)) {
			return false;
		}else{
			return true;
		}
	}
	$(function () {
		  $('[data-toggle="tooltip"]').tooltip()
	})				
	$("#refreshCaptcha").click(function(){
		getRefreshCaptcha();
	});		
	function getRefreshCaptcha(){
		var request =$.ajax({
			type:'POST',
			data:{Action:"refreshCaptcha"},
		 	dataType: 'text',
			url:'../ValidateUserLogin',
			success:function(result){
				$("#refreshCaptcha").val(result);
			},	
		    error: function () {
				$("#refreshCaptcha").val("Sorry, there was an error");
		    }				
		});	 // eof AJAX
	}

	$("#email").focusout(function() {	
		$("#LoginId").val($("#email").val())
		var email = $("#email").val();
		if(!IsEmail(email)){
			$("#email").val(email+' Invalid email format');
			$("#email").focus();
		}
		var request =$.ajax({
			type:'POST',
			data:{"EmailId":email, Action:"Email"},
		 	dataType: 'text',
			url:'../../SchoolInfo',
			success:function(result){
				if(result!="Duplicate"){
					$("#mobileNo").focus()
				}else{
					$("#email").val("Email Id Already exist!")
					$("#email").focus()
				}

//				result!="Duplicate"?$("#mobileNo").focus():$("#email").focus();
			},	
		    error: function () {
				$("#email").val("Sorry, there was an error");
		    }				
		});	 // eof AJAX
	});// eof RegNo
	
	$("#HoEmail").focusout(function() {	
		var email = $("#HoEmail").val();
		if(!IsEmail(email)){
			$("#HoEmail").val(email +' Invalid email format');
			$("#HoEmail").focus();
		} else{
			$("#HoMobileNo").focus();
		}
		var request =$.ajax({
			type:'POST',
			data:{"EmailId":email, Action:"Email"},
		 	dataType: 'text',
			url:'../../SchoolInfo',
			success:function(result){
				if(result!="Duplicate"){
					$("#HoMobileNo").focus()
				}else{
					$("#HoEmail").val("Email Id Already exist!")
					$("#HoEmail").focus()
				}
			},	
		    error: function () {
				$("#email").val("Sorry, there was an error");
		    }				
		});	 // eof AJAX

	});

	$("#RegNo").focusout(function() {
		var RegNo = $("#RegNo").val();
		if(RegNo.length<=4){
			$("#RegNo").focus();
		}
		var request =$.ajax({
			type:'POST',
			data:{"RegNo":RegNo, Action:"RegNo"},
		 	dataType: 'text',
			url:'../../SchoolInfo',
		    success:function(result){
				if(result != "Duplicate"){
					$("#SchName").focus();
				}else{
					$("#RegNo").val("School Reg No already exist");
					$("#RegNo").focus();
				}
			},	
		    error: function () {
				$("#RegNo").val("Sorry, There is an Error ");
				$("#RegNo").focus();
		    }				
		});	 // eof AJAX
	});// eof RegNo
	
});
