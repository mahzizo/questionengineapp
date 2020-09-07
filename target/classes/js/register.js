
function validate() {
	"use strict";
	var result = false;
	var firstName = document.getElementById("fn");
	var lastName = document.getElementById("ln");
	var email = document.getElementById("email");
	var pass = document.getElementById("pass");
	
	// first name
	if(firstName.value.trim() === ""){
		firstName.parentElement.nextElementSibling.style.display = "block";
		result = false;
	}
	// last name
	if(lastName.value.trim() === ""){
		lastName.parentElement.nextElementSibling.style.display = "block";
		result = false;
	}
	// email
	if(email.value.trim() === ""){
		email.parentElement.nextElementSibling.style.display = "block";
		result = false;
	}
	//if(email.value.trim() != "" && !validateEmail(email.value)){
	//	console.log("1");
	//	email.parentElement.nextElementSibling.firstElementChild.nextElementSibling.style.display = "block";
	//	result = false;
	//}
	// password
	if(pass.value.trim() === ""){
		pass.parentElement.nextElementSibling.style.display = "block";
		result = false;
	}
	//if(pass.value.trim() != "" && pass.value.length < 7){
	//	console.log("2");
	//	pass.parentElement.nextElementSibling.firstElementChild.nextElementSibling.style.display = "block";
	//	result = false;
	//}
	if(firstName.value.trim() != "" && lastName.value.trim() != "" && email.value.trim() != "" && pass.value.trim() != "") {
    	result = true;
    }
	return result;
}

function onblurFunction(id){
    "use strict";
    var element = document.getElementById(id);
    if(element.value.trim() === "") {
        element.parentElement.nextElementSibling.style.display = "block";
	}
	// for email and password
	if(element.value.trim() != ""){
		var isValid = validateEmail(element.value);
		if((id === "email" && isValid) || (id === "pass" && element.value.length > 7) || ((id === "fn" || id === "ln") && element.value.length > 1)){
			element.parentElement.nextElementSibling.nextElementSibling.style.display = "none";
		} else {
			element.parentElement.nextElementSibling.nextElementSibling.style.display = "block";
		}
	}
}

function onkeyupFunction(id){
    "use strict";
    var element = document.getElementById(id);
	// for first name & last name
    if(element.value.trim() != "") {
		// for email and password
		if(element.parentElement.nextElementSibling.style.display === "block"){
			element.parentElement.nextElementSibling.style.display = "none";
			element.parentElement.nextElementSibling.nextElementSibling.style.display = "block";
		} else {
			element.parentElement.nextElementSibling.style.display = "none";
		}
    }
	// for email and password
	if(element.value.trim() === "" &&
	   element.parentElement.nextElementSibling.nextElementSibling.style.display === "block"){
		element.parentElement.nextElementSibling.nextElementSibling.style.display = "none";
		element.parentElement.nextElementSibling.style.display = "block";
	}
	if(element.value.trim() != "" &&
	   (element.parentElement.nextElementSibling.nextElementSibling.style.display === "block" ||
		element.parentElement.nextElementSibling.nextElementSibling.style.display === "none")){
		var isValid = validateEmail(element.value);
		if((id === "email" && isValid) || (id === "pass" && element.value.length > 7) || ((id === "fn" || id === "ln") && element.value.length > 1)){
			element.parentElement.nextElementSibling.style.display = "none";
			element.parentElement.nextElementSibling.nextElementSibling.style.display = "none";
		} else {
			element.parentElement.nextElementSibling.style.display = "none";
			element.parentElement.nextElementSibling.nextElementSibling.style.display = "block";
		}
	}
	
}


var tester = /^[-!#$%&'*+\/0-9=?A-Z^_a-z`{|}~](\.?[-!#$%&'*+\/0-9=?A-Z^_a-z`{|}~])*@[a-zA-Z0-9](-*\.?[a-zA-Z0-9])*\.[a-zA-Z](-?[a-zA-Z0-9])+$/;
// Thanks to:
// http://fightingforalostcause.net/misc/2006/compare-email-regex.php
// http://thedailywtf.com/Articles/Validating_Email_Addresses.aspx
// http://stackoverflow.com/questions/201323/what-is-the-best-regular-expression-for-validating-email-addresses/201378#201378
function validateEmail(email) {
  if (!email) return false;

  if (email.length > 256) return false;

  if (!tester.test(email)) return false;

  // Further checking of some things regex can't handle
  var [account, address] = email.split('@');
  if (account.length > 64) return false;

  var domainParts = address.split('.');
  if (domainParts.some(function (part) {
    return part.length > 63;
  })) return false;

  return true;
}




