<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <link rel="stylesheet" href="../index.css?ver=1.0">
        <script defer src="index.js"></script>
        <link rel="icon" href="../Images/FaviconLogo.ico" type="image/x-icon"/>
        <title>IR Control Panel</title>
    </head>
    <body>
    	<div class="container top">
	   		<table>
	   			<tr>
	   				<td width="33%">
	   					<a target="_self" href="../Control"><img alt="logo" class="top_logo" src="../Images/Logo_no_background.png"></a>
	   				</td>
	   				<td width="34%">
	   					<h1 class="page_title">Control Panel</h1>
	   				</td>
	   				<td width="33%">
	   				</td>
	   			</tr>
	   		</table>
   		</div>
   		<div class="mid_container">
   			<div id="cmd_output" style="position:absolute; top:120px;">Output from server</div>
   			<table>
	   			<tr>
					<td>
						<a style="display:grid;" target="_blank" href="../Host"><button class="main_button">Host</button></a>
					</td>
					<td>
						<a style="display:grid;" target="_blank" href="../Guest"><button class="main_button">Guest</button></a>
					</td>
				</tr>
		    </table>
	    </div>
    </body>
</html>