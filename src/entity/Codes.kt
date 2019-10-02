package entity

import kotlin.random.Random

enum class Codes(code: String) {
    MTS("MTS"){
        override fun genCode(): String {
            val list: Array<String> = arrayOf("910","915","916","918")
            return list.get(Random.nextInt(0,list.size))
        }
    },
    MEGAFON("MEGAFON"){
        override fun genCode(): String {
            val list: Array<String> = arrayOf("925","926","928")
            return list.get(Random.nextInt(0,list.size))
        }
    },
    BEELINE("BEELINE"){
        override fun genCode(): String {
            val list: Array<String> = arrayOf("903","904","905","906")
            return list.get(Random.nextInt(0,list.size))
        }
    };
    abstract fun genCode():String
}
