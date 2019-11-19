<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 2019-03-11
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>


    <%@ include file="../_include/head.jsp"%>


</head>
<body>


<title>Validation de votre saisie</title>

<div class="container">
    <div class="row" style="margin-top: 50px">
        <div class="col-xs-1 col-sm-3 col-md-3 col-lg-3"></div>
        <div class="col-xs-10 col-sm-6 col-md-6 col-lg-6">
            <ul class="list-group list-group-item">
                <li class="list-group-item list-group-item-info">ID : <s:property value="lecteur.id"/></li>
                <li class="list-group-item">Identifiant : <s:property value="lecteur.identifiant"/></li>
                <li class="list-group-item">Nom : <s:property value="lecteur.nom"/></li>
                <li class="list-group-item">Prénom : <s:property value="lecteur.prenom"/></li>
                <li class="list-group-item">Date d'inscription : <s:property value="lecteur.dateInscription"/></li>
                <s:a action="utilisateur_supp" class="btn btn-secondary btn-block" cssStyle="margin-top: 15px">Annuler cette saisie<s:param name="idutilisateur" value="lecteur.id"/></s:a>
                <s:a action="ncoordonnees" class="btn btn-primary btn-block">Confirmer cette saisie<s:param name="idutilisateur" value="lecteur.id"/></s:a>
            </ul>
        </div>
    </div>
</div>

</body>
</html>

