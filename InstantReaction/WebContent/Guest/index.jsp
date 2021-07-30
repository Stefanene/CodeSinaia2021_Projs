<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>IR Guest Login</title>
        <link rel="stylesheet" href="index.css">
        <script defer src="index.js"></script>
    </head>
    <body style="font-family:Helvetica,sans-serif;">
        <table>
        	<tr>
        		<td>
        			<span>Instant Reaction</span>
        			<span id="guest_label">Guest</span>
        		</td>
        	</tr>
        </table>
        <br>
		<table>
			<tr>
				<td>Name:</td>
				<td>
					<input id="guest_name" type="text">
				</td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align:right">
					<input id="guest_login" type="submit" value="Login">
				</td>
			</tr>
		</table>
	    <div id="cmd_output">Output from server</div>
    </body>
</html>
