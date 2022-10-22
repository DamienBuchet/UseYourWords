<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <link rel="shortcut icon" href="media/logo.png" type="image/x-icon">
    <title>Use Your Words</title>
</head>

<body>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
        integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
    </script>
    <script>
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
	    
        function sleep(ms) {
            return new Promise(resolve => setTimeout(resolve, ms));
        }
        function getRandomInt(max) {
            return Math.floor(Math.random() * max);
        }
		
        window.onload = async function () {
            let x = getRandomInt(3);
            switch(x) {
                case 0:
                    document.getElementById('video').setAttribute('src', 'media/pexels-kampus-production-8818531_Trim.mp4');
                    break;
                case 1:
                    document.getElementById('video').setAttribute('src', 'media/Voir - 51537_Trim.mp4');
                    break;
                case 2:
                    document.getElementById('video').setAttribute('src', 'media/Astronaute - 111995_Trim.mp4');
                    break;
                default:
                    document.getElementById('video').setAttribute('src', 'media/pexels-kampus-production-8818531_Trim.mp4');
                }
            await sleep(10000);
            document.getElementById('titre').innerText = "Sub The Title - Résultats";
            let cookie = getCookie("choix");
            let choices = [cookie, "On m'appelle l'ovni", "Allons enfants de la Patrie", "C'est ma direction", "Was wollen wir trinken"];
            for (let index = 1; index < 7; index++) {
                document.getElementById('p').innerText = choices[index - 1] + " (" + index + ")";
                document.getElementById("video").play();
                await sleep(5000);
            }
        }
    </script>
    <h1 class="text-center mt-5" id="titre">Sub The Title</h1>
    <p class="text-center mt-2">Remplissez les sous-titres manquants</p>
    <div class="container text-center">
        <video src="" muted autoplay id="video" width="70%"></video>
        <p class="text-center fs-3 mt-3" id="p">[Insérez les sous-titre]</p>
    </div>
</body>

</html>