$(function() {
  // Initialize form validation on the setRoute form.
  // It has the name attribute "setRoute"
  $("form[name='setRoute']").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
	  date: {
		  required: true,
		  date: true
	  },
	  time: {
		required: true,
		customvalidation: true
	  },
      price: {
        required: true,
        digits: true
      }
    },
    // Specify validation error messages
    messages: {
	  date: {
		  required: "Please enter Date",
		  date: "Enter valid Date"
	  },
	  time:{
		  required: "Please enter time",
		  customvalidation: "Enter valid Time"
	  },
	  price: {
        required: "Please enter Price",
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
      return this.optional(element) || /^(0?[1-9]|1[012])(:[0-5]\d) [APap][mM]$/.test(value);
  }, "Time.");
});