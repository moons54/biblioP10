<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 2019-04-19
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
    <%@ taglib prefix="margin-top" uri="/struts-dojo-tags" %>
    <%@ include file="../_include/head.jsp" %>

</head>
<body>
<link href="css/detailOuvrage.css" rel="stylesheet">
<div class="container-fluid">
    <s:form action="nreserv" class="container-fluid">
    <title>Détail d'un ouvrage</title>
    <div class="row ami_card">
        <div class="col-sm-4">
            <div class="card header">
                <li class="list-group-item alert-primary text-uppercase"><strong><s:property
                        value="ouvrage.intituleOuvrage"/></strong></li>
            </div>
            <li class="list-group-item">REFERENCE ISBN : <s:property value="ouvrage.isbn"/></li>
            <li class="list-group-item">reservable : <s:property  value="controlereservable"/></li>

            <li class="list-group-item">NOM AUTEUR : <s:property value="auteur.intituleAuteur"/></li>
            <li class="list-group-item">EDITION :
                <s:iterator value="ouvrage.editeurs">
                    <td><s:property value="intituleEditeur"/></td>
                </s:iterator>
            </li>
            <li class="list-group-item">Lien Web :
                <s:iterator value="ouvrage.editeurs">
                    <td><s:property value="lienweb"/></td>
                </s:iterator>
            </li>
            <li class="list-group-item">GENRE :
                <s:iterator value="ouvrage.genres">
                    <td><s:property value="intituleGenre"/></td>
                </s:iterator>
            </li>
        </div>
        <div class="col-sm-4">
            <div class="card header ">
                <li class="list-group-item alert-primary">Description</li>
            </div>
            <li class="list-group-item" style="height: 230px"><s:property value="ouvrage.description"/></li>
        </div>
        <div class="col-sm-4">
            <div class="card header">
                <li class="list-group-item alert-primary">Photo</li>
                <ul class="text-center"><img height="215" width="190" src="images/<s:property value="ouvrage.photo"/>"/>
                </ul>
            </div>
        </div>
    </div>
    <div class="container-fluid bibliomarge">
        <s:if test="%{controlereservable==true}">
            Vous pouvez reserver cet ouvrage

        <li class="list-group-item alert-primary">Exemplaires Disponibles</li>

            <div class="container-fluid bibliomarge">
                <li class="list-group-item alert-primary">Demande de réservation de l'ouvrage <s:property value="referenceInterne"/></li>
                <div class="card container-fluid">
                    <div class="card-body">
                        <h3>Cliquer sur valider pour enregistrer la reservation de cet ouvrage</h3>
                        <h4>Vous devrez le retourner au plus tard le : <script>calcdateretour()</script></h4>
                        <s:hidden name="reservation.lecteur.id" label="numéro id lecteur" requiredLabel="true" value="%{idutilisateur}"/>
                        <s:hidden name="reservation.ouvrage.ID"  label="num ref exemplaire" value="%{ouvrageid}" requiredLabel="true"/>

                        <div class="row">
                            <div class="col-md-offset-5 col-md-2 col-lg-offset-5 col-lg-2">
                                <s:reset value="Annuler" class="btn btn-danger btn-block" />
                                <s:submit value="Valider" class="btn btn-primary btn-block" />
                            </div></s:if><s:else>Vous ne pouvez reserver cetouvrage</s:else>
                        </div>
                        </s:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
