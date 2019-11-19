<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 2019-02-26
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<head>
    <%@ include file="../_include/head.jsp" %>
</head>
<html>

<body>
<div class="container">
    <div class="row">
        <div class="col">
            <h1> Liste des utilisateurs </h1>
            <ul>
                <s:iterator value="lecteurs">
                    <li>
                        <s:a action="utilisateur_detail">
                            <s:param name="idutilisateur" value="id"/>
                            <s:property value="id"/>
                            <s:property value="identifiant"/>
                            Inscrit depuis le  : <s:property value="dateInscription"/>
                            <s:property value="nom"/>
                            <s:property value="prenom"/>
                        </s:a>
                    </li>
                </s:iterator>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
