<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:structure titre="Partie">
    
    <title>Use Your Words</title>
    
	<style>
        ::placeholder {
            text-align: center;
        }

        ::-webkit-input-placeholder {
            text-align: center;
        }

        :-moz-placeholder {
            text-align: center;
        }

        ::-moz-placeholder {
            text-align: center;
        }

        :-ms-input-placeholder {
            text-align: center;
        }
    </style>
   
    <h1 class="text-center mt-5">Use Your Words</h1>
    <hr style="width: 90%; margin-left: auto; margin-right: auto;">
    
    <script>
        function getRandomInt(max) {
            return Math.floor(Math.random() * max);
        }

        function sleep(ms) {
            return new Promise(resolve => setTimeout(resolve, ms));
        }

        function animate(obj, initVal, lastVal, duration) {
            let startTime = null;
            let currentTime = Date.now();
            const step = (currentTime) => {
                if (!startTime) {
                    startTime = currentTime;
                }
                const progress = Math.min((currentTime - startTime) / duration, 1);
                obj.innerHTML = Math.floor(progress * (lastVal - initVal) + initVal);
                if (progress < 1) {
                    window.requestAnimationFrame(step);
                } else {
                    window.cancelAnimationFrame(window.requestAnimationFrame(step));
                }
            };
            window.requestAnimationFrame(step);
        }
        
        function getCookie(name) {
	        var nameEQ = name + "=";
	        var ca = document.cookie.split(';');
	        for(var i=0;i < ca.length;i++) {
	            var c = ca[i];
	            while (c.charAt(0)==' ') c = c.substring(1,c.length);
	            if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	        }
	        return null;
	    }

        function sendchoice() {
        	let choice = document.getElementById("choix").value;
        	setCookie("choix", choice, 1);
        }
        
        function setCookie(cname, cvalue, exdays) {
	       	  const d = new Date();
	       	  d.setTime(d.getTime() + (exdays*24*60*60*1000));
	       	  let expires = "expires="+ d.toUTCString();
	       	  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
       	}
        
        async function vote(){

            document.getElementById('choix').style.display = 'none';

            for (let j = 1; j < 7; j++) {
                let i = document.createElement("input");
                i.type = 'submit';
                i.classList.add('form-control');
                i.classList.add('mt-3');
                i.classList.add('btn');
                i.classList.add('btn-primary');
                i.name = "vote";
                i.style.width = "30px";
                i.style.height = "30px";
                i.style.borderRadius = "50%";
                i.value = j;
                i.onclick = () => { document.getElementById('user_choice').style.display = "none";};
                document.getElementById('user_choice').appendChild(i);
            }
            await sleep(5000*6);
            document.getElementById('user_choice').style.display = 'none';
            document.cookie="choix='Aucune réponse du joueur !'; expires=Thu, 01 Jan 2030 00:00:00 UTC; path=/;";
            location.reload();
            
        }

        window.onload = async function () {
            let decompte = document.getElementById('decompte');
            animate(decompte, 10, 0, 10000);
            await sleep(10000);
            vote();
        }
    </script>
    
    <div class="container d-flex" style="height: 80vh; padding: 0;">
        <div class="left w-25">
            <ul style="list-style-type: none; font-size: 2vw; text-align: center; line-height: 13vh;">
                <li>${ pseudo }</li>
                <li>${ JoueursOrdi1 }</li>
                <li>${ JoueursOrdi2 }</li>
                <li>${ JoueursOrdi3 }</li>
                <li>${ JoueursOrdi4 }</li>
                <li>${ JoueursOrdi5 }</li>
            </ul>
        </div>
        <div class="right w-75">
            <div style="text-align: center; display: flex;"><h3>Temps restant : &nbsp;</h3><h3 id="decompte"></h3><h3>s</h3></div>
            <iframe src="http://localhost:8080/${ typemanche }" id="ifr" frameborder="0" width="100%" height="70%"></iframe>
            <div class="d-flex justify-content-center align-items-center" style="height: 30%;">
                <form method="post" style="width: 90vw" id="user_choice">
                    <input type="text" maxlength="35" size="35" class="form-control" name="choix" id="choix" placeholder="Votre choix" onkeyup="sendchoice()">
                    <!--<input type="button" class=" form-control mt-3 btn btn-primary" name="send_choix" id="send_choix" value="Envoyer" onclick="sendchoice()">-->
                </form>
               <!--  <form method="post" style="width: 90vw; display: none; flex-wrap: wrap; justify-content: space-around;" id="vote_form">
                    
                </form> -->
            </div>
        </div>
    </div>
</t:structure>

</html>