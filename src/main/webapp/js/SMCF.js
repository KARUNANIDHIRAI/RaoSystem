/*Shikha Rai*
 * Second March 2021
 */

var countryOptions=" ";
var athCountryOptions=" ";
var	fTOption=" ";
var courseOption=" ";
var fApplCF=" ";
var fApplCT=" ";
var feePenality =" ";
var PenalityApplCF = " ";
var feeGrade = " ";
var section = " ";
var subjects="";
var days = " ";
var gender = " ";
var facultyOption= " ";
var actionType =" ";
var category =" ";
var uRType = " ";
alert("knSMFC");
$(document).ready(function(){
	   $("#Category").click(function(){
			if (category!=" "){return;}
			category=" <option selected value=0>Choose Category*</option>";
		    var cCategory = ['Computer Science', 'History','Social Science','English','Mathematics','Music','Dance', 'Home Science'];
	       $.each(cCategory, function(index, value){
	    	   category+=" <option value='"+value +"'>"+ value+ "</option>";
	       });
	       $("#Category").html(category);
	   });
	
	$("#ulpwd").load("../UserLogin/UserLoginPwdRest.jsp", function(){
		getRefreshCaptcha();
		$("#email").focus();
	});
	$("#xfmMainPage").load("../SMSISystem/SMSystems/FacultyMemberMain.jsp", function(){
		actionType();
	});
	actionType
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
				if(ctyp=='C'){
					countryOptions+=" <option value=1>Select Country Name</option>";
					$.each(result, function(id, name){
						countryOptions+=" <option value='"+name.id +"'>"+ name.name + "</option>";
					});
					$("#country").html(countryOptions)
				}else{
					athCountryOptions+=" <option value=1>Select Country Name</option>";
					$.each(result, function(id, name){
						athCountryOptions+=" <option value='"+name.id +"'>"+ name.name + "</option>";
					});
					$("#athCountry").html(athCountryOptions);
				}
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

	$("#feeType").click(function(){
		if (fTOption!=" "){
			return;
		}
		var request =$.ajax({
			type:'POST',
			data:{Action:"xSFTRI"},
		 	dataType: 'Json',
			url:'../../SFType',
			success:function(result){
				fTOption+=" <option value=1>Choose fee Type</option>";
				$.each(result, function(id, name){
					fTOption+=" <option value='"+name.Name +"'>"+ name.Name + "</option>";
				});
				$("#feeType").html(fTOption)
			}	
		});	 // eof AJAX
	});

	$("#fProgram").click(function(){
		if (courseOption!=" "){	return;	}
		courseOption="";
		var request =$.ajax({
			type:'POST',
			data:{Action:"xSRVl"},
		 	dataType: 'Json',
			url:'../../SubjectsInfo',
			success:function(result){
				courseOption+=" <option selected value=0>Choose Course Program</option>";
				$.each(result, function(id, name){
					courseOption+=" <option value='"+name.Code +"'>"+ name.Name+ "</option>";
				});
				$("#fProgram").html(courseOption);
			}	
		});	 // eof AJAX
	});
	
	$("#fApplCF").click(function(){
		if(fApplCF!=" "){return;}
		fApplCF=" <option selected value=0>Choose Class from</option>";
		for (var ctr=1;ctr<=12;ctr++){
			fApplCF+=" <option value='"+ctr +"'>"+ ctr+ "</option>";
		}
		$("#fApplCF").html(fApplCF);
		$("#PenalityApplCF").html(fApplCF);
 	});
	$("#feeSlab").click(function(){
		if (fApplCT!=" "){return;}
		fApplCT=" <option selected value=0>Choose Fee Slab</option>";
			fApplCT+=" <option value='Monthly'>Monthly   </option>";
			fApplCT+=" <option value='Monthly'>Quaterly  </option>";
			fApplCT+=" <option value='Monthly'>HalfYearly</option>";
			fApplCT+=" <option value='Monthly'>Yearly    </option>";
		$("#feeSlab").html(fApplCT);
	});
	$("#feePenality").click(function(){
		if (feePenality!=" "){return;}
		feePenality="  <option selected value=0> Choose Penality Charge Slab</option>";
		feePenality+=" <option value='Fix'>Fixed               </option>";
		feePenality+=" <option value='Daily'>Daily             </option>";
		feePenality+=" <option value='Weekly'>Weekly           </option>";
		feePenality+=" <option value='Fortnightly'>Fortnightly </option>";
		feePenality+=" <option value='Monthly'>Monthly         </option>";
		feePenality+=" <option value='Monthly'>Quaterly        </option>";
		feePenality+=" <option value='Monthly'>HalfYearly      </option>";
		feePenality+=" <option value='Monthly'>Yearly          </option>";
		$("#feePenality").html(feePenality);
	});
	$("#feeGrade").click(function(){
		if (feeGrade!=" "){return;}
		
		feeGrade=" <option selected value=0>Choose Fee Slab</option>";
		feeGrade+=" <option value='General'>General   </option>";
		feeGrade+=" <option value='EWS'>EWS  </option>";
		feeGrade+=" <option value='OBC'>OBC  </option>";
		feeGrade+=" <option value='SC'>SC    </option>";
		feeGrade+=" <option value='ST'>ST    </option>";
		feeGrade+=" <option value='DQ'>DQ    </option>";
		feeGrade+=" <option value='MQ'>MQ    </option>";
		$("#feeGrade").html(feeGrade);
	});

	function scrollPage(pos){
		$("html, body").animate({
            scrollTop: $('html, body').get(0).scrollHeight}, pos);				
	 }

   $("#Ssection").click(function(){
		if (section!=" "){return;}
		section=" <option selected value=0>Choose Student Section*</option>";
	    var StudentSection = ['A', 'B', 'C', 'D', 'E' , 'F','G'];
        $.each(StudentSection, function(index, value){
        	section+=" <option value='"+value +"'>"+ value+ "</option>";
        });
        $("#Ssection").html(section);
   });
   $("#Days").click(function(){
		if (days!=" "){return;}
		days=" <option selected value=0>Choose Day*</option>";
	    var cDays = ['SUNDAY', 'MONDAY','TUESDAY','WEDNESSDAY','THURSDAY','FRIDAY','SATURDAY'];
       $.each(cDays, function(index, value){
    	   days+=" <option value='"+value +"'>"+ value+ "</option>";
       });
       $("#Days").html(days);
   });
  
   
	$("#Subject").click(function(){
		if (subjects!=""){	return;	}
		subjects="";
		var request =$.ajax({
			type:'POST',
			data:{Action:"xSRVl"},
		 	dataType: 'Json',
			url:'../../SubjectsInfo',
			success:function(result){
				subjects+=" <option selected value=0>Choose Subject*</option>";
				$.each(result, function(id, name){
					subjects+=" <option value='"+name.Name +"'>"+ name.Name+ "</option>";
				});
				$("#Subject").html(subjects);
			}	
		});	 // eof AJAX
	});
	$("#Gender").click(function(){
		if (gender!=" "){return;}
		gender=" <option selected value=0>Choose Gender*</option>";
		var cGender = ['MALE', 'FEMALE','TRANS'];
	    $.each(cGender, function(index, value){
	    	gender+=" <option value='"+value +"'>"+ value+ "</option>";
	    });
	    $("#Gender").html(gender);
	});
	$("#ActionType").click(function(){
		if (actionType!=" "){return;}
		actionType=" <option selected value=0>Choose Gender*</option>";
		var aType = ['Veiw Faculity Staffs List ', 'Update Faculity Staff Details'];
	    $.each(aType, function(index, value){
	    	actionType+=" <option value='"+index +"'>"+ value+ "</option>";
	    });
	    $("#ActionType").html(actionType);
	});
	
	$("#UserType").click(function(){
		if (uRType!=" "){return;}
		uRType=" <option selected value=0>Choose User Role Type*</option>";
		var cURType = ['Super User', 'Admin User','Site User'];
	    $.each(cURType, function(index, value){
	    	uRType+=" <option value='"+index+1 +"'>"+ value+ "</option>";
	    });
	    $("#UserType").html(uRType);
	});
	
	var vTime = visitTime();
	function visitTime(){
		var vDate = new Date();
		var vInTime = vDate.getHours()+":"+ vDate.getMinutes();
		return 	vInTime;
	}	
	function yearStart(){
		var cdate = new Date();
		return cdate.getFullYear();
	}
	$("#doj").datetimepicker({
		timepicker: false,
		datepicker: true,
		format: 'd-m-yy', // formate date
		value:  false, //defaultTime
		step: 5,	
		yearStart:yearStart(),
		yearEnd:'2030',
		weeks:true	
	});

	$("#dor").datetimepicker({
		timepicker: false,
		datepicker: true,
		format: 'd-m-yy', // formate date
		value:  false, //defaultTime visitTime() ; default date value:  false
		step: 5,	
		yearStart:yearStart(),
		yearEnd:'2030',
		weeks:true	
	});
	$("#dob").datetimepicker({
		timepicker: false,
		datepicker: true,
		format: 'd-m-yy', // formate date
		value:  false, //defaultTime and date
		step: 5,	
		yearStart:yearStart(),
		yearEnd:'2030',
		weeks:true	
	});
	
	$("#fromDate").datetimepicker({
		timepicker: false,
		datepicker: true,
		format: 'd-m-yy', // formate date
		value:  false, //defaultTime and date
		step: 5,	
		yearStart:yearStart(),
		yearEnd:'2030',
		weeks:true	
	});
	$("#toDate").datetimepicker({
		timepicker: false,
		datepicker: true,
		format: 'd-m-yy', // formate date
		value:  false, //defaultTime and date
		step: 5,	
		yearStart:yearStart(),
		yearEnd:'2030',
		weeks:true	
	});
	$("#MfcDate").datetimepicker({
		timepicker: false,
		datepicker: true,
		format: 'd-m-yy', // formate date
		value:  false, //defaultTime and date
		step: 5,	
		yearStart:yearStart(),
		yearEnd:'2030',
		weeks:true	
	});
	$("#ExpiryDate").datetimepicker({
		timepicker: false,
		datepicker: true,
		format: 'd-m-yy', // formate date
		value:  false, //defaultTime and date
		step: 5,	
		yearStart:yearStart(),
		yearEnd:'2030',
		weeks:true	
	});
	/*$("#retnDate").datetimepicker({
		timepicker: false,
		datepicker: true,
		format: 'dd-MM-yyyy', // formate date
		value:  false, //defaultTime and date
		step: 5,	
		yearStart:yearStart(),
		yearEnd:'2030',
		weeks:true	
	});*/
	$("#faculty").click(function(){
		facultyOption!=" "?retrun:facultyList();
	});
	function facultyList(){
		facultyOption="";
		var request =$.ajax({
			type:'POST',
			data:{Action:"xRNLFaculty"},
	 		dataType: 'json',
			url:'../../FacultyInformation',
			success:function(result){
				facultyOption+=" <option value=1>Choose Faculty*</option>";
				$.each(result, function(id, name){
					facultyOption+=" <option value='"+name.Code +"'>"+ name.Name + "</option>";
				});
				$("#faculty").html(facultyOption)
			}	
		});// End Of the $.Ajax()
	}	
   	function scrollPageDown(pos){
		$("html, body").animate({
		    scrollTop: $('html, body').get(0).scrollHeight}, pos);				
	}// eof function -> function for scroll page bottom
	function scrollPageUP(pos){
		$("html, body").animate({
		    scrollTop: $('html, body').get(0).scrollHeight}, pos);	
	       var bottom = $(document).height() - $(window).height();
		$("HTML, BODY").animate({
	            scrollTop: bottom }, 1000);			
	}// eof function -> function for scroll page bottom
   $("#Unit").click(function(){
		if (unit!=" "){return;}
		unit=" <option selected value=0>Choose Unit*</option>";
	    var uUnit = ['KG', 'PKT','NOS','LTR'];
       $.each(uUnit, function(index, value){
    	   unit+=" <option value='"+value +"'>"+ value+ "</option>";
       });
       $("#Unit").html(unit);
   });



});
