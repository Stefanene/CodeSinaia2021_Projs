<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <!-- link href="style.css" rel="stylesheet" type="text/css" -->
        <link href="index.css" rel="stylesheet" type="text/css">
        <script defer src="index.js"></script>
        <title>IR Host Login</title>
    </head>
    <body style="font-family:Helvetica,sans-serif;">
<!--  
<meta name="viewport" content="width=device-width, initial-scale=1">
<br></br>
<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</button>

<div id="id01" class="modal">
  
  <form class="modal-content animate" action="/action_page.php" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label for="uname"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="uname" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>
        
      <button type="submit">Login</button>
      <label>
        <input type="checkbox" checked="checked" name="remember"> Remember me
      </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
      <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
  </form>
</div>

<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
-->
	    <table>
	            <tr>
	                <td>
	                    <span>Instant Reaction</span>
	                    <span id="host_label">Host</span>
	                </td>
	            </tr>
	    </table>
	    <p>
	    <table>
	        <tr>
	            <td>Name:</td>
	            <td><input id="host_name" type="text"></td>
	        </tr>
	        <tr>
	            <td>Password:</td>
	            <td><input type="password" id="host_password"></td>
	        </tr>
	        <tr>
	            <td></td>
	            <td style="text-align:right">
	               <input type="submit" value="Login" id="host_login" class="custom_button">
	            </td>
	        </tr>
	    </table>
	    <div id="cmd_output">Output from server</div>
    </body>
</html>

