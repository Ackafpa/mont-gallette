//function changeDispo(id, urld, urli){
//    var img = document.getElementById(id);
//    if(img.src == urld){
//    img.value = urli;
//    } else {
//        img.value = urld;
//    }
//}

//function changeDispo(id){
//    var xhr = new XMLHttpRequest();
//    window.alert("Dans changeDispo");
//    xhr.onreadystatechange = function(){
//        if(xhr.readyState == 4 && xhr.status == 200){
//            window.alert(xhr.readyState);
//            window.alert(xhr.responseText);
//            document.getElementById(id).innerHTML = xhr.responseText;
//        }
//    };
//    xhr.open("GET", "Controller?section=commandeCTRL.acka", true);
//    xhr.send;
//}

function changeDispo(id, url){
    window.alert($('#1').attr('src'));
    $('#'+id).attr('src', url);
}

