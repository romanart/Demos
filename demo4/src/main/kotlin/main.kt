suspend fun foo():Int { return 0 }





suspend fun bar(): Int {
    println("1")

    val f1 = foo()

    println("2")

    val f2 = foo()

    println("3")

    return f1 + f2
}
