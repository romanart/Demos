
package foo

private fun printType(o: Any, typeName: String) = println(
        "Kotlin $typeName -> " +
         "JS ${jsTypeOf(o)} (${prototypeString(o)}), " +
          "metadata ${o.asDynamic().constructor.`$metadata$`}")

private inline fun prototypeString(o: Any):String = js("Object.prototype.toString.call(o)")

interface I

open class A

class B : A(), I

fun main(args: Array<String>) {
    printType(Any(), "Any")
    printType(B(), "Class B")
    printType(js("({})"), "dynamic")
    printType(true, "Boolean")
    printType("S", "String")
    printType(42, "Int")
    printType(.42, "Double")
    printType(4242L, "Long")
    printType('c', "Char")
    printType(arrayOf(42, 42), "Array")
    printType({}, "Function")
    printType(floatArrayOf(42f, 4.2f, 0.42f, 0.042f), "floatArray")
}