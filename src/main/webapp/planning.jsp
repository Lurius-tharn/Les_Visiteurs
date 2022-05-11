<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lurius.les_visiteurs.model.Visite" %>
<%@ page import="com.lurius.les_visiteurs.dao.DAOVisite" %>

<%@include file="index.jsp" %>
<html>
<head>
	<title>Planning</title>
</head>
<body>
<div class="container">
	<table class="table">
		<thead>
		<tr>
			<th scope="col">id</th>
			<th scope="col">Nom</th>
			<th scope="col">Note</th>
			<th scope="col">Date</th>
		</tr>
		</thead>
		<tbody>

		<%
			int idPlanning = (Integer) request.getAttribute("idPlanning");
			ArrayList<Visite> listeVisite = DAOVisite.lister(idPlanning);
			for (Visite v : listeVisite
			) {
				System.out.println(v.getIdPlanning());
		%>
		<tr>
			<th scope="col"><%= v.getId() %>
			</th>
			<th scope="col"><%= v.getNom() %>
			</th>
			<th scope="col"><%= v.getNote() %>
			</th>
			<th scope="col"><%= v.getDate() %>
			</th>
			<th scope="col"><a href="supprimer-servlet?idVisite=<%= v.getId() %>&idPlanning=<%= v.getIdPlanning()%>">Suppression</a>
			</th>

		</tr>

		<%
			}

		%>


		</tbody>
	</table>
	<button onclick="ajouter()" type="button" class="btn btn-success">Ajouter une visite</button>

	<br>
	<br>
	<br>
	<div style="display:none" id="hidedForm">
		<form method="post" action="creer-planning-servlet">
			<fieldset class="border p-2">
				<legend class="float-none w-auto">Nouvelle Visite</legend>

				<div class="row-cols-2">
					<div class="col">
						<label> Nom</label>
						<input type="text" name="nom" class="form-control" placeholder="Nom">
					</div>
					<div class="col">
						<label> Date</label>

						<input type="text" name="date" class="form-control" placeholder="Date">
					</div>
					<div class="col">
						<label> Note</label>
						<input type="text" name="note" class="form-control" placeholder="Note">
					</div>
					<br>
					<div class="col form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" id="register" class="btn btn-dark" value="Ajouter">
						</div>
					</div>
				</div>

		</form>
		</fieldset>


	</div>


</div>
</body>
<script>
    var hidedForm = document.getElementById("hidedForm");

    ajouter = () => {
        hidedForm.style.display = "block";
        console.log(hidedForm)
    }
</script>
</html>
