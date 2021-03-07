package com.example.mvvm.repository

import com.example.mvvm.models.Joke

/**
 * This class simulates calls to an API to get random jokes
 */
class JokeRepository {

    private val jokes: MutableList<Joke> = ArrayList()

    init {
        if (jokes.isEmpty()) {
            jokes.add(Joke("Chuck Norris has already been to mars; that why there's no signs of life."))
            jokes.add(Joke("Any man can make yellow snow. Chuck Norris can make brown snow."))
            jokes.add(Joke("Once I thought water was rain till I took a trip to outer space and saw Chuck Norris peeing on the earth."))
            jokes.add(Joke(("Chuck Norris played battletoads..... after several failed attempts, the game rage quit")))
            jokes.add(Joke(("When Chuck Norris destroys a pub in Britain, everybody there says that 'he caused a right royal Chuckus'.")))
            jokes.add(Joke(("Chuck Norris doesn't use a chainsaw to cut trees, he just stares at the tree until it falls over.")))
            jokes.add(Joke(("Chuck Norris once had he's own teit paper only problem it didn't take any shit")))
        }
    }

    fun fetchRandomJoke(): Joke {
        return jokes.random()
    }

}
