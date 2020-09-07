//document.getElementById("img").getAttribute("src")

var sessionValue= $("#hdnSession").data('value');

function loadImage() {
	"use strict";
//	document.getElementById("img").style.backgroundImage = "url("
//			+ document.getElementById("photo").getAttribute("src") + ")";
	
	document.getElementById("img").style.backgroundImage = "url(" + sessionValue + ")";
}

function previewFile() {
	const preview = document.getElementById('img');
	const file = document.querySelector('input[type=file]').files[0];
	const reader = new FileReader();

	reader.addEventListener("load", function() {
		// convert image file to base64 string
		// preview.src = reader.result;
		preview.style.backgroundImage = "url(" + reader.result + ")";
	}, false);

	if (file) {
		reader.readAsDataURL(file);
	}
}