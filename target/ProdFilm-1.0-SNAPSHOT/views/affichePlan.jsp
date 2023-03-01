<%-- 
    Document   : affichePlan
    Created on : 1 mars 2023, 08:56:25
    Author     : Hart
--%>

<%@page import="model.Plan"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Plan> plan=(ArrayList<Plan>)request.getAttribute("plan"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/assets/css/affichePlan.css">
    </head>
    <body>
        <%@ include file="header.jsp" %>

        <div class="card shadow mb-3">
            <div class="card-header">
                <p class="card-title">Affiche plan</p>
            </div>
            <div class="card-body">
                <table class="table table-dark">
                    <tr>
                        <th class="entete" scope="col">id</th>
                        <th class="entete" scope="col">heure</th>
                    </tr>
                    <% for (Plan elem : plan) { %>
                    <tr>
                        <td><%= elem.getScene().getIdscene() %></td>
                        <td><%= elem.getDaty().toLocaleString() %></td>
                    </tr>
                    <%  }  %>
                    
                </table>
            </div>
        </div>
        
    </body>
</html>
