/** knrai
 *  coommon function used for all JSP PAGE.
 */
var countryOptions=" ";
var rcOptions= " ";
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
	$("#SetValueType").click(function(){
		if (rcOptions!=" "){
			retrun;
		}
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
	
});
