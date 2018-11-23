import kotlin.coroutines.*

val mySequence1 = sequence {
    println("S1: one")
    yield(1)
    for (s in mySequence2) {
        yield(s)
    }
    println("S1: two")
    yield(2)
    println("S1: three")
    yield(3)
}

val mySequence2 = sequence {
    println("S2: one")
    yield(11)
    println("S2: two")
    yield(22)
    println("S2: three")
    yield(33)
}

fun main(args: Array<String>) {
    println("start")
    for (i in mySequence1) {
        println("SEQ: $i")
    }
    println("done")
}