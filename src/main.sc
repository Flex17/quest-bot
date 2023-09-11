require: slotfilling/slotFilling.sc
  module = sys.zb-common
require: functions.js 
theme: /

    state: Start
        q!: $regex</start>
        a: Молви друг и войди
        
        state: NoMatchPhrase
            event!: noMatch
            a: Неверный ответ! Попробуй еще раз
        
        state: Friend
                q: друг
                a: А теперь скажи друг на эльфийском
        
        state: Melon
            q: (melon|~мелон)
            a: Входите! Вы вошли в подземелье Мории. Перед вами три коридора. Ваши действия?
            
            state: Left
                q: * *лев* *
                a: Вас съел дракон.
                go!: /Start
                    
                
            state: Right
                q: * *прав* *
                a: Перед вами сундук, ваши действия?
                
                state: Open
                    q: * *откр* *
                    a: в сундуке оказались монеты, ровно {{ $context.coins = getRandomInt(10) }}. Хотите
                    сыграть в игру? В ней вы можете преумножить монеты или лишиться их вовсе.
                    
                state: Play
                    q: да
                    a: {{ 
                        getRandomInt(1) 
                            ? 'Поздравляю, вы преумножили количество своих монет, теперь их $context.coins * 2' 
                            : `Вы потеряли свои монеты ${$context.coins = 0}`
                        }}
                    
                
            state: Straight
                q: * *прям* *
                a: Вы упали в яму...
                go!: /Start
                
            state: Back
                q: * (назад|~вернуться|~вернуть|~возвращаться) *
                a: Вход завалило. Выберите другое направление.
                
            state: NoMatchWay
                event!: noMatch
                a: Выберите направление
        
    state: NoMatch
        event!: noMatch
        a: Попробуйте сказать это на эльфийском!
