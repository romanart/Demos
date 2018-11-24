import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

@Serializable
data class DataSimple(val i: Int, val s: String)

@Serializable
data class DataComplex(val list: List<DataSimple>, val map: Map<String, Int>)

fun main(args: Array<String>) {

    val dataListIn = DataComplex(
            listOf(DataSimple(1, "data1"), DataSimple(2, "data2"), DataSimple(3, "data3")),
            (10..20).associate { it.toString(16) to it }
    )

    println("Input data: $dataListIn")

    val json = JSON.stringify(DataComplex.serializer(), dataListIn)
    println("\nJSON: $json\n")

    val dataListOut = JSON.parse(DataComplex.serializer(), json)
    println("Deserialized: $dataListOut")

    require(dataListIn == dataListOut)

    println("Success")
}