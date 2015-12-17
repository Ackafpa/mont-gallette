function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    m = checkTime(m);
    document.getElementById("horloge").innerHTML = h + ":" + m;
}

function checkTime(i) {
    if (i < 10)
        i = "0" + i;
    return i;
}

function afficherOptionsSession() {
   // <c:url value="Controller?section=menu.acka&action=home" var="urlms01" />
   //  --- <a href="${urlms01}">Home</a>
}

    