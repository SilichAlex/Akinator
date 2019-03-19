function requestList(way) {
    fetch(" http://localhost:8080/list",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: 'POST',
            mode: 'no-cors',
            body: way

        })
        .then(function (res) {
            return res.text();
        })
        .then(function (text) {
            deleteElementsFromList();
            let array = separateSentenseOnWords(text);
            addArrayToList(array);
        })
        .catch(function (res) {
            console.log(res)
        })


}

function requestAnswer(way) {

    fetch(" http://localhost:8080/question",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: 'POST',
            mode: 'no-cors',
            body: way

        })
        .then(function (res) {
            return res.text();
        })
        .then(function (text) {
            document.getElementById("question").innerText = text;
            question = text;
            checking(text);
        });

}

function checking(text) {
    if (text.charAt(0) === ' ') {
        document.getElementById("yes").style.display = 'none';
        document.getElementById("no").style.display = 'none';
        document.getElementById("retry").style.display = 'block';
        document.getElementById("question").style.color = 'red';
        document.getElementById("answer").style.display = 'block';
    }
}

