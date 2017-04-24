/**
 * ponerEmojis.js
 */

var n = 0;

function insertarEmoji(emoji){ 
    var campo = document.getElementById('campo');
    campo.focus()
    campoInicial= campo.innerHTML
    campo.innerHTML = campoInicial + '<img width="35px" height="35px" src='+emoji.src+'/>'; 
    
    var campo2 = document.getElementById('traduccion');
    var x = emoji.src;
    
    var pulsada = emoji.alt;
   
    if(n>0){
    	pulsada = pulsada.toLowerCase();
    }
    campo2.value += pulsada+" ";
    n++
} 
