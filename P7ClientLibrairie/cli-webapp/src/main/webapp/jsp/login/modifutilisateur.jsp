<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 2019-03-24
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
    <%@ include file="../_include/head.jsp" %>

</head>
<body>
<title>Modification profil</title>

<div class="container">
    <div class="row">
        <div class="col-xs-1 col-sm-3 col-md-3 col-lg-3"></div>
        <div class="col-xs-10 col-sm-6 col-md-6 col-lg-6">
            <div class="card text-center center-block ami_card">
                <div class="header-panel primary">Modification des données personnels</div>
                    <div class="card-body">
                        <s:form action="utilisateur_mod" class="col-lg-12">
                            <s:textfield name="lecteur.identifiant" class="form-control" label="Identifiant de connexion" requiredLabel="true" labelSeparator="" labelposition="top" ></s:textfield>
                            <s:textfield name="lecteur.motDePasse" class="form-control" label="Mot de passe" requiredLabel="true" labelSeparator="" labelposition="top"></s:textfield>
                            <s:textfield name="lecteur.nom" class="form-control" label="Nom" requiredLabel="true" labelSeparator="" labelposition="top" ></s:textfield>
                            <s:textfield name="lecteur.prenom" class="form-control" label="Prénom" requiredLabel="true" labelSeparator="" labelposition="top"></s:textfield>
                            <s:textfield name="idutilisateur" class="form-control" labelSeparator="" labelposition="top" />
                            <s:hidden name="lecteur.id"/>
                                <div class="row">
                                    <div class="col-md-offset-5 col-md-2 col-lg-offset-5 col-lg-2">
                                        <s:reset value="Annuler" class="btn btn-danger btn-block" />
                                        <s:submit value="Valider" class="btn btn-primary btn-block" />
                                    </div>
                                 </div>
                        </s:form>
                    </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
