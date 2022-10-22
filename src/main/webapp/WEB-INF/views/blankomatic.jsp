<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<link rel="shortcut icon" href="media/logo.png" type="image/x-icon">
<title>Use Your Words</title>
</head>

<body>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous">
    </script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
		crossorigin="anonymous">
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
    
        let phrases_base = ['Qui va à la chasse perd...', 'Les petits ruisseaux font...', 'Qui peut le plus, peut ...'];
        
        function getRandomInt(max) {
            return Math.floor(Math.random() * max);
        }

        function sleep(ms) {
            return new Promise(resolve => setTimeout(resolve, ms));
        }

        async function res(){
            await sleep(10000);
            document.querySelector('h1').innerText = "Blank-o-matic - Résultats";
            let results = [getCookie('choix'), 'une chaussure', 'des champignons', 'le moins', 'des bons amis', 'rien'];

            for (let index = 1; index < 7; index++) {
                document.getElementById('res').innerText = results[index - 1] + "\n(" + index + ")";
                await sleep(5000);
            }
        }

        window.onload = function () {
            let x = getRandomInt(2);
            document.getElementById('base').innerText = phrases_base[x];
            res();
        }
    </script>
	<h1 class="text-center mt-5">Blank-o-matic</h1>
	<p class="text-center mt-2">Choissiez la fin de la phrase</p>
	<div class="container">
		<p class="text-center mt-5 fs-2" id="base"></p>
		<p class="text-center mt-2 fs-3" id="res"></p>
	</div>
</body>

</html>