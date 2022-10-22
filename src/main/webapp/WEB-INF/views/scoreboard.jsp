<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:structure titre="ScoreBoard">
    <h1 class="text-center mt-5">Use Your Words - Scoreboard</h1>
    <hr style="width: 90%; margin-left: auto; margin-right: auto;">
    <script>
        /* function animate(obj, initVal, lastVal, duration) {
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

        window.onload = function () {
            let scores = [9, 8, 7, 6, 5, 4, 3, 2, 1]
            for (let j = 1; j < 4; j++) {
                let p = document.createElement("p");
                p.innerText = "Joueur " + j;
                let score = document.createElement("p");
                document.getElementById(j).appendChild(p);
                document.getElementById(j).appendChild(score);
                animate(score, 0, scores[j], scores[j] * 700)
            }
        } */
    </script>
    <style>
        #a {
            height: 30vh;
            background-color: silver;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        #b {
            height: 50vh;
            background-color: gold;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        #c {
            height: 10vh;
            background-color: rgb(60, 0, 0);
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
        }

        @keyframes zoom-in-zoom-out {
            0% {
                transform: scale(1, 1);
            }

            50% {
                transform: scale(1.5, 1.5);
            }

            100% {
                transform: scale(1, 1);
            }
        }
        .premier{
            animation: zoom-in-zoom-out 2s ease-in-out infinite;
        }
    </style>
    <div class="d-flex justify-content-center align-items-center" style="height: 70vh;">
        <div id="vote" class="d-flex justify-content-between align-items-end flex-wrap"
            style="width: 130vh; font-size: 3vh;">
            <div>
                <div id="2" style="text-align: center;">${ listescore[1].getName() } <br> ${ listescore[1].getScore() } </div>
                <div id="a">2</div>
            </div>
            <div>
                <div id="1" class="premier" style="text-align: center;">${ listescore[0].getName() } <br> ${ listescore[0].getScore() } </div>
                <div id="b">1</div>
            </div>
            <div>
                <div id="3" style="text-align: center;">${ listescore[2].name } <br> ${ listescore[2].score } </div>
                <div id="c">3</div>
            </div>
        </div>
    </div>
</t:structure>