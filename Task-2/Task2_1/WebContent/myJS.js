window.onload = customize;

function customize() {
	window.document.getElementById('div3').style.display = 'none';
}

function generateName() {
	var q_str = 'name=' + document.getElementById('nameId').value;
	var e = document.getElementById("dropdown");
	var strGender = e.options[e.selectedIndex].text;
	
	if (strGender != null && strGender !== undefined)
		doAjax('NameGeneratorServlet', q_str, 'getName_back', 'post', 0);
}

function getName_back(resultName) {
	if (resultName === null || resultName === undefined || !resultName) {
		window.document.getElementById('div3').style.display = 'block';
		window.document.getElementById('div3').innerHTML = "<p style='color:red;'><b>"
				+ " name is null or undefined" + "</b></p>";
	} else {
		window.document.getElementById('name').innerHTML = resultName;
	}
}
