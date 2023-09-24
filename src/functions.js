function getRandomInt(max) {
  return Math.floor(Math.random() * max);
}

function playGame() {
    var isWinned = getRandomInt(2) % 2 === 1;
    
    if (isWinned) {
        $jsapi.context.coins *= 2;
        return 'Вы победили, количество ваших очков ' + $jsapi.context.coins;
    }
    
    $jsapi.context.coins = 0;
    
    return 'Вы проиграли, количество ваших очков равно 0';
}
