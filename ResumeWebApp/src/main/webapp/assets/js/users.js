function whenWrite() {
    var input = document.getElementById("surname")
    var inpValue = input.value
    var when = document.getElementById("whenWrite")
    when.innerHTML = inpValue
}

function hide() {
    var btnSrch = document.getElementById("search")
    btnSrch.style.display = 'none';
}

function changeColor() {
    var btnSrch = document.getElementById("search")
    btnSrch.style = "background-color: red";
}