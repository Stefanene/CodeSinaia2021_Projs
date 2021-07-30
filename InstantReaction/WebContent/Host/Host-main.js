/**
 * Variables for the Host main page parameters
 */
const username = (new URLSearchParams(window.location.search)).get("name");

/**
 * Variables for the Host main UI elements
 */
const textTitleName = document.getElementById("titleName");
const buttonHostLogout = document.getElementById("hostLogout");
const txtCmdOutput = document.getElementById("cmd_output");



/**
 * Hook code listeners to actions and events in the Host main flow
 */
document.addEventListener("DOMContentLoaded", onPageLoad);
//window.addEventListener("beforeunload", onPageClosing);
buttonHostLogout.addEventListener("click", onClickLogout);

/**
 * Static resources needed in the Host main code
 */
const URLHostAPI = window.location.origin + "/InstantReaction/IRHost";

/**
 * Callback for the initial loading of the Host main page.
 */

function onPageLoad() {
	textTitleName.innerHTML = username;
    var request = new XMLHttpRequest();
    request.open("GET", `${URLHostAPI}?cmd=status`);
    request.timeout = 2000;
    request.onload = onStatusResponse;
    request.send();
}

function onStatusResponse() {
    var jsonResponse = JSON.parse(this.response);
    if (jsonResponse.Success) {
        txtCmdOutput.innerHTML = jsonResponse.Message;
    } else {
        alert(jsonResponse.Message);
    }
}

function onClickLogout() {
	var request = new XMLHttpRequest();
	request.open("GET", `${URLHostAPI}?cmd=logout&name=${username}`);
    request.timeout = 2000;
    request.onload = onLogoutResponse;
	request.send();
			
}

function onLogoutResponse() {
    var jsonResponse = JSON.parse(this.response);
    if (jsonResponse.Success)
	{
       window.history.back();
	}
	else 
	{
		alert(jsonResponse.Message);
	}
}

function onPageClosing(e)
{
	e.preventDefault();
    e.returnValue = '';
	alert("Leaving site?");
}

