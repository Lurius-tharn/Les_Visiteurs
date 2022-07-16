<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lurius.les_visiteurs.model.VisiteEntity" %>
<%@ page import="com.lurius.les_visiteurs.dao.VisiteDAO" %>
<%@ page import="com.lurius.les_visiteurs.model.PlanningEntity" %>
<%@ page import="com.lurius.les_visiteurs.dao.PlanningDAO" %>
<%
	int idPlanning = (Integer) request.getAttribute("idPlanning");
	ArrayList<VisiteEntity> listeVisite = VisiteDAO.lister(idPlanning);
%>
<%@include file="index.jsp" %>
<html>
<head>
	<title>Planning</title>
</head>
<body>
<div class="container">

	<h1>
		Planning <%=request.getAttribute("nomPlanning")%>
	</h1>
	<div class="row">
		<div class="col">
		</div>
		<div class="col-5">
		</div>
		<div class="col">
			<button type="button" class="btn btn-danger" onclick="deleteChecked(<%=idPlanning%>)">Supprimer</button>
		</div>

	</div>
	<table class="table">
		<thead>
		<tr>
			<th scope="col">
				<div class="form-check">
					<input id="globalSelect" type="checkbox"
						   onchange="handleGlobalChange(this)" checked="false">
				</div>

			</th>

			<th scope="col">id</th>
			<th scope="col">Nom</th>
			<th scope="col">Note</th>
			<th scope="col">Date</th>
		</tr>
		</thead>
		<tbody>

		<%

			for (VisiteEntity v : listeVisite
			) {
				System.out.println(v.getIdPlanning());
		%>
		<tr id="item-<%=v.getIdVisite()%>">
			<th scope="col">
				<div class="form-check">
					<input type="checkbox" onchange="handleChange(this)"
						   id="<%=v.getIdVisite()%>" checked="false">
				</div>


			</th>
			<th scope="col"><%= v.getIdVisite() %>
			</th>
			<th scope="col"><%= v.getNom() %>
			</th>
			<th scope="col"><%= v.getNote() %>
			</th>
			<th scope="col"><%= v.getDate() %>
			</th>
			<th scope="col" onclick=""><a
			>Modifier</a>
			</th>

		</tr>

		<%

			}

		%>


		</tbody>
	</table>
	<button onclick="document.getElementById('hidedAddForm').style.display = 'block'" type="button"
			class="btn btn-success">Ajouter une visite
	</button>

	<br>
	<br>
	<br>
	<div style="display:none" id="hidedAddForm">
		<form method="post" action="add-visite-servlet">

			<fieldset class="border p-2">
				<div class="row justify-content-between">
					<legend class="float-none w-auto col-4 align-self-center">Nouvelle Visite</legend>

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
					<div class="col">
						<label> Date</label>

						<input type="text" name="date" class="form-control" placeholder="Date">
					</div>
					<div class="col">
						<label> Note</label>
						<input type="text" name="note" class="form-control" placeholder="Note">
					</div>
					<br>
					<div class="col">
						<label> Planning</label>
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
<script>
    var listeASupprimer = [];


    handleGlobalChange = (checkbox) => {
        let isChecked = false;
        const checkBoxes = $("input[type=checkbox][id!='globalSelect']");
        checkbox.checked == true ? isChecked = true : isChecked = false;
        checkBoxes.each(function () {
            $(this).prop({'checked': isChecked});
            handleChange($(this)[0]);
        });

    }

    handleChange = (checkbox) => {
        checkbox.checked == true ? (listeASupprimer.indexOf(checkbox.id) === -1 ? listeASupprimer.push(checkbox.id) : '') : listeASupprimer = listeASupprimer.filter((item) => {
            return item != checkbox.id
        });
    }

    deleteChecked = (idPlanning) => {
        if (listeASupprimer.length > 0) {
            var url = "supprimer-servlet?idPlanning=" + idPlanning + "&visites=" + listeASupprimer;
            if (window.XMLHttpRequest) {
                requete = new XMLHttpRequest();
                requete.open("GET", url, true);
                requete.send(null);
                removeItem();
            } else if (window.ActiveXObject) {
                requete = new ActiveXObject("Microsoft.XMLHTTP");
                if (requete) {
                    requete.open("GET", url, true);
                    requete.send();
                }
            } else {
                alert("Le navigateur ne supporte pas la technologie AJAX");
            }
        }

    }

    removeItem = () => {
        listeASupprimer.forEach(element => {
            console.log(element)
            console.log($("#item-" + element))
            $("#item-" + element).remove()
        })

        listeASupprimer = [];
    }


</script>
</html>
