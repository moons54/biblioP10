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
<body><title>Modification de votre Coordonnées</title>

<div class="container">
    <div class="row">
        <div class="col-xs-1 col-sm-3 col-md-3 col-lg-3"></div>
        <div class="col-xs-10 col-sm-6 col-md-6 col-lg-6">
            <div class="card text-center center-block ami_card">
                <div class="header-panel primary">Modification des Coordonnées </div>
                <div class="card-body">
                    <s:form action="coordonnees_mod" class="col-lg-12">
                        <s:hidden name="coordonnees.lecteur.id"  />
                        <s:textfield name="coordonnees.email" class="form-control ami_txtfield" label="Email" requiredLabel="true" labelSeparator="" labelposition="top" ></s:textfield>
                        <s:textfield name="coordonnees.telephone" class="form-control" label="telephone" requiredLabel="true" labelSeparator="" labelposition="top" ></s:textfield>
                        <s:textfield name="coordonnees.rue" class="form-control" label="rue" requiredLabel="true" labelSeparator="" labelposition="top" ></s:textfield>
                        <s:textfield name="coordonnees.codePostal" class="form-control" label="code postale" requiredLabel="true" labelSeparator="" labelposition="top" ></s:textfield>
                        <s:textfield name="coordonnees.ville" class="form-control" label="ville" requiredLabel="true" labelSeparator="" labelposition="top" ></s:textfield>
                        <s:hidden name="coordonnees.ID"/>
                        <s:hidden name="idutilisateur"/>
                        <s:param name="idutilisateur" value="coordonnees.lecteur.id"/>
                            <div class="row">
                                <div class="col-md-offset-5 col-md-2 col-lg-offset-5 col-lg-2">
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
