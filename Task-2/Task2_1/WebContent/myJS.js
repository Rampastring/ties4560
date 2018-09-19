window.onload = customize;

function customize() {
	window.document.getElementById('div3').style.display = 'none';
}

function generateName() {
	var e = document.getElementById("dropdown");
	var strGender = e.options[e.selectedIndex].text;
	var q_str = 'gender=' + strGender;
	
	if (strGender != null && strGender !== undefined)
		doAjax('NameGeneratorServlet', q_str, 'getName_back', 'post', 0);
}

function getName_back(resultName) {
	if (resultName === null || resultName === undefined || !resultName) {
		window.document.getElementById('div3').style.display = 'block';
		window.document.getElementById('div3').innerHTML = "<p style='color:red;'><b>"
				+ " The generated name is null or undefined" + "</b></p>";
	} else {
		window.document.getElementById('name').innerHTML = resultName;
	}
}
