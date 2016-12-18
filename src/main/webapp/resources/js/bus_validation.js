$(function() {
  // Initialize form validation on the bus form.
  // It has the name attribute "bus"
  $("form[name='bus']").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      busNo:{
		  required: true,
		  customvalidation: true
	  }      
    },
    // Specify validation error messages
    messages: {
      busNo: {
		  required: "Please enter Bus No",
		  customvalidation: "Please enter valid value only"
	  } 
    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });
  $.validator.addMethod("customvalidation", function(value, element) {
        return this.optional(element) || /^[a-zA-Z0-9]+$/.test(value);
    }, "busNo must contain only letters, numbers.");
});