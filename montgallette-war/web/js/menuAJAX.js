function getxmlhttp() {
    var xmlhttp = null;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest;
    } else if (window.ActiveXObject) {
        try {
            xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
    } else {
        alert("AJAX n'est pas supporté par votre navigateur");
        xmlhttp = false;
    }
    return xmlhttp;
}

function refreshMenu(categorie) {
    var xmlhttp = getxmlhttp();

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById('menuCarte').innerHTML = xmlhttp.responseText;
        }
        else {
            document.getElementById('menuCarte').innerHTML = "Loading: " + categorie;
        }
    };
    xmlhttp.open("GET", "Controller?section=menu.acka&action=afficher&categorie=" + categorie, true);
    xmlhttp.send(null);
}