<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 2019-02-25
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="a" uri="/struts-tags" %>
<html>
<head>
    <title>Authentification</title>
    <%@ include file="../_include/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.0/css/select.bootstrap4.min.css"/>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
</head>
<body>
<a:actionerror/>
<div class="container">
    <div class="row">
        <div class="col-xs-1 col-sm-3 col-md-3 col-lg-3"></div>
        <div class="col-xs-10 col-sm-6 col-md-6 col-lg-6">
            <div class="card text-center center-block ami_card">
                <div class="header-panel primary"><i class="fas fa-users fa-2x"></i>identification</div>
                <div class="card-body">
                    <s:form action="Login" class="col-lg-10 col-lg-offset-4">
                    <div class="form-group">
                            <%--<label for="identifiant">identifiant</label>--%>
                        <s:textfield name="identifiant" key="Identifiant" class="form-control form-control-lg" id="identifiant" placeholder="identifiant" labelSeparator=""/>
                    </div>
                    <div class="form-group">
                            <%--<s:label for="motDePasse">Mot de passe</s:label>--%>
                        <s:password name="motDePasse" key="Mot de passe" class="form-control form-control-lg" placeholder="*********" labelSeparator=""/>
                    </div>
                        <s:submit value="Valider" class="btn btn-primary center-block "/></div></div>
                </s:form>
            </div>
            <%--<s:if test="%{#session.user==null}">
                <li><s:a action="nutilisateur">Inscription</s:a></li>
            </s:if>--%>
        </div>
    </div>
    <div class="col-xs-1 col-sm-3 col-md-3 col-lg-3"></div>
</div>
</div>
</body>
</html>
