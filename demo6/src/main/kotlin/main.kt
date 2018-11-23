
class Foo(val x: Int, val s: String) {
    val arr = Array(10) { "ID$it" }
}

fun toStringObject(o: Any): String {
    println("skip me")
    return o.toString()
}

fun main(args: Array<String>) {
    val arrays = Array(10) { Foo(it, "@$it") }

    val intArray = intArrayOf(1, 2, 3, 4, 5)

    println(toStringObject(intArray))

    println(arrays[0].s)
}