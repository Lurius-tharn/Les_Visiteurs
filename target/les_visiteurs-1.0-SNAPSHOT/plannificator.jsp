<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lurius.les_visiteurs.model.Planning" %>
<%@ page import="com.lurius.les_visiteurs.dao.DAOPlanning" %>

<%@include file="index.jsp" %>


<html>
<head>
	<title>Plannificator</title>
</head>
<body>
<div class="container">
	<form action="planning-servlet" method="get">
		<div class="form-group">
			<label for="planning">Liste des plannings</label>
			<select class="form-control" id="planning" name="idPlanning">
				<%
					ArrayList<Planning> listePlanning = DAOPlanning.lister();
					for (Planning p : listePlanning
					) {
				%>
				<option value=<%= p.getIdPlanning() %>><%= p.getNom() %>
				</option>

				<%
					}

				%>
			</select>
		</div>


		<input type="submit" value="Visualiser" class="btn btn-secondary"> </input>
	</form>

</div>


</body>
</html>
