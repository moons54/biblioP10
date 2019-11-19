<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 2019-03-19
  Time: 00:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<head>
    <%@ include file="../_include/head.jsp"%>
    <s:actionmessage name="nutilisateur"/>
</head>
<body>


<div class="container">
    <div class="row">
        <div class="col-xs-1 col-sm-3 col-md-3 col-lg-3"></div>
        <div class="col-xs-10 col-sm-6 col-md-6 col-lg-6">
            <div class="card text-center center-block ami_card">
            <div class="header-panel primary">Suite de l'inscription</div>
                <div class="card-body">
                    <s:form action="ncoordonnees" class="col-lg-12">
                        <s:textfield name="rue" class="form-control" label="numéro rue + voie" labelSeparator="" labelposition="top" />
                        <s:textfield name="codePostal" class="form-control" label="code postal" labelSeparator="" labelposition="top" />
                        <s:textfield name="ville" class="form-control" label="ville" labelSeparator="" labelposition="top"/>
                        <s:textfield name="telephone" class="form-control" label="numéro de téléphone" labelSeparator="" labelposition="top"/>
                        <s:textfield name="email" class="form-control" label="email" labelSeparator="" labelposition="top" cssStyle="margin-bottom: 10px"/>
                        <s:hidden name="idutilisateur"/>
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
