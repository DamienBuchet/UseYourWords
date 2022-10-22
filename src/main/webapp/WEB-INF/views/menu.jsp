<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:structure titre="Menu">

	<h1 class="text-center mt-5">Use Your Words</h1>
    <hr style="width: 90%; margin-left: auto; margin-right: auto;">
    <a href="/leaderboard" class="text-end link-success">Classement</a>
    <div class="container d-flex justify-content-around align-items-center flex-wrap" style="height: 80vh">
        <form method="post">
            <input type="text" class="form-control mb-3" name="pseudo" id="pseudo" placeholder="Pseudonyme" required>
            <input class="btn btn-primary w-100" type="submit" name="start" value="Commencer une partie">
        </form>
        <form method="post" class="d-flex flex-column">
            <input type="text" class="form-control mb-3" name="pseudo_join" id="pseudo_join" placeholder="Pseudonyme" required>
            <input type="text" class="form-control mb-3" name="code" id="code" placeholder="Code du groupe" title="Veuillez indiquer le code d'une partie" required>
            <input class="btn btn-primary" type="submit" name="join" value="Rejoindre une partie">
        </form>
    </div>
</t:structure>