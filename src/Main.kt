
import api.MainGenerator
import entity.Codes
import kotlin.random.Random


fun main() {
    //    for(pers in Person::class.memberProperties) {
    //        println("User property ${pers.name} - ${pers.get(test)}")
    //    }

    val hashMap:HashMap<String,String> = HashMap<String,String>();
    hashMap.put("lat","39.948474")
    hashMap.put("long","48.333423")

    val code = MainGenerator().genPhone( Codes.MEGAFON.genCode() )
    print(code)
}
