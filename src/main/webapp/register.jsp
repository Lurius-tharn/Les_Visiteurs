<%@include file="index.jsp" %>
<body>
<p>Inscrivez-vous pour pouvoir acc�der aux plannings</p>
<form action="register-servlet" method="POST">
	<div class="form-group">
		<label class="control-label col-sm-2" for="login">Login</label>
		<div class="col-sm-10">
			<input onchange="valider()" type="text" class="form-control" id="login" name="login"
				   placeholder=" votre login" size="20"
				   maxlength="20" required/>
		</div>
		<p id="error" style="color: darkred"></p>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="motdepasse">Mot de passe </label>
		<div class="col-sm-10">
			<input onchange="valider()" type="password" class="form-control" id="motdepasse" name="password"
				   placeholder="Votre mot de passe"
				   value="" size="20" maxlength="20" required/>
		</div>
	</div>
	<%--	<div class="form-group">--%>
	<%--		<div class="col-sm-offset-2 col-sm-10">--%>
	<%--			<div class="checkbox">--%>
	<%--				<label><input type="checkbox"> Rester connecter</label>--%>
	<%--			</div>--%>
	<%--		</div>--%>
	<%--	</div>--%>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<input onclick="check()" type="submit" id="register" class="btn btn-success" value="S'inscrire">
		</div>
	</div>


</form>
</body>
<script>
    var login = document.getElementById("login");
    var textLogin = document.getElementById("error");
    var registerButton = document.getElementById("register");

    function valider() {

        var url = "account-exist?login=" + login.value;
        if (window.XMLHttpRequest) {
            requete = new XMLHttpRequest();
            requete.open("GET", url, true);
            requete.onreadystatechange = majIHM;
            requete.send(null);
        } else if (window.ActiveXObject) {
            requete = new ActiveXObject("Microsoft.XMLHTTP");
            if (requete) {
                requete.open("GET", url, true);
                requete.onreadystatechange = majIHM;
                requete.send();
            }
        } else {
            alert("Le navigateur ne supporte pas la technologie AJAX");
        }
    }


    function majIHM() {
        if (requete.readyState == 4) {
            if (requete.status == 200) {
                var messageTag = requete.responseXML.getElementsByTagName("message")[0];
                if (messageTag.childNodes.length > 0) {
                    var message = messageTag.childNodes[0].nodeValue;
                    textLogin.innerText = message;
                    registerButton.setAttribute("disabled", "disabled")
                } else {
                    textLogin.innerText = null;
                    registerButton.removeAttribute("disabled")


                }
            }
        }
    }


</script>
</html>