import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter


fun main(args: Array<String>) {

    val dir = File("output/")
    dir.mkdirs()

    val mainCode = File(dir, "main.kt")

    val mainStream = FileOutputStream(mainCode)
    val mainStringStream = OutputStreamWriter(mainStream)

    mainStringStream.append("fun main(args: Array<String>) {\n")

    for (i in 0..100) {

        val packageName = "foofaa$i"
        val file = File(dir, "$packageName.kt")
        val outputStream = FileOutputStream(file)
        val stringStream = OutputStreamWriter(outputStream)

        stringStream.append("package $packageName\n")

        stringStream.append("fun foo0(): String { return \"!!!me is used @ $packageName!!!\" }\n")

        mainStringStream.append("  println($packageName.foo0())\n")

//        val textStream =
        for (j in 1..150) {
            stringStream.append("fun foo$j(): String { return \"me is not used $j\" }\n")
        }

        stringStream.flush()
        stringStream.close()
        outputStream.close()
    }

    mainStringStream.append("}\n")
    mainStringStream.flush()
    mainStringStream.close()

}