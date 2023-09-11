const playGame = () => {
    const isWinned = getRandomInt(1) > 0.5;
    
    if (isWinned) {
        $context.coins *= 2;
        return `Вы победили, количество ваших очков ${$context.coins}`;
    }
    
    $context.coins = 0;
    
    return 'Вы проиграли, количество ваших очков равно 0';
}