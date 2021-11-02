let box = document.getElementById('gamebox');
let context = gamebox.getContext('2d');

context.fillStyle = 'brown';

let posX = 0;
let posY = 0;

setInterval(function() {
    posX += 10;
    posY += 10;
    context.clearRect(0, 0, box.width, box.height);
    context.fillRect(0, posY, 20, 20);
}, 100)