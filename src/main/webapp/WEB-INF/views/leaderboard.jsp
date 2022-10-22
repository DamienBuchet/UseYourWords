<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:structure titre="LeaderBoard">
    <h1 class="text-center mt-5">Use Your Words</h1>
    <hr style="width: 90%; margin-left: auto; margin-right: auto;">
    <a href="/menu" class="text-end link-success">Menu</a>
    <div class="container d-flex justify-content-around align-items-center flex-wrap" style="height: 80vh; overflow-y: scroll;">
        <table class="table table-striped table-hover">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Pseudo</th>
                <th scope="col">Score</th>
              </tr>
            </thead>
            <tbody>
            <c:set var = "i" value = "1"/>
            
            <c:forEach items="${ scores }" var="score">
            	<tr>
	                <th scope="row">${ i }</th>
	                <td>${ score.name }</td>
	                <td>${ score.scoretotal }</td>
              </tr>
              <c:set var = "i" value = "${ i+1 }"/>
            </c:forEach>
              
            </tbody>
          </table>
    </div>
</t:structure>