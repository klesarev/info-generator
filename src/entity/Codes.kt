package entity

import kotlin.random.Random

enum class Codes {
    MOBILE {
        override fun generate(): Int {
            val list: Array<Int> = arrayOf(900,901,902,903,905,906,908,909,910,915,916,918,928,929,953,958,960,961,966,967,968,999)
            return list.get(Random.nextInt(0,list.size))
        }
    };
    abstract fun generate():Int
}
