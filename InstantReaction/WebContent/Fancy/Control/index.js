/**
 * JavaScript code for InstantReaction/ControlPanel
 */
 
 /*
  * Variables for the Control UI elements
  */
 const txtCmdOutput = document.getElementById("cmd_output");
 
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
    txtCmdOutput.innerHTML = this.response;
}
