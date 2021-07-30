/**
 * 
 */

const editGuestName = document.getElementById("guest_name");
const editGuestLogin = document.getElementById("guest_login");
const editGuestOutput = document.getElementById("cmd_output");

editGuestLogin.addEventListener("click", onClickLogin);

const URLGuestAPI = window.location.origin + "/InstantReaction/IRGuest";
const URLGuestMain = window.location.origin + "/InstantReaction/Guest/Guest-main.jsp";


 function onClickLogin(e) {
	e.preventDefault();
	var username = editGuestName.value;
	if(username == null || username == "")
		alert("Please provide the guest name");
	else
		{
			var request = new XMLHttpRequest();
			request.open("GET", `${URLGuestAPI}?cmd=login&name=${username}`);
    		request.timeout = 2000;
    		request.onload = onLoginResponse;
    		request.send();
		}
}

function onLoginResponse() {
    if (this.response.includes("IRGuest_TODO")) 
    {
       window.location.href = `${URLGuestMain}?name=${editGuestName.value}`;
    }
    else 
    {
        alert(this.response);
    }
}
