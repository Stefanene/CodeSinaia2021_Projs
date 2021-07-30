<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <!-- Text on the browser tab: "IR Control Panel" -->
        <title>IR Control Panel</title>
        <link rel="stylesheet" href="index.css?ver=1.0">
        <script defer src="index.js?ver=1.0"></script>
    </head>
    <body>
    
        <!-- Title of the page: "Instant Reaction CONTROL PANEL -->
        <table>
            <tr>
                <td>
                    <span>Instant Reaction</span>
                    <span class="title-highlight">Control Panel</span>
                </td>
            </tr>
        </table>
        <p>
        
        <!-- Side-by-side buttons, [Host] and [Guest] 
             each leading to new browser pages for the Host and Guest entry page-->
        <a href="Host/index.jsp" target="_blank"><button>Host</button></a>
        <a href="Guest/index.jsp" target="_blank"><button>Guest</button></a>
        
        <!--  Output area -->
        <p>
        <div id="controlOutput" class="text-output"></div>
        <p>
        <table id="statusTable" style="width:80%" class="status-table">
            <thead>
	            <tr id="statusHeader" class="status-tr">
	                <th style="width:15%" class="status-th">Role</th>
	                <th style="width:25%" class="status-th">IP</th>
	                <th style="width:60%" class="status-th">Name</th>
	            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </body>
</html>
