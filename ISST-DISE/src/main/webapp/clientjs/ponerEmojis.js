/**
 * ponerEmojis.js
 */

//var emojisATraducir = "";
var n = 0;

function insertarEmoji(emoji){ 
    var campo = document.getElementById('campo');
    campo.focus()
    campoInicial= campo.innerHTML
    campo.innerHTML = campoInicial + '<img width="24px" height="24px" src='+emoji.src+'/>';
    
    //var imagen = emoji.src
    //emojisATraducir += '' + imagen.slice(imagen.length-23)+";";
    
    var campo2 = document.getElementById("traduccionAEsp");
    var traduccionPulsada = emoji.alt;
    if (n>0){
    	traduccionPulsada = traduccionPulsada.toLowerCase();
    }
    campo2.value += traduccionPulsada + " ";
    n++
} 
