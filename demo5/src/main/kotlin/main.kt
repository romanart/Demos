import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

@Serializable
data class Data(val a: Int, val b: Array<String>)

fun Data.verify():Boolean {
    require(this is Data)
    require(a is Int)
    require(b is Array<String>)
    require(b.all { it is String })
    return true
}

@Serializable
data class DataList(val list: List<Data>, val map: Map<String, Int>)

fun DataList.verify() {
    require(this is DataList)
    require(list.all { it.verify() })
    require(map.all { it.key is String && it.value is Int })
}


fun main(args: Array<String>) {

    val dataListIn = DataList(listOf(Data(1, arrayOf("data1")),
            Data(2, arrayOf("data2")),
            Data(3, arrayOf("data3"))),
            mapOf("8" to 8,
                    "9" to 9,
                    "A" to 10,
                    "B" to 11))



    println("Input data:")
    println(dataListIn)

    val serializer = DataList.serializer()

    val json = JSON.stringify(serializer, dataListIn)
    println("JSON:")
    println(json)

    val dataListOut = JSON.parse(serializer, json)
    println("Deserialized:")
    println(dataListOut)

    require(dataListIn == dataListOut)
    require(dataListIn.toString() == dataListOut.toString())

    dataListOut.verify()
}