document.getElementById("Start").addEventListener("click",function () {
    fetch("http://localhost:8080/page",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'

            },
            method: 'GET',
            redirect: 'manual',
            mode: 'no-cors',

        })
        .then(function (res) {
            console.log(res)
        })
        .catch(function (res) {
            console.log(res)
        })
});