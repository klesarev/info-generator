import api.MainGenerator
import entity.Codes
import utils.FileDataProvider
import utils.WriteableDataProvider
import kotlin.random.Random

fun main() {
    //    for(pers in Person::class.memberProperties) {
    //        println("User property ${pers.name} - ${pers.get(test)}")
    //    }

    val hashMap:HashMap<String,String> = HashMap<String,String>();
    hashMap.put("lat","39.948474")
    hashMap.put("long","48.333423")

    val test = FileDataProvider().getDataById("names.txt", Random.nextInt(0,2))

    print(test)

}
