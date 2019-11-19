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
        <title>Détail d'un ouvrage</title>
        <div class="row ami_card">
            <div class="col-sm-4">
                <div class="card header">
                    <li class="list-group-item alert-primary text-uppercase"><strong><s:property
                            value="ouvrage.intituleOuvrage"/></strong></li>
                </div>
                <li class="list-group-item">REFERENCE ISBN : <s:property value="ouvrage.isbn"/></li>
                <li class="list-group-item">NOM AUTEUR : <s:property value="ouvrage.auteur.intituleAuteur"/></li>
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
            <li class="list-group-item alert-primary">Exemplaires Disponibles</li>
            <div class="row">
                <s:iterator value="bibliothequeList">
                    <div class="card col-md alert-secondary bibliotheque">

                       <s:property value="intituleBibliotheque"/>

                        <div class="container-fluid">
                            <s:iterator value="exemplaireList">
                                <s:if test="%{intituleBibliotheque==bibliotheque.intituleBibliotheque}">
                                    <li> Ouvrage Référence : <strong><s:property value="referenceInterne"/></strong>
                                        <s:if test="%{#session.user==null}">
                                            <s:a action="Login">
                                                <u>S'authentifier pour le reserver</u>
                                            </s:a>
                                        </s:if>
                                <s:if test="%{#session.user.identifiant!=''}">

                                <s:a action="nreservation">
                                            <s:param name="id" value="ID"/>
                                            <s:param name="idutilisateur" value="#session.user.id"/>
                                            <u>reserver</u>
                                        </s:a>
                                    </li>
                                </s:if>
                                </s:if>
                            </s:iterator>
                        </div>
                    </div>
                </s:iterator>
            </div>
        </div>
    </div>
</body>
</html>
