<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Detect Internet Connection</title>
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v3.0.6/css/line.css">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            overflow: hidden;
            background: #f2f2f2;
        }

        .wrapper {
            position: absolute;
            top: 20px;
            left: 20px;
            animation: show_toast 1s ease forwards;
        }

        @keyframes show_toast {
            0% {
                transform: translateX(-100%);
            }

            40% {
                transform: translateX(10%);
            }

            80%,
            100% {
                transform: translateX(20px);
            }
        }

        .wrapper.hide {
            animation: hide_toast 1s ease forwards;
        }

        @keyframes hide_toast {
            0% {
                transform: translateX(20px);
            }

            40% {
                transform: translateX(10%);
            }

            80%,
            100% {
                opacity: 0;
                pointer-events: none;
                transform: translateX(-100%);
            }
        }

        .wrapper .toast {
            background: #fff;
            padding: 20px 15px 20px 20px;
            border-radius: 10px;
            border-left: 5px solid #2ecc71;
            box-shadow: 1px 7px 14px -5px rgba(0, 0, 0, 0.15);
            width: 430px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .wrapper .toast.offline {
            border-color: #ccc;
        }

        .toast .content {
            display: flex;
            align-items: center;
        }

        .content .icon {
            font-size: 25px;
            color: #fff;
            height: 50px;
            width: 50px;
            text-align: center;
            line-height: 50px;
            border-radius: 50%;
            background: #2ecc71;
        }

        .toast.offline .content .icon {
            background: #ccc;
        }

        .content .details {
            margin-left: 15px;
        }

        .details span {
            font-size: 20px;
            font-weight: 500;
        }

        .details p {
            color: #878787;
        }

        .toast .close-icon {
            color: #878787;
            font-size: 23px;
            cursor: pointer;
            height: 40px;
            width: 40px;
            text-align: center;
            line-height: 40px;
            border-radius: 50%;
            background: #f2f2f2;
            transition: all 0.3s ease;
        }

        .close-icon:hover {
            background: #efefef;
        }
    </style>
</head>

<body>
    <div class="wrapper">
        <div class="toast">
            <div class="content">
                <div class="icon"><i class="uil uil-wifi"></i></div>
                <div class="details">
                    <span>You're online now</span>
                    <p>Hurray! Internet is connected.</p>
                </div>
            </div>
            <div class="close-icon"><i class="uil uil-times"></i></div>
        </div>
    </div>
    <script>
        const wrapper = document.querySelector(".wrapper"),
            toast = wrapper.querySelector(".toast"),
            title = toast.querySelector("span"),
            subTitle = toast.querySelector("p"),
            wifiIcon = toast.querySelector(".icon"),
            closeIcon = toast.querySelector(".close-icon");
        window.onload = () => {
            function ajax() {
                let xhr = new XMLHttpRequest();
                xhr.open("GET", "https://jsonplaceholder.typicode.com/posts",
                true);
                xhr.onload = () => {
                    
                    if (xhr.status == 200 && xhr.status < 300) {
                        toast.classList.remove("offline");
                        title.innerText = "Vous �tes de nouveau connect� � Internet \ud83d\ude42 !";
                        subTitle.innerText = "Si le probl�me persiste, red�marrez votre wifi.";
                        wifiIcon.innerHTML = '<i class="uil uil-wifi"></i>';
                        closeIcon.onclick = () => {
                            wrapper.classList.add("hide");
                        }
                        setTimeout(() => { 
                            wrapper.classList.add("hide");
                        }, 5000);
                    } else {
                        offline
                    ();
                    }
                }
                xhr.onerror = () => {
                    offline
                ();
                }
                xhr.send();
            }

            function offline() {
                wrapper.classList.remove("hide");
                toast.classList.add("offline");
                title.innerText = "Vous n'�tes plus connect� � Internet \uD83D\uDE25 !";
                subTitle.innerText = "Red�marrez votre wifi.";
                wifiIcon.innerHTML = '<i class="uil uil-wifi-slash"></i>';
            }
            setInterval(() => {
                ajax();
            }, 100);
        }
    </script>
</body>

</html>