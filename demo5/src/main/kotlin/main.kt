import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

@Serializable
data class DataSimple(val i: Int, val a: List<String>)

@Serializable
data class DataComplex(val list: List<DataSimple>, val map: Map<String, Int>)

fun main(args: Array<String>) {

    val dataListIn = DataComplex(listOf(DataSimple(1, listOf("data1")),
            DataSimple(2, listOf("data2")),
            DataSimple(3, listOf("data3"))),
            (10..20).associate { it.toString(16) to it })

    println("Input data: $dataListIn")

    val serializer = DataComplex.serializer()

    val json = JSON.stringify(serializer, dataListIn)
    println("\nJSON:$json\n")

    val dataListOut = JSON.parse(serializer, json)
    println("Deserialized: $dataListOut")

    require(dataListIn == dataListOut)

    println("Success")
}