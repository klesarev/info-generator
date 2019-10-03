import api.MainGenerator
import entity.Codes

fun main() {
    //    for(pers in Person::class.memberProperties) {
    //        println("User property ${pers.name} - ${pers.get(test)}")
    //    }

    val hashMap:HashMap<String,String> = HashMap<String,String>();
    hashMap.put("lat","39.948474")
    hashMap.put("long","48.333423")

    val test = MainGenerator().genPhone(925)
    print(test)
}
