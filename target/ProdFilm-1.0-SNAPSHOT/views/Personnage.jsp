<%@page import="model.Personnage"%>
<%@page import="model.Scene"%>
<%@page import="java.util.ArrayList"%>
<%
    String idscene = (String) request.getAttribute("idscene");
    ArrayList listscene = (ArrayList) request.getAttribute("listscene");
    ArrayList listperso = (ArrayList) request.getAttribute("listperso");
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Design</title>
    <link rel="stylesheet" href="css/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">
    <link rel="stylesheet" href="css/assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="css/assets/css/Article-Clean.css">
    <link rel="stylesheet" href="css/assets/css/Contact-Form-Clean.css">
    <link rel="stylesheet" href="css/assets/css/Footer-Clean.css">
    <link rel="stylesheet" href="css/assets/css/Highlight-Phone.css">
    <link rel="stylesheet" href="css/assets/css/Navigation-Clean.css">
    <link rel="stylesheet" href="css/assets/css/Personnage.css">
    <link rel="stylesheet" href="css/assets/css/styles.css">
</head>

<body style="background-color: #404040;">
   

    <%@ include file="header.jsp" %>


    <section class="contact-clean">



        <div class="modal fade" role="dialog" tabindex="-1" id="modal-1" style="/*background-color: #505050;*/">
            <div class="modal-dialog" role="document">
                <div class="modal-content" style="background-color: #505050;">
                    <div class="modal-header" style="border: none;">
                        <h4 class="modal-title" style="color: #933;text-transform: uppercase;letter-spacing: 0.1em;">Error</h4><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <p style="color: #fffefa;">The content of your modal</p>
                    </div>
                    <div class="modal-footer" style="border: none;"></div>
                </div>
            </div>
        </div>


        
        <form method="post" action="insertpersonnagescene">
            <h2 class="text-center">Ajout personnage <br>dans une scene</h2>
            <div class="mb-3">
                <select id="selectscene" name="idscene" class="form-select form-control" style="background-color: transparent;color: #fffefa;" onchange="checky()">
                    <optgroup label="This is a group">
                        <option value="12" >Scene</option>
                        <% for(Object ob:listscene) {
                            Scene obj = (Scene) ob;
                            System.out.println(obj);
                        %>                        
                        <option value="<%= obj.getIdscene()%>"><%= obj.getNom() %></option>
                        <%}%>
                    </optgroup>
                </select></div>
            <div class="mb-3">
                <select class="form-select form-control" name="idperso" style="background-color: transparent;color: #fffefa;">
                    <optgroup label="This is a group">
                        <option value="12" >Personnage</option>
                        <% for(Object ob:listperso) {
                            Personnage obj = (Personnage) ob;
                            System.out.println(obj);
                        %>                        
                        <option value="<%= obj.getIdpersonnage()%>"><%= obj.getNom() %> <%= obj.getPrenom() %></option>
                        <%}%>
                    </optgroup>
                </select></div>
            <div class="mb-3"><button class="btn btn-primary" type="submit">Ajouter</button></div>
        </form>
    </section>
    
    <script type="text/javascript">
        var selectElement = document.getElementById("selectscene");
        var optionIndex = Array.from(selectElement.options).findIndex(option => option.value === '<%=idscene%>');
        document.getElementById("selectscene").selectedIndex=optionIndex;
    function checky() {
    //   console.log(document.getElementById("selectscene").value);
        window.location.href = 'insertpersonnagescene?idscene='+document.getElementById("selectscene").value;
    };
  </script>



     
    <script src="css/assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>