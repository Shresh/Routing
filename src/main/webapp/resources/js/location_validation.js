$(function() {
  // Initialize form validation on the location form.
  // It has the name attribute "location"
  $("form[name='location']").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      location: {
		  required: true,
		  customvalidation: true
	  }      
    },
    // Specify validation error messages
    messages: {
      location: {
		  required: "Please enter Location",
		  customvalidation: "Please enter alphabets only"
	  }
    },
	
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });
  $.validator.addMethod("customvalidation", function(value, element) {
        return this.optional(element) || /^[a-zA-Z]+$/i.test(value);
    }, "location must contain only letters.");
});