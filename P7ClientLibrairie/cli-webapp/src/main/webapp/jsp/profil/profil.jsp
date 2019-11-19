<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 2019-04-08
  Time: 12:29
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

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.0/css/select.bootstrap4.min.css"/>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
</head>
<body>
<script type="text/javascript">
    function getDate() {
        /* methode conv date */
        let dateTemp = '<s:property value="%{#session.user.dateInscription}"/>';
        var dateLocale = new Date(dateTemp).toLocaleDateString();
        document.write(dateLocale);
    }
</script>
<link href="css/profilUtilisateur.css" rel="stylesheet">
<div class="ami_decal container-fluid">
    <div class="row container-fluid">
         <div class="col-md-3 col-lg-3">
            <div class="card">
                <div class="card-header">
                    <h3> <i class="far fa-address-card fa-2x"> Mes Données</i></h3>
                </div>
                <ul class="list-group list-group-flush ami_profilcustom"><s:hidden value="#session.user.id"/>
                    <li class="list-group-item">Identifiant : <strong><s:property value="#session.user.identifiant"/></strong></li>
                    <li class="list-group-item">Nom : <strong><s:property value="#session.user.nom"/></strong></li>
                    <li class="list-group-item maval">Prénom : <strong><s:property value="#session.user.prenom"/></strong></li>
                    <li class="list-group-item">Date d'inscription : <strong><script>getDate();</script></strong></li>
                    <li class="list-group-item">Telephone : <strong><s:property value="coordonnees.telephone"/> </strong></li>
                    <li class="list-group-item">Email : <strong><s:property value="coordonnees.email"/> </strong></li>
                </ul>
            </div>
        </div>
        <div class="col-md-9 col-lg-9">
            <div class="table-responsive table-bordered">
                <h3><i class="fas fa-book fax-2x"></i>Historique de mes lectures</h3>
                <table class="table table-striped table-borderHd table-hover exemple1" style="width:100%" >
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Ouvrage</th>
                            <th scope="col">Editeur</th>
                            <th scope="col">Auteur</th>
                            <th scope="col">Date d'emprunt</th>
                            <th scope="col">Ref ISBN</th>
                            <th scope="col">Description</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="empruntList">
                            <script>function getdemprunt() {
                                let dateTemp1 = '<s:property value="%{dateDebut}"/>';
                                var dateLocale2 = new Date(dateTemp1).toLocaleDateString();
                                console.log("valeur date "+dateTemp1)
                                document.write(dateLocale2);
                            }</script>
                                <tr>
                                    <th scope="row"><s:property value="exemplaire.ouvrage.intituleOuvrage"/> </th>
                                        <s:iterator value="exemplaire.ouvrage.editeurs">
                                            <td><s:property value="intituleEditeur"/></td>
                                        </s:iterator>
                                    <td><s:property value="exemplaire.ouvrage.auteur.intituleAuteur"/></td>
                                    <td><script>getdemprunt()</script></td>
                                    <td><s:property value="exemplaire.ouvrage.isbn"/></td>
                                    <td> <s:a action="detail_livre">
                                        <s:param name="numISBN" value="exemplaire.ouvrage.isbn"/>
                                        <u>detail</u>
                                    </s:a></td>
                                </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="ami_decal row container-fluid" style="margin-top: 50px">
    <div class="col col-md-12 col-lg-12 ">
        <div class="card" style="margin-bottom: 50px">
            <div class="card-header">

            </div>
            <table class="table table-striped table-bordered table-hover exemple1" style="width: 100%">
                <h3>Mes livres empruntés</h3>
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Livres en cours</th>
                    <th scope="col">Date d'emprunt</th>
                    <th scope="col">Date de retour prévue</th>
                    <th scope="col">Durée d'emprunt prolongée</th>
                    <th scope="col">Situation de votre emprunt</th>
                </tr>
                </thead>
                <tbody>
                    <s:iterator value="empruntencours">
                        <script>
                            function getdemprunt() {
                        let dateTemp1 = '<s:property value="%{dateDebut}"/>';
                        var dateLocale2 = new Date(dateTemp1).toLocaleDateString();
                        document.write(dateLocale2);
                        }

                            function getretourprevu() {
                                let dateTemp1 = '<s:property value="%{dateFin}"/>';
                                var dateLocale3 = new Date(dateTemp1).toLocaleDateString();
                                document.write(dateLocale3);
                            }
                        </script>
                            <tr>
                                <th scope="row">
                                        <strong><s:property value="exemplaire.ouvrage.intituleOuvrage"/></strong></th>
                                <td><script>getdemprunt()</script></td>
                                <td><script>getretourprevu()</script></td>
                                <td><s:if test="%{renouvellement==false}">

                                    <s:if test="%{situationEmprunt.situation=='En cours'}">
                                        <s:a action="emprunt_mod">
                                            <s:param name="numISBN" value="exemplaire.ouvrage.isbn"/>
                                            <s:param name="id" value="exemplaire.ID"/>
                                            <s:param name="numemprunt" value="ID"/> Prolonger votre emprunt
                                        <s:param name="idutilisateur" value="idutilisateur"/></s:a>
                                    </s:if>
                                </s:if>
                                    <s:else>Déja prolongé</s:else>
                                </td></td>
                                <td>
                                <s:if test="%{situationEmprunt.situation=='Non rendus à temps'}">
                                    <i class="fas fa-info-circle fa-1x altColor">  votre delais d'emprunt est dépassé merci de nous contacter</i>
                                    </s:if>
                                    <s:else><s:property value="situationEmprunt.situation"/></s:else>
                                    </td>
                            </tr>
                    </s:iterator>
                </tbody>
            </table>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.18/js/dataTables.bootstrap4.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/select/1.3.0/js/dataTables.select.min.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.0/js/mdb.min.js"></script>
        <script>
            $('.exemple1').DataTable({
                "scrollY": "245",
                "scrollCollapse": true,
                "pagingType": "numbers",
            });
        </script>
    </div>
</div>
</body>
</html>
