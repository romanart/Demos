import kotlin.coroutines.*

val mySequence = sequence {
    println("one")
    yield(1)
    for (s in mySequence2) {
        yield(s)
    }
    println("two")
    yield(2)
    println("three")
    yield(3)
}

val mySequence2 = sequence {
    println("oneone")
    yield(11)
    println("twotwo")
    yield(22)
    println("threethree")
    yield(33)
}

fun main(args: Array<String>) {
    for (i in mySequence) {
        println("SEQ: $i")
    }
    println("check")
}