<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lurius.les_visiteurs.model.PlanningEntity" %>
<%@ page import="com.lurius.les_visiteurs.dao.PlanningDAO" %>

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
			<select class="form-control" id="planning" name="planning">
				<%
					ArrayList<PlanningEntity> listePlanning = PlanningDAO.lister();
					for (PlanningEntity p : listePlanning
					) {
				%>
				<option value=<%= p.getIdPlanning() + "|" + p.getNom().replace(" ", "_") %>><%= p.getNom() %>
				</option>

				<%
					}

				%>
			</select>
		</div>


		<input type="submit" value="Visualiser" class="btn btn-secondary"> </input>

	</form>


	<button onclick="document.getElementById('hidedAddForm').style.display = 'block'" type="button"
			class="btn btn-success">Ajouter un Planning
	</button>
</div>


<div id="hidedAddForm" style="display: none">
	<form method="post" action="add-planning-servlet">

		<fieldset class="border p-2">
			<div class="row justify-content-between">
				<legend class="float-none w-auto col-4 align-self-center">Nouveau Planning</legend>

				<span class=" align-self-center mr-3" style="font-size: 45px;
  							font-weight: 600;"
					  onclick="document.getElementById('hidedAddForm').style.display = 'none'">
					&times;
				</span>
			</div>


			<div class="row-cols-2">
				<div class="col">
					<label> Nom</label>
					<input type="text" name="nom" class="form-control" placeholder="Nom">
				</div>
				<div class="col form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" id="register" class="btn btn-dark" value="Ajouter">
					</div>
				</div>
			</div>
		</fieldset>

	</form>


</div>

</div>

</body>
</html>
