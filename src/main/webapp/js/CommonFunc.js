/** knrai
 *  coommon function used for all JSP PAGE.
 */
var countryOptions=" ";
var rcOptions= " ";
var apartmentOptions=" ";
var flatOption=" ";
var VehileOption=" ";
alert('Apartment');
$(document).ready(function(){
	$("#ulpwd").load("../UserLogin/UserLoginPwdRest.jsp", function(){
		getRefreshCaptcha();
		$("#email").focus();
	});
	$("#country").click(function(){
		if (countryOptions!=" "){
			retrun;
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
	$("#email").focusout(function() {
		var email = $("#email").val();
		if(!IsEmail(email)){
			$("#email").val(' Invalid email format');
			$("#email").focusin();
			return;
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
	$("#SetValueType").click(function(){
		if (rcOptions!=" "){retrun;}
		getRCList();
	});
	function getRCList(){
		$.ajax({
			type:'POST',
			data:{Action:"getRCList"},
		 	dataType: 'json',
			url:'../ConfigInfo',
			success:function(result){
				rcOptions=" <option value= 0>Select Name</option>";
				$.each(result, function(id, name){
					rcOptions+=" <option value='"+name.id +"'>"+ name.name + "</option>";
				});
				$("#SetValueType").html(rcOptions);
			},	
		    error: function () {
				$("#SetValueType").val("Sorry, Technical Issue");
		    }				
		});	 // eof AJAX
	}

	$("#apartment").click(function(){
		if (apartmentOptions!=" "){
			retrun;
		}
		getAPTList();
	});

	function getAPTList(){ 
		$.ajax({
			type:'POST',
			data:{Action:"getAPTList"},
		 	dataType: 'json',
			url:'../AptInfo',
			success:function(result){
				apartmentOptions = " <option value= 0>Select Apartment*</option>";
				$.each(result, function(id, name){
					apartmentOptions += " <option value='"+name.TowerNo +"'>"+ name.TowerNo + "</option>";
				});
				$("#apartment").html(apartmentOptions);
				
			},	
		    error: function () {
				$("#apartment").val("Sorry, Technical Issue");
		    }				
		});	 // eof AJAX
	}
	
 	$("#flatInfo").click(function(){
		if (flatOption!=" "){
			retrun;
		}
		var apartmentList = $("#apartment").val();
		getFlatList(apartmentList);
	});

	function getFlatList(apartmentList){ 
		$.ajax({
			type:'POST',
			data:{Action:"getFlatList","inputTowerNo" : apartmentList},
		 	dataType: 'json',
			url:'../AptInfo',
			success:function(result){
				flatOption = " <option value= 0>Select Flat No.*</option>";
				$.each(result, function(id, name){
					flatOption += " <option value='"+name.FlatNo +"'>"+ name.FlatNo + "</option>";
				});
				$("#flatInfo").html(flatOption);
			},	
		    error: function () {
				$("#flatInfo").val("Sorry, Technical Issue");
		    }				
		});	 // eof AJAX
	}
	// function to generate vehicle list 
	$("#VehType").click(function(){
		if (VehileOption!=" "){
			retrun;
		}
		$.ajax({
			type:'POST',
			data:{Action:"VehTypeList"},
		 	dataType: 'json',
			url:'../VehicleInfo',
			success:function(result){
				VehileOption = " <option value= 0>Select Vehicle Type*</option>";
				$.each(result, function(id, name){
					VehileOption += " <option value='"+name.VehicleType +"'>"+ name.VehicleType + "</option>";
				});
				$("#VehType").html(VehileOption);
			},	
		    error: function () {
				$("#VehType").val("Sorry, Technical Issue");
		    }				
		});	 // eof AJAX
	});

	
});
