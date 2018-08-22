

@JsModule("./module.js")
external fun foo(s: String): dynamic

fun main(args: Array<String>) {
    println(foo("Hello").message)
}