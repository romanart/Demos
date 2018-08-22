import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.suspendCoroutine

private external fun setTimeout(handler: dynamic, timeout: Int = definedExternally): Int

private suspend fun delay(t: Int) {
    if (t <= 0) return
    suspendCoroutine<Unit> {
        setTimeout({
            it.resume(Unit)
        }, t)
    }
}

suspend fun asyncTask(name: String, timeout: Int) {
    println("BEFORE DELAY $name, PAUSE FOR $timeout")
    delay(timeout)
    println("AFTER DELAY $name")
}

fun main(args: Array<String>) {
    launch {
        asyncTask("FOO", 3000)
    }

    launch {
        asyncTask("BAR", 2000)
    }

    launch {
        asyncTask("BAZ", 1000)
    }
}