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


<s:actionmessage name="ncoordonnees"/>
<title>Détail d'un lecteur</title>

<ul>

    <s:hidden value="id"/>
    <li><s:property value="identifiant"/></li>
    <li><s:property value="nom"/></li>
    <li><s:property value="prenom"/></li>
    <li><s:property value="lecteur.motDePasse"/></li>
    <li><s:property value="lecteur.dateInscription"/></li>


    <s:property value="coordonnees.ID"/>
    <li><s:property value="coordonnees.rue"/></li>
    <li><s:property value="coordonnees.codepostal"/></li>
    <li><s:property value="coordonnees.email"/></li>
    <li><s:property value="coordonnees.telephone"/></li>



</ul>
<div><s:a action="utilisateur_mod">modifier cette saisie<s:param name="idutilisateur" value="lecteur.id"/></s:a>
    <s:a action="coordonnees_mod">modifier l'adresse<s:param name="idutilisateur" value="lecteur.id"/></s:a>>
</body>
</html>
