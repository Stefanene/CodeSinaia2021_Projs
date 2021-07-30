/**
 * JavaScript code for InstantReaction/ControlPanel
 */
 
 /*
  * Variables for the Control UI elements
  */
 const txtCmdOutput = document.getElementById("cmd_output");
 const tblServerStatus = document.getElementById("statusTable").getElementsByTagName('tbody')[0];
 
 /**
  * Hook code listeners to actions and events in the Control page
  */
 document.addEventListener("DOMContentLoaded", onPageLoad);
 
 /**
  * Static resources needed in the Control page code
  */
 const urlControlAPI = window.location.origin + "/InstantReaction/IRControl";

 /**
  * Code handler for page load event
  */
 function onPageLoad() {
    var request = new XMLHttpRequest();
    request.open("GET", `${urlControlAPI}?cmd=status`);
    request.timeout = 2000;
    request.onload = onStatusResponse;
    request.send();
}

function onStatusResponse() {
    var jsonResponse = JSON.parse(this.response);
    if (jsonResponse.Success) {
        // print out the summary message
        txtCmdOutput.innerHTML = jsonResponse.Message;
        // empty the table and repopulate it with the current server status
        tblServerStatus.innerHTML = '';
        for (i = 0; i < jsonResponse.Members.length; i++) {
            var newRow = tblServerStatus.insertRow();
            // chose the row styling based on the role of this member
            newRow.className = (jsonResponse.Members[i].Role == 'Host') ? 'status-host-tr': 'status-guest-tr';
            newRow.insertCell().innerHTML = jsonResponse.Members[i].Role;
            newRow.insertCell().innerHTML = jsonResponse.Members[i].IPAddress;
            newRow.insertCell().innerHTML = jsonResponse.Members[i].Name;
        }
    } else {
        alert(jsonResponse.Message);
    }
}
