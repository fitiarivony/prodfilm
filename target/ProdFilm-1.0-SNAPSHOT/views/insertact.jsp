<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Inserer action</title>
        <link rel="stylesheet" href="css/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/assets/css/insertact.css">
    </head>
    <body>
        <%@ include file="header.jsp" %>

        <div class="card row">
            <div class="card-header">
                <p class="card-title title">Inserer les actions d'une scene</p>
            </div>
            <div class="card-body">
                <form class="row" action="createact" method="post" >
                    <div class="col-md-4">
                        <h4>La scène</h4>
                        <div>    
                            <label for="scene" class="form-label">Scene:</label>
                            <select class="form-control" onchange="callperso(this)"   id="idscene" name="idscene"   >

                                <c:forEach items="${scenes}" var="row">
                                    <option value="${row.idscene}" >${row.nom}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div>

                            <h4>Les actions de cette scène</h4>

                            <div id="conteneur">
                                <input type="hidden" id="nb" name="nb" value="1" />
                                <div>

                                    <div>
                                        <label for="evenement" class="form-label">Evenement:</label>
                                        <textarea name="evenement1" class="form-control" type="text" ></textarea>
                                    </div>

                                    <div>
                                        <label for="expression" class="form-label">Expression:</label>
                                        <input name="expression1" class="form-control" id="expression" type="text" />
                                    </div>



                                    <div>
                                        <label for="perso_scene" class="form-label">Personnage:</label>
                                        <select id="perso_scene1" class="form-control" name="perso_scene1">
                                            <c:forEach items="${perso_scene}" var="row">
                                                <option value="${row.idpersonnage}" >${row.prenom} ${row.nomperso}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>


                            </div>
                            <br>    
                            <button class="validationBtn btn w-100">Valider</button>
                            <br><br>

                        </div>
                    </div>
                </form>
                <center><button id="add" class="AddBtn btn" onclick="addcomponent()">Ajouter une action</button></center>   
            </div>
        </div>



    </body>
    <script src="views/ajax.js"></script>
    <script type="text/javascript">
                        var data = {};
                        function getperso() {

                            for (let index = 1; index <= (parseInt(document.getElementById('nb').value)); index++) {
                                genereSelect("perso_scene" + index);
                            }
                        }


                        function callperso(myval, bool = true) {
                            let url = "http://localhost:8084/Springmvc/perso_scene?idscene=" + myval.value;
                            let ajax = new Ajax(url
                                    , "GET");
                            data = ajax.call();
                            if (bool) {
                                getperso();
                        }

                        }

                        function changetype(myval) {
                            bool = false;
                            console.log("tonga ato" + myval.value);
                            if (myval.value === 1)
                                bool = true;
                            document.getElementById("expression").disabled = bool;
                        }
                        function addcomponent() {
                            let div = document.createElement("div");
                            div.appendChild(genereInput("evenement", "Evenement"));
                            div.appendChild(genereInput("expression", "Expression"));

                            div.appendChild(addSelect("perso_scene", "Personnage"));
                            document.getElementById('nb').value = (parseInt(document.getElementById('nb').value)) + 1;
                            document.getElementById("conteneur").appendChild(div);
                            genereSelect("perso_scene" + (parseInt(document.getElementById('nb').value)));
                        }
                        function addSelect(name, label, i = (parseInt(document.getElementById('nb').value) + 1)) {
                            let div = document.createElement("div");
                            let select = document.createElement("select");
                            select.setAttribute("id", "perso_scene" + i);
                            let libelle = document.createElement("label");
                            libelle.setAttribute("for", name);
                            libelle.setAttribute("class", "form-label");
                            libelle.append(label + ":");
                            select.setAttribute("name", name + i);
                            select.setAttribute("class", "form-control");
                            div.appendChild(libelle);
                            div.appendChild(select);
                            console.log(select);
                            return div;
                        }

                        function genereSelect(id, donnee = data) {
                            if (donnee.perso === undefined) {
                                callperso(document.getElementById("idscene"), false);
                                donnee = data;
                            }

                            let perso_scene = document.getElementById(id);
                            perso_scene.innerHTML = "";
                            for (const element of donnee.perso) {
                                let perso = document.createElement("option");
                                perso.setAttribute("value", element.idpersonnage);
                                perso.append(element.prenom + " " + element.nomperso);
                                perso_scene.appendChild(perso);
                        }
                        }
                        function genereInput(name, label, type = "text", i = (parseInt(document.getElementById('nb').value) + 1)) {
                            let div = document.createElement("div");
                            let libelle = document.createElement("label");
                            libelle.setAttribute("for", name);
                            libelle.setAttribute("class", "form-label");
                            libelle.append(label + ":");
                            let input = document.createElement("input");
                            input.setAttribute("name", name + i);
                            input.setAttribute("type", type);
                            input.setAttribute("class", "form-control");
                            div.appendChild(libelle);
                            div.appendChild(input);
                            return div;
                        }

    </script>
</html>