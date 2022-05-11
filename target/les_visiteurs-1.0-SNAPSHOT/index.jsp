<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title> Plannificator</title>
	<div class="container-fluid">
		<div class="row no-gutters">
			<div class="col-1">
				<img height="50" width="50" class="img-fluid" src="assets/img/cadenas.png">
			</div>
			<div class="col-1 align-items-center">
				<p class="text-success text-center ">Plannificator</p>
			</div>
		</div>
	</div>
	<%--	<div class="container">--%>
	<%--		<div class="row">--%>
	<%--			<div class="col-12">--%>
	<%--				<img height="50" width="50" class="img-fluid" src="assets/img/cadenas.png">--%>
	<%--				<p class="text-success">Plannificator</p>--%>
	<%--			</div>--%>
	<%--		</div>--%>

	<%--	</div>--%>


	<nav class="navbar navbar-expand-lg navbar-light bg-light">

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">

				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
					   data-toggle="dropdown"
					   aria-haspopup="true" aria-expanded="false">
						Planning
					</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="">Créer</a>
						<a class="dropdown-item" href="#">Modifier</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Visualiser</a>
					</div>
				</li>


				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button"
					   data-toggle="dropdown"
					   aria-haspopup="true" aria-expanded="false">
						Compte
					</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown2">
						<a class="dropdown-item" href="register-servlet">Créer</a>
						<% HttpSession httpSession = request.getSession();
							if (httpSession.getAttribute("compte") == null) {
						%>
						<a class="dropdown-item" href="authentification.jsp">Se connecter</a>

						<%}%>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="authentification.jsp">Se déconnecter</a>
					</div>
				</li>
			</ul>
		</div>
	</nav>
	<br>
	<br>
	<br>
	<br>

	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
		  integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
			crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
			integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
			crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
			integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
			crossorigin="anonymous"></script>

</head>

</html>