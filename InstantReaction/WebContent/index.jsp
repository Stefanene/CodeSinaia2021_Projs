<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <link rel="stylesheet" href="index.css?ver=1.1">
        <script defer src="index.js"></script>
        <title>IR Control Panel</title>
    </head>
    <body>
        <span>Instant Reaction</span>
        <span style="color:blue;font-size:24px">Control Panel</span>
        <br>
        <p></p>
        <table>
            <tr>
                <td>
                    <a target="_blank" href="Host/index.jsp"><button id="host_button" class="custom_button">Host</button></a>
                </td>
                <td>
                    <a target="_blank" href="Guest/index.jsp"><button id="guest_button" class="custom_button">Guest</button></a>
                </td>
            </tr>
        </table>
        <p></p>
        <div id="cmd_output">Output from server</div>
        <p></p>
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