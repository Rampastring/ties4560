function create_access_token()
{
	doAjax('myservlet',"action=create_token",'access_token_created','get',0);
}

function get_access_token()
{	
	var url = window.location.href
	
	var token = "access token not generated!"
	
	if(url.indexOf('access_token') != -1)
		token = url.substring(url.indexOf('access_token')+13, url.indexOf('&token_type'));
	
	var element = window.document.getElementById('created_token')
	var p = document.createElement("p")
	var text = document.createTextNode(token);
	p.appendChild(text);
	element.appendChild(p);
	
	document.getElementById("getTokenButton").disabled = true;
}

function upload_file()
{
	var token = document.getElementById('created_token').textContent;
	
	var filepath = encodeURI(document.getElementById('file_path').value);
	
	if(token.length == 0)
	{
		console.log("token not fetched!")
		return;
	}
	
	doAjax('myservlet',"action=upload_file&access_token=" + token + "&file_path=" + filepath,'file_uploaded','get',0);
}

function access_token_created(result)
{
	window.location.href = result;
}

function file_uploaded(result)
{
	var response = JSON.parse(result);
	var element = window.document.getElementById('uploaded_file_info')
	var p = document.createElement("p")
	var text = document.createTextNode(result);
	p.appendChild(text);
	element.appendChild(p);
	
}

function show_user_info()
{
	var token = document.getElementById('created_token').textContent;
	
	if(token.length == 0)
	{
		console.log("token not fetched!")
		return;
	}
	
	doAjax('myservlet',"action=get_user_info&access_token=" + token,'user_info_received','get',0);
}

function create_new_folder()
{
	var token = document.getElementById('created_token').textContent;
	
	if(token.length == 0)
	{
		console.log("token not fetched!")
		return;
	}
		
	
	var folderpath = encodeURI(document.getElementById('folder_path').value);
	
	doAjax('myservlet',"action=create_new_folder&access_token=" + token + "&folder_path=" + folderpath, 'folder_created','get',0);
}

function folder_created(result)
{
	var element = window.document.getElementById('folder_info')
	var p = document.createElement("p")
	var text = document.createTextNode(result);
	p.appendChild(text);
	element.appendChild(p);
}

function user_info_received(result)
{
	var element = window.document.getElementById('user_info')
	var p = document.createElement("p")
	var text = document.createTextNode(result);
	p.appendChild(text);
	element.appendChild(p);
}
