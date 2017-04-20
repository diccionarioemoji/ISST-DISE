/**
 * ponerEmojis.js
 */

function insertarEmoji(emoji){ 
    document.getElementById('campo').focus();
    document.execCommand('insertHTML',false,'<img style="width:17px;height:17px;" src='+emoji.src+' />') 
} 
