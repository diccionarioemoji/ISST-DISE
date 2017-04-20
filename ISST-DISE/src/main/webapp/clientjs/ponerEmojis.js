/**
 * ponerEmojis.js
 */

function insertarEmoji(emoji){ 
    var campo = document.getElementById('campo');
    campo.focus()
    campoInicial= campo.innerHTML
    campo.innerHTML = campoInicial + '<img width="18px" height="18px" src='+emoji.src+'/>'; 
} 
