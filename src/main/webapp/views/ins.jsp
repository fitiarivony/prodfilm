<%-- 
    Document   : ins
    Created on : 1 mars 2023, 14:27:11
    Author     : FITIA ARIVONY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserer les informations générales</title>
        <link rel="stylesheet" href="css/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/assets/css/insertact.css">
    </head>
    <body>
        <%@ include file="header.jsp" %>
         <div class="card row">
            <div class="card-header">
                <p class="card-title title">Inserer les information generale sur la scene</p>
            </div>
            <div class="card-body">
        <%= request.getAttribute("form") %>
            </div>
         </div>
    </body>
</html>
