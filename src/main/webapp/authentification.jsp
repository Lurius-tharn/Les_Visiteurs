<%@include file="index.jsp" %>
<%
	HttpSession httpSession1 = request.getSession();
%>
<body>
<p>Connectez-vous pour pouvoir accéder aux plannings</p>
<form action="login-servlet" method="GET">
	<div class="form-group">
		<label class="control-label col-sm-2" for="login">Login</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="login" name="login" placeholder=" votre login" size="20"
				   maxlength="20" required/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="motdepasse">Mot de passe </label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="motdepasse" name="password" placeholder="Votre mot de passe"
				   value="" size="20" maxlength="20" required/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<input type="submit" class="btn btn-success" value="se connecter">
		</div>
	</div>


</form>
</body>

</html>