<%@page import="com.raoSystem.constants.Information"%>
<%@page import="com.rao.System.MaintWork.MaintConstant"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		 	<meta charset="ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href="../../css/Custom.css" type="text/css">
			<link rel="stylesheet" href='../../webjars/jquery-ui/1.12.1/jquery-ui.css'>
		 	<link rel="stylesheet" 	href='../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.css'>
		 	<link rel="stylesheet" 	href='../../webjars/bootstrap-datetimepicker/2.4.4/css/bootstrap-datetimepicker.min.css'>

			<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

			<script type="text/javascript" 	src="../../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
			<script type="text/javascript" 	src="../../webjars/bootstrap-datetimepicker/2.4.4/js/bootstrap-datetimepicker.min.js"></script>
			<script type="text/javascript" 	src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
		
		 	<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.js"></script>
			<script type="text/javascript"	src="../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script>
		
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		  	<script type="text/javascript" src="../../js/CommonFunc.js"></script>

			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script>
			<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>
		  	<script type="text/javascript" src="../../js/SMCF.js"></script>			
			<style type="text/css">
				//-- Colours --------------------------
				$gray:  #E5E5E5;
				$gray2: #808080;
				$blue:  #2183DD;
				$green: #009900;
				$white: #FFFFFF;
				
				//-- Setup ----------------------------
				body {
				  font-family: Arial;
				  text-transform: capitalize;
				}
				
				//-- Progress Bar ---------------------
				.progress {
				  position: absolute;
				  top: 15vh;
				  width: 0%;
				  height: 10px;
				  background-color: $blue;
				  transition: width .2s;
				  
				  @for $i from 1 through 5 {
				    &.progress--#{$i} {
				      width: calc(#{$i * 20}%);
				    }
				  }
				  
				  &.progress--complete {
				    width: 100vw;
				  }
				}
				
				//-- Background Track --
				.progress__bg {
				  position: absolute;
				  width: 100vw;
				  height: 10px;
				  background-color: $gray;
				  z-index: -1;
				}
				
				//-- Steps --
				.progress__step {
				  position: absolute;
				  top: -8px;
				  left: 0;
				  display: flex;
				  flex-direction: column;
				  align-items: center;
				  text-align: center;
				  
				  @for $i from 1 through 5 {
				    &.progress__step--#{$i} {
				      left: calc(#{$i * 20}vw - 9px);
				    }
				  }
				  
				  &.progress__step--active {
				    color: $blue;
				    font-weight: 600;
				  }
				  
				  &.progress__step--complete {
				    .progress__indicator {
				      background-color: $green;
				      border-color: $blue;
				      color: $white;
				      display: flex;
				      align-items: center;
				      justify-content: center;
				    }
				    
				    .progress__indicator .fa {
				        display: block;
				    }
				
				    .progress__label {
				      font-weight: 600;
				      color: $green;
				    }
				
				  }
				}
				
				//-- Indicators --
				.progress__indicator {
				  width: 25px;
				  height: 25px;
				  border: 2px solid $gray2;
				  border-radius: 50%;
				  background-color: $white;
				  margin-bottom: 10px;
				  
				  .fa {
				    display: none;
				    font-size: 16px;
				    color: $white;
				  }
				}
				
				//-- Labels --
				.progress__label {
				  position: absolute;
				  top: 40px;
				}
				
				//-- Controls --
				.progress__actions {
				  position: absolute;
				  top: 75px;
				  left: 10px;
				  display: flex;
				  align-items: center;
				  width: max-content;
				}
				
				//-- Buttons --
				.btn {
				  width: fit-content;
				  padding: 5px 8px;
				  background-color: $white;
				  border: 1px solid $gray2;
				  border-radius: 5px;
				  cursor: pointer;
				  user-select: none;
				  
				  &:nth-child(2) {
				    margin: 0 10px;
				  }
				}
			
			</style>
	</head>
	<body >
	
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="SPInfo" name="SPInfo" action="../../StudentInfoPersonal?Action=student" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=MaintConstant.New%> <%=MaintConstant.User%> <%=MaintConstant.Login%> <%=MaintConstant.Info%></a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />


<div id="app" :class="progressClasses">
	<div class="progress__bg"></div>
		<template v-for="(step, index) in steps">
	    	<div :class="stepClasses(index)">
	 	    	<div class="progress__indicator">
	        		<i class="fa fa-check"></i>
	      		</div>
	      		<div class="progress__label">
	        		{{step.label}}
	      		</div>
	    	</div>
	  	</template>
  
	  	<div class="progress__actions">
			<div  class="btn"  v-on:click="nextStep(false)" > Back	</div>
			<div  class="btn" v-on:click="nextStep" >Next 	</div>
	    	<div>Step: {{currentStep ? currentStep.label : "Start"}}	</div>
		</div>
		
</div>


				
				
				<div class="bg-light text-dark">	
					<div class="row">		
						<br />
						<div class="col-sm-3 offset-sm-3 ">
							<button type="submit" id ="subRwa01" name="subRwa01" class="form-control  text-light 
							text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=MaintConstant.Reset%></button>
						</div>
						<div class="col-sm-3 offset-sm-0 ">
							<button type="submit" id ="subRwa01" name="subRwa01" class="form-control  text-light 
							text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=MaintConstant.Submit %></button>
						</div>
					</div>
				</div>	
				<br />
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
		$(document).ready(function(){
			var app = new Vue({
				  el: '#app',
				  data: {
				    currentStep: null,
				    steps: [
				      {"label": "one"},
				      {"label": "two"},
				      {"label": "three"},
				      {"label": "complete"}
				    ]
				  },
				  methods: {
				    nextStep(next=true) {
				      const steps = this.steps
				      const currentStep = this.currentStep
				      const currentIndex = steps.indexOf(currentStep)
				      
				      // handle back
				      if (!next) {
				        if (currentStep && currentStep.label === 'complete') {
				          return this.currentStep = steps[steps.length - 1]           
				        }

				        if (steps[currentIndex - 1]) {
				          return this.currentStep = steps[currentIndex - 1] 
				        }

				        return this.currentStep = { "label": "start" }   
				      }
				      
				      // handle next
				      if (this.currentStep && this.currentStep.label === 'complete') {
				        return this.currentStep = { "label": "start" }
				      }
				      
				      if (steps[currentIndex + 1]) {
				        return this.currentStep = steps[currentIndex + 1]
				      }

				      this.currentStep = { "label": "complete" }   
				    },
				    stepClasses(index) {
				      let result = `progress__step progress__step--${index + 1} `
				      if (this.currentStep && this.currentStep.label === 'complete' ||
				          index < this.steps.indexOf(this.currentStep)) {
				        return result += 'progress__step--complete'
				      }
				      if (index === this.steps.indexOf(this.currentStep)) {
				        return result += 'progress__step--active'
				      }
				      return result
				    }
				  },
				  computed: {
				     progressClasses() {
				      let result = 'progress '
				      if (this.currentStep && this.currentStep.label === 'complete') {
				        return result += 'progress--complete'
				      }
				      return result += `progress--${this.steps.indexOf(this.currentStep) + 1}`
				    }
				  }
				})
		});
	</script>
</html>