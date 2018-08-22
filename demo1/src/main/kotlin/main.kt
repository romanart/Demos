

inline fun tpof(o: Any) = js("typeof o").unsafeCast<String>()

private fun printType(o: Any, typeName: String) = println(
        "Kotlin $typeName -> " +
         "JS ${tpof(o)} (${prototypeString(o)}), " +
          "metadata ${o.asDynamic().constructor.`$metadata$`}")

private inline fun prototypeString(o: Any) = js("Object.prototype.toString.call(o)").toString()

interface I

open class A

class B : A(), I

fun main(args: Array<String>) {
    printType(Any(), "Any")
    printType(B(), "Class")
    printType(true, "Boolean")
    printType(42, "Int")
    printType(.42, "Double")
    printType(4242L, "Long")
    printType('c', "Char")
    printType("S", "String")
    printType(arrayOf(42, 42), "Array")
    printType({}, "FunctionN<*>")
    printType(floatArrayOf(42f, 4.2f, 0.42f, 0.042f), "floatArray")
    printType(js("({})"), "dynamic")
}