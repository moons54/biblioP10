<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 2019-03-11
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<head>
    <%@ include file="../_include/head.jsp"%>
        <script type="text/javascript">
         //   var re = /(?:\d{2}|\+\d{2}[ ]\d)([- ])\d{2}\1\d{2}\1\d{2}\1\d{2}/;
           var re= /[a-z!?]/;
            function testInfo(ide){
                var OK = re.exec(ide.value);
                if (!OK)
                   window.alert(ide.input + " Vous devez saisir un identifiant ! Celui-ci vous permettra de reserver des livres dans nos librairies");
            }
         function passinfo(pass){
             var OK = re.exec(pass.value);
             if (!OK)
                 window.alert(pass.input + " Vous devez saisir un mot de passe ! Celui-ci vous permettra de reserver des livres dans nos librairies");
         }
         function nominfo(nom){
             var OK = re.exec(nom.value);
             if (!OK)
                 window.alert(nom.input + " Vous devez saisir votre nom et prenom afin que le formulaire soit valide");
         }
         function prenominfo(prenom) {
             var OK = re.exec(prenom.value);
             if (!OK)
                 window.alert(prenom.input + "Vous devez saisir votre nom et prenom afin que le formulaire soit valide");
         }
        </script>
        <title>Inscription</title>

        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.min.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.0/css/select.bootstrap4.min.css"/>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    <sx:head />
    <html>
<body>

<div class="container">
    <div class="row">
        <div class="col-xs-1 col-sm-3 col-md-3 col-lg-3"></div>
        <div class="col-xs-10 col-sm-6 col-md-6 col-lg-6">
            <div class="card text-center center-block ami_card">
                <div class="header-panel primary">Inscription</div>
                <div class="card-body">
                    <s:form action="nutilisateur" class="col-lg-12">
                        <s:textfield name="identifiant" id="ide" class="form-control"  label="Identifiant" labelSeparator="" labelposition="top" onchange="testInfo(document.getElementById('ide'));"/>
                        <s:password name="motDePasse" id="pass" class="form-control" label="Mot de Passe" labelSeparator="" labelposition="top" onchange="passinfo(document.getElementById('pass'));"/>
                        <s:password name="motDePasse2" class="form-control" label="deuxieme saisie mot de passe" labelSeparator="" labelposition="top"/>
                        <s:textfield name="nom"  id="nom" class="form-control" label="nom" labelSeparator="" labelposition="top" onchange="nominfo(document.getElementById('nom'))"/>
                        <s:textfield name="prenom" id="prenom" class="form-control" label="prenom" labelSeparator="" labelposition="top" cssStyle="margin-bottom: 10px" onchange="prenominfo(document.getElementById('prenom'))"/>
                            <div class="row">
                                <div class="col-md-offset-5 col-md-2 col-lg-offset-5 col-lg-2">

                                    <s:reset value="Annuler" class="btn btn-danger btn-block" />
                                    <s:submit id="valider" value="Valider" class="btn btn-primary btn-block" />

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

