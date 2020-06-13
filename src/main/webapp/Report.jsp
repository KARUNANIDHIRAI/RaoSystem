<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	   	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	   	<link rel="stylesheet" type="text/css" href="styLes/Custom.css" >

 	   	<link rel="stylesheet"  type="text/css" href="webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
   		<script type="text/javascript" src="webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
<!-- 
		<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/tabletools/2.2.4/css/dataTables.tableTools.min.css" >	
 -->
 			                           <script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
	                            		<script src="//cdn.datatables.net/buttons/1.6.0/js/dataTables.buttons.min.js"></script>

<!-- 		<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/buttons/1.6.0/css/buttons.dataTables.min.css" >  -->
 
 
 
<script  src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/1.6.0/js/buttons.html5.min.js"></script>
 
 
 
 
 
 
		<style type="text/css">
			body{
			position:relativ;}
		    .panel-body{padding-top:5px;
		                padding-bottom:5px;}
		   div.dataTables_wrapper {
        		width: 800px;
        		margin: 0 auto;
    		}             
			td.highlight {
			    background-color: whitesmoke !important;
			}
		</style>
	</head>

	<body data-spy="scroll" data-target="#main" data-offset="50" >
		<div class ="container">
		   	<form id="login" name="login" action="getLoginChecking" method="post" class="form-horizontal" autocomplete="off">
				<div class="row" > 
					<div class="col-xs-2" style=" padding-left: 0px; padding-right: 0px;">
						<div class="customDivHeader" style="background:linear-gradient(to right, #00008B, #6ebce2); color:white"> 
							<img src="#" class="img-responsive"/>
			 				<div class="">
			 					<h5 align="center">  logo </h5>
			 				</div>	
						</div>
					</div>
	                <div class="col-xs-8" style=" padding-left: 0px; padding-right: 0px; "> 
						<div class="customDivHeader" style="background:linear-gradient(to right, #00008B, #6ebce2); color:white"> 
							<img src="#" class="img-responsive"/>
			 				<div class="">
			 					<h3 align="center"> KBS  </h3>
			 				</div>	
						</div>
					</div>
					<div class="col-xs-2" style=" padding-left: 0px; padding-right: 0px;"> 
						<div class="customDivHeader" style="background:linear-gradient(to right, #00008B, #6ebce2); color:white"> 
<!-- 						<div class="customDivHeader" style="background:linear-gradient(to right, #3a7fd5, #6ebce2); color:white">  -->
							<div align="center">
								<span class ="glyphicon glyphicon-user" style="color:white; align:left"></span>
			 					<h5 > LOGO </h5>
							</div>
						</div>
	 				</div>
	 			</div>
				<div class="panel-group " >
					<div class="row" style="padding-top: 0px;" >
					    <div class="col-xs-4"  >
					    	<div class="panel panel-basic" >
					    		<div class="panel-heading" >
					    			<h3 class="panel-title">KBS INFOSYS</h3>
					    		</div>
					    		<div class="panel-body " >
					    			<p >Every one wants to meet or contact cTech Solution with N number of reasons.
					    		 	And so, to fulfill the aspiration of the people and to generate direct contact with the public, the ctech Solution's Office has started several online and offline services. Let us find out the ways to communicate with the <a href="contactUs.jsp"> cTech solution's CEO KN RAI and cTech Office.</a>  </p>   
		
		
					    		</div>
		  		    		</div>  
					    </div>
					    <div class="col-xs-8" style=" padding-left: 0px;" >
							<div class="row"> 
								<div class="col-sx-8">
								 	<div class= "panel-group " id="accordion" style="padding-left:15px; padding-right: 15px;"> 
								 		<div class="panel panel-primary"  >
								 			<div class ="panel-heading" align="center">
								    			<h3 class="panel-title" >REGISTER</h3>
												<ul class="nav nav-pills" style="background-color:#fff" >
													<li role="presentation" ><a href="#btnExpandAll" data-toggle="collapse"  data-parent="#accordion" >
													  	<span class ="glyphicon glyphicon-plus-sign"> </span>
													  	USERMIS</a>
													</li>
				 									<li>
			 											<button	type="button"  class="btn btn-primary" id="Reset">
															<span class ="glyphicon glyphicon-refresh" data-toggle="tooltip" data-placement="bottom" title="click to " > </span>
				 					 				    </button>
				 					 				</li>
				 					 				<li role="presentation"><a href="homePage.jsp"> 
														<span class ="glyphicon glyphicon-home" data-toggle="tooltip" data-placement="bottom" title="click to go Home Page" > </span></a>
     												</li>
												</ul>
			                                 </div> 
								 		</div>
									</div>		
								</div>
							</div>	
							<div id="btnExpandAll" class="panel-collapse collapse" id="main" >		 			
					    		<div class="panel-body "  >

                               	<table id="datatable" class="hover display " style="width:100%"> 
                                      	<thead style="background-color:#0085be; color:#fff" >
  
                                    		<tr> 
	                                    		<th>User ID   </th>
	                                    		<th>FName     </th>
	                                    		<th>LName     </th>
	                                    		<th>Mobile No </th>
	                                    		<th>Email ID  </th>
	                                    		<th>Aadhar No </th>
                                    		</tr>
                                    	</thead>
                                    	<tbody>

                                    		<tr>
                                    			<td>101       </td>
	                                    		<td>Raman     </td>
	                                    		<td>Yadav     </td>
	                                    		<td>9811557160 </td>
	                                    		<td>karunanidhirai@yahoo.com  </td>
	                                    		<td>1024120501260</td>
	                                   	    </tr>
                                    		<tr>
                                    			<td>102        </td>
	                                    		<td>Raman1     </td>
	                                    		<td>Yadav2     </td>
	                                    		<td>9811557160 </td>
	                                    		<td>karunanidhiraig@gmail.com  </td>
	                                    		<td>1024120501260</td>
	                                   	    </tr>

                                    		<tr>
                                    			<td>104       </td>
	                                    		<td>Raman     </td>
	                                    		<td>Yadav     </td>
	                                    		<td>9811557160 </td>
	                                    		<td>karunanidhirai@yahoo.com  </td>
	                                    		<td>1024120501260</td>
	                                   	    </tr>
                                    		<tr>
                                    			<td>106       </td>
	                                    		<td>Raman1     </td>
	                                    		<td>Yadav2     </td>
	                                    		<td>9811557160 </td>
	                                    		<td>karunanidhiraig@gmail.com  </td>
	                                    		<td>1024120501260</td>
	                                   	    </tr>
                                    		<tr>
                                    			<td>101       </td>
	                                    		<td>Raman     </td>
	                                    		<td>Yadav     </td>
	                                    		<td>9811557160 </td>
	                                    		<td>karunanidhirai@yahoo.com  </td>
	                                    		<td>1024120501260</td>
	                                   	    </tr>
                                    		<tr>
                                    			<td>102        </td>
	                                    		<td>Raman1     </td>
	                                    		<td>Yadav2     </td>
	                                    		<td>9811557160 </td>
	                                    		<td>karunanidhiraig@gmail.com  </td>
	                                    		<td>1024120501260</td>
	                                   	    </tr>

                                    		<tr>
                                    			<td>104       </td>
	                                    		<td>Raman     </td>
	                                    		<td>Yadav     </td>
	                                    		<td>9811557160 </td>
	                                    		<td>karunanidhirai@yahoo.com  </td>
	                                    		<td>1024120501260</td>
	                                   	    </tr>
                                    		<tr>
                                    			<td>106       </td>
	                                    		<td>Raman1     </td>
	                                    		<td>Yadav2     </td>
	                                    		<td>9811557160 </td>
	                                    		<td>karunanidhiraig@gmail.com  </td>
	                                    		<td>1024120501260</td>
	                                   	    </tr>
                                    		<tr>
                                    			<td>101       </td>
	                                    		<td>Raman     </td>
	                                    		<td>Yadav     </td>
	                                    		<td>9811557160 </td>
	                                    		<td>karunanidhirai@yahoo.com  </td>
	                                    		<td>1024120501260</td>
	                                   	    </tr>
                                    		<tr>
                                    			<td>102        </td>
	                                    		<td>Raman1     </td>
	                                    		<td>Yadav2     </td>
	                                    		<td>9811557160 </td>
	                                    		<td>karunanidhiraig@gmail.com  </td>
	                                    		<td>1024120501260</td>
	                                   	    </tr>

                                    		<tr>
                                    			<td>104       </td>
	                                    		<td>Raman     </td>
	                                    		<td>Yadav     </td>
	                                    		<td>9811557160 </td>
	                                    		<td>karunanidhirai@yahoo.com  </td>
	                                    		<td>1024120501260</td>
	                                   	    </tr>
                                    		<tr>
                                    			<td>106       </td>
	                                    		<td>Raman1     </td>
	                                    		<td>Yadav2     </td>
	                                    		<td>9811557160 </td>
	                                    		<td>karunanidhiraig@gmail.com  </td>
	                                    		<td>1024120501260</td>
	                                   	    </tr>

                                    	</tbody>
                                    </table>

								</div>
							</div>			
	 			    	</div> 
				    </div>
				</div>
				<div class="row" > 
					<div class="col-md-12" > 
						<div class="customDivFooter" align="center"  style="background:linear-gradient(to right, #00008B,#0000ff); color:white"> 
							<p class="h4"></p>
							<p class="h5"></a> </p>
							<p class="h5"></p>
						</div>
					</div>
				</div>
			</form>
		</div>
		<!-- style="background-color:#0085be; color:#fff" -->
		
	<script type="text/javascript">
		$(document).ready(function() {
		
			$('[data-toggle="tooltip"]').tooltip();
			
			$('.collapse').on('shown.bs.collapse', function() {
			   	$(this).parent().find('.glyphicon-plus-sign').removeClass('glyphicon-plus-sign').addClass('glyphicon-minus-sign');
			});
			$('.collapse').on('hidden.bs.collapse', function() {
			   	$(this).parent().find('.glyphicon-minus-sign').removeClass('glyphicon-minus-sign').addClass('glyphicon-plus-sign');
			});
			
			$('#btnExpandAll').click(function(){
				$('.panel-collapse.collapse').collapse('show');	
			});
			$('#btnCollapseAll').click(function(){
				$('.panel-collapse.collapse').collapse('hide');	
			});
	
			     
 			var table = $('#datatable').dataTable({
 		        dom: 'Bfrtip',
 		        buttons: ['copyHtml5', 'excelHtml5','csvHtml5','pdfHtml5'],
		        "scrollY": 200,
		        "scrollX": true,
		        "scrollCollapse": true,
		        "pageLength": 5
			
 			});
 			$(tableTools.fnContainer()).insertBefore('#datatable_wrapper'); 

		});
     </script>
 		
		
		
	</body>
</html>

 


