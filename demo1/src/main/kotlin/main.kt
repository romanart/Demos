@file:Suppress("UnsafeCastFromDynamic")

package foo

private fun printType(o: Any, typeName: String) = println(
        "Kotlin $typeName -> JS typeof: ${jsTypeOf(o)} (${prototypeString(o)})")

private fun prototypeString(o: Any):String
        = js("Object.prototype.toString.call(o)")

interface I

open class A : I

class B : A()

fun main(args: Array<String>) {
    printType(Any(), "Any")
    printType(B(), "Class B")
    printType(true, "Boolean")
    printType("S", "String")
    printType(42, "Int")
    printType(.42, "Double")
    printType(4242L, "Long")
    printType('c', "Char")
    printType(arrayOf(42, 42), "Array")
    printType(floatArrayOf(42f, 4.2f, 0.42f, 0.042f), "FloatArray")
    printType({}, "Function")
}











