const WHITE = ['q', 'w', 'e', 'r', 't', 'y', 'u', 'v', 'b', 'n', 'm', ',', '.', '/'];
const BLACK = ['2', '3', '5', '6', '7', 'g', 'h', 'k', 'l', ';'];
let keys = document.querySelectorAll('.key');
let blackKeys = document.querySelectorAll('.key.black');
let whiteKeys = document.querySelectorAll('.key.white');

// eventlistener for mouse click
keys.forEach(key => {
    key.addEventListener('click', () => playMusic(key));
});
//eventlistener for key press using keydown
document.addEventListener('keydown', e => {
    let key = e.key;
    let whiteKeyIndex = WHITE.indexOf(key);
    let blackKeyIndex = BLACK.indexOf(key);

    if (whiteKeyIndex > -1) playMusic(whiteKeys[whiteKeyIndex]);
    if (blackKeyIndex > -1) playMusic(blackKeys[blackKeyIndex])
});

// this function will play audio
function playMusic(key) {
    const audio = document.getElementById(key.dataset.note);
    audio.currentTime = 0;
    audio.play();
}