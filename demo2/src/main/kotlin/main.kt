

@JsModule("./module.js")
external fun foo(s: String): dynamic

fun <T> type_of(o: T): String = js("typeof o")

fun main(args: Array<String>) {
    println(foo("Hello").message)
}