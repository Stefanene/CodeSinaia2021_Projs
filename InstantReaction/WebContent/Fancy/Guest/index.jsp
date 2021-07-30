<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <link rel="stylesheet" href="../index.css">
        <script defer src="index.js"></script>
        <script defer src="../JavaScript/drop_animation.js"></script>
        <link rel="icon" href="../Images/FaviconLogo.ico" type="image/x-icon"/>
        <title>IR Guest Login</title>
    </head>
    <body>
		<div class="container top">
	   		<table>
	   			<tr>
	   				<td width="33%">
	   					<a target="_self" href="../Control"><img alt="logo" class="top_logo" src="../Images/Logo_no_background.png"></a>
	   				</td>
	   				<td width="34%">
	   					<h1 class="page_title">Guest Login</h1>
	   				</td>
	   				<td width="33%">
	   					<p class="other_links">Not guest? login as <a target="_self" href="../Host">host</a>.</p>
	   				</td>
	   			</tr>
	   		</table>
   		</div>
		<div class="mid_container" style="">
			<div id="cmd_output" style="position:absolute; top:120px;">Output from server</div>
			<button class="main_button" id="drop_button">Login</button>
		</div>
		<div>
			<div id="drop_frame" class="drop_frame">
				<div class="login_menu">
					<div class="login_top_container">
						<button id="cancel_button" class="cancel_button">X</button>
						 <form id="login_data" action="ADD HERE PAGE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!">
							<p class="login_text">
								Username:
							</p>
							<input type="text" id="guest_name" class="login_input" placeholder="Your username here" onfocus="this.value=''"><br>
							<p class="login_text">
								Room(not implemented):
							</p>
							<input type="text" id="pswd" class="login_input" placeholder="Your room code here" onfocus="this.value=''"><br>
						</form>
						<p></p>
					</div>
					<div class="login_bottom_container">
						<button type="submit" form="login_data" id="guest_login" class="login_button">Login</button>
					</div>
				</div>
			</div>
			<div id="background_effects" class="background_effects"></div>
		</div>
    </body>
</html>
