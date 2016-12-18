$(function() {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("form[name='registration']").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      firstName:{
    	  required: true,
    	  customvalidation: true
      },
      lastName:{
    	  required: true,
    	  customvalidation: true
      },
	  contactNo: {
		  required: true,
		  digits: true
	  },
	  dateOfBirth: {
		  required: true,
		  date: true
	  },
      email: {
        required: true,
        email: true
      },
	  username:{
		  required: true
	  },
      password: {
        required: true,
        minlength: 5
      },
      cpassword: {
		  required: true,
		  equalTo: "#password"
	  }
    },
    // Specify validation error messages
    messages: {
      firstName:{
    	  required:  "Please enter your First Name",
    	  customvalidation: "Enter alphabets only"
      },
      lastName:{
    	  required: "Please enter your Last Name",
    	  customvalidation:	"Enter alphabets only"  
      },
	  contactNo: {
		  required: "Please enter your Contact Number",
		  digits: "Please enter numeric value only"
	  },
	  dateOfBirth: {
		  required: "Please enter your Date of Birth",
		  date: "Enter valid Date of Birth"
	  },
      email:{
    	  required: "Please enter your Email",
    	  email:  "Please enter a valid Email"
      },
	  username:{
		  required: "Please enter your Username"
	  },
	  password: {
        required: "Please provide a Password",
        minlength: "Your password must be at least 5 characters long"
      },
	  cpassword: {
		  required: "Please confirm your Password",
		  equalTo: "Your Password does not match"
	  }
    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });
  $.validator.addMethod("customvalidation", function(value, element) {
      return this.optional(element) || /^[a-zA-Z]+$/.test(value);
  }, "Must contain only letters.");
});