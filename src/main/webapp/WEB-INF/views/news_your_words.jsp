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
    <style>
        .s_img{
            position: absolute; 
            margin-left: -15vw; 
            margin-top: 8vh;
            width: 150px;
            height: 150px;
        }
        .s{
            display: none;
        }
        #s_img{
            width: 80%;
        }
    </style>
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
        window.onload = async function(){
            await sleep(10000);
            document.getElementById('titre').innerText = "News Your Words - Résultats";
            document.getElementById('f').style.display = 'none';
            document.getElementById('s_h2').style.display = 'block';
            document.getElementById('s_img').style.display = 'block';
            document.getElementById('image').classList.add('s_img');
            document.getElementById('s_h2').innerText = getCookie("choix") + " (1)";
            await sleep(5000);
            for (let index = 2; index < 7; index++) {
                document.getElementById('s_h2').innerText = "Légende" + " (" + index + ")";
                await sleep(5000);
            }
        }
    </script>
    <h1 class="text-center mt-5" id="titre">News Your Words</h1>
    <div class="container d-flex flex-column align-items-center justify-content-center">
        <p id="f">Trouvez une légende à cette image</p>
        <img src="https://random.imagecdn.app/v1/image?height=350&width=350" id="image" class="img-fluid" alt="image random">
        <h2 id="s_h2" class="s" style="position: absolute; margin-left: 25vw; margin-top: -10vh; max-width: 20vw; font-size: 1.5vw; word-wrap: break-word"></h2>
        <img class="s" id="s_img" src="media/newspaper.png" alt="newspaper">
    </div>
</body>

</html>