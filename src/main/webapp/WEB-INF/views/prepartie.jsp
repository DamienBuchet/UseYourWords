<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:structure titre="PrePartie">

	<style>
	
		#a, #b, #c, #d, #e {
		
		display: none;
		
		}
	
	</style>
    <h1 class="text-center mt-5">Use Your Words</h1>
    <hr style="width: 90%; margin-left: auto; margin-right: auto;">
    <script>
        function sleep(ms) {
            return new Promise(resolve => setTimeout(resolve, ms));
        }

        function getRandomInt(max) {
            return Math.floor(Math.random() * max);
        }
        
        window.onload = async function () {
            await sleep(2000);
            
			document.getElementById('a').style.display = "block";
            await sleep(1000);

            document.getElementById('b').style.display = "block";
            await sleep(3000);

            document.getElementById('c').style.display = "block";
            await sleep(1500);

            document.getElementById('d').style.display = "block";
            await sleep(2000);

            document.getElementById('e').style.display = "block";
            
        }
    </script>
    <div class="container d-flex" style="height: 80vh; padding: 0;">
        <div class="left w-25">
            <ul style="list-style-type: none; font-size: 2vw; text-align: center; line-height: 13vh;">
                <li>${ pseudo }</li>
                <li id="a">${ JoueursOrdi1 }</li>
                <li id="b">${ JoueursOrdi2 }</li>
                <li id="c">${ JoueursOrdi3 }</li>
                <li id="d">${ JoueursOrdi4 }</li>
                <li id="e">${ JoueursOrdi5 }</li>
            </ul>
        </div>
        <div class="right w-75">
            <div style="display: flex; justify-content: center; align-items: center; height: 100%">
                <form method="post">
                    <input type="submit" class="btn btn-success" value="Lancer la partie" name="debut">
                </form>
            </div>
    	</div>
	</div>
</t:structure>