

fun unusedFun1() {

}

fun unsuedFun2(i : Int) {
    unusedFun1()

    unusedFun1()
    if (i > 0)
    unsuedFun2(i - 1)
}

val unsedProperty = "unsued"

fun usedFun() {
    println("me is used")
}

fun main(args: Array<String>) {
    usedFun()
}