<%-- 
    Document   : clientError
    Created on : 18 janv. 2023, 17:00:55
    Author     : FITIA ARIVONY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erreur administrateur</title>
        <link rel="shortcut icon" href="css/images/checklist.png" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="css/assets/css/adminerror.css">
        <link rel="stylesheet" type="text/css" href="css/assets/css/bootstrap.min.css">
    </head>
    <body >
        <div style="height: 200px;"></div>
        <div class="row">
            <div class="col"></div>
            <div class="col">

                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">Erreur!</h5>
                        <p class="card-text"><spring:eval expression="message"/></p>
                        <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Retour</a>
                    </div>
                </div>


            </div>
            <div class="col"></div>
        </div>
        
    </body>
</html>
