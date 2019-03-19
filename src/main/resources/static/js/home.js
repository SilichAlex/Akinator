let way = "0";
let question = "";
let listOfDish;

document.getElementById("button-begin").addEventListener("click", function () {
    document.getElementById("button-begin").style.display = 'none';
    document.getElementById("window").style.display = 'block';
    requestList(way);
    requestAnswer(way);
});

document.getElementById("yes").addEventListener("click", function () {
    way += "1";
    requestList(way);
    requestAnswer(way);
    document.getElementById("way").innerText = way;

});

document.getElementById("no").addEventListener("click", function () {
    way += "0";
    requestList(way);
    requestAnswer(way);
    document.getElementById("way").innerText = way;


});

function addElementToList(string) {
    let node = document.createElement("li");
    let textnode = document.createTextNode(string);
    node.appendChild(textnode);
    document.getElementById("list").appendChild(node);
}

function addArrayToList(array) {
    array.forEach(function (element) {
        addElementToList(element);
    });
    let list = document.getElementById("list");
    list.removeChild(list.childNodes[list.childNodes.length-1]);
}
    function deleteElementsFromList() {
        let list = document.getElementById("list");
        while (list.childNodes.length > 1) {
            list.removeChild(list.childNodes[1]);
        }
    }

    function separateSentenseOnWords(sentence) {
        return sentence.trim().split("/");
    }
