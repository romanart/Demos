suspend fun foo():Int { return 0 }

suspend fun bar() {
    foo()

    foo()

    while(foo() >= 0) {

        println("LOOP BEGIN")
        foo()
        if (foo() > 0) {
            println("1")
        } else {
            foo()
            println("2")
        }


        println("LOOP END")
    }

    println("3")
    foo()

    foo()

    foo()
}
