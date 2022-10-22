<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:structure titre="Login">

	<h1 class="d-flex justify-content-center" style="margin-top: 150px;">
		Page de connexion</h1>
	<div class="container-fluid container-sm"
		style="max-width: 350px; margin-top: 100px;">

		<form method="post">
			<div class="mb-3">
				<label for="exampleInputPseudo1" class="form-label">Pseudo</label> <input
					name="pseudo" type="text" class="form-control"
					id="exampleInputPseudo1">
				<div id="emailHelp" class="form-text">
					<small> <c:if test="${ error == true }">

							<div class="text-danger">Authentification incorrecte</div>

						</c:if>
					</small>
				</div>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input name="pwd" type="password" class="form-control"
					id="exampleInputPassword1">
			</div>
			<button type="submit" class="btn btn-primary">Se connecter</button>
		</form>

	</div>

</t:structure>