<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:structure titre="AffichageVote">

    <h1 class="text-center mt-5">Use Your Words</h1>
    <hr style="width: 90%; margin-left: auto; margin-right: auto;">
    <script>
	    function sleep(ms) {
	        return new Promise(resolve => setTimeout(resolve, ms));
	    }
	    
        window.onload = async function () {

                await sleep(4000);
            	location.href = "http://localhost:8080/partie";
        }
    </script>
    
    <div class="d-flex justify-content-center align-items-center" style="height: 70vh;">
        <div id="vote" class="d-flex justify-content-between flex-wrap" style="width: 130vh; font-size: 3vh;">
            <div id="1" style="text-align: center;">${ pseudo }<br> ${ compteur1 }</div>
            <div id="2" style="text-align: center;">${ JoueursOrdi1 } <br>${ compteur2 }</div>
            <div id="3" style="text-align: center;">${ JoueursOrdi2 } <br>${ compteur3 }</div>
            <div id="4" style="text-align: center;">${ JoueursOrdi3 } <br>${ compteur4 }</div>
            <div id="5" style="text-align: center;">${ JoueursOrdi4 } <br>${ compteur5 }</div>
            <div id="6" style="text-align: center;">${ JoueursOrdi5 } <br>${ compteur6 }</div>
        </div>
    </div>
</t:structure>