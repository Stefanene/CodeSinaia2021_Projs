/**
 * Variables for the Guest main page parameters
 */
const username = (new URLSearchParams(window.location.search)).get("name");

/**
 * Variables for the Guest Main UI elements
 */
const textTitleName = document.getElementById("titleName");
const buttonGuestLogout = document.getElementById("guestLogout");

/**
 * Hook code listeners to actions and events in the Guest main flow
 */
document.addEventListener("DOMContentLoaded", onPageLoad);

/**
 * Static resources needed in the Guest Main code
 */
const URLGuestAPI = window.location.origin + "/InstantReaction/IRGuest";

buttonGuestLogout.addEventListener("click", onClickLogout);

function onClickLogout(e){
	e.preventDefault();
	var request = new XMLHttpRequest();
	request.open("GET", `${URLGuestAPI}?cmd=logout&name=${username}`);
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

/**
 * Callback for the initial loading of the Guest main page.
 */
function onPageLoad() {
    textTitleName.innerHTML = username;
}
