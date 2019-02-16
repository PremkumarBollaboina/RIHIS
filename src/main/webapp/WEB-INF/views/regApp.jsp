<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.his.util.AppConstants" %>
 <jsp:include page="header.jsp"></jsp:include>
 <jsp:include page="adminNav.jsp"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>|userReg|</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
 
<script>
	$(function() {
		
		$('form[id="userRegForm"]').validate({
			rules : {
				firstName : 'required',
				lastName : 'required',
				email : {
					required : true,
					email : true,
				},
				
				ssn1 : {
					required : true,
					minlength : 3,
					maxlength : 3,
			
				},
			
				ssn2 : {
					required : true,
					minlength : 3,
					maxlength : 3,
				},
				ssn3 : {
					required : true,
					minlength : 3,
					maxlength : 3,
				},
				dob:'required',
				role:'required',
				phno:'required'
			},
			messages : {
				firstName : 'Please enter first name',
				lastName : 'please enter last name',
				email : 'Please enter a valid email',
				
				ssn1: {
					required :'Please enter ssn',
					minlength : 'Please enter 3 digits',
					maxlength : 'Please enter 3 digits',
				},
				ssn2: {
					required :'Please enter ssn',
					minlength : 'Please enter 3 digits',
						maxlength : 'Please enter 3 digits',
				},
				ssn3: {
					required :'Please enter ssn',
					minlength : 'Please enter 3 digits',
						maxlength : 'Please enter 3 digits',
				},
				dob:'Please select dob',
				role:'Please select a role',
				phno:'Please enter Phno'
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
		

		$("#email").blur(function() {
			var enteredEmail = $("#email").val();
			$.ajax({
				url : window.location + "/checkEmail",
				data : "email=" + enteredEmail,
				success : function(result) {

					if (result == 'DUPLICATE') {
						$("#emailMsg").html("Email already registered.!!");
						$("#email").focus();
					} else {
						$("#emailMsg").html("");
					}

				}
			});

		});

		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : 'dd/mm/yy',
			maxDate : new Date()
		});
	});
</script>
</head>
<body>
<div class="container my_course_red">
<form:form action="regApp" method="post" name="regUserForm"  id="userRegForm" modelAttribute="regApp" style="max-width:700px;margin:auto">
<h3 class="text-center" style="color:#ff0000;border-radius: 5px; background-color: #00ffbf">User Informations</h3>
 <div class="text-center" style="color:green">${SUCCESS}</div>
<div class="text-class" style="color:red">${ERROR}</div>
 <br/>
<div class="input-container">
 <i class="fa fa-user icon"></i>
 <form:input path="firstName"  class="input-login" placeholder="First Name"/>
 </div>
  
  <div class="input-container">
 <i class="fa fa-user icon"></i>
 <form:input  class="input-login" path="lastName" placeholder="Last Name"/>
 </div>
 
 <div class="input-container">
  <i class="fa fa-user icon"></i>
  <form:input  class="input-login" path="surName" placeholder="Sur Name(otional)" id="surname"/>
  <span style="color:red" id="emailMsg"></span>
  </div>
  
  <div class="input-container">
  <i class="fa fa-envelope icon"></i>
  <form:input  class="input-login" path="email" placeholder="Email" id="email"/>
  <span style="color:red" id="emailMsg"></span>
  </div>
  
  
  <div class="input-container">
  <i class="fa fa-phone icon"></i>
  <form:input  class="input-login" path="phno" placeholder="Phone Number"/>
 </div>
 
  <div class="input-container">
  <i class="fa fa-calculator icon"></i>
  <form:input  class="input-ssn1" path="ssn1" placeholder="SSN-3"/>&nbsp;
 <form:input  class="input-ssn1" path="ssn2" placeholder="SSN-3"/>&nbsp;
  <form:input  class="input-ssn1" path="ssn3" placeholder="SSN-3"/>
 </div>
 
  <div class="input-container">
  <i class="fa fa-calendar icon"></i>
  <form:input  class="input-login" path="dob" id="datepicker" placeholder="DOB" readonly="true"/>
 </div>
  
<input type="submit"  id="userSaveBtn" value="Register" class="btn2" onclick="validation(this);" />
<input type="reset" class="btn2"/><br/>

</form:form>

</div>
</body>
 <jsp:include page="footer.jsp"></jsp:include> 
</html>