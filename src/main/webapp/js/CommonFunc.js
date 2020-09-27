/** knrai
 *  coommon function used for all JSP PAGE.
 */
var countryOptions=" ";
$(document).ready(function(){
	alert('wahwah');
	$("#country").click(function(){
		if (countryOptions!=" "){
			retrun;
		}
		countryList();
	});
	function countryList(){
		aler('wah');
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
});
