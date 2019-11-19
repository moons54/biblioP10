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
<script type="text/javascript">
    function calcdateretour() {
        /* methode conv date */
        let dateTemp1 = '<s:property value="%{#session.dureelivre}"/>';
       let dateTemp = new Date();
       dateTemp.setDate(dateTemp.getDate()+<s:property value="%{#session.dureelivre}"/>)

        var dateLocale = new Date(dateTemp).toLocaleDateString();
        document.write(dateLocale);
    }
</script>
<link href="css/detailOuvrage.css" rel="stylesheet">
<s:form action="nreservation" class="container-fluid">
    <title>Détail de votre emprunt</title>
        <div class="row ami_card container-fluid">
            <div class="col-sm-4 ">
                <div class="card header">
                    <li class="list-group-item alert-primary text-uppercase"><strong><s:property
                            value="exemplaire.ouvrage.intituleOuvrage"/></strong></li>
                </div>
                <li class="list-group-item">REFERENCE ISBN : <s:property value="exemplaire.ouvrage.isbn"/></li>
                <li class="list-group-item">NOM AUTEUR : <s:property value="exemplaire.ouvrage.auteur.intituleAuteur"/></li>
                <li class="list-group-item">EDITION :
                    <s:iterator value="exemplaire.ouvrage.editeurs">
                        <s:property value="intituleEditeur"/>
                    </s:iterator>
                </li>

               <li class="list-group-item">Lien Web :
                    <s:iterator value="exemplaire.ouvrage.editeurs">
                        <s:property value="lienweb"/>
                    </s:iterator>
                </li>
                <li class="list-group-item">GENRE :
                    <s:iterator value="exemplaire.ouvrage.genres">
                        <s:property value="intituleGenre"/>
                    </s:iterator>
                </li>
            </div>
            <div class="col-sm-4">
                <div class="card header ">
                    <li class="list-group-item alert-primary">Description</li>
                </div>
                <li class="list-group-item" style="height: 230px"><s:property value="exemplaire.ouvrage.description"/></li>
            </div>
            <div class="col-sm-4">
                <div class="card header">
                    <li class="list-group-item alert-primary">Photo</li>
                    <ul class="text-center"><img height="215" width="190" src="images/<s:property value="exemplaire.ouvrage.photo"/>"/>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container-fluid bibliomarge">
            <li class="list-group-item alert-primary">Demande de prolongation d'emprunt réference interne : <s:property value="exemplaire.referenceInterne"/></li>
            <div class="card container-fluid">
                <div class="card-body">
                    <h3>Cliquer sur valider pour enregistrer la reservation de cet ouvrage</h3>
                   <h4>Vous devrez le retourner au plus tard le : <script>calcdateretour()</script></h4>
                        <s:hidden name="emprunt.lecteur.id" label="numéro id lecteur" requiredLabel="true" value="%{idutilisateur}"/>
                        <s:hidden name="emprunt.exemplaire.ID"  label="num ref exemplaire" value="%{id}" requiredLabel="true"/>

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
</body>
</html>

