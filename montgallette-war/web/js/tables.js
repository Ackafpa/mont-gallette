function getXhr(){
    var xhr = null;
    if(window.XMLHttpRequest){
        xhr = new XMLHttpRequest;
    }else if(window.ActiveXObject){
        try{
            xhr = new ActiveXObject("Msxml2.XMLHTTP");
        }catch(e){
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }else{
        alert("AJAX n'est pas supporté par votre navigateur");
        xhr = false;
    }
    return xhr;
}

function dispoTable(id){

     var xhr = getXhr();
        
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            var resp = xhr.responseText;
            alert(resp);
            var image = document.getElementById(id);
            image.innerHTML = resp;
        }
    };
    xhr.open("GET", "Controller?section=commande.acka&action=creerCo", true);
    xhr.send(null);
}



