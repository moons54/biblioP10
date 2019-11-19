<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 2019-04-11
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
    <%@ taglib prefix="margin-top" uri="/struts-dojo-tags" %>
    <%@ include file="../_include/head.jsp" %>

</head>
<body>



<table class="table table-sm table-striped" style="margin-top: 10px">
    <thead class="table-info">
    <tr>

        <th scope="col">Nom de l'ouvrage</th>
        <th scope="col">Ref ISBN</th>
        <th scope="col">Auteur</th>
        <th scope="col">Editeur</th>
        <th scope="col"></th>
        <th scope="col">id</th>


    </tr>
    </thead>
    <tbody>
    <s:iterator value="ouvrageList" >
        <tr>
            <td class="h4"><s:property value="intituleOuvrage" />
            <td><s:property value="isbn"/></td>
            <td><s:property value="auteur.intituleAuteur"/></td>
            <s:iterator value="editeurs">
                <td><s:property value="intituleEditeur"/></td>
            </s:iterator>
            <td>
                <s:if test="%{#session.user==null}">
                    <s:a action="Login">
                            <u>Se connecter</u>
                    </s:a>
                </s:if>
                <s:if test="%{#session.user.identifiant!=''}">
                    <s:a action="detail_livre">
                            <s:param name="numISBN" value="isbn"/>
                            <u>detail</u>
                    </s:a>
                </s:if>
            </td>

        </tr>
    </s:iterator>
    </tbody>
</table>






</body>

</html>