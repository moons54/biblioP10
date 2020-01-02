<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 2019-04-19
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
    <%@ taglib prefix="margin-top" uri="/struts-dojo-tags" %>
    <%@ include file="../_include/head.jsp" %>

</head>
<script type="text/javascript">
    function getDate() {
        /* methode conv date */
        let dateTemp = '<s:property value="dteretour"/>';
        var dateLocale = new Date(dateTemp).toLocaleDateString();
        document.write(dateLocale);
    }
</script>
<script>jQuery.fn.dataTable.Api.register( 'sum()', function ( ) {
    return this.flatten().reduce( function ( a, b ) {
        if ( typeof a === 'string' ) {
            a = a.replace(/[^\d.-]/g, '') * 1;
        }
        if ( typeof b === 'string' ) {
            b = b.replace(/[^\d.-]/g, '') * 1;
        }

        return a + b;
    }, 0 );
} );</script>
<body>
<link href="css/detailOuvrage.css" rel="stylesheet">
<title>Détail d'un ouvrage</title>
<div class="row ami_card fluid">
    <div class="col-sm-8">
        <div class="card header">
            <li class="list-group-item alert-primary text-uppercase"><strong><s:property
                    value="ouvrage.intituleOuvrage"/></strong></li>
        </div>
        <li class="list-group-item">REFERENCE ISBN : <s:property value="ouvrage.isbn"/></li>
        <li class="list-group-item">NOM AUTEUR : <s:property value="ouvrage.auteur.intituleAuteur"/></li>
        <li class="list-group-item">EDITION :
            <s:iterator value="ouvrage.editeurs">
                <td><s:property value="intituleEditeur"/></td>
            </s:iterator>
        </li>
        <li class="list-group-item">Lien Web :
            <s:iterator value="ouvrage.editeurs">
                <td><s:property value="lienweb"/></td>
            </s:iterator>
        </li>
        <li class="list-group-item">GENRE :
            <s:iterator value="ouvrage.genres">
                <td><s:property value="intituleGenre"/></td>
            </s:iterator>
        </li>
    </div>
    <div class="col-sm-4">
        <div class="card header">
            <li class="list-group-item alert-primary">Photo</li>
            <ul class="text-center"><img height="215" width="190" src="images/<s:property value="ouvrage.photo"/>"/>
            </ul>
        </div>
    </div>
</div>


<div class="container-fluid bibliomarge">
    <li class="list-group-item alert-primary">Reservation d'un ouvrage</li>
    <s:if test="%{controlereservable==true}">

        <table class="table table-striped table-bordered table-hover exemple1" style="width: 100%">

            <thead class="thead-dark">
            <tr>
                <th scope="col">Nom de l'ouvrage</th>
                <th scope="col">Date du prochain retour de l'ouvrage</th>
                <th scope="col">Nombre de demande en cours</th>
            </tr>
            </thead>
            <tbody>
            <th scope="row">
                <strong><s:property value="ouvrage.intituleOuvrage"/></strong></th>
            <td><script>getDate()</script></td></td>
            <td><s:property value="nombreOuvrageAttente"/> </td>
            </tbody>

        </table>
        <s:form action="nreserv" class="container-fluid">
            <s:hidden name="reservation.lecteur.id" label="numéro id lecteur" requiredLabel="true" value="%{idutilisateur}"/>
            <s:hidden name="reservation.ouvrage.ID"  label="num ref exemplaire" value="%{ouvrageid}" requiredLabel="true"/>

            <s:submit value="Demande de Réservation" class="btn btn-primary btn-block"/>


        </s:form>

    </s:if>
    <li class="list-group-item ami_txtfield text-center">

    <s:else>ATTENTION : Impossible de reserver cet ouvrage : <s:property value="message"/> </s:else>

    </li>
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
<script type="text/javascript" src="https://cdn.datatables.net/plug-ins/1.10.20/api/sum().js"></script>

<script>
    $('#example').DataTable( {
        drawCallback: function () {
            var api = this.api();
            $( api.table().footer() ).html(
                api.column( 4, {page:'current'} ).data().sum()
            );
        }
    } );
</script>
</div>
</div>
</div>

</body>
</html>
