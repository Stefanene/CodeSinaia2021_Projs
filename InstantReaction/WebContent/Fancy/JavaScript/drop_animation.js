
document.getElementById("drop_button").addEventListener("click", onClickOpen);
document.getElementById("background_effects").addEventListener("click", onClickClose);
document.getElementById("cancel_button").addEventListener("click", onClickClose);

var is_down = false;

function onClickOpen(e) {
	console.log("open click");
	e.preventDefault();
	document.getElementById("drop_frame").style.top = "150px";
	document.getElementById("background_effects").style.backgroundColor = "#00000080";
	document.getElementById("background_effects").style.zIndex = "1";
	is_down = true;
}

function onClickClose(e){
	console.log("close click");
	e.preventDefault();
	document.getElementById("drop_frame").style.top = "-500px";
	document.getElementById("background_effects").style.backgroundColor = "#00000000";
	document.getElementById("background_effects").style.zIndex = "-1";
	is_down = false;
}