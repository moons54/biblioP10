<%--
  Created by IntelliJ IDEA.
  User: aurelienmimouni
  Date: 2019-04-13
  Time: 15:07
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
<div class="form-group-lg container card">



    <s:form action="recherche">





                        <s:select label="Choix du genre"
                                                       headerKey="-1" headerValue="choisir un Genre"
                                                       list="#{'1':'renaissance', '2':'distopie', '3':'poésie', '4':'roman','5':'théatre'}"
                                                       name="genre.ID"
                                                       value="2" /></p>
                      <s:select label="Choix de l'auteur"
                                                       headerKey="-1" headerValue="choisir de l'auteur"
                                                       list="#{'1':'Rabelais', '2':'Moore', '3':'Du Bellay', '4':'Montesquieu','5':'Baudelaire','6':'Victor Hugo', '7':'Maupassant', '8':'Orwell', '9':'Choderlos de laclos','10':'de musset'
                      ,'11':'Harlan Coben', '12':'Ken FOLLET', '13':'Stephne King'}"
                                                       name="auteur.ID"
                                                       value="2" /></p>

                    </div>
                </div>
            </div>
        </div>



            </div>


        <s:submit value="ok"/>
</s:form>


<div>


<s:form action="rechercheisbn">





    <s:textfield class="form-control" name="ouvrage.isbn" label="reference isbn"></s:textfield>
    <s:submit value="ok"/>
</s:form>

</div>













</body>
</html>
