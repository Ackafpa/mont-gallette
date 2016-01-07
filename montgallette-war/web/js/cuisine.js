function getXhr() {
    var xhr = null;
    if (window.XMLHttpRequest) { // Firefox et autres
        xhr = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) { // Internet Explorer
        try {
            xhr = new ActiveXObject("Msxml2.XMLHTTP");
        }
        catch (e) {
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
    } else {
        alert("Votre navigateur ne prend pas en charge AJAX");
        xhr = false;
    }
    return xhr;
}


// --> RAJOUTER CHANGEMENT ETAT DES PRODUITS ET SURTOUT LIEN AVEC CHAQUE PRODUIT
function preparation(id) {
    var prepa = document.getElementById('btnPreparation' + id);
    var pret = document.getElementById('btnPret' + id);
    if (pret.className === 'CuisineInactif') {
        if (prepa.className === 'CuisineInactif') {
            prepa.className = 'CuisineEnCours';
            prepa.value = 'En prépa';
        } else {
            prepa.className = 'CuisineInactif';
            prepa.value = 'Préparer';
        }
    } else {
        //NE FAIT RIEN CAR BOUTON NON CLIQUABLE
    }
}

function changerEtat(idProduit, id) {
    var prepa = document.getElementById('btnPreparation' + id);
    var pret = document.getElementById('btnPret' + id);

    var xhr = getXhr();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {

            if (pret.className === 'CuisineInactif') {
                if (prepa.className === 'CuisineInactif') {
                    changerEtatValider(idProduit);
                } else {
                    changerEtatAnnuler();
                }
            } else {
                //NE FAIT RIEN CAR BOUTON NON CLIQUABLE
            }
            
        } else if (xhr.readyState === 4 && xhr.status === 404) {
            // to do ....
            print(">>>>>> ERROR XHR");
        }
    }
    xhr.open("POST", "Controller", true);
    xhr.send("action=modifierEtat");
}

function validerEtat() {
    var xhr = getXhr();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            nomProduit.changerEtatValider();
        } else if (xhr.readyState == 4 && xhr.status == 404) {
            // to do ....
        }
    }
    xhr.open("POST", "Controleur", true);
    xhr.send("section=modifierEtat");
}

function pret(id) {
    var prepa = document.getElementById('btnPreparation' + id);
    var pret = document.getElementById('btnPret' + id);
    if (prepa.className === 'CuisineEnCours') {
        if (pret.className === 'CuisineInactif') {
            prepa.className = 'CuisineFini';
            pret.className = 'CuisineEnCours';
        }
        if (prepa.className === 'CuisineFini') {
            pret.className = 'CuisineFini';
            prepa.className = 'CuisineInactif';
            //--> ENVOYER ALERTE PLAT PRET A SERVIR
        }
    } else {
        if (pret.className === 'CuisineFini') {
            pret.className = 'CuisineInactif';
            prepa.className = 'CuisineEnCours';
        } else {
            //NE FAIT RIEN CAR NON CLIQUABLE
        }
    }
}

function indispo() {
    //CHANGER ETAT PRODUIT DANS LA CARTE
    //ENVOYER ALERTE GARCON SI PRODUIT COMMANDÉ    

}



//XHR : 
//xhr.open("GET", "Controleur?action=modifierEtat", true);
//xhr.send(null);



//A SUPPRIMER A LA FIN
function test() {
    var t = document.getElementById('btnTest');
    if (t.className === 'CuisineInactif') {
        t.className = 'CuisineEnCours';
    } else {
        t.className = 'CuisineInactif';
    }
}