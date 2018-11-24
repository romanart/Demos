@file:Suppress("UnsafeCastFromDynamic")

@JsModule("module.js")
external fun foo(s: String): dynamic

fun <T> type_of(o: T): String {
    return js("typeof o")
}

@JsName("helloKotlin")
fun helloKotlin(name: String) {
    println("Hello $name from Kotlin \uD83D\uDC4B")
}

fun main(args: Array<String>) {
    println(foo("Hello").msg)
}