$(function() {
  // Initialize form validation on the driver form.
  // It has the name attribute "driver"
  $("form[name='driver']").validate({
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
	  dateOfBirth: {
		  required: true,
		  date: true
	  },
      salary: {
        required: true,
        digits: true
      }
    },
    // Specify validation error messages
    messages: {
      firstName:{
		  required: "Please enter First Name",
		  customvalidation: "Please enter alphabets only"
	  },
      lastName:{
		  required: "Please enter Last Name",
		  customvalidation: "Please enter alphabets only"
	  },
	  dateOfBirth: {
		  required: "Please enter Date of Birth",
		  date: "Enter valid Date of Birth"
	  },
	  salary: {
        required: "Please enter Salary",
        digits: "Please enter numeric values only"
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