/**
 * 
 */
const editHostName = document.getElementById("host_name");
const editHostPassword = document.getElementById("host_password");
const editHostLogin = document.getElementById("host_login");
const editHostOutput = document.getElementById("cmd_output");

editHostLogin.addEventListener("click", onClickLogin);

const URLHostAPI = window.location.origin + "/InstantReaction/IRHost";
const URLHostMain = window.location.origin + "/InstantReaction/Host/Host-main.jsp";

function onClickLogin(e) {
	e.preventDefault();
    var password = editHostPassword.value;
    var username = editHostName.value;

    if(username == null || username == "" || password == null || password == "")
	   alert("Please provide the credentials");
	else {
        const encoder = new TextEncoder();
        const data = encoder.encode(password);
        crypto.subtle.digest('SHA-512', data).then(onHashingComplete);
    }
}

function onHashingComplete(hash) {
    var binaryHash = btoa(String.fromCharCode.apply(null, new Uint8Array(hash)));
    var encodedHash = encodeURIComponent(binaryHash);
    var request = new XMLHttpRequest();
    var username = editHostName.value;
    request.open("GET", `${URLHostAPI}?cmd=login&name=${username}&password=${encodedHash}`);
    request.timeout = 2000;
    request.onload = onLoginResponse;
    request.send();
}

function onLoginResponse() {
    var jsonResponse = JSON.parse(this.response);
    if (jsonResponse.Success)
	{
        window.location.href = `${URLHostMain}?name=${editHostName.value}`;
    }
	else 
	{
        alert(jsonResponse.Message);
    }
}
