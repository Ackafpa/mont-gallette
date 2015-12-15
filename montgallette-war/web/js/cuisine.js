function test() {
    var t = document.getElementById('btnTest');
    if (t.className === 'CuisineInactif') {
        t.className = 'CuisineEnCours';
    } else {
        t.className = 'CuisineInactif';
    }
}
// --> RAJOUTER CHANGEMENT ETAT DES PRODUITS ET SURTOUT LIEN AVEC CHAQUE PRODUIT
function preparation() {
    var prepa = document.getElementById('btnPreparation');
    var pret = document.getElementById('btnPret');

    if (pret.className === 'CuisineInactif') {
        if (prepa.className === 'CuisineInactif') {
            prepa.className = 'CuisineEnCours';
            prepa.value = 'En prépa';
        } else {
            prepa.className = 'CuisineInactif';
            prepa.value = 'Préparer';
            //CHANGER ETAT 1-->0
        }
    } else {
        //NE FAIT RIEN CAR NON CLIQUABLE
    }
}

function changerEtat(idProduit){
    document.getElementById('idProduit').etat = 1; //CHANGER ETAT 0-->1
}

//function preparation() {
//    var prepa = document.getElementById('btnPreparation');
//    var pret = document.getElementById('btnPret');
//
//    if (pret.className === 'CuisineInactif') {
//        if (prepa.className === 'CuisineInactif') {
//            prepa.className = 'CuisineEnCours';
//            prepa.value = 'En prépa';
//        } else {
//            prepa.className = 'CuisineInactif';
//            prepa.value = 'Préparer';
//        }
//    } else {
//        //NE FAIT RIEN CAR NON CLIQUABLE
//    }
//}


function pret() {
    var prepa = document.getElementById('btnPreparation');
    var pret = document.getElementById('btnPret');
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


